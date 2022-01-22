public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point ne) {
        this(ne.x, ne.y);
    }

    public double distance(Point other) {
        // Square both values of subtraction [Point other] and [Point current]
        double newX = Math.pow(other.x - this.x, 2);
        double newY = Math.pow(other.y - this.y, 2);

        // Find the square root of the sum of the both value
        return Math.sqrt(newX + newY);
    }

    public String toString() {
        return "java.awt.Point[x=" + this.x + ",y=" + this.y + "]";
    }
}
