package myspring.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;

@Entity//מדובר במחלקה שמייצגת ישות
@Table//כל מופע של המחלקה הוא רשומה של הטבלה המתאימה
public class Account {
	@Id //מייצג שדה מפתח בטבלה
	@GeneratedValue(strategy = GenerationType.IDENTITY)//שדה של מיספור אוטומטי
	@Column//מייצג שדה בטבלה
	private int accountNumber;	
	@Column
	private String accountOwnerName;
	@Column
	private double balance;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String telephone;
	@Column
	private String cellphone;
	
	@OneToMany(mappedBy = "accountFrom",fetch = FetchType.LAZY)//הגדרת השם של השדה בישות של הרבים שמכיל הפניה לישות הנוכחית
	private Collection<BankTransfer> transfersFromAccount;//ההעברות מהחשבון הנוכחי
	
	@OneToMany(mappedBy = "accountTo",fetch = FetchType.LAZY)//הגדרת השם של השדה בישות של הרבים שמכיל הפניה לישות הנוכחית
	private Collection<BankTransfer> transfersToAccount;//העברות לחשבון הנוכחי
	
	
	public Collection<BankTransfer> getTransfersFromAccount() {
		return transfersFromAccount;
	}

	public void setTransfersFromAccount(Collection<BankTransfer> transfersFromAccount) {
		this.transfersFromAccount = transfersFromAccount;
	}

	public Collection<BankTransfer> getTransfersToAccount() {
		return transfersToAccount;
	}

	public void setTransfersToAccount(Collection<BankTransfer> transfersToAccount) {
		this.transfersToAccount = transfersToAccount;
	}

	
	
	public Account() {
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountOwnerName() {
		return accountOwnerName;
	}

	public void setAccountOwnerName(String accountOwnerName) {
		this.accountOwnerName = accountOwnerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	
	

}
