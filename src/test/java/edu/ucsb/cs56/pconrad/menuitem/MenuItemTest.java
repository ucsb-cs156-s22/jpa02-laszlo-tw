package edu.ucsb.cs56.pconrad.menuitem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MenuItemTest {

    private MenuItem smallPokeBowl;
    private MenuItem nothing;
    private MenuItem kobeSteak;

    // Provided
    @Test
    public void test_getPrice() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("$10.49", smallPokeBowl.getPrice());
    }

    @Test
    public void test_getPrice_10() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("    $10.49", smallPokeBowl.getPrice(10));
    }

    @Test
    public void test_getPrice_7() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals(" $10.49", smallPokeBowl.getPrice(7));
    }

    @Test
    public void test_getPrice_6() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("$10.49", smallPokeBowl.getPrice(6));
    }

    @Test
    public void test_getPrice_5() {
        assertThrows(MenuItem.TooNarrowException.class, () -> {
            smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
            smallPokeBowl.getPrice(5);
        });
    }

    @Test
    public void test_getPrice_0() {
        assertThrows(MenuItem.TooNarrowException.class, () -> {
            smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
            smallPokeBowl.getPrice(0);
        });
    }

    @Test
    public void test_toString() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("Small Poke Bowl,1049,Poke Bowls", smallPokeBowl.toString());
    }

    // Added

    @Test
    public void test_getName() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("Small Poke Bowl", smallPokeBowl.getName());
    }

    @Test
    public void test_getCategory() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("Poke Bowls", smallPokeBowl.getCategory());
    }

    @Test
    public void test_getPriceinCents() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals(1049, smallPokeBowl.getPriceInCents());
    }

    @Test
    public void test_getPrice_00() {
        nothing = new MenuItem("Nothing", 0, "Not Applicable");
        assertEquals("$0.00", nothing.getPrice());
    }

    @Test
    public void test_getPrice_100() {
        kobeSteak = new MenuItem("Kobe Steak", 100000, "Steaks");
        assertEquals("$1000.00", kobeSteak.getPrice());
    }

    @Test
    public void test_getPrice_101() {
        assertThrows(MenuItem.TooNarrowException.class, () -> {
            kobeSteak = new MenuItem("Kobe Steak", 100000, "Steaks");
            kobeSteak.getPrice(7);
        });
    }

}
