package Objects.MiniMap;

import Objects.Client;
import Objects.Location;
import Util.MemoryRegion;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class MiniMap {


    private Client client;

    private String path;

    private Map<Location, MapFile> mapFileMap;

    public MiniMap(Client client) {

        File myObj = new File("/proc/" + client.getPid() + "/maps");

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

        readWaypointCost();

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

                boolean b = waypoint.exists();
                boolean b1 = color.exists();
                location.setX(Integer.parseInt(filename[2]));
                location.setY(Integer.parseInt(filename[3]));
                location.setZ(Integer.parseInt(filename[4]));
                System.out.println(location);

            }


        }
    }

}

