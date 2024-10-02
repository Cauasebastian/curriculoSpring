package org.sebastiandev.curriculospring.controller

import org.sebastiandev.curriculospring.exception.ResourceNotFoundException
import org.sebastiandev.curriculospring.model.Pessoa
import org.sebastiandev.curriculospring.repository.PessoaRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/pessoas")
class PessoaController(private val pessoaRepository: PessoaRepository) {

    // GET All Pessoas
    @GetMapping
    fun getAllPessoas(): List<Pessoa> = pessoaRepository.findAll()

    // GET Pessoa by ID
    @GetMapping("/{id}")
    fun getPessoaById(@PathVariable(value = "id") pessoaId: Long): ResponseEntity<Pessoa> {
        val pessoa = pessoaRepository.findById(pessoaId)
            .orElseThrow { throw ResourceNotFoundException("Pessoa não encontrada com id $pessoaId") }
        return ResponseEntity.ok().body(pessoa)
    }

    // CREATE Pessoa
    @PostMapping
    fun createPessoa(@RequestBody pessoa: Pessoa): Pessoa = pessoaRepository.save(pessoa)

    // UPDATE Pessoa
    @PutMapping("/{id}")
    fun updatePessoa(
        @PathVariable(value = "id") pessoaId: Long,
        @RequestBody pessoaDetails: Pessoa
    ): ResponseEntity<Pessoa> {
        val pessoa = pessoaRepository.findById(pessoaId)
            .orElseThrow { throw ResourceNotFoundException("Pessoa não encontrada com id $pessoaId") }

        val updatedPessoa = pessoa.copy(
            informacoesPessoais = pessoaDetails.informacoesPessoais,
            descricao = pessoaDetails.descricao,
            conhecimentos = pessoaDetails.conhecimentos,
            educacoes = pessoaDetails.educacoes,
            experiencias = pessoaDetails.experiencias,
            certificacoes = pessoaDetails.certificacoes
        )

        return ResponseEntity.ok(pessoaRepository.save(updatedPessoa))
    }

    // DELETE Pessoa
    @DeleteMapping("/{id}")
    fun deletePessoa(@PathVariable(value = "id") pessoaId: Long): ResponseEntity<Void> {
        val pessoa = pessoaRepository.findById(pessoaId)
            .orElseThrow { throw ResourceNotFoundException("Pessoa não encontrada com id $pessoaId") }

        pessoaRepository.delete(pessoa)
        return ResponseEntity.noContent().build()
    }
}