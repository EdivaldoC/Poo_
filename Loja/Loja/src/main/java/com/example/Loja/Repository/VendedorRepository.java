package com.example.Loja.Repository;

import com.example.Loja.Model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    Vendedor findByNome(String nome);
    List<Vendedor> findByCargoLessThan(String cargo);
    List<Vendedor> findByCargoGreaterThan(String cargo);
    List<Vendedor> findByNomeIsNull();
    List<Vendedor> findByNomeIsNotNull();
    List<Vendedor> findByNomeLike(String nome);
    List<Vendedor> findByNomeNotLike(String nome);
    List<Vendedor> findByNomeOrderByCargoDesc(String nome);
}
