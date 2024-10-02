package org.sebastiandev.curriculospring.repository

import org.sebastiandev.curriculospring.model.Pessoa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PessoaRepository : JpaRepository<Pessoa, Long>
