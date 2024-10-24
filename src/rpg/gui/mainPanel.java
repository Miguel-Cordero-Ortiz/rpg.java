package rpg.gui;

import javax.swing.*;
import java.awt.*; // Importamos todas las clases de AWT
import rpg.gui.TopPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.BottomPanel;
import rpg.gui.BackgroundPanel;

public class mainPanel extends JFrame {

    private JPanel mainPanel;

    public mainPanel() {
        // Configuración del JFrame
        setTitle("RPG Game");
        setSize(1280, 860);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Usamos un layout para organizar los paneles
        mainPanel = new JPanel(new BorderLayout());

        // Crear los diferentes paneles
        TopPanel topPanel = new TopPanel();
        MiddlePanel middlePanel = new MiddlePanel();
        BottomPanel bottomPanel = new BottomPanel();
        BackgroundPanel backgroundPanel = new BackgroundPanel();

        // Agregar los paneles al mainPanel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Configurar el contenido del JFrame
        setContentPane(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new mainPanel();
    }
}
