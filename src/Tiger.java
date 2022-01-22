import java.awt.*;
import java.util.Random;

public class Tiger extends Critter {

    Random ran = new Random();
    Color typeColor;
    int counter;
    static String karakter = "TGR";

    public Tiger() {
        setColor();
        this.counter = 1;
    }

    public Action getMove(CritterInfo info) {
        counter++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    public Color getColor() {
        if (counter > 3) {
            setColor();
            counter = 1;
        }
        return typeColor;
    }

    public String toString() { return karakter; }

    public void setColor() {
        if (ran.nextInt(3) == 1) {
            typeColor = Color.RED;
        } else if (ran.nextInt(3) == 2) {
            typeColor = Color.GREEN;
        } else {
            typeColor = Color.BLUE;
        }
    }
}