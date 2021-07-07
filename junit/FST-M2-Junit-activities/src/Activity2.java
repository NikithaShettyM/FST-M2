import org.junit.jupiter.api.Test;
//import BankAccount;
//import NotEnoughFundsException;
import static org.junit.jupiter.api.Assertions.*;

public class Activity2 {
	@Test
	void notEnoughFunds() {
		// Create an object for BankAccount class
	BankAccount bal= new BankAccount(9);
	// Assertion for exception
    assertThrows(NotEnoughFundsException.class, () -> bal.withdraw(10), "Insufficient balance in the account");
	}
@Test
void enoughFunds() {
    // Create an object for BankAccount class
    BankAccount bal = new BankAccount(100);

    // Assertion for no exceptions
    assertDoesNotThrow(() -> bal.withdraw(100));
}
}
