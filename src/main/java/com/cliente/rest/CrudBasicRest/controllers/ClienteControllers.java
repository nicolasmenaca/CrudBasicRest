package com.cliente.rest.CrudBasicRest.controllers;

import com.cliente.rest.CrudBasicRest.Service.IClienteService;
import com.cliente.rest.CrudBasicRest.entidades.Clientes;
import com.cliente.rest.CrudBasicRest.excepciones.ResourceNotFoundException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteControllers {

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Clientes>> findAll(){
        List<Clientes> clientes = clienteService.llamartodo();
        if (clientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
        Optional<Clientes>clientesOptional = clienteService.llamarporid(id);

        if (clientesOptional.isPresent()) {
            return new ResponseEntity<>(clientesOptional, HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Clientes> save(@RequestBody Clientes clientes){
        Clientes clientes1 = clienteService.save(clientes);
        if (clientes1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(clientes1, HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public void  delete(@PathVariable Long id){
        clienteService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, Clientes clientes ){
        try{
            Clientes clientes1 = clienteService.actualizar(id, clientes);

            return ResponseEntity.ok(clientes1);
        }catch (ResourceNotFoundException e){

            Map<String,String> respuesta = new HashMap<>();
            respuesta.put("mensaje", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
        }

    }




}




