# CriaQuiz SaaS

Plataforma para geracao automatizada de quizzes educacionais com Inteligencia Artificial. O sistema permite criar avaliacoes e perguntas de multipla escolha a partir de temas livres ou textos base, gerando enunciados, alternativas, gabarito e explicacoes pedagogicas.

---

## Arquitetura

O projeto adota os principios de **Clean Architecture (Arquitetura Hexagonal / Ports and Adapters)**, garantindo total isolamento das regras de negocio em relacao a frameworks, banco de dados e provedores externos de IA.

```text
com.criaquiz/
|
|-- domain/                  # Regras de negocio e entidades puras (POJOs)
|   |-- entities/            # Quiz, Pergunta
|   `-- exceptions/
|
|-- application/             # Casos de uso e contratos de comunicacao
|   |-- ports/
|   |   |-- in/              # Portas de entrada (GerarQuizUseCase)
|   |   `-- out/             # Portas de saida (QuizRepositoryPort, AiQuizGeneratePort)
|   `-- usecases/            # Implementacao da logica (GerarQuizService)
|
`-- infrastructure/          # Detalhes tecnologicos e adaptadores externos
    |-- adapters/
    |   |-- in/web/          # Controllers REST e DTOs (Spring MVC)
    |   `-- out/
    |       |-- persistence/ # Adaptador de banco de dados (Spring Data JPA)
    |       `-- ai/          # Adaptador de integracao com LLM (Google Gemini)
    `-- config/              # Injecao de dependencias e configuracao de beans
```

---

## Tecnologias

### Backend
- **Java 17**
- **Spring Boot 3.3.4**
- **Spring Data JPA / Hibernate**
- **PostgreSQL**
- **RestClient** (cliente HTTP nativo para integracao com IA)
- **Jackson** (serializacao e desserializacao JSON)
- **Maven** (gerenciamento de dependencias e build)

### Inteligencia Artificial
- **Google Gemini API (Gemini 1.5 Flash)** com Structured Outputs (JSON Schema)

### DevOps e CI/CD
- **GitHub Actions** (pipeline automatizada de build, validacao e testes a cada push)
- **Docker e Docker Compose**

---

## Fluxo da Aplicacao

1. O cliente HTTP envia uma requisicao para o endpoint `POST /api/quizzes`.
2. O `QuizController` (Adaptador Web) recebe os dados via `CriaQuizRequest` e repassa para a porta de entrada `GerarQuizUseCase`.
3. O `GerarQuizService` coordena o fluxo:
   - Aciona a porta de saida `AiQuizGeneratePort` para gerar as perguntas estruturadas via IA.
   - Constroi a entidade `Quiz` com as perguntas retornadas.
   - Persiste os dados atraves da porta de saida `QuizRepositoryPort`.
4. O `QuizPersistenceAdapter` mapeia a entidade de dominio para `QuizJpaEntity` e grava no PostgreSQL.
5. O quiz criado e retornado como resposta HTTP com status 201 Created.

---

## Como Executar Localmente

### Pre-requisitos
- JDK 17 instalado
- Maven 3.8+ instalado
- Docker e Docker Compose (opcional para banco de dados)

### Passos

1. Clone o repositorio:
```bash
git clone https://github.com/MayconVyctor/CriaQuiz-AI.git
cd criaquiz
```

2. Compile e valide o projeto via Maven:
```bash
cd backend
mvn clean compile
```

3. Execute a aplicacao:
```bash
mvn spring-boot:run
```
