package model;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Board {

    private final Map<Coordinate,Cell> cells;
    private IDeletedPieceManager deletedPieceManager;

    public Board(){

        deletedPieceManager = new DeletedPieceManager();

        cells = new HashMap<>();
        //to create every cell
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells.put(new Coordinate((char)('A'+j),i+1),new Cell(this, new Coordinate((char)('A'+j),i+1)));
            }
        }
    }

    public void highlight(Set<Coordinate> coordinates){
        for (Coordinate c: coordinates) {
            getCell(c).highlight();
        }
    }

    public void resetColors(){
        for(Cell c: cells.values())
            c.resetColor();
    }


    public Cell getCell(Coordinate coordinate){
        if(coordinate.getRow()<1 || coordinate.getRow()>8)
            return null;
        if(coordinate.getColumn()<'A' || coordinate.getColumn()>'H')
            return null;
        return cells.get(coordinate);
    }

    public void startPieces(){
        Piece p;
        p = new RookWhite(getCell(new Coordinate('A',8)));
        p.putInYourPlace();
        p = new RookWhite(getCell(new Coordinate('H',8)));
        p.putInYourPlace();
        p = new KnightWhite(getCell(new Coordinate('B',8)));
        p.putInYourPlace();
        p = new KnightWhite(getCell(new Coordinate('G',8)));
        p.putInYourPlace();
        p = new BishopWhite(getCell(new Coordinate('C',8)));
        p.putInYourPlace();
        p = new BishopWhite(getCell(new Coordinate('F',8)));
        p.putInYourPlace();
        p = new KingWhite(getCell(new Coordinate('D',8)));
        p.putInYourPlace();
        p = new QueenWhite(getCell(new Coordinate('E',8)));
        p.putInYourPlace();

        p = new RookBlack(getCell(new Coordinate('A',1)));
        p.putInYourPlace();
        p = new RookBlack(getCell(new Coordinate('H',1)));
        p.putInYourPlace();
        p = new KnightBlack(getCell(new Coordinate('B',1)));
        p.putInYourPlace();
        p = new KnightBlack(getCell(new Coordinate('G',1)));
        p.putInYourPlace();
        p = new BishopBlack(getCell(new Coordinate('C',1)));
        p.putInYourPlace();
        p = new BishopBlack(getCell(new Coordinate('F',1)));
        p.putInYourPlace();
        p = new KingBlack(getCell(new Coordinate('D',1)));
        p.putInYourPlace();
        p = new QueenBlack(getCell(new Coordinate('E',1)));
        p.putInYourPlace();

        for (int i = 0; i < 8; i++) {
            p = new PawnBlack(getCell(new Coordinate((char)('A'+i),2)));
            p.putInYourPlace();
            p = new PawnWhite(getCell(new Coordinate((char)('A'+i),7)));
            p.putInYourPlace();
        }


    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("   A  B  C  D  E  F  G  H\n");
        for (int i = 0; i < 8; i++) {
            output.append(i + 1).append(" ");
            for (int j = 0; j < 8; j++) {
                output.append(cells.get(new Coordinate((char) ('a' + j), i + 1)));
            }
            output.append(" ").append(i + 1).append("\n");
        }

        output.append("   A  B  C  D  E  F  G  H");

        output.append("\n    PIEZAS ELIMINADAS\n").append(deletedPieceManager.toString());

        return output.toString();
    }



}
