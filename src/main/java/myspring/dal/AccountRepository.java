package myspring.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import myspring.model.Account;
@Repository //כך מגדירים את האובייקט שניגש לנתונים 
public interface AccountRepository extends CrudRepository<Account, Integer> 
//יורש ממשק מובנה המכיל את כל הפעולות הבסיסיות על מחלקת חשבון
{
	
	Iterable<Account> findByTelephone(String telephone);
	
	Account findByEmailAndPassword(String email, String password);
	
	Account findByAccountNumberAndPassword(int accountNumber, String password);
	
}
