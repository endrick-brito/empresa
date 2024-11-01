package br.com.empresa.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.empresa.entity.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long>{

}
