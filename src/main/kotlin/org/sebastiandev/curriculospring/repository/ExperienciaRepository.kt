package org.sebastiandev.curriculospring.repository

import org.sebastiandev.curriculospring.model.Experiencia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExperienciaRepository : JpaRepository<Experiencia, Long> {
}