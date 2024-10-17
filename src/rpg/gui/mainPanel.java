package rpg.gui;

import javax.swing.*;

public class mainPanel extends JFrame {

    private JPanel mainPanel;

    public mainPanel() {
        setTitle("RPG Game");
        setSize(1280, 860);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new mainPanel();
    }
}