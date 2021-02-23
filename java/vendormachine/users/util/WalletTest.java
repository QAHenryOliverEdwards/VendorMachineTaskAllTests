package vendormachine.users.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WalletTest {

    @Test
    public void walletConstructorTest() {
        Wallet wallet = new Wallet();
        assertEquals("Generic", wallet.getBrand());
        assertEquals(0.5f, wallet.getStoredCredit());
    }

    @Test
    public void walletConstructorTest1() {
        Wallet wallet = new Wallet(2.0f);
        assertEquals("Generic", wallet.getBrand());
        assertEquals(2.0f, wallet.getStoredCredit());
    }

    @Test
    public void walletConstructorTest2() {
        Wallet wallet = new Wallet("Hugo Boss", 5.0f);
        assertEquals("Hugo Boss", wallet.getBrand());
        assertEquals(5.0f, wallet.getStoredCredit());
    }

    @Test
    public void creditSettersAndGettersTest() {
        Wallet wallet = new Wallet();
        wallet.addCredit(2.0f);
        assertEquals(2.5f, wallet.getStoredCredit());

        // Will retrieve
        float amountTaken = wallet.getCredit(0.5f);
        assertEquals(0.5f, amountTaken);
        assertEquals(2.0f, wallet.getStoredCredit());

        // Fails not enough money
        float failsToTake = wallet.getCredit(200.0f);
        assertEquals(0.0f, failsToTake);
        assertEquals(2.0f, wallet.getStoredCredit());
    }

    @Test
    public void brandSetterAndGettersTest() {
        Wallet wallet = new Wallet();
        assertEquals("Generic", wallet.getBrand());

        wallet.setBrand("Armani");
        assertEquals("Armani", wallet.getBrand());
    }

    @Test
    public void storedCreditGettersAndSettersTest() {
        Wallet wallet = new Wallet();
        assertEquals(0.5f, wallet.getStoredCredit());

        wallet.setStoredCredit(5.0f);
        assertEquals(5.0f, wallet.getStoredCredit());
    }
}
