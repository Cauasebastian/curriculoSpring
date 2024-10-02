package org.sebastiandev.curriculospring.model

import jakarta.persistence.*

@Entity
@Table(name = "conhecimentos")
data class Conhecimento(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val nome: String,
    val descricao: String,

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    val pessoa: Pessoa
) {
    constructor() : this(0, "", "", Pessoa()) {

    }
}
