import Objects.Client;

public class Program {


    private static Client client;

    public static void main(String[] args) {
        int processId = 8629;

        client = new Client(processId);
        System.out.println(client.getPlayer().getLocation());
        System.out.println(client.getPlayer().getExperience());
        System.out.println(client.getInventory().getInventoryCount());

    }
}
