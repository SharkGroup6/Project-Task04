package Layout;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private WorkingWithMenu frame;

    @BeforeEach
    void setUp() {

        frame = new WorkingWithMenu();
    }

    @AfterEach
    void tearDown() {

        if (frame != null) {
            frame.dispose();
        }
    }

    @Test
    void testMenuItemsIndividually() {

        List<JMenuItem> menuItems = List.of(
                frame.createHomeMenuItem(),
                frame.createSettingsMenuItem(),
                frame.createAboutMenuItem()
        );


        assertAll("Menu Items Validation",
                () -> {

                    for (JMenuItem item : menuItems) {
                        assertNotNull(item, "Menu item should not be null");
                        assertTrue(item instanceof JMenuItem, "Item must be a JMenuItem instance");


                        assertTrue(item.isEnabled(), "Item " + item.getText() + " should be enabled");
                        assertDoesNotThrow(()->item.doClick(),"Clicking"+item.getText()+"should not throw an exception");
                        assertTimeout(Duration.ofMillis(100),()->item.getName(),"Retrieving properties for"+item.getText()+"took too long");
                    }
                }
        );
    }

    @Test
    void testPanelLayoutStructure() {

        assertAll("Panel and Component Checks",
                () -> assertNotNull(frame.mainPanel, "Main panel should be initialized"),
                () -> assertEquals(3, frame.mainPanel.getComponentCount(), "Should have exactly 3 panels")
        );
    }
}