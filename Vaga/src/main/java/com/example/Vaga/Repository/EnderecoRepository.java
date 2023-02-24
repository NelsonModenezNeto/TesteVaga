package com.example.Vaga.Repository;

import com.example.Vaga.Model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    @Query(value="SELECT en FROM Endereco en where en.pessoa.idP = ?1")
    List<Endereco> findEndByIdP(int idP);
}
