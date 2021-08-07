package UI;

import Addresses.AddressIdentifier;
import Objects.Client;
import Objects.Creature;
import Objects.Location;
import Objects.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Main {

    private JButton button1;
    private JPanel panelMain;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JPanel panel1;
    private JLabel playerName;
    private JLabel food;
    private Client client;

    public Main() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                button1.setText(client.getBattleList().getPlayer().getName());
                button1.setBackground(client.getMiniMap().getColor(client.getPlayer().getLocation()));
                Player player = client.getPlayer();


                playerName.setText(player.getName());
                food.setText(player.getFoodStatus().toString());

                player.fullLight();

            }
        });


        this.client = new clientChooser().getClient();
        this.client.selectClient();

        System.out.println("EXP address" + String.format("0x%08X", client.getAddress(AddressIdentifier.PLAYER_EXPERIENCE)));
        if (client == null) {
            System.exit(-1);
        }

    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Main");
        jFrame.setContentPane(new Main().panelMain);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);


    }


}
