package Objects;

import Addresses.AddressIdentifier;
import Addresses.AddressScanner;
import Objects.MiniMap.MiniMap;
import Util.Bash;
import Util.Memory;
import Util.MemoryScanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Client {

    private int pid;

    private int windowIdentifier;
    private Bash bash;
    private Memory memory;
    private MemoryScanner memoryScanner;

    private AddressScanner addressScanner;
    private Map<AddressIdentifier, Long> addresses;
    private Player player;
    private MiniMap miniMap;
    private Inventory inventory;
    private BattleList battleList;


    public Client(int _tibiaPid) {
        this.pid = _tibiaPid;
        this.bash = new Bash();
        this.findWindowIdentifier();
    }


    /**
     * Only call this method when you have selected to work with this client.
     */
    public void selectClient() {
        memory = new Memory(this.pid);
        memoryScanner = new MemoryScanner(this.pid);

        addresses = new HashMap<AddressIdentifier, Long>();
        addressScanner = new AddressScanner(memoryScanner, addresses);


        player = new Player(this);
        inventory = new Inventory(this);
        battleList = new BattleList(this);
        miniMap = new MiniMap(this);
    }

    public long getAddress(AddressIdentifier identifier) {
        return addresses.get(identifier);
    }

    public Memory getMemory() {
        return memory;
    }

    public Player getPlayer() {
        return player;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public BattleList getBattleList() {
        return battleList;
    }


    public int getPid() {
        return this.pid;
    }

    public String getWindowTitle() {
        List<String> result = this.bash.executeCommand("xdotool getwindowname " + this.windowIdentifier);
        return result.get(0);
    }

    public boolean isLoggedIn() {
        return this.getWindowTitle().contains("-");
    }

    public String getCharacterName() {

        if (this.isLoggedIn()) {
            String[] title = this.getWindowTitle().split("-");
            return title[1].trim();
        }
        return "offline";
    }

    @Override
    public String toString() {
        return "Client{" +
                "pid=" + pid + ", " +
                "loggedIn=" + this.isLoggedIn() + ", " +
                "character=" + this.getCharacterName() +
                '}';
    }

    /**
     * This method require xdotool
     * http://manpages.ubuntu.com/manpages/trusty/man1/xdotool.1.html
     */
    private void findWindowIdentifier() {

        List<String> result = this.bash.executeCommand("xdotool search --pid " + this.pid + "getwindowname");
        this.windowIdentifier = Integer.parseInt(result.get(0));
    }

    public static List<Client> getClients() {

        ArrayList<Client> clients = new ArrayList<>();
        List<String> result = new Bash().executeCommand("ps -C client -o pid");
        for (String str : result) {
            if (str.toLowerCase().contains("pid")) continue;
            int pid = Integer.parseInt(str.trim());

            clients.add(new Client(pid));
        }
        return clients;


    }

}
