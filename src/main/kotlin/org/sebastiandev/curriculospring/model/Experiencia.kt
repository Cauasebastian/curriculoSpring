package org.sebastiandev.curriculospring.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "experiencias")
data class Experiencia(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val cargo: String,
    val empresa: String,
    val inicio: LocalDate,
    val fim: LocalDate?,
    val descricao: String,

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    val pessoa: Pessoa
) {
    constructor() : this(0, "", "", LocalDate.now(), null, "", Pessoa()) {

    }
}
