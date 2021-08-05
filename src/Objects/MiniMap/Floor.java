package Objects.MiniMap;

import Objects.Location;

import java.awt.*;
import java.util.List;

public class Floor {

    private int z;
    private int _startX, _endX, _startY, _endY;
    private List<MapFile> mapFiles;
    private Color[][] colorData;


    public Floor(int z, List<MapFile> mapFiles) {
        this.z = z;
        this.mapFiles = mapFiles;
        this.getBoundaryBox();

        this.colorData = new Color[_endX - _startX + 256][_endY - _startY + 256];
        this.readData();

    }

    private void getBoundaryBox() {

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (MapFile m : mapFiles) {
            if (m.getLocation().getX() > maxX)
                maxX = m.getLocation().getX();
            if (m.getLocation().getY() > maxY)
                maxY = m.getLocation().getY();
            if (m.getLocation().getX() < minX)
                minX = m.getLocation().getX();
            if (m.getLocation().getY() < minY)
                minY = m.getLocation().getY();

        }
        this._startX = minX;
        this._startY = minY;

        this._endX = maxX;
        this._endY = maxY;


    }

    private void readData() {
        for (MapFile m : mapFiles) {
            for (int x = 0; x < m.getImageColor().getWidth(); x++) {
                for (int y = 0; y < m.getImageColor().getHeight(); y++) {

                    int offsetX = m.getLocation().getX() - _startX + x;
                    int offsetY = m.getLocation().getY() - _startY + y;
                    this.colorData[offsetX][offsetY] = new Color(m.getImageColor().getRGB(x, y));


                }
            }
        }
    }

    public Color getColor(Location location) throws Exception {
        if (location.getZ() != this.z) {
            throw new Exception("This is on another floor!");
        }
        return this.colorData[location.getX() - _startX][location.getY() - _startY];
    }


}
