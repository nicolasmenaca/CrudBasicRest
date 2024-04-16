package com.cliente.rest.CrudBasicRest.Service;

import com.cliente.rest.CrudBasicRest.entidades.Clientes;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Clientes> llamartodo();

    Optional<Clientes> llamarporid(Long id);

    Clientes save(Clientes clientes);

    void delete(Long id);

    Clientes actualizar(Long id, Clientes clientes);

}

