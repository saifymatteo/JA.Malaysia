import java.awt.*;

public class WhiteTiger extends Critter {

    boolean infected;
    static Color typeColor = Color.WHITE;

    public WhiteTiger() {
        this.infected = false;
    }

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            this.infected = true;
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    public Color getColor() { return typeColor; }

    public String toString() {
        if (this.infected) {
            return "TGR";
        } else {
            return "tgr";
        }
    }
}