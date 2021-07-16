import Objects.Client;

public class Program {


    private static Client client;

    public static void main(String[] args) {
        int processId = 8629;


        client = new Client(processId);

    }
}
