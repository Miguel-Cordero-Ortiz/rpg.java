package rpg.gui;
import rpg.gui.panels.TopPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.BottomPanel;
import javax.swing.*;
import java.awt.*;
public class MainWindow extends JFrame {
    private TopPanel topPanel;
    private MiddlePanel middlePanel;
    private BottomPanel bottomPanel;
    private JPanel MainWindow;

    public MainWindow() {
        initComponents();
    }
    private void initComponents() {
        // Configuramos la ventana
        setTitle("RPG Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Inicializamos y agregamos los paneles
        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel();

        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        // Ajustar el tamaño de la ventana y hacerla visible
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new); // Llama a la ventana en el hilo de eventos de Swing
    }
}