package com.wipro.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.Bean.AccountBean;
import com.wipro.DAO.AccountDao;
import com.wipro.Exception.RecordNotFoundException;

@Service
public class AccountService {
	@Autowired
	AccountDao ad;
	
	@Autowired
	CustomerService cs;
	
	public AccountBean GetAccDetailsByAccNum(Long accountNumber) throws RecordNotFoundException
	{
		Optional<AccountBean> account=ad.findByAccountNumber(accountNumber);
		if(account.isPresent()) 
		{
			return account.get();
		}
		else
		{
			throw new RecordNotFoundException("No Customer record exist for given Account Number :"+accountNumber);
		}
	}

}
