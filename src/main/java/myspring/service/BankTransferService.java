package myspring.service;

import java.util.List;

import myspring.model.BankTransfer;

public interface BankTransferService {
	public List<BankTransfer> getTransferByEmailByThreeDay(String Email);
	public void DoTransfer(BankTransfer b) ;

}
