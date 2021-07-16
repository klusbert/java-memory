package Objects;

public class Location {

    private int x;
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
