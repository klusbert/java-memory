package UI;

import Objects.Client;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;

public class clientChooser extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;

    public Client client;
    List<Client> clientList;

    public clientChooser() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        DefaultListModel<String> model = new DefaultListModel<>();

        clientList = Client.getClients();

        list1.setModel(model);

        clientList.forEach(client -> model.addElement(client.toString()));


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        Client.getClients();
    }

    private void onOK() {

        if (list1.getSelectedIndex() > -1)
            this.client = clientList.get(list1.getSelectedIndex());
         else
            this.client = null;

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        this.client = null;
        dispose();

    }

    public Client getClient() {
        this.pack();
        this.setVisible(true);
        return client;
    }

    public static void main(String[] args) {
        clientChooser dialog = new clientChooser();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
