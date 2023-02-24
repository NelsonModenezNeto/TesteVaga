package com.example.Vaga.Controle;

import com.example.Vaga.Model.Endereco;
import com.example.Vaga.Model.Pessoa;
import com.example.Vaga.Repository.EnderecoRepository;
import com.example.Vaga.Repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiEndereco")
public class EnderecoControle {

    @Autowired
    EnderecoRepository enRepo;

    @PostMapping("/Cadastrar") //Segue um exemplo de Json de cadastro de Endeco {"logradouro": "Rua Exemplo","cep": "12345-678","numero": 123,"cidade": "São Paulo","primaryAddress": true,"pessoa": {"id": 1}}
    public void criarEndereco(@RequestBody Endereco endereco){
        enRepo.save(endereco);
    }

    @GetMapping("/buscarId/{id}") //Basta informar o id que quer consultar após a barra
    public Optional<Endereco> buscarEnderecosID(@PathVariable (value = "id") int id){
        return enRepo.findById(id);
    }

    @GetMapping("/buscarTodosIdP/{idP}") //Basta informa o id da pessoa que vc quer busca logo após a barra
    public List<Endereco> buscarEnderecosIdP(@PathVariable (value="idP") int idP){
         return enRepo.findEndByIdP(idP);
    }
}

