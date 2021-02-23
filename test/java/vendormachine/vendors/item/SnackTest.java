package vendormachine.vendors.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnackTest {

    @Test
    public void snackConstructorTest() {
        Snack snack = new Snack(2.0f);
        assertEquals(2.0f, snack.getPrice());
    }

    @Test
    public void snackConstructorTest2() {
        Snack snack = new Snack("Chocolate",  2.0f);
        assertEquals("Chocolate", snack.getName());
        assertEquals(2.0f, snack.getPrice());
    }

    @Test
    public void snackCostTest() {
        Snack snack = new Snack(2.0f);
        float cost = snack.cost();
        assertEquals(2.0f, cost);
    }

    @Test
    public void snackSetValueTest() {
        Snack snack = new Snack(2.0f);
        snack.setValue(1.0f);
        assertEquals(1.0f, snack.getPrice());
    }

    @Test
    public void snackNameSetterAndGettersTest() {
        Snack snack = new Snack("Fudge", 3.0f);
        assertEquals("Fudge", snack.getName());

        snack.setName("Crisps");
        assertEquals("Crisps", snack.getName());
    }

    @Test
    public void snackPriceSettersAndGettersTest() {
        Snack snack = new Snack("Fudge", 3.0f);
        assertEquals(3.0f, snack.getPrice());

        snack.setPrice(3.5f);
        assertEquals(3.5f, snack.getPrice());
    }
}
