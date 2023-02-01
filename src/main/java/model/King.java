package model;
import tad.ListCoor;

    public abstract class King extends Piece{

        public King(Type type, Cell cell) {
            super(type, cell);
        }

        @Override
        public ListCoor getNextMovements() {

            Coordinate position = getCell().getCoordinate();
            Coordinate c;

            c = position.up();
            check(c);
            c = position.left();
            check(c);
            c = position.down();
            check(c);
            c = position.right();
            check(c);
            c = position.diagonalDownLeft();
            check(c);
            c = position.diagonalDownRight();
            check(c);
            c = position.diagonalUpLeft();
            check(c);
            c = position.diagonalUpRight();
            check(c);

            return coordinates;

        }
}
