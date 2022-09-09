package myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.dal.BankTransfersRepository;
import myspring.model.BankTransfer;

@Service
public class BankTransferServiceImpl implements BankTransferService{

	@Autowired
BankTransfersRepository bT;
	public List<BankTransfer> getTransferByEmailByThreeDay(String Email){
	
	List<BankTransfer> l=bT.getTransferByEmailByThreeDay(Email);
	return l;
}
	
	public void DoTransfer(BankTransfer b) {
	bT.DoTransfer(b);
		
	}
}
