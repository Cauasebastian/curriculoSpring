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
            // Criação das informações pessoais
            val informacoesPessoais = InformacoesPessoais(
                nomeCompleto = "Cauã Sebastian Ferreira Barbosa",
                email = "cauasebastian@example.com",
                telefone = "(81) 99999-9999",
                endereco = "Recife, PE"
            )

            // Criação da descrição
            val descricao = Descricao(
                descricao = "Desenvolvedor Full Stack com experiência em Spring Boot, Kotlin, React e AWS..."
            )

            // Criação da instância de Pessoa
            val pessoa = Pessoa(
                informacoesPessoais = informacoesPessoais,
                descricao = descricao
            )

            // Criação de Conhecimentos relacionados à Pessoa
            val conhecimento1 = Conhecimento(
                nome = "Spring Boot",
                descricao = "Desenvolvimento de aplicações backend com Spring Boot.",
                pessoa = pessoa
            )

            val conhecimento2 = Conhecimento(
                nome = "Kotlin",
                descricao = "Linguagem de programação Kotlin para desenvolvimento conciso e seguro.",
                pessoa = pessoa
            )

            // Adicionando Conhecimentos à Pessoa
            pessoa.conhecimentos.addAll(listOf(conhecimento1, conhecimento2))

            // Criação de Certificações relacionadas à Pessoa
            val certificacao1 = Certificacao(
                titulo = "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                instituicao = "Udemy",
                dataObtencao = LocalDate.of(2024, 8, 15),
                linkCredencial = "https://udemy.com/certification-link",
                pessoa = pessoa
            )

            // Adicionando Certificações à Pessoa
            pessoa.certificacoes.add(certificacao1)

            // Exemplo de Educação
            val educacao1 = Educacao(
                instituicao = "UNICAP - Universidade Católica de Pernambuco",
                curso = "Curso de Desenvolvimento de Sistemas",
                inicio = LocalDate.of(2020, 3, 1),
                fim = LocalDate.of(2024, 6, 30),
                localizacao = "Recife, PE",
                descricao = "Durante meu período acadêmico, participei de residências tecnológicas...",
                pessoa = pessoa
            )

            pessoa.educacoes.add(educacao1)

            // Salvar a instância de Pessoa com todas as entidades relacionadas
            pessoaRepository.save(pessoa)
        }
    }
}
