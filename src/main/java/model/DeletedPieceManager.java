package model;

import java.util.ArrayList;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class DeletedPieceManager implements IDeletedPieceManager{

    private final List<Piece> pieces;

    public DeletedPieceManager(){ pieces = new ArrayList<>();}

    @Override
    public void addPiece(Piece piece){
        pieces.add(piece);
    }
    public int count(Piece.Type type){
        int num = 0;
        for (Piece piece : pieces) {
            if ((piece.getCell().getPiece().getType() == type)) num++;
        }
        return num;
    }
    public Piece removeLast(){
        return pieces.remove(0);
    }

    @Override
    public String toString(){
        StringBuilder output= new StringBuilder();

        for (Piece.Type type : Piece.Type.values())
            output.append(colorize(" " + type.getShape() + " ", type.getColor().getPieceColor(), Cell.Color.BLACK_CELL.getAttribute()));

        output.append("\n");

        for (Piece.Type type : Piece.Type.values())
            output.append(colorize(" " + count(type) + " ", type.getColor().getPieceColor(), Cell.Color.WHITE_CELL.getAttribute()));

        output.append("\n");

        for (Piece.Type type : Piece.Type.values())
            output.append(colorize(" " + type.getShape() + " ", type.getColor().getPieceColor(), Cell.Color.BLACK_CELL.getAttribute()));

        output.append("\n");
        System.out.println("PIEZAS VIVAS");
        output.append("\n");
        int aux;
        for (Piece.Type type : Piece.Type.values()){
            aux=0;
            if (type.getShape()=="\u2659"){
                aux=8;
            } else if (type.getShape()=="\u265B"||type.getShape()=="\u265A") {
                aux=1;
            }else {
                aux=2;
            }
        output.append(colorize(" " + (aux-count(type)) + " ", type.getColor().getPieceColor(), Cell.Color.WHITE_CELL.getAttribute()));}

        return output.toString();

    }

}
