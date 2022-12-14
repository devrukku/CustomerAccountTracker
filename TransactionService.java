package com.wipro.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.Bean.AccountBean;
import com.wipro.Bean.CustomerBean;
import com.wipro.Bean.TransactionBean;
import com.wipro.DAO.AccountDao;
import com.wipro.DAO.CustomerDao;
import com.wipro.DAO.TransactionDao;
import com.wipro.Exception.RecordNotFoundException;

@Service
public class TransactionService {
	@Autowired
	TransactionDao td;
	
	@Autowired
	AccountDao ad;
	
	public String AmountTransfer(long accountNumber,TransactionBean tb,AccountBean ab)
	{
		Optional<AccountBean> transaction=ad.findByAccountNumber(accountNumber);
		String result="";
		if(transaction.isPresent())
		{
			tb.setAmount(tb.getAmount());
			tb.setBeneficiaryAccountNumber(tb.getBeneficiaryAccountNumber());
			tb.setBeneficiaryName(tb.getBeneficiaryName());
			AccountBean acc=transaction.get();
			if(acc.getBalanceAmount()>tb.getAmount())
			{
				tb.setBalanceAmount(acc.getBalanceAmount()-tb.getAmount());
				td.save(tb);
				acc.setBalanceAmount(acc.getBalanceAmount()-tb.getAmount());
				ad.save(acc);
				result=result+ "Transaction Successfull";
			}
			else
			{
				result=result+ "Max amount available for transaction is "+acc.getBalanceAmount();
			}
		return result;
		}
		else
		{
			return "Account Number Not Found";
		}
	}
}
