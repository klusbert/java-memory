package Objects.MiniMap;

import Objects.Location;

public class MapFile {


    private Location location;
    private String colorPath;
    private String waypointPath;


    public MapFile(Location location, String colorPath, String waypointPath) {
        this.location = location;
        this.colorPath = colorPath;
        this.waypointPath = waypointPath;


    }
}
