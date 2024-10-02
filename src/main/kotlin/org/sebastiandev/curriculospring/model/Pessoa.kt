package org.sebastiandev.curriculospring.model

import jakarta.persistence.*

@Entity
@Table(name = "pessoas")
data class Pessoa(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "informacoes_pessoais_id", referencedColumnName = "id")
    val informacoesPessoais: InformacoesPessoais = InformacoesPessoais(),

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "descricao_id", referencedColumnName = "id")
    val descricao: Descricao = Descricao(),

    @OneToMany(mappedBy = "pessoa", cascade = [CascadeType.ALL], orphanRemoval = true)
    val conhecimentos: List<Conhecimento> = emptyList(),

    @OneToMany(mappedBy = "pessoa", cascade = [CascadeType.ALL], orphanRemoval = true)
    val educacoes: List<Educacao> = emptyList(),

    @OneToMany(mappedBy = "pessoa", cascade = [CascadeType.ALL], orphanRemoval = true)
    val experiencias: List<Experiencia> = emptyList(),

    @OneToMany(mappedBy = "pessoa", cascade = [CascadeType.ALL], orphanRemoval = true)
    val certificacoes: List<Certificacao> = emptyList()
) {
    constructor() : this(0, InformacoesPessoais(), Descricao(), emptyList(), emptyList(), emptyList(), emptyList())
}