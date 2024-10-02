package org.sebastiandev.curriculospring.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "educacoes")
data class Educacao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val instituicao: String,
    val curso: String,
    val inicio: LocalDate,
    val fim: LocalDate?,
    val localizacao: String,
    val descricao: String,

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    val pessoa: Pessoa
) {
    constructor() : this(0, "", "", LocalDate.now(), null, "", "", Pessoa()) {

    }
}
