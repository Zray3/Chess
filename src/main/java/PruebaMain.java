import model.Coordinate;

public class PruebaMain {

    public static void main(String[] args) {
        Coordinate c1 = new Coordinate('G',1);
        Coordinate c2 = c1.down().diagonalDownLeft();

        System.out.println(c1 + " " + c2);


    }


}
