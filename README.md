# ClienteSwing6 — Java Desktop com Clean Architecture

Aplicação **Java Desktop (Swing)** para cadastro, listagem, exportação e geração de relatórios de clientes, desenvolvida com foco em **Clean Architecture**, **SOLID**, **injeção de dependência** e **separação clara de responsabilidades**.

Projeto acadêmico desenvolvido no curso de **Sistemas de Informação – UNIRIO**, com abordagem e organização alinhadas às **boas práticas adotadas no mercado de software**.

---

## ✨ Funcionalidades

- 📋 **Cadastro de clientes**
  - Validação de CPF, idade mínima, endereço e telefone
  - Integração com serviços de CEP e UF
- 📑 **Listagem de clientes**
  - Visualização em tabela HTML dentro do Swing (`JEditorPane`)
  - Formatação de CPF, data de nascimento, endereço completo e telefone
- 📄 **Relatório de clientes em PDF**
  - Geração de relatório ordenado por CPF
  - Layout profissional usando **iText**
  - Abertura automática no visualizador padrão do sistema
- 📦 **Exportação de clientes em JSON**
  - Estrutura compatível com as entidades de domínio (`Cliente`, `CPF`, `Endereco`, `UF`, `Telefone`)
  - Serialização com **Gson** e suporte a `LocalDate`
  - Abertura automática no visualizador padrão do sistema
- 💾 **Persistência em banco de dados SQLite**

---

## 🧠 Arquitetura

O projeto foi estruturado seguindo os princípios da **Clean Architecture**, separando claramente:

- **Domain**
  - Entidades (`Cliente`, `CPF`, `Endereco`, `Telefone`, `UF`)
  - Regras de negócio e validações
- **Application (Use Cases)**
  - Casos de uso como:
    - Cadastro de cliente
    - Geração de relatório
    - Exportação de clientes
- **Ports (Interfaces)**
  - Definição de contratos para entrada e saída de dados
  - Inversão de dependência
- **Adapters**
  - Interface gráfica (Swing)
  - Persistência (SQLite)
  - Integrações externas (CEP, PDF, JSON)

Essa abordagem facilita:
- Testabilidade
- Evolução do sistema
- Substituição de tecnologias sem impacto no domínio

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Swing (UI Desktop)**
- **Gradle**
- **SQLite**
- **Gson** (serialização JSON)
- **iText** (geração de PDF)
- **JUnit 5**

---

## ▶️ Como Executar

### Pré-requisitos
- Java JDK 17+
- Gradle (ou wrapper incluso)

### Build do projeto
```bash
./gradlew clean build
