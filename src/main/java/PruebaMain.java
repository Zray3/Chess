import model.*;

public class PruebaMain {

    public static void main(String[] args) {
        Coordinate c1 = new Coordinate('G',1);
        Board tablero = new Board();
        Cell celda = new Cell(tablero, c1);
        Piece caballoBlanco = new Piece(Piece.Type.WHITE_KING,celda);
        System.out.println(caballoBlanco);
        Piece caballoNegro = new Piece(Piece.Type.BLACK_KING,celda);
        System.out.println(caballoNegro);
    }


}
