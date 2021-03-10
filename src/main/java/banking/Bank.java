package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	Long accStartNum = 1000L;
	
	public Bank() {
		accounts = new LinkedHashMap<>(); 
	}

	private Account getAccount(Long accountNumber) {
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		Long accountNum = accStartNum++;
		Account ca = new CommercialAccount(company, accountNum, pin, startingDeposit);
		accounts.put(accountNum, ca);
		return accountNum;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		Long accountNum = accStartNum++;
		Account ca = new ConsumerAccount(person, accountNum, pin, startingDeposit);
		accounts.put(accountNum, ca);
		return accountNum;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		return accounts.get(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		 accounts.get(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		return accounts.get(accountNumber).debitAccount(amount);
	}
}
