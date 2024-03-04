package model;

import java.util.HashSet;
import java.util.Set;

public abstract class King extends Piece{

        private boolean moved;
        public King(Type type, Cell cell) {

            super(type, cell);
            this.moved = false;
        }

        public void move(){
            moved=true;
        }



        @Override
        public Set<Coordinate> getNextMovements() {
            Set<Coordinate> coordinates = new HashSet<>();
            Coordinate position = getCell().getCoordinate();
            Coordinate c;

            c = position.up();
            check(c, coordinates);
            c = position.left();
            check(c, coordinates);
            c = position.down();
            check(c, coordinates);
            c = position.right();
            check(c, coordinates);
            c = position.diagonalDownLeft();
            check(c, coordinates);
            c = position.diagonalDownRight();
            check(c, coordinates);
            c = position.diagonalUpLeft();
            check(c, coordinates);
            c = position.diagonalUpRight();
            check(c, coordinates);

            return coordinates;

        }
}
