package com.example.Loja.Services;

import com.example.Loja.Exception.LojaNotFoundException;
import com.example.Loja.Model.Loja;
import com.example.Loja.Repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    public List<Loja> getAllLojaes() {
        return lojaRepository.findAll();
    }

    public Loja getLojaById(Long id) {
        return lojaRepository.findById(id)
                .orElseThrow(() -> new LojaNotFoundException(id));
    }

    public Loja createLoja(Loja Loja) {
        return lojaRepository.save(Loja);
    }

    public Loja updateLoja(Long id, Loja Loja) {
        Loja existingLoja = lojaRepository.findById(id)
                .orElseThrow(() -> new LojaNotFoundException(id));
        existingLoja.setNomeLoja(Loja.getNomeLoja());
        existingLoja.setCnpjLoja(Loja.getCnpjLoja());
        return lojaRepository.save(existingLoja);
    }
    public void deleteLoja(Long id) {
        lojaRepository.deleteById(id);
    }
}
