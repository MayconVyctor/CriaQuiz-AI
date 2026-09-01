# CriaQuiz

Plataforma web de geração de quizzes personalizados com inteligência artificial. O usuário pode gerar perguntas a partir de um tema livre ou fazer upload de materiais próprios em PDF, e a IA cria automaticamente um quiz completo com alternativas e explicações.

---

## Tecnologias

**Backend**
- Java 21
- Spring Boot 4
- Spring Security com autenticação JWT
- Spring Data JPA com Hibernate
- PostgreSQL 16
- Apache PDFBox (extração de texto de PDFs)
- API da Anthropic (geração de perguntas com IA)

**Frontend**
- React com TypeScript (em desenvolvimento)

**Infraestrutura**
- Docker e Docker Compose
- Deploy: Railway (backend) e Vercel (frontend)

---

## Arquitetura


O backend segue arquitetura em camadas: Controller, Service e Repository. A autenticação é stateless via JWT, sem uso de sessão, compatível com ambiente containerizado.

---

## Como rodar localmente

**Requisitos**
- Docker e Docker Compose instalados

**1. Clone o repositório**
```bash
git clone https://github.com/seu-usuario/criaquiz.git
cd criaquiz
```

**2. Configure as variáveis de ambiente**
```bash
cp .env.example .env
```

Edite o arquivo `.env` e adicione sua chave da API da Anthropic:
