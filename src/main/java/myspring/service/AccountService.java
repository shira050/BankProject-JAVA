package myspring.service;


import java.util.List;

import myspring.model.Account;

public interface AccountService {
	
	void update(Account a);//פונקציה להוספה או עידכון של חשבון
	
	Iterable<Account> getAll();
	
	Iterable<Account> getByTelephone(String telephone);
	
	Account getByEmailAndPassword(String email,String password);

}
