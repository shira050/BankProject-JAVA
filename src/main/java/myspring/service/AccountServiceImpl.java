package myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.dal.AccountRepository;
import myspring.model.Account;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired//Spring  של  IoC באופן אוטומטי השדה ימולא על ידי מנגנון ה
	private AccountRepository accountRep;

	@Override
	public void update(Account a) {
		if(accountRep.existsById(a.getAccountNumber()))
			accountRep.save(a);
		else
			throw new RuntimeException("לא קיים ולכן לא ניתן לעדכן");
		
	}

	@Override
	public Iterable<Account> getAll() {
		return accountRep.findAll();
	}

	@Override
	public Iterable<Account> getByTelephone(String telephone) {
		return accountRep.findByTelephone(telephone);
	}

	@Override
	public Account getByEmailAndPassword(String email, String password) {
		return accountRep.findByEmailAndPassword(email, password);
	}

	
}
