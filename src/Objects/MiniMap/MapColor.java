package Objects.MiniMap;

import java.awt.*;

public class MapColor {


    public Color getMapColor() {
        return mapColor;
    }

    public Color getWaypointColor() {
        return waypointColor;
    }

    private Color mapColor;
    private Color waypointColor;

    public MapColor(Color mapColor) {
        this.mapColor = mapColor;

    }


}
