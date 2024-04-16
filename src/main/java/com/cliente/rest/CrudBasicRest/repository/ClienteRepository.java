package com.cliente.rest.CrudBasicRest.repository;

import com.cliente.rest.CrudBasicRest.entidades.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {

}
