package com.wipro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.Bean.AccountBean;
import com.wipro.Bean.CustomerBean;
import com.wipro.Bean.TransactionBean;
import com.wipro.Exception.RecordNotFoundException;
import com.wipro.Service.TransactionService;

@RestController
@RequestMapping("/transaction")

public class TransactionController {

	@Autowired
	TransactionService ts;
	
	@RequestMapping(value="/transfer/{accountNumber}", method=RequestMethod.PUT)
	public String AmountTransfer(@PathVariable("accountNumber") Long accountNumber,TransactionBean tb, AccountBean ab)
	{
		return ts.AmountTransfer(accountNumber,tb,ab);
	}
}
