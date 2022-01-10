package com.testEndpoint.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testEndpoint.demo.model.Cuenta;

@Service
public class CuentaService {
	
	private final CuentaRepository cuentaRepository;

	@Autowired
	public CuentaService(CuentaRepository cuentaRepository) {
		this.cuentaRepository = cuentaRepository;
	}//CuentaService
	
	public void addCount( Cuenta cuenta) {
		cuentaRepository.save(cuenta);
	}//addCount

	@Transactional
	public void updateAccount(String account, Float balance) {
		System.out.println(" >>>>>>> "+account+" el valor de balance es "+balance);
	    Cuenta cuenta = cuentaRepository.findByAccount(account).orElseThrow(()-> new IllegalStateException("La cuenta " + account + "no existe"));
	    System.out.println("cuenta vale : "+cuenta);
	    System.out.println("la cuenta es de tipo : "+((Object)cuenta).getClass().getSimpleName());
	    if ((balance > 0) &&(balance != null) ) {
	    	System.out.println("estoy dentro de la condicional de balance");
	    	cuenta.setBalance((cuenta.getBalance() + balance));
	    }//if
	    System.out.println("Estoy fuera de la condional balance");
	}//updateAccount
}//CuentaService
