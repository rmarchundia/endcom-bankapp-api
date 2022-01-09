package com.testEndpoint.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.testEndpoint.demo.CuentaService;
import com.testEndpoint.demo.model.Cuenta;

@RestController
@RequestMapping("/create-account")
@CrossOrigin("*")
public class CuentaController {
	
	public final CuentaService cuentaService;

	public CuentaController(CuentaService cuentaService) {
		this.cuentaService = cuentaService;
	}//CuentaController
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Object addCount(@RequestBody Cuenta cuenta) {
		cuentaService.addCount(cuenta);
		return ResponseEntity.ok("{'statusCode': "+ "200"+", \n 'mensaje': "+"Cuenta creada" + ",\n 'id':" + cuenta.getId() +",\n 'account' : "
		+cuenta.getAccount()+cuenta.getId()+",\n 'balance' : "+cuenta.getBalance()+
		", \n 'name': "+cuenta.getName()+", \n 'mail': "+cuenta.getMail()+"\n}");
	}//addCount
	
	

}//CuentaController
