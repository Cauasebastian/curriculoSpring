package org.sebastiandev.curriculospring

import org.sebastiandev.curriculospring.model.*
import org.sebastiandev.curriculospring.repository.PessoaRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class DataLoader(private val pessoaRepository: PessoaRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (pessoaRepository.count() == 0L) {
            val informacoes = InformacoesPessoais(
                nomeCompleto = "Cauã Sebastian Ferreira Barbosa",
                email = "cauasebastian@example.com",
                telefone = "(81) 99999-9999",
                endereco = "Recife, PE"
            )

            val descricao = Descricao(
                descricao = "Desenvolvedor Full Stack com experiência em Spring Boot, Kotlin, React e AWS..."
            )

            val conhecimento = Conhecimento(
                nome = "Spring Boot",
                descricao = "Desenvolvimento de aplicações backend com Spring Boot.",
                pessoa = Pessoa() // Temporário, será setado posteriormente
            )

            // Crie instâncias de Conhecimento, Educacao, Experiencia, Certificacao conforme necessário

            val pessoa = Pessoa(
                informacoesPessoais = informacoes,
                descricao = descricao,
                conhecimentos = listOf(conhecimento),
                educacoes = emptyList(),
                experiencias = emptyList(),
                certificacoes = emptyList()
            )

            // Atualize a referência da pessoa nos conhecimentos
            val conhecimentosAtualizados = pessoa.conhecimentos.map { it.copy(pessoa = pessoa) }
            val pessoaAtualizada = pessoa.copy(conhecimentos = conhecimentosAtualizados)

            pessoaRepository.save(pessoaAtualizada)
        }
    }
}
