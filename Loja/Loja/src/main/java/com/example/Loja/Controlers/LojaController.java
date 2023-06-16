package com.example.Loja.Controlers;


import com.example.Loja.Exception.LojaNotFoundException;
import com.example.Loja.Model.Loja;
import com.example.Loja.Repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController

public class LojaController {

    @Autowired
    private LojaRepository LojaRepository;

    @PostMapping("/Loja")
    Loja newLoja(@RequestBody Loja newLoja) { return LojaRepository.save(newLoja); }

    @GetMapping("/Lojas")
    List<Loja> getAllLojas() { return LojaRepository.findAll(); }

    @GetMapping("/Loja/{id}")
    Loja getLojaById(@PathVariable Long id){
        return LojaRepository.findById(id)
                .orElseThrow(()->new LojaNotFoundException(id));
    }

    @PutMapping("/Loja/{id}")
    Loja updateLoja(@RequestBody Loja newLoja, @PathVariable Long id){
        return LojaRepository.findById(id)
                .map(Loja -> {
                    Loja.setCnpjLoja(newLoja.getCnpjLoja());
                    Loja.setNomeLoja(newLoja.getNomeLoja());
                    return LojaRepository.save(Loja);
                }).orElseThrow(()->new LojaNotFoundException(id));
    }

    @DeleteMapping("/Loja/{id}")
    String deleteLoja(@PathVariable Long id){
        if(!LojaRepository.existsById(id)){
            throw new LojaNotFoundException(id);
        }
        LojaRepository.deleteById(id);
        return "A Loja com o  id " +id+ " foi deletada com sucesso!";
    }
}

