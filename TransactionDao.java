package com.wipro.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.Bean.TransactionBean;

@Repository
public interface TransactionDao extends CrudRepository<TransactionBean, Integer> {

}
