package com.example.Loja.Controlers;
import com.example.Loja.Model.Cliente;
import com.example.Loja.Repository.ClienteRepository;
import com.example.Loja.Exception.ClienteNotFoundException;
import com.example.Loja.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private ClienteRepository ClienteRepository;



    @PostMapping("/Cliente")
    Cliente newCliente(@RequestBody Cliente newCliente){
        return ClienteRepository.save(newCliente);
    }

    @GetMapping("/Cliente")
    List<Cliente> getAllCliente(){
        return ClienteRepository.findAll();
    }

    @GetMapping("/Cliente/{id}")
    Cliente getClienteById(@PathVariable Long id){
        return ClienteRepository.findById(id)
                .orElseThrow(()->new ClienteNotFoundException(id));
    }

    @PutMapping("/Cliente/{id}")
    Cliente updateCliente(@RequestBody Cliente newCliente, @PathVariable Long id){
        return ClienteRepository.findById(id)
                .map(Cliente -> {
                    Cliente.setCpf(newCliente.getCpf());
                    Cliente.setNome(newCliente.getNome());
                    return ClienteRepository.save(Cliente);
                }).orElseThrow(()->new ClienteNotFoundException(id));
    }

    @DeleteMapping("/Cliente/{id}")
    String deleteCliente(@PathVariable Long id){
        if(!ClienteRepository.existsById(id)){
            throw new ClienteNotFoundException(id);
        }
        ClienteRepository.deleteById(id);
        return "O Cliente com o  id " +id+ " foi deletado com sucesso!";
    }


}

