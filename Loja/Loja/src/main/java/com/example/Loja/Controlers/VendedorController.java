package com.example.Loja.Controlers;



import com.example.Loja.Exception.VendedorNotFoundException;
import com.example.Loja.Model.Vendedor;
import com.example.Loja.Repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000/")
public class VendedorController {

    @Autowired
    private VendedorRepository VendedorRepository;

    @PostMapping("/Vendedor")
    Vendedor newVendedor(@RequestBody Vendedor vendedor){
        return VendedorRepository.save(vendedor);
    }

    @GetMapping("/Vendedor")
    List<Vendedor> getAllVendedor(){
        return VendedorRepository.findAll();
    }

    @GetMapping("/Vendedor/{id}")
    Vendedor getVendedorById(@PathVariable Long id){
        return VendedorRepository.findById(id)
                .orElseThrow(()->new VendedorNotFoundException(id));
    }

    @PutMapping("/Vendedor/{id}")
    Vendedor updateVendedor(@RequestBody Vendedor newVendedor, @PathVariable Long id){
        return VendedorRepository.findById(id)
                .map(Vendedor -> {
                    Vendedor.setCpf(newVendedor.getCpf());
                    Vendedor.setNome(newVendedor.getNome());
                    Vendedor.setCargo(newVendedor.getCargo());

                    return VendedorRepository.save(Vendedor);
                }).orElseThrow(()->new VendedorNotFoundException(id));
    }

    @DeleteMapping("/Vendedor/{id}")
    String deleteVendedor(@PathVariable Long id){
        if(!VendedorRepository.existsById(id)){
            throw new VendedorNotFoundException(id);
        }
        VendedorRepository.deleteById(id);
        return "Vendedor com o  id " +id+ " foi deletado com sucesso!";
    }
}












