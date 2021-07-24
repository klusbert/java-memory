package Objects.MiniMap;

import Objects.Client;
import Objects.Location;
import Util.MemoryRegion;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class MiniMap {


    private Client client;

    private String path;

    private List<MapFile> mapFiles;
    private Floor[] floors;

    public MiniMap(Client client) {

        File myObj = new File("/proc/" + client.getPid() + "/maps");
        mapFiles = new ArrayList<>();

        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);


            String line = myReader.nextLine();
            int startPos = line.indexOf("/home/");

            path = line.substring(startPos).replace("bin/client", "") + "minimap/";
            System.out.println(path);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.readWaypointCost();
        this.getBoundaries();

    }

    private void readWaypointCost() {
        File folder = new File(this.path);
        FileFilter fileFilter = file -> !file.isDirectory() && file.getName()
                .endsWith(".png");

        for (File f : folder.listFiles(fileFilter)) {


            String[] filename = f.getName().replace(".png", "").split("_");
            if (filename[1].equals("Color")) {

                Location location = new Location();
                String colorFullLocation = f.getAbsolutePath();
                String waypointCostFullLocation = colorFullLocation.replace("Color", "WaypointCost");

                File color = new File(colorFullLocation);
                File waypoint = new File(waypointCostFullLocation);

                location.setX(Integer.parseInt(filename[2]));
                location.setY(Integer.parseInt(filename[3]));
                location.setZ(Integer.parseInt(filename[4]));

                BufferedImage imageColor = null;
                BufferedImage imageWayPoint = null;
                try {
                    imageColor = ImageIO.read(color);
                    imageWayPoint = ImageIO.read(waypoint);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mapFiles.add(new MapFile(location, imageColor, imageWayPoint));

            }


        }
    }

    private void getBoundaries() {

        int minZ = Integer.MAX_VALUE;
        int maxZ = Integer.MIN_VALUE;
        for (MapFile m : this.mapFiles) {
            if (m.getLocation().getZ() > maxZ)
                maxZ = m.getLocation().getZ();
            if (m.getLocation().getZ() < minZ)
                minZ = m.getLocation().getZ();

        }
        floors = new Floor[maxZ];

        for (int z = minZ; z < maxZ; z++) {
            int finalZ = z;
            floors[z] = new Floor(z, mapFiles.stream().filter(mapFile -> mapFile.getLocation().getZ() == finalZ).collect(Collectors.toList()));

        }
        System.out.println("Minz " + minZ + " maxZ " + maxZ);

    }

    public Color getColor(Location location) {
        try {
            return this.floors[location.getZ()].getColor(location);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

