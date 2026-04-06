package Layout;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class WorkingWithMenuTest {

    private WorkingWithMenu window;

    @BeforeEach
    void setUp() {
        // Skip GUI tests if running in headless environment (Jenkins)
        assumeFalse(GraphicsEnvironment.isHeadless(), "Skipping GUI tests in headless environment");

        assertDoesNotThrow(() -> window = new WorkingWithMenu());
    }

    @AfterEach
    void tearDown() {
        if (window != null) {
            assertDoesNotThrow(() -> window.dispose());
        }
    }

    @Test
    void createFrame() {
        assertSame(CardLayout.class, window.mainPanel.getLayout().getClass());

        assertEquals(600, window.getWidth(), "Window width must be 600");
        assertEquals(400, window.getHeight(), "Window height must be 400");

        assertDoesNotThrow(() -> window.setVisible(true));
    }

    @Test
    void createAndAddPanels() {
        Component[] panels = window.mainPanel.getComponents();

        assertSame(3, panels.length);

        for (Component c : panels) {
            assertInstanceOf(JPanel.class, c);
        }

        assertSame(Color.CYAN, panels[0].getBackground());
        assertSame(Color.LIGHT_GRAY, panels[1].getBackground());
        assertSame(Color.ORANGE, panels[2].getBackground());
    }

    @Test
    void createMenuBar() {
        JMenuBar menuBar = window.getJMenuBar();

        assertInstanceOf(JMenuBar.class, menuBar);

        JMenu menu = menuBar.getMenu(0);
        assertInstanceOf(JMenu.class, menu);

        assertSame("Navigate", menu.getText());

        assertSame(3, menu.getItemCount());
    }

    @Test
    void createHomeMenuItem() {
        JMenuItem homeItem = window.createHomeMenuItem();

        assertInstanceOf(JMenuItem.class, homeItem);
        assertSame("Home", homeItem.getText());

        assertDoesNotThrow(() -> homeItem.doClick());
    }

    @Test
    void createSettingsMenuItem() {
        JMenuItem settingsItem = window.createSettingsMenuItem();

        assertInstanceOf(JMenuItem.class, settingsItem);
        assertSame("Settings", settingsItem.getText());
        assertDoesNotThrow(() -> settingsItem.doClick());
    }

    @Test
    void createAboutMenuItem() {
        JMenuItem aboutItem = window.createAboutMenuItem();

        assertInstanceOf(JMenuItem.class, aboutItem);
        assertSame("About", aboutItem.getText());
        assertDoesNotThrow(() -> aboutItem.doClick());
    }
}