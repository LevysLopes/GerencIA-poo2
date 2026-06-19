# GerencIA (Stoka)

Sistema de gestão inteligente de estoque e vendas desenvolvido para pequenos comércios, como mercados e mercearias, com foco em automatizar processos e reduzir perdas operacionais.

## 📌 Sobre o Projeto

O **GerencIA (Stoka)** foi desenvolvido na disciplina de **Programação Orientada a Objetos 2** do curso de Engenharia da Computação da UTFPR – Campus Cornélio Procópio.

O sistema surgiu da necessidade de substituir controles manuais de estoque e vendas, frequentemente realizados por planilhas ou cadernos, por uma solução automatizada, segura e escalável.

Seu principal objetivo é fornecer uma ferramenta capaz de:

* Controlar o estoque de produtos;
* Registrar vendas com validações de negócio;
* Gerar relatórios gerenciais;
* Emitir alertas de reposição de estoque;
* Garantir integridade dos dados através de transações seguras.

---

## 🚀 Tecnologias Utilizadas

### Back-end

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL

### Front-end

* HTML5
* CSS3
* JavaScript Vanilla
* Fetch API

### Modelagem e Documentação

* UML
* PlantUML
* html2pdf.js

---

## 🏗️ Arquitetura

O projeto foi desenvolvido seguindo o padrão arquitetural **MVC (Model-View-Controller)**, promovendo separação de responsabilidades e facilitando manutenção e escalabilidade.

Além disso, foram aplicados os princípios **SOLID**, garantindo:

* Responsabilidade única (SRP);
* Extensibilidade sem modificações (OCP);
* Baixo acoplamento entre componentes;
* Maior facilidade de manutenção.

---

## ⚙️ Funcionalidades

### 🔐 Login de Usuário

Autenticação por usuário e senha com acesso ao dashboard principal.

### 📦 Gestão de Produtos

Permite:

* Cadastro de produtos;
* Consulta de produtos;
* Controle de estoque;
* Definição de estoque mínimo;
* Registro de preço e código de barras.

### 💰 Registro de Vendas

O sistema:

* Permite vendas com múltiplos produtos;
* Atualiza o estoque automaticamente;
* Calcula o valor total da venda;
* Valida quantidades disponíveis;
* Impede operações inconsistentes.

### 📊 Relatórios e Alertas

Disponibiliza:

* Histórico de vendas;
* Situação atual do estoque;
* Alertas de estoque baixo;
* Exportação de relatórios em PDF.

---

## 🔒 Segurança e Boas Práticas

O sistema implementa diversas práticas de Engenharia de Software, entre elas:

* Validações de domínio na camada Service;
* Uso de transações com `@Transactional`;
* Proteção das credenciais do banco através de variáveis de ambiente;
* Separação rigorosa das responsabilidades entre camadas;
* Arquitetura preparada para expansão de funcionalidades.

---

## 🗄️ Banco de Dados

A persistência dos dados é realizada utilizando **PostgreSQL** com **Hibernate**.

As operações críticas, como registro de vendas, utilizam transações ACID através da anotação `@Transactional`, garantindo que, caso algum item apresente inconsistência, toda a operação seja revertida automaticamente.

---

## 🎯 Resultados

O projeto demonstrou a viabilidade de desenvolver uma solução de gestão:

* Leve e eficiente;
* Robusta e segura;
* Escalável;
* Baseada em boas práticas de Engenharia de Software;
* Com arquitetura limpa e de fácil manutenção.

Além disso, a experiência consolidou conceitos fundamentais de Programação Orientada a Objetos, arquitetura MVC e princípios SOLID aplicados a um sistema real.

---

## 👥 Equipe

* Fhelipe Vinicios Dechico
* Levy Gaspar Lopes Vitor
* Leandro Machado

---

## 🔗 Repositório

GitHub: https://github.com/LevysLopes/GerencIA-poo2
