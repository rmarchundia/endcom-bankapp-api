package com.testEndpoint.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.testEndpoint.demo.CuentaRepository;
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
//	@ResponseStatus(HttpStatus.OK)
	public Object addCount(@RequestBody Cuenta cuenta) {
		cuentaService.addCount(cuenta);
		return ResponseEntity.ok("{'statusCode': "+ "200"+", \n 'mensaje': "+"Cuenta creada" + ",\n 'id':" + cuenta.getId() +",\n 'account' : "
		+cuenta.getAccount()+cuenta.getId()+",\n 'balance' : "+cuenta.getBalance()+
		", \n 'name': "+cuenta.getName()+", \n 'mail': "+cuenta.getMail()+"\n}");
	} //addCount
	
	 @PutMapping ("/account") 
	    public ResponseEntity<Cuenta> updateAccount(@RequestParam(required = false) String account, @RequestParam(required = false) Float balance) {                   
	        cuentaService.updateAccount(account, balance);
	        return  new ResponseEntity<Cuenta>(HttpStatus.OK);
	    }//updateUsuario
	// public Object requestPut(){
		
		 //return ResponseEntity.ok("{'statusCode': 200 , \n 'mensaje': 'Saldo actualizado',\n 'account' : "+ cuenta.getAccount()+""+ cuenta.getId()+",\n 'balance' : "+ cuenta.getBalance());

	
}//CuentaController
