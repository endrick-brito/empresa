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

import br.com.empresa.empresa.entity.Setor;
import br.com.empresa.empresa.service.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService setorService;

    // Listar todos os Setors
    @GetMapping
    public ResponseEntity<List<Setor>> findAll(){
        List<Setor> setores = setorService.findAll();
        return ResponseEntity.ok().body(setores);
    }

    // Mostrar Setor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Setor> findById(@PathVariable Long id){
        Setor setor = setorService.findById(id);
        return ResponseEntity.ok().body(setor);
    }

    // Inserir novo Setor
    @PostMapping
    public ResponseEntity<Setor> insertNew(@RequestBody Setor setor){
        Setor setorCriado = setorService.insertNew(setor);
        return ResponseEntity.ok().body(setorCriado);
    }

    // Alterar Setor
    @PutMapping("/{id}")
    public ResponseEntity<Setor> update(@PathVariable Long id, @RequestBody Setor setorAlterado){
        Setor setorAtual = setorService.update(id, setorAlterado);
        return ResponseEntity.ok().body(setorAtual);
    }

    // Deletar Setor
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = setorService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }
}
