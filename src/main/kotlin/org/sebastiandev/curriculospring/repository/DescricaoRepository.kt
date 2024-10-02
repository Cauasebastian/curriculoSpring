package org.sebastiandev.curriculospring.repository

import org.sebastiandev.curriculospring.model.Descricao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DescricaoRepository : JpaRepository<Descricao, Long> {
}