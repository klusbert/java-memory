import Objects.Client;

public class Program {


    private static Client client;

    public static void main(String[] args) {
        int processId = 48764;

        client = new Client(processId);


        client.getBattleList().readBattleList();

    }
}
