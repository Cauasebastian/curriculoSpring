package org.sebastiandev.curriculospring.model

import jakarta.persistence.*

@Entity
@Table(name = "informacoes_pessoais")
data class InformacoesPessoais(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val nomeCompleto: String,
    val email: String,
    val telefone: String,
    val endereco: String
) {
    constructor() : this(0, "", "", "", "") {


    }
}
