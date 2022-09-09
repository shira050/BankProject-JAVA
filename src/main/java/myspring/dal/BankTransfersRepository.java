package myspring.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import myspring.model.BankTransfer;
@Repository
public interface BankTransfersRepository extends CrudRepository<BankTransfer, Integer>,BankTransfersCustomRepository{

}



