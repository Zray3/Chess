import model.*;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class PruebaMain {

    public static void main(String[] args) {
        Board b = new Board();
        b.startPieces();
        Piece.Color turnColor = Piece.Color.WHITE;
        Coordinate pick;
        Coordinate place;
        Set <Coordinate> highlighting;
        System.out.println(b);

        System.out.println(b);

        while (true) {
            System.out.println(b);
            if (turnColor==Piece.Color.WHITE) {
                System.out.println("Bando blanco, elija pieza:");
            }
            else {
                System.out.println("Bando negro elija pieza:");
            }
            while (b.getCell(pick=PideCoord()).getPiece() == null || b.getCell(pick).getPiece().getColor() != turnColor) {
                System.out.println("Posición no válida, inténtelo de nuevo:");
            }
            highlighting = new HashSet<>(b.getCell(pick).getPiece().getNextMovements());
            highlighting.add(pick);
            b.highlight(highlighting);
            System.out.println(b + "\n");
            System.out.println("Elige dónde:");
            while (b.getCell(place=PideCoord()).getColor() == Cell.Color.BLACK_CELL || b.getCell(place).getColor() == Cell.Color.WHITE_CELL) {
                System.out.println("Posición no válida, inténtelo de nuevo:");
            }
            if (!pick.equals(place) && b.getCell(place).getPiece() != null) {
                if (b.getCell(place).getPiece().getType() == Piece.Type.BLACK_KING ||
                        b.getCell(place).getPiece().getType() == Piece.Type.WHITE_KING) {
                    break;
                }
            }
            b.getCell(pick).getPiece().moveTo(place);
            b.resetColors();

            if (!pick.equals(place)) {
                if (turnColor == Piece.Color.WHITE) turnColor = Piece.Color.BLACK;
                else turnColor = Piece.Color.WHITE;
            }
        }
        b.getCell(pick).getPiece().moveTo(place);
        b.resetColors();
        System.out.println(b);
        if (turnColor == Piece.Color.WHITE) System.out.println("VENCE EL BANDO BLANCO!");
        else System.out.println("VENCE EL BANDO NEGRO!");
    }


    public static Coordinate PideCoord(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la posición:");
        String scaner = sc.nextLine().toUpperCase();
        System.out.println(scaner);
        if (scaner.length()<2) {
            System.out.println("Coordenada no válida, introduzca una coordenada compuesta por 1 comlumna y 1 fila:");
            return PideCoord();
        }

        if (scaner.charAt(0)<'A'||'H'<scaner.charAt(0)) {
        System.out.println("Columna inadecuada");
        return PideCoord();
        }
        String aux = String.valueOf(scaner.charAt(1));
        Integer aux2 = Integer.parseInt(aux);

        if (aux2<1||aux2>8){
            System.out.println("Fila inadecuada");
            return PideCoord();
        }

        System.out.println(scaner.charAt(0)+" "+aux2);
        return new Coordinate(scaner.charAt(0),aux2);

    }
}
