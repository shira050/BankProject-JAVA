package myspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import myspring.dal.AccountRepository;
import myspring.dal.BankTransfersRepository;
import myspring.dto.*;
import myspring.model.Account;
import myspring.model.BankTransfer;
import myspring.service.AccountService;
import myspring.service.BankTransferService;

@RestController
@RequestMapping("/banktransfers")
public class BankTransferController {
	@Autowired
	BankTransferService bs;
	@Autowired
	AccountService a;
	@Autowired
	private AccountService accountService;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	AccountRepository acR;
	@GetMapping
	public ResponseEntity<List<DtoBankTransfer>> getLastThreeDays(@RequestParam("email") String email, @RequestParam("password") String pass)
	{
		Account ac=a.getByEmailAndPassword(email, pass);
		if(a!=null) {
       List<DtoBankTransfer> list;
			
	   mapper.map(bs.getTransferByEmailByThreeDay(email),list);
		return new ResponseEntity<>(HttpStatus.OK);//במקרה שהוא  מורשה

		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//במקרה שהוא לא מורשה

		//בודק אם קיים האימייל והסיסמה ואם כן מפעיל את הפונקציה של ההעברות
		//אם לא מחזיר סטטוס לא מורשה
	}
	
	@PostMapping
	public ResponseEntity doTransfer(@RequestBody DtoBankTransfer bt, @RequestParam String pass)
	{
		BankTransfer b=mapper.map(bt,BankTransfer.class);
		
		Account a= acR.findByAccountNumberAndPassword(b.getAccountNumFrom(),pass);
		if(a==null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(HttpStatus.OK);
		//בודק אם המספר חשבון מעביר והסיסמה תואמים ואם כן מבצע העברה ומחזיר סטטוס אוקי
		//אחרת מחזיר סטטוס לא מורשה
	}

}
