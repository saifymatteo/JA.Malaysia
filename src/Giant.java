import java.awt.*;

public class Giant extends Critter {

    static Color typeColor = Color.GRAY;
    int counter;

    public Giant() {
        this.counter = 1;
    }

    public Action getMove(CritterInfo info) {
        this.counter++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    public Color getColor() { return typeColor; }

    // TODO: "fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves, then "fum" for 6 moves, then repeat.
    public String toString() {
        if (this.counter > 24) {
            this.counter = 1;
        }

        if (this.counter <= 6) {
            return "fee";
        } else if (this.counter <= 12) {
            return "fie";
        } else if (this.counter <= 18) {
            return "foe";
        } else {
            return "fum";
        }
    }
}