import java.awt.*;

public class Bear extends Critter {

    Color typeColor;
    int even = 0;

    public Bear(boolean polar) {
        if (polar) {
            typeColor = Color.WHITE;
        } else {
            typeColor = Color.BLACK;
        }
    }

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }
    public Color getColor() { return typeColor; }

    public String toString() {
        if (even % 2 == 0) {
            even++;
            return "/";
        } else {
            even++;
            return "\\";
        }
    }
}