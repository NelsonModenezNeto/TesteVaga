package com.example.Vaga.Controle;

import com.example.Vaga.Model.Pessoa;
import com.example.Vaga.Repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiPessoa")
public class PessoaControle {
    @Autowired
    PessoaRepository psRepo;

    @PostMapping("/Cadastrar") //Basta colocar os dados de nome e DataNac no Json
    public void CadastrarPessoa(@RequestBody Pessoa ps) {
        psRepo.save(ps);
    }

    @Transactional
    @PutMapping("/Atualizar") //Basta colocar o id que quer atualizar e mudar o nome e dataNac EXEMPLO: {"nome": "João Silva Elaine", "dataNac": "1980-01-01", "id": 1}
    public void atualizarPessoa(@RequestBody Pessoa ps) {
        psRepo.save(ps);
    }

    @GetMapping ("/buscarPessoas")
    public List<Pessoa> buscarPessoas()
    {
        return psRepo.findAll();
    }

    @GetMapping("/buscarId/{idP}") //Basta informar o id que quer consultar após a barra
    public Optional<Pessoa> buscarCodigo(@PathVariable int idP)
    {
        return psRepo.findById(idP);
    }
}