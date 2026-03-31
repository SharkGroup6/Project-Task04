package Layout;

import javax.swing.*;
import java.awt.*;

public class WorkingWithMenu extends JFrame {
    CardLayout cardLayout;
    JPanel mainPanel;

    public WorkingWithMenu() {
        CreateFrame();
    }

    public void CreateFrame() {
        setTitle("Swing Application with Panels and Menu");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        createAndAddPanels();
        setJMenuBar(createMenuBar());
        add(mainPanel);
        setVisible(true);
    }

    public void createAndAddPanels() {
        JPanel homePanel = new JPanel();
        homePanel.setBackground(Color.CYAN);
        homePanel.add(new JLabel("Welcome to the Home Page!"));
        mainPanel.add(homePanel, "Home");

        JPanel settingsPanel = new JPanel();
        settingsPanel.setBackground(Color.LIGHT_GRAY);
        settingsPanel.add(new JLabel("Settings Page"));
        settingsPanel.add(new JCheckBox("Enable Feature"));
        settingsPanel.add(new JButton("Save Settings"));
        mainPanel.add(settingsPanel, "Settings");

        JPanel aboutPanel = new JPanel();
        aboutPanel.setBackground(Color.ORANGE);
        aboutPanel.add(new JLabel("About This Application"));
        aboutPanel.add(new JLabel("Version 1.0"));
        aboutPanel.add(new JLabel("Created with Swing"));
        mainPanel.add(aboutPanel, "About");
    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Navigate");

        menu.add(createHomeMenuItem());
        menu.add(createSettingsMenuItem());
        menu.add(createAboutMenuItem());

        menuBar.add(menu);
        return menuBar;
    }

    public JMenuItem createHomeMenuItem() {
        JMenuItem homeItem = new JMenuItem("Home");
        homeItem.addActionListener(_ -> cardLayout.show(mainPanel, "Home"));
        return homeItem;
    }

    public JMenuItem createSettingsMenuItem() {
        JMenuItem settingsItem = new JMenuItem("Settings");
        settingsItem.addActionListener(e -> cardLayout.show(mainPanel, "Settings"));
        return settingsItem;
    }

    public JMenuItem createAboutMenuItem() {
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> cardLayout.show(mainPanel, "About"));
        return aboutItem;
    }
}