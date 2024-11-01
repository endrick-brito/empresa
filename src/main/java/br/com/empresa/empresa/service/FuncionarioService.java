package br.com.empresa.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.empresa.entity.Funcionario;
import br.com.empresa.empresa.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Listar Todos os Funcionarios
    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }

    // Mostrar Funcionario por ID
    public Funcionario findById(Long id){
        return funcionarioRepository.findById(id).orElse(null);
    }

    // Inserir novo Funcionario
    public Funcionario insertNew(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    // Alterar Funcionario
    public Funcionario update(Long id, Funcionario funcionarioAlterado){
        Funcionario funcionarioAtual = findById(id);
        funcionarioAtual.setNome(funcionarioAlterado.getNome());
        funcionarioAtual.setMatricula(funcionarioAlterado.getMatricula());
        funcionarioAtual.setSetor(funcionarioAlterado.getSetor());
        return funcionarioRepository.save(funcionarioAtual);
    }

    // Deletar Funcionario
    public Boolean deleteById(Long id){
        Funcionario funcionario = findById(id);
        if (funcionario == null){
            return false;
        }else{
            funcionarioRepository.deleteById(id);
            return true;
        }
    }
}
