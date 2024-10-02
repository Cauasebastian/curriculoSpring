package org.sebastiandev.curriculospring.repository

import org.sebastiandev.curriculospring.model.InformacoesPessoais
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InformacoesPessoaisRepository : JpaRepository<InformacoesPessoais, Long>
