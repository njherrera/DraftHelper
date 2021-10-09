package com.mucho;

import java.sql.Array;
import java.util.ArrayList;

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
    public void generateBoards(ExcelReader reader){
        for (int i = 1; i < reader.getImportedBoard().getLastRowNum(); i++) {
            if (reader.getImportedBoard().getRow(i).getCell(0).toString().equals("R#") != true) {
                String[] FGPercentageSplit = reader.getImportedBoard().getRow(i).getCell(7).toString().split("\\s*[()]\\s*");
                double actualFGPercentage = Double.parseDouble(FGPercentageSplit[0]);
                String[] FTPercentageSplit = reader.getImportedBoard().getRow(i).getCell(8).toString().split("\\s*[()]\\s*");
                double actualFTPercentage = Double.parseDouble(FTPercentageSplit[0]);
                Player newPlayer = new Player(reader.getImportedBoard().getRow(i).getCell(3).toString(), reader.getImportedBoard().getRow(i).getCell(2).toString(),
                        reader.getImportedBoard().getRow(i).getCell(5).getNumericCellValue(), actualFGPercentage, actualFTPercentage,
                        reader.getImportedBoard().getRow(i).getCell(9).getNumericCellValue(), reader.getImportedBoard().getRow(i).getCell(10).getNumericCellValue(),
                        reader.getImportedBoard().getRow(i).getCell(11).getNumericCellValue(), reader.getImportedBoard().getRow(i).getCell(12).getNumericCellValue(),
                        reader.getImportedBoard().getRow(i).getCell(13).getNumericCellValue(), reader.getImportedBoard().getRow(i).getCell(14).getNumericCellValue(),
                        reader.getImportedBoard().getRow(i).getCell(15).getNumericCellValue(), reader.getImportedBoard().getRow(i).getCell(16).getNumericCellValue());
                overallBoard.add(newPlayer);
                if (newPlayer.getPositions().contains("PG")){
                    PGBoard.add(newPlayer);
                } else if (newPlayer.getPositions().contains("SG")){
                    SGBoard.add(newPlayer);
                } else if (newPlayer.getPositions().contains("SF")){
                    SFBoard.add(newPlayer);
                } else if (newPlayer.getPositions().contains("PF")){
                    PFBoard.add(newPlayer);
                } else if (newPlayer.getPositions().contains("C")){
                    CBoard.add(newPlayer);
                }
            }
        }
    }

    public void generateStandardDeviations(){

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
}
