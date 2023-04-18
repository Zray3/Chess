package model;

import java.util.HashSet;
import java.util.Set;

public abstract class Knight extends Piece {

    public Knight(Type type, Cell cell) {
        super(type, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        Set<Coordinate> coordinates = new HashSet<>();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;

        //Up
        c = position.up().up().right();
        check(c, coordinates);
        c = position.up().up().left();
        check(c, coordinates);

        //Down
        c = position.down().down().left();
        check(c, coordinates);
        c = position.down().down().right();
        check(c, coordinates);

        //Left
        c = position.left().left().up();
        check(c, coordinates);
        c = position.left().left().down();
        check(c, coordinates);

        //right
        c = position.right().right().down();
        check(c, coordinates);
        c = position.right().right().up();
        check(c, coordinates);

        return coordinates;
    }


}
