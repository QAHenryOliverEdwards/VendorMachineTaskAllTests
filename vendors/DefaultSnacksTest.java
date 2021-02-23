package vendormachine.vendors;

import org.junit.jupiter.api.Test;
import vendormachine.vendors.item.Snack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.powermock.api.mockito.PowerMockito.*;

public class DefaultSnacksTest {

    private Snack snack = new Snack("Water", 0.20f);
    private Snack snack1 = new Snack("VanillaBurst", 1.75f);
    private Snack snack2 = new Snack("GoblinSpring", 0.90f);
    private Snack snack3 = new Snack("Comet Trails", 2.15f);
    private List<Snack> allSnacks = List.of(snack, snack1, snack2, snack3);

    @Test
    public void defaultSnacksTest() throws Exception {
        allSnacks.stream().forEach(System.out::println);
        List<Snack> snackList = Arrays.stream(DefaultSnacks.snackList).collect(Collectors.toList());
        for (int i = 0; i < allSnacks.size(); i++) {
            assertEquals(allSnacks.get(i).toString(), snackList.get(i).toString());
        }
    }
}
