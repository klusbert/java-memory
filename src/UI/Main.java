package UI;

import Objects.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private JButton button1;
    private JPanel panelMain;

    public Main() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                clientChooser clientChooser = new clientChooser();


                System.out.println(clientChooser.getClient());
            }
        });
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Main");
        jFrame.setContentPane(new Main().panelMain);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
