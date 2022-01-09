package com.testEndpoint.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testEndpoint.demo.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

}//CuentaRepository
