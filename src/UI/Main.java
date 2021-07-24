package UI;

import Objects.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private JButton button1;
    private JPanel panelMain;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JList list1;
    private Client client;

    public Main() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                button1.setText(client.getBattleList().getPlayer().getName());
                button1.setBackground(client.getMiniMap().getColor(client.getPlayer().getLocation()));

            }
        });


        this.client = new clientChooser().getClient();
        this.client.selectClient();
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
