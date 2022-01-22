import java.awt.*;

public class NinjaCat extends Critter {

    Color typeColor;
    int kill;

    public NinjaCat() {
        this.typeColor = Color.WHITE;
        this.kill = 0;
    }

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            this.kill++;
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    public Color getColor() {
        if (kill > 0) {
            typeColor = Color.BLACK;
        } else if (kill > 5) {
            typeColor = Color.RED;
        } else {
            typeColor = Color.ORANGE;
        }
        return typeColor;
    }

    public String toString() { return "K" + kill; }
}