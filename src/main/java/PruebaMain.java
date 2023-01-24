import model.*;

public class PruebaMain {

    public static void main(String[] args) {
        Board b1 = new Board();
        System.out.println(b1);

        b1.placePieces();
        System.out.println(b1);

        Coordinate[] coordinates = b1.getCell(new Coordinate('C',6)).getPiece().getNextMovements();
        b1.highlight(coordinates);
        System.out.println(b1);
        b1.resetColors();
        System.out.println(b1);

    }
}
