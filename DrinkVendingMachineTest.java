package vendormachine.vendors;

import org.junit.jupiter.api.Test;
import vendormachine.users.Person;
import vendormachine.users.util.Wallet;
import vendormachine.vendors.DefaultSnacks;
import vendormachine.vendors.DrinkVendingMachine;
import vendormachine.vendors.enums.BRANDS;
import vendormachine.vendors.item.Snack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class DrinkVendingMachineTest {

	private List<BRANDS> allBrands = Arrays.stream(BRANDS.values()).collect(Collectors.toList());

	private List<Snack> allSnacks = Arrays.stream(DefaultSnacks.snackList).collect(Collectors.toList());

	@Test
	public void drinkVendingMachineConstructorTest() {
		DrinkVendingMachine actual = new DrinkVendingMachine();
		assertTrue(allBrands.contains(actual.getBrandName()));

		assertEquals(allSnacks ,actual.getDrinkList());
	}

	@Test
	public void drinkVendingMachineConstructorTest2() {
		DrinkVendingMachine actual = new DrinkVendingMachine(20.0f, BRANDS.InFuse);

		assertEquals(20.0f, actual.getAvailableCredit());
		assertEquals(BRANDS.InFuse, actual.getBrandName());

		assertEquals(allSnacks ,actual.getDrinkList());
	}

	@Test
	public void selectDrinkTest() {
		DrinkVendingMachine machine = new DrinkVendingMachine();

		// All pass test
		machine.setAvailableCredit(5.0f);

		// 1 Index is water, cost 1.75f
		Snack expectedSnack = machine.selectDrink(1);
		assertEquals(allSnacks.get(1), expectedSnack);
		assertEquals(3.25f, machine.getAvailableCredit());

		// Fails due to item not existing
		Snack snackNotFound = machine.selectDrink(-1);
		assertNull(snackNotFound);

		// Fails due to lack of available credit
		machine.setAvailableCredit(0.0f);
		Snack snackNotEnoughMoney = machine.selectDrink(1);
		assertNull(snackNotEnoughMoney);
	}

	@Test
	public void creditSettersAndGettersTest() {
		DrinkVendingMachine machine = new DrinkVendingMachine(20.0f, BRANDS.SoulWater);

		Wallet wallet = new Wallet(10.0f);
		Person person = new Person("Henry", wallet);

		assertEquals(20.0f, machine.getAvailableCredit());

		machine.giveCredit(person, 2.0f);
		assertEquals(22.0f, machine.getAvailableCredit());

		machine.setAvailableCredit(5.0f);
		assertEquals(5.0f, machine.getAvailableCredit());
	}

	@Test
	public void brandNameSettersAndGettersTest() {
		DrinkVendingMachine machine = new DrinkVendingMachine(20.0f, BRANDS.EnergyMax);

		assertEquals(BRANDS.EnergyMax, machine.getBrandName());

		machine.setBrandName(BRANDS.CaramelSprinkle);
		assertEquals(BRANDS.CaramelSprinkle, machine.getBrandName());
	}

	@Test
	public void snackListSettersAndGettersTest() {
		DrinkVendingMachine machine = new DrinkVendingMachine(20.0f, BRANDS.SoulWater);

		assertEquals(allSnacks, machine.getDrinkList());

		Snack fakeSnack = new Snack("Chocolate", 2.0f);
		Snack fakeSnack1 = new Snack("Fudge", 3.0f);
		ArrayList<Snack> fakeSnackList = new ArrayList<>();
		fakeSnackList.add(fakeSnack);
		fakeSnackList.add(fakeSnack1);

		machine.setDrinkList(fakeSnackList);
		assertEquals(fakeSnackList, machine.getDrinkList());
	}
}
