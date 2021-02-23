package vendormachine.vendors.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BANDSTest {

    @Test
    public void brandsTest() {
        assertEquals("CaramelSprinkle", BRANDS.CaramelSprinkle.name());
        assertEquals("EnergyMax", BRANDS.EnergyMax.name());
        assertEquals("SoulWater", BRANDS.SoulWater.name());
        assertEquals("InFuse", BRANDS.InFuse.name());
    }
}
