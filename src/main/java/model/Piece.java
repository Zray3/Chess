package model;

import com.diogonunes.jcolor.Attribute;
import static com.diogonunes.jcolor.Ansi.colorize;

public class Piece {
    private Type type;
    private Cell cell;

    public Piece(Type type, Cell cell) {
        this.cell = cell;
        this.type = type;
    }

    @Override
    public String toString(){
        return colorize(this.type.getShape(),this.type.getColor().getPieceColor());
    }

    public enum Color{
        WHITE(Attribute.TEXT_COLOR(250)),
        BLACK(Attribute.TEXT_COLOR(16));
        private final Attribute pieceColor;
        private Color(Attribute pieceColor){
            this.pieceColor = pieceColor;
        }
        public Attribute getPieceColor() { return pieceColor;}
        public Color next(){
            if(this.equals(WHITE))
                return BLACK;
            return WHITE;
        }
    }

    public enum Type{
        WHITE_KING("\u265A", Color.WHITE),
        BLACK_KING("\u265A", Color.BLACK),
        WHITE_QUEEN("\u265B", Color.WHITE),
        BLACK_QUEEN("\u265B", Color.BLACK),
        WHITE_ROOK("\u265C", Color.WHITE),
        BLACK_ROOK("\u265C", Color.BLACK),
        WHITE_BISHOP("\u265D", Color.WHITE),
        BLACK_BISHOP("\u265D", Color.BLACK),
        WHITE_KNIGHT("\u265E", Color.WHITE),
        BLACK_KNIGHT("\u265E", Color.BLACK),
        WHITE_PAWN("\u2659", Color.WHITE),
        BLACK_PAWN("\u2659", Color.BLACK);
        private String shape;
        private Color color;
        private Type(String shape, Color color) {
            this.color = color;
            this.shape = shape;
        }
        public Color getColor() {
            return color;
        }
        public String getShape() {
            return shape;
        }

    }


}