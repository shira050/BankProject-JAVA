package myspring.controller;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import myspring.dto.DtoAccount;
import myspring.model.Account;
import myspring.service.AccountService;

@RestController
@RequestMapping("/users")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@GetMapping
	public ResponseEntity<DtoAccount> getByEmailAndPass(@RequestParam("email") String email, @RequestParam("password") String pass)
//&	//ניתן להוסיף אותם בכתובת אחרי ששמים סימן שאלה ולכל פרמטר נוסף את הסימן //request//באופן זה הפרמטרים הינם פרמטרים שמתקבלים מה 
	{	
		return new ResponseEntity<>(mapper.map(accountService.getByEmailAndPassword(email, pass),DtoAccount.class),HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity update(@RequestBody DtoAccount obj) 
	{
	DtoAccount a=mapper.map(accountService.getByEmailAndPassword(obj.getEmail(), obj.getPassword()),DtoAccount.class)
		if(obj.getBalance()==a.getBalance()&&obj.getAccountOwnerName()==a.getAccountOwnerName())
		{	accountService.update(mapper.map(accountService,Account.class));
			return new ResponseEntity<>("good",HttpStatus.OK);}
		//הפונקציה תבדוק אם קיים המשתמש עם מספר חשבון והסיסמה המתאימים
		
		//וגם התעודת זהות והיתרה זהה למקור
		//אם כן העידכון יתבצע
		//אם לא להחזיר סטטוס לא מורשה
		
		
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//במקרה שהוא לא מורשה
	}
	
	
	/*@GetMapping
	public Iterable<DtoAccount> getAll()
	{
		ArrayList<DtoAccount> list=new ArrayList<>();
		mapper.map(accountService.getAll(),list);
		return list;
	}
	*/
	
	
	
	
	
	
	/*
	@GetMapping
	@RequestMapping("/getByTelephone/{tel}")
	public Iterable<DtoAccount> getByTel(@PathVariable String tel)
//באופן זה מקבלים פרמטר מהנתיב של הכתובת 
	{
		
		ArrayList<DtoAccount> list=new ArrayList<>();
	    mapper.map( accountService.getByTelephone(tel),list);
	    return list;
	}
	*/
	
	/*
	@PostMapping
	public void addOrUpdate(@RequestBody DtoAccount a)
	{
		accountService.addOrUpdate(mapper.map(a, Account.class));
	}*/

}
