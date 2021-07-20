package Objects;

public class Location {

    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    private int y;
    private int z;

    public Location() {
        x = -1;
        y = -1;
        z = -1;
    }

    public Location(int _x, int _y, int _z) {
        this.x = _x;
        this.y = _y;
        this.z = _z;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
