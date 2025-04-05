package csc216.magazine.clippings.oceresa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class AppTest {
    private App app;

    @BeforeEach
    public void setUp() {
        app = new App();
    }

    @Test
    public void testZero() {
        assertTrue(app.canCreateNote("", new String[]{}));
    }

    @Test
    public void testOne() {
        assertTrue(app.canCreateNote("Baja Blast", new String[]{"baja blast"}));
        assertFalse(app.canCreateNote("Baja Blast", new String[] {"5 Layer Beefy Burrito"}));
    }

    @Test
    public void testMany() {
        assertTrue(app.canCreateNote("Baja Blast", new String[] {"Baja B", "last"}));
        assertFalse(app.canCreateNote("Baja Blast", new String[] {"Baja B", "loat"}));
    }

    @Test
    public void testBoundaryCases() {
        assertTrue(app.canCreateNote("b", new String[]{"b"}));
        assertFalse(app.canCreateNote("b", new String[]{""}));
    }

    @Test
    public void testOnePart() {
        assertTrue(app.canCreateNote("Baja", new String[]{"Baja Blast"}));
    }

    @Test
    public void testExceptions() {
        assertFalse(app.canCreateNote("Baja Blast", new String[] {null}));
        assertFalse(app.canCreateNote(null, new String[] {"Baja Blast"}));
    }
}
