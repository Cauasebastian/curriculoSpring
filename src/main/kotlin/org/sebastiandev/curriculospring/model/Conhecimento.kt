package org.sebastiandev.curriculospring.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "conhecimentos")
data class Conhecimento(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val nome: String,
    val descricao: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    @JsonBackReference
    var pessoa: Pessoa
) {
    constructor() : this(0, "", "", Pessoa()) {

    }
}
