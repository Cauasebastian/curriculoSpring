package org.sebastiandev.curriculospring.model

import jakarta.persistence.*

@Entity
@Table(name = "descricoes")
data class Descricao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(columnDefinition = "TEXT")
    val descricao: String
) {
    constructor() : this(0, "") {
    }
}
