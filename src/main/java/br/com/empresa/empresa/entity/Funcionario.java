package br.com.empresa.empresa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    private String matricula;
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "setor_numero", referencedColumnName = "numero") // Nome da coluna que armazenará o número do setor e a coluna referenciada na entidade setor
    private Setor setor; // Referência ao objeto Setor
}
