package model;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece {
    public Queen(Type type, Cell cell){
        super(type, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        Set<Coordinate> aux = new HashSet<>(Bishop.getNextMovementsAsBishop(this));
        aux.addAll(Rook.getNextMovementsAsRook(this));
        return aux;

    }


}
