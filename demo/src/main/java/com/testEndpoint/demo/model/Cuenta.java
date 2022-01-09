package com.testEndpoint.demo.model;


import java.util.Formatter;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "cuenta")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	protected Long id;
	private String name;
	private String mail;
	private String account = randomNumber();
	private Float balance =1000F;
	
	public Cuenta(Long id, String name, String mail, String account, Float balance) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.account = account;
		this.balance = balance;
	}//ConstrutorCuenta
	
	public Cuenta() {}//ConstructorCuenta

	public Long getId() {
		return id;
	}//getId

	public void setId(Long id) {
		this.id = id;
	}//setId

	public String getName() {
		return name;
	}//getName

	public void setName(String name) {
		if(name.length() >=3) {
			this.name = name;
		}else {
			System.out.println("El nombre necesita mas de 3 caractéres.");
		}
		
	}//setName

	public String getMail() {
		return mail;
	}//getMail
	
	
	public String randomNumber() {
		int newNumber =  (int)(Math.random()*99999999+10000);
		String parseNumber = String.valueOf(newNumber);
		//genera5 digitos para un randomnumber
		Formatter fmt = new Formatter();
		
		
		String otherNumber = parseNumber + fmt.format("%02d",0);
		System.out.println(otherNumber);
		return otherNumber;
	}//randomNumber
	
	
	
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


	public void setMail(String mail) {
		
		if(VALID_EMAIL_ADDRESS_REGEX.matcher(mail) != null) {
			this.mail = mail;
		}else {
			System.out.println("Email inválido.");
		}
		
	}//setMail
	
	
		
	public String getAccount() {
		return account;
	}//getAccount

	public void setAccount(String account) {
		this.account = account;
	}//setAccount

	public Float getBalance() {
		return balance;
	}//getBalance

	public void setBalance(Float balance) {
			this.balance = balance;
	}//setBalance
	
	
	
	
	

}//CuentaClass
