package org.sebastiandev.curriculospring.repository

import org.sebastiandev.curriculospring.model.Educacao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EducacaoRepository : JpaRepository<Educacao, Long> {
}