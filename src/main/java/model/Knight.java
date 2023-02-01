package model;

import tad.ListCoor;

public abstract class Knight extends Piece {
    private ListCoor coordinates;

    public Knight(Type type, Cell cell) {
        super(type, cell);
    }

    @Override
    public ListCoor getNextMovements() {
        coordinates = new ListCoor();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;

        //Up
        c = position.up().up().left();
        check(c);
        c = position.up().up().right();
        check(c);

        //Down
        c = position.down().down().right();
        check(c);
        c = position.down().down().left();
        check(c);

        //Right
        c = position.right().right().down();
        check(c);
        c = position.right().right().up();
        check(c);

        //Left
        c = position.left().left().down();
        check(c);
        c = position.left().left().up();
        check(c);

        return coordinates;
    }

    public void check(Coordinate c){
        Board board = getCell().getBoard();

        if(board.getCell(c) != null){
            if(board.getCell(c).isEmpty() ||
                    board.getCell(c).getPiece().getColor() != getColor())
                coordinates.add(c);
        }


    }


}
