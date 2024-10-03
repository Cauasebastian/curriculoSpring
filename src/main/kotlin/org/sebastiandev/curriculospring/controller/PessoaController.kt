// PessoaController.kt
package org.sebastiandev.curriculospring.controller

import org.sebastiandev.curriculospring.exception.ResourceNotFoundException
import org.sebastiandev.curriculospring.model.Pessoa
import org.sebastiandev.curriculospring.repository.PessoaRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.transaction.annotation.Transactional

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
    @Transactional
    fun createPessoa(@RequestBody pessoa: Pessoa): Pessoa {
        // Para cada lista de entidades relacionadas, associe a pessoa
        pessoa.conhecimentos.forEach { it.pessoa = pessoa }
        pessoa.educacoes.forEach { it.pessoa = pessoa }
        pessoa.experiencias.forEach { it.pessoa = pessoa }
        pessoa.certificacoes.forEach { it.pessoa = pessoa }

        // Salva a pessoa com as entidades relacionadas associadas
        return pessoaRepository.save(pessoa)
    }

    // UPDATE Pessoa
    @PutMapping("/{id}")
    @Transactional
    fun updatePessoa(
        @PathVariable(value = "id") pessoaId: Long,
        @RequestBody pessoaDetails: Pessoa
    ): ResponseEntity<Pessoa> {
        val pessoa = pessoaRepository.findById(pessoaId)
            .orElseThrow { throw ResourceNotFoundException("Pessoa não encontrada com id $pessoaId") }

        // Atualiza os campos da pessoa
        val updatedPessoa = pessoa.copy(
            informacoesPessoais = pessoaDetails.informacoesPessoais,
            descricao = pessoaDetails.descricao,
            conhecimentos = pessoaDetails.conhecimentos,
            educacoes = pessoaDetails.educacoes,
            experiencias = pessoaDetails.experiencias,
            certificacoes = pessoaDetails.certificacoes
        )

        // Para cada lista de entidades relacionadas, associe a pessoa
        updatedPessoa.conhecimentos.forEach { it.pessoa = updatedPessoa }
        updatedPessoa.educacoes.forEach { it.pessoa = updatedPessoa }
        updatedPessoa.experiencias.forEach { it.pessoa = updatedPessoa }
        updatedPessoa.certificacoes.forEach { it.pessoa = updatedPessoa }

        // Salva a pessoa atualizada com as entidades relacionadas associadas
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