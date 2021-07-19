package UI;

import Objects.Client;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class clientChooser extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;

    public String asd;

    public clientChooser() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        DefaultListModel<String> model = new DefaultListModel<>();
        list1.setModel(model);
        model.addElement("asd");
        model.addElement("asd1");
        model.addElement("asd2");


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
        ;
        this.asd = "ok " + list1.getSelectedIndex();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        this.asd = "not ok";
        dispose();

    }

    public String getClient() {
        this.pack();
        this.setVisible(true);
        return asd;
    }

    public static void main(String[] args) {
        clientChooser dialog = new clientChooser();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
