package br.fiap.assistencia.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JAVA_CLIENTE")
@Setter //do lombok
@Getter //do lombok
@NoArgsConstructor //para falar q nao tem construtor


public class Cliente {

    //entidade so representa a entidade
    //entidade nao tem construtor


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 120)
    private String nome;

    @Column(name = "EMAIL",nullable = false, unique = true)
    private String email;

    @Column(name = "SENHA", nullable = false, length = 512)
    private String senha;

    @Column(name = "TELEFONE", length = 20)
    private String telefone;

}
