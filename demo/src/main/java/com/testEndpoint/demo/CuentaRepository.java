package com.testEndpoint.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.testEndpoint.demo.model.Cuenta;

@EnableJpaRepositories
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
//   @Query(value = "SELECT account FROM cuenta c WHERE c.account=?1", nativeQuery = true)
	 @Query("SELECT p FROM Cuenta p WHERE p.account=?1")
   Optional<Cuenta> findByAccount(String account);
   
}//CuentaRepository
