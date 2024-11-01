package br.com.empresa.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.empresa.entity.Funcionario;
import br.com.empresa.empresa.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // Listar todos os Funcionarios
    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll(){
        List<Funcionario> funcionarios = funcionarioService.findAll();
        return ResponseEntity.ok().body(funcionarios);
    }

    // Mostrar Funcionario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Long id){
        Funcionario funcionario = funcionarioService.findById(id);
        return ResponseEntity.ok().body(funcionario);
    }

    // Inserir novo Funcionario
    @PostMapping
    public ResponseEntity<Funcionario> insertNew(@RequestBody Funcionario funcionario){
        Funcionario funcionarioCriado = funcionarioService.insertNew(funcionario);
        return ResponseEntity.ok().body(funcionarioCriado);
    }

    // Alterar Funcionario
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @RequestBody Funcionario funcionarioAlterado){
        Funcionario funcionarioAtual = funcionarioService.update(id, funcionarioAlterado);
        return ResponseEntity.ok().body(funcionarioAtual);
    }

    // Deletar Funcionario
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = funcionarioService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }
}
