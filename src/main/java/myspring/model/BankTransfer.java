package myspring.model;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table/*(name = "bank_tbl")*/
public class BankTransfer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column/*(name = "name_of_field_in_tbl - if different")*/
	private int code;
	@Column
	private int accountNumFrom;
	@Column
	private int accountNumTo;
	@Column
	private double sumOfTransfer;
	@Column
	@Temporal(TemporalType.TIMESTAMP)//באופן זה במסד הנתונים יהיה שדה מקביל של תאריך ושעה
	private Date dateOfTransfer;
	

	@JoinColumn(name = "accountNumFrom", referencedColumnName = "accountNumber", insertable = false, updatable = false)
	@ManyToOne
	private Account accountFrom;//הפניה לעצם שממנו נעשתה ההעברה
	@JoinColumn(name = "accountNumTo", referencedColumnName = "accountNumber", insertable = false, updatable = false)
	@ManyToOne
	private Account accountTo;//הפניה לעצם שאליו נעשתה ההעברה
	
	
	
	public Account getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(Account accountFrom) {
		this.accountFrom = accountFrom;
	}
	public Account getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(Account accountTo) {
		this.accountTo = accountTo;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getAccountNumFrom() {
		return accountNumFrom;
	}
	public void setAccountNumFrom(int accountNumFrom) {
		this.accountNumFrom = accountNumFrom;
	}
	public int getAccountNumTo() {
		return accountNumTo;
	}
	public void setAccountNumTo(int accountNumTo) {
		this.accountNumTo = accountNumTo;
	}
	public double getSumOfTransfer() {
		return sumOfTransfer;
	}
	public void setSumOfTransfer(double sumOfTransfer) {
		this.sumOfTransfer = sumOfTransfer;
	}
	public Date getDateOfTransfer() {
		return dateOfTransfer;
	}
	public void setDateOfTransfer(Date dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}
	
	
	

}
