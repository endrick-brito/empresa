package br.com.empresa.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.empresa.entity.Setor;
import br.com.empresa.empresa.repository.SetorRepository;

@Service
public class SetorService {

    @Autowired
    SetorRepository setorRepository;

    // Listar todos os Setores
    public List<Setor> findAll(){
        return setorRepository.findAll();
    }

    // Mostrar Setor por ID
    public Setor findById(Long id){
        return setorRepository.findById(id).orElse(null);
    }

    // Inserir novo Setor
    public Setor insertNew(Setor setor){
        return setorRepository.save(setor);
    }

    // Alterar Setor
    public Setor update(Long id, Setor setorAlterado){
        Setor setorAtual = findById(id);
        setorAtual.setNome(setorAlterado.getNome());
        setorAtual.setNumero(setorAlterado.getNumero());
        return setorRepository.save(setorAtual);
    }

    // Deletar Setor
    public Boolean deleteById(Long id){
        Setor setor = findById(id);
        if (setor == null){
            return false;
        }else{
            setorRepository.deleteById(id);
            return true;
        }
    }
}
