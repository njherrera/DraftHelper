package com.mucho;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class DraftBoard {
    /*
    maintains lists of all Players still remaining in draft
    sorts players based on BPA, as well as by whatever criteria the user is looking for (i.e. sorted by impact in each category)
    has position quotas (set by user)
    tracks player/position scarcity
    test for git
     */

    private ArrayList<Player> overallBoard;
    private ArrayList<Player> PGBoard;
    private ArrayList<Player> SGBoard;
    private ArrayList<Player> SFBoard;
    private ArrayList<Player> PFBoard;
    private ArrayList<Player> CBoard;
    private HashMap<String, Player> playerMap = new HashMap<String, Player>();
    private static Player averagePlayer;
    private static Player averagePG;
    private static Player averageSG;
    private static Player averageSF;
    private static Player averagePF;
    private static Player averageC;

    public DraftBoard(ArrayList<Player> overallBoard, ArrayList<Player> PGBoard, ArrayList<Player> SGBoard, ArrayList<Player> SFBoard, ArrayList<Player> PFBoard, ArrayList<Player> CBoard) {
        this.overallBoard = overallBoard;
        this.PGBoard = PGBoard;
        this.SGBoard = SGBoard;
        this.SFBoard = SFBoard;
        this.PFBoard = PFBoard;
        this.CBoard = CBoard;
    }
    public DraftBoard(){
        this.overallBoard = new ArrayList<Player>();
        this.PGBoard = new ArrayList<Player>();
        this.SGBoard = new ArrayList<Player>();
        this.SFBoard = new ArrayList<Player>();
        this.PFBoard = new ArrayList<Player>();
        this.CBoard = new ArrayList<Player>();
    }

    // generateBoards reads the excel file with projections/stats for each player, then goes through line by line and adds each player to draft boards
    // if cell 0 in a row is R#, that means it isn't a player row and instead has headers for the stat categories
    // can i split this up somehow? it's getting pretty unwieldy
    public void generateBoards(ExcelReader reader){
        DataFormatter formatter = new DataFormatter();
        for (int i = 1; i < reader.getImportedBoard().getLastRowNum(); i++) {
            if (reader.getImportedBoard().getRow(i).getCell(0).toString().equals("R#") != true) {
                double[] FGBreakdown = generateFGPercentage(reader.getImportedBoard().getRow(i).getCell(7));
                double[] FTBreakdown = generateFTPercentage(reader.getImportedBoard().getRow(i).getCell(8));
                Player newPlayer = new Player(reader.getImportedBoard().getRow(i).getCell(3).toString(), reader.getImportedBoard().getRow(i).getCell(2).toString(),
                        reader.getImportedBoard().getRow(i).getCell(5).getNumericCellValue(), FGBreakdown[2], FTBreakdown[2],
                        reader.getImportedBoard().getRow(i).getCell(9).getNumericCellValue(), reader.getImportedBoard().getRow(i).getCell(10).getNumericCellValue(),
                        reader.getImportedBoard().getRow(i).getCell(11).getNumericCellValue(), reader.getImportedBoard().getRow(i).getCell(12).getNumericCellValue(),
                        reader.getImportedBoard().getRow(i).getCell(13).getNumericCellValue(), reader.getImportedBoard().getRow(i).getCell(14).getNumericCellValue(),
                        reader.getImportedBoard().getRow(i).getCell(15).getNumericCellValue(), reader.getImportedBoard().getRow(i).getCell(16).getNumericCellValue());
                newPlayer.setFGAttemptedAndMade(FGBreakdown[0], FGBreakdown[1]);
                newPlayer.setFTAttemptedAndMade(FTBreakdown[0], FTBreakdown[1]);
                if (reader.getImportedBoard().getRow(i).getCell(1).getCellType() == CellType.NUMERIC){
                    newPlayer.setAverageDraftPosition(reader.getImportedBoard().getRow(i).getCell(1).getNumericCellValue());
                } else {
                    newPlayer.setAverageDraftPosition(i);
                }
                overallBoard.add(newPlayer);
                playerMap.put(newPlayer.getName().toLowerCase(), newPlayer);
                if (newPlayer.getPositions().contains("PG")){
                    PGBoard.add(newPlayer);
                } if (newPlayer.getPositions().contains("SG")){
                    SGBoard.add(newPlayer);
                } if (newPlayer.getPositions().contains("SF")){
                    SFBoard.add(newPlayer);
                } if (newPlayer.getPositions().contains("PF")){
                    PFBoard.add(newPlayer);
                } if (newPlayer.getPositions().contains("C")){
                    CBoard.add(newPlayer);
                }
            }
        }
        for (Player plyr : getOverallBoard()){
            plyr.generateZScore(this, "none");
        }
    }

    public double[] generateFGPercentage(XSSFCell cell){
        String[] FGPercentageSplit = cell.toString().split("\\s*[()]\\s*");
        double actualFGPercentage = Double.parseDouble(FGPercentageSplit[0]);
        String[] MakesAndAttempts = FGPercentageSplit[1].split("/");
        double attempts = Double.parseDouble(MakesAndAttempts[0]);
        double makes = Double.parseDouble(MakesAndAttempts[1]);
        double[] FGBreakdown = new double[3];
        FGBreakdown[0] = makes;
        FGBreakdown[1] = attempts;
        FGBreakdown[2] = actualFGPercentage;
        return FGBreakdown;
    }

    public double[] generateFTPercentage(XSSFCell cell){
        String[] FTPercentageSplit = cell.toString().split("\\s*[()]\\s*");
        double actualFTPercentage = Double.parseDouble(FTPercentageSplit[0]);
        String[] MakesAndAttempts = FTPercentageSplit[1].split("/");
        double attempts = Double.parseDouble(MakesAndAttempts[0]);
        double makes = Double.parseDouble(MakesAndAttempts[1]);
        double[] FTBreakdown = new double[3];
        FTBreakdown[0] = makes;
        FTBreakdown[1] = attempts;
        FTBreakdown[2] = actualFTPercentage;
        return FTBreakdown;
    }
    // for each player on the overall board (i.e. all players), determine which categories they're outliers in
    public void flagPlayers(){
        BoardAnalyzer.generateAveragePlayer(this);
        BoardAnalyzer.generateStandardDeviations(this);
        for (Player plyr : this.overallBoard) {
            plyr.setPositiveOutliers(BoardAnalyzer.getAveragePlayer(), BoardAnalyzer.getStandardDeviations());
            plyr.setNegativeOutliers(BoardAnalyzer.getAveragePlayer(), BoardAnalyzer.getStandardDeviations());
        }
    }

    public ArrayList<Player> getOverallBoard() {
        return overallBoard;
    }

    public void setOverallBoard(ArrayList<Player> overallBoard) {
        this.overallBoard = overallBoard;
    }

    public ArrayList<Player> getPGBoard() {
        return PGBoard;
    }

    public void setPGBoard(ArrayList<Player> PGBoard) {
        this.PGBoard = PGBoard;
    }

    public ArrayList<Player> getSGBoard() {
        return SGBoard;
    }

    public void setSGBoard(ArrayList<Player> SGBoard) {
        this.SGBoard = SGBoard;
    }

    public ArrayList<Player> getSFBoard() {
        return SFBoard;
    }

    public void setSFBoard(ArrayList<Player> SFBoard) {
        this.SFBoard = SFBoard;
    }

    public ArrayList<Player> getPFBoard() {
        return PFBoard;
    }

    public void setPFBoard(ArrayList<Player> PFBoard) {
        this.PFBoard = PFBoard;
    }

    public ArrayList<Player> getCBoard() {
        return CBoard;
    }

    public void setCBoard(ArrayList<Player> CBoard) {
        this.CBoard = CBoard;
    }

    public HashMap<String, Player> getPlayerMap(){
        return this.playerMap;
    }
}
