package Objects.MiniMap;

import Objects.Location;

import java.awt.image.BufferedImage;

public class MapFile {


    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public BufferedImage getImageColor() {
        return imageColor;
    }

    public void setImageColor(BufferedImage imageColor) {
        this.imageColor = imageColor;
    }

    public BufferedImage getImageWaypoint() {
        return imageWaypoint;
    }

    public void setImageWaypoint(BufferedImage imageWaypoint) {
        this.imageWaypoint = imageWaypoint;
    }

    private BufferedImage imageColor;
    private BufferedImage imageWaypoint;


    public MapFile(Location location, BufferedImage imageColor, BufferedImage imageWaypoint) {
        this.location = location;
        this.imageColor = imageColor;
        this.imageWaypoint = imageWaypoint;


    }
}
