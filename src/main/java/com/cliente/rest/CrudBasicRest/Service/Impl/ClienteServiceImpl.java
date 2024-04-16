package com.cliente.rest.CrudBasicRest.Service.Impl;

import com.cliente.rest.CrudBasicRest.Service.IClienteService;
import com.cliente.rest.CrudBasicRest.entidades.Clientes;
import com.cliente.rest.CrudBasicRest.excepciones.ResourceNotFoundException;
import com.cliente.rest.CrudBasicRest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {


    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Clientes> llamartodo() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Clientes> llamarporid(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Clientes save(Clientes clientes) {
        return clienteRepository.save(clientes);

    }
    @Override
    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

    @Override
    public Clientes actualizar(Long id, Clientes clientes) {
        Clientes clientes1 = clienteRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("no corresponde ID" + id));

        clientes1.setNombre(clientes.getNombre());
        clientes1.setApellido(clientes.getApellido());
        clientes1.setCorreo(clientes.getCorreo());
        clientes1.setNumberPhone(clientes.getNumberPhone());

        return clienteRepository.save(clientes1);
    }
}
