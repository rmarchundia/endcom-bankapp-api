package com.testEndpoint.demo;

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

	
	
}//CuentaService
