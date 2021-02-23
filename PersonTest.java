package vendormachine.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendormachine.users.util.Wallet;

import static org.junit.jupiter.api.Assertions.*;

// Example 100% Person Test Coverage
// add @Ignore above class to help WalletTest.java
public class PersonTest {

	@Test
	public void personConstructorTest() {
		Person person = new Person("Henry");
		assertEquals("Henry", person.getName());
		assertNull(person.getWallet());
	}

	@Test
	public void personConstructorTest1() {
		Wallet wallet = new Wallet();
		Person person = new Person("Henry", wallet);
		assertEquals("Henry", person.getName());
		assertEquals(wallet, person.getWallet());
	}

	@Test
	public void creditSettersAndGettersTest() {
		Wallet wallet = new Wallet();
		Person person = new Person("Henry", wallet);

		// Succeed in taking money
		float amountTaken = person.getCredit(0.2f);
		assertEquals(0.2f, amountTaken);
		assertEquals(0.3f, person.getWallet().getStoredCredit());

		// Not enough money in wallet
		float noneTaken = person.getCredit(20.0f);
		assertEquals(0.0f, noneTaken);
		assertEquals(0.3f, person.getWallet().getStoredCredit());

		// Add credit interlude
		person.addCredit(0.2f);
		assertEquals(0.5f, person.getWallet().getStoredCredit());

		// Wallet is null (adding and removing credit)
		person.setWallet(null);
		float nullTaken = person.getCredit(0.5f);
		assertEquals(0.0f, nullTaken);
		assertNull(person.getWallet());

		person.addCredit(0.5f);
	}

	@Test
	public void nameSettersAndGettersTest() {
		Person person = new Person("Henry");
		assertEquals("Henry", person.getName());

		person.setName("Sam");
		assertEquals("Sam", person.getName());
	}

	@Test
	public void walletSettersAndGettersTest() {
		Wallet wallet = new Wallet();
		Person person = new Person("Henry", wallet);
		assertEquals(wallet, person.getWallet());

		Wallet bigWallet = new Wallet(20.0f);
		person.setWallet(bigWallet);
		assertEquals(bigWallet, person.getWallet());
	}
}