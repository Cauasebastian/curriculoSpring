package org.sebastiandev.curriculospring.model

import com.fasterxml.jackson.annotation.JsonBackReference
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "pessoa_id")
    val pessoa: Pessoa
) {
    constructor() : this(0, "", "", LocalDate.now(), null, "", "", Pessoa()) {

    }
}
