package myspring.dal;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import myspring.model.Account;
import myspring.model.BankTransfer;

public class BankTransfersCustomRepositoryImpl implements BankTransfersCustomRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public List<Account> getAccountThatMadrTransferOf1000LastThreeDay() {
		javax.persistence.Query q = em.createQuery(
				"select a from Account a join a.fromBankTransfers b where b.sum>=100 and  b.dateOfTransfer >= :dateParam ");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -3);
		Date d = c.getTime();
		q.setParameter("dateParam", d);
		List<Account> list = q.getResultList();
		return list;
	}

	@Override
	@Transactional
	public void dotransferOf100Shekels(String email1, String email2) {
		BankTransfer b = new BankTransfer();
		b.setSumOfTransfer((float) 100);
		b.setDateOfTransfer(new Date());
		synchronized (Object.class) {
			javax.persistence.Query q = em.createQuery("select a from Account a where a.email= :emailParam ");
			q.setParameter("emailParam", email1);
			Account from = (Account) q.getSingleResult();
			q.setParameter("emailParam", email2);
			Account to = (Account) q.getSingleResult();
			if (from == null || to == null)
				throw new RuntimeException("אחד מהחשבונות לא קיים!");

			b.setAccountNumFrom(from.getAccountNumber());
			b.setAccountNumTo(to.getAccountNumber());

			if (from.getBalance() >= b.getSumOfTransfer()) {
				from.setBalance(from.getBalance() - b.getSumOfTransfer());
				to.setBalance(to.getBalance() + b.getSumOfTransfer());
			} else
				throw new RuntimeException("לא ניתן לבצע בגלל יתרה נמוכה");
		}
		em.persist(b);
	}

	@Override
	@Transactional
	//נבדק
	public List<BankTransfer> getTransferByEmailByThreeDay(String Email) {
		javax.persistence.Query q = em.createQuery("select b from BankTranfer b"
				+ " join b.accountFrom a1 join b.accountTo a2 where (a1.email=:emailParam or a2.email=:emailParam) and  b.dateOfTransfer >= :dateParam ");// ׳׳¡׳“׳¨
		// ׳©׳׳™׳׳×׳”

		q.setParameter("emailParam", Email);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -3);
		Date d = c.getTime();
		q.setParameter("dateParam", d);
		List<BankTransfer> list = q.getResultList();
		return list;
	}

	@Override
	@Transactional
	//נבדק
	public void DoTransfer(BankTransfer b) {
		synchronized (Object.class) {
			javax.persistence.Query q = em.createQuery("select a from Account a where a.accountNumber=:accountParams ");
			q.setParameter("accountParams", b.getAccountNumTo());
			Account aTo = (Account) q.getSingleResult();
			if (aTo == null)
				throw new RuntimeException("אחד מהחשבונות לא קיים!");
			q.setParameter("accountParams", b.getAccountNumFrom());
			
			Account aFrom = (Account) q.getSingleResult();
			if (aFrom == null)
				throw new RuntimeException("אחד מהחשבונות לא קיים!");

			Calendar c = Calendar.getInstance();
			b.setDateOfTransfer(c.getTime());
			if (aFrom.getBalance() < b.getSumOfTransfer())
				throw new RuntimeException("לא ניתן לבצע בגלל יתרה נמוכה!");
			else
			{
				aFrom.setBalance(aFrom.getBalance()-b.getSumOfTransfer());
				aTo.setBalance(aTo.getBalance()+b.getSumOfTransfer());
				em.persist(b);
			}
		}
		
	}

}
