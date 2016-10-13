package com.enderase.services;

import java.util.List;

import com.enderase.entities.Account;

/**
 * Service for handling the account stuff related to the security.
 * 
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 */
public class AccountService {
	
	public Account create(Account account) {
		return account;
	}
	
	public Account update(Account account) {
		return account;
	}
	
	public boolean delete(Account account) {
		return true;
	}
	
	public List<Account> getActiveAccounts() {
		return null;
	}
	
	public String generateSecurityKey() {
		return "";
	}
	
	public String generateToken() {
		return "";
	}
	
	public String generateAccountId() {
		return "";
	}
}
