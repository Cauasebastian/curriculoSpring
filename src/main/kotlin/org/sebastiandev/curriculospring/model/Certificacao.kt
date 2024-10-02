package org.sebastiandev.curriculospring.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "certificacoes")
data class Certificacao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val titulo: String,
    val instituicao: String,
    val dataObtencao: LocalDate,
    val linkCredencial: String?,

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    val pessoa: Pessoa
) {
    constructor() : this(0, "", "", LocalDate.now(), "", Pessoa()) {

    }
}
