package com.example.Loja.Services;

import com.example.Loja.Exception.VendedorNotFoundException;
import com.example.Loja.Model.Vendedor;
import com.example.Loja.Repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository VendedorRepository;

    public List<Vendedor> getAllVendedors() {
        return VendedorRepository.findAll();
    }

    public Vendedor getVendedorById(Long id) {
        return VendedorRepository.findById(id)
                .orElseThrow(() -> new VendedorNotFoundException(id));
    }

    public Vendedor createVendedor(Vendedor Vendedor) {
        return VendedorRepository.save(Vendedor);
    }

    public Vendedor updateVendedor(Long id, Vendedor Vendedor) {
        Vendedor existingVendedor = VendedorRepository.findById(id)
                .orElseThrow(() -> new VendedorNotFoundException(id));
        existingVendedor.setNome(Vendedor.getNome());
        existingVendedor.setCpf(Vendedor.getCpf());
        existingVendedor.setCargo(Vendedor.getCargo());
        return VendedorRepository.save(existingVendedor);
    }
    public void deleteVendedor(Long id) {
        VendedorRepository.deleteById(id);
    }
}
