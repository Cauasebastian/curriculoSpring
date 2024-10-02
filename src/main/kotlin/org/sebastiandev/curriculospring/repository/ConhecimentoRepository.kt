package org.sebastiandev.curriculospring.repository

import org.sebastiandev.curriculospring.model.Conhecimento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ConhecimentoRepository : JpaRepository<Conhecimento, Long> {
}