package myspring.dal;

import myspring.model.*;
import java.util.List;

public interface BankTransfersCustomRepository {
	List<BankTransfer> getTransferByEmailByThreeDay(String Email);

	
	void DoTransfer(BankTransfer b);

	List<Account> getAccountThatMadrTransferOf1000LastThreeDay();


	void dotransferOf100Shekels(String email1, String email2);
}
