package org.sebastiandev.curriculospring.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "pessoas")
data class Pessoa(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "informacoes_pessoais_id", referencedColumnName = "id")
    val informacoesPessoais: InformacoesPessoais,

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "descricao_id", referencedColumnName = "id")
    val descricao: Descricao,

    @OneToMany(mappedBy = "pessoa", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    val conhecimentos: MutableList<Conhecimento> = mutableListOf(),

    @OneToMany(mappedBy = "pessoa", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    val educacoes: MutableList<Educacao> = mutableListOf(),

    @OneToMany(mappedBy = "pessoa", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    val experiencias: MutableList<Experiencia> = mutableListOf(),

    @OneToMany(mappedBy = "pessoa", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    val certificacoes: MutableList<Certificacao> = mutableListOf()
) {
    constructor() : this(0, InformacoesPessoais(), Descricao(), mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf()) {

    }
}
