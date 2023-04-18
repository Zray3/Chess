package model;

import java.util.HashSet;
import java.util.Set;

public class PawnBlack extends Pawn {
    public PawnBlack(Cell cell){
        super(Type.BLACK_PAWN, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        coordinates = new HashSet<>();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;

        c = position.down();
        checkPawnMove(c);
        if(getCell().getCoordinate().getRow()==2){
            c = position.down().down();
            checkPawnMove(c);
        }

        c=position.diagonalDownLeft();
        checkPawnKiller(c);
        c=position.diagonalDownRight();
        checkPawnKiller(c);

        return coordinates;

    }

    @Override
    public void transform() {
        new QueenBlack(getCell());
        cell=null;
    }

}
