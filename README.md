# 🚚 Sistema de Roteirização Logística

Sistema desenvolvido para gerenciamento e organização de operações de logística, permitindo o cadastro e gerenciamento de **clientes, motoristas, veículos, entregas, paradas e rotas**.

O projeto foi desenvolvido utilizando **Java 21, Spring Boot, Maven e MySQL**, com documentação da API através do **Swagger/OpenAPI** e estratégia de testes utilizando **Postman, Cypress e MySQL Workbench**.

---

## 👨‍💻 Autor

**José Ribamar Vieira Batista**

🔗 GitHub: [github.com/jriba78](https://github.com/jriba78)

Projeto desenvolvido para estudo, prática e demonstração de conhecimentos em:

* Desenvolvimento Backend
* Java
* Spring Boot
* APIs REST
* Banco de dados
* Testes de API
* Automação de testes
* Qualidade de software (QA)
* Git e GitHub

---

# 📋 Índice

* [Objetivo](#-objetivo)
* [Escopo](#-escopo)
* [Funcionalidades](#-funcionalidades)
* [Arquitetura](#-arquitetura)
* [Tecnologias](#-tecnologias)
* [Banco de Dados](#-banco-de-dados)
* [Entidades](#-entidades)
* [API REST](#-api-rest)
* [Swagger](#-swagger)
* [Testes](#-testes)
* [Cypress](#-cypress)
* [Postman](#-postman)
* [MySQL Workbench](#-mysql-workbench)
* [GitHub Project](#-github-project)
* [Como executar](#-como-executar)
* [Configuração do banco](#-configuração-do-banco)
* [Estrutura do projeto](#-estrutura-do-projeto)
* [Cenários de teste](#-cenários-de-teste)
* [Critérios de aceite](#-critérios-de-aceite)
* [Melhorias futuras](#-melhorias-futuras)
* [Autor](#-autor)

---

# 🎯 Objetivo

O objetivo do projeto é desenvolver uma API REST para apoiar o gerenciamento de operações de transporte e entregas.

O sistema permite centralizar informações relacionadas a:

* Clientes
* Motoristas
* Veículos
* Entregas
* Paradas
* Rotas

A aplicação também permite aplicar práticas de **Qualidade de Software**, incluindo testes funcionais, testes de API, testes de integração e automação.

---

# 📌 Escopo

O sistema contempla:

### Clientes

* Cadastro
* Consulta
* Alteração
* Exclusão
* Validação de dados

### Motoristas

* Cadastro
* Consulta
* Alteração
* Exclusão
* Validação de informações

### Veículos

* Cadastro
* Consulta
* Alteração
* Exclusão
* Associação ao processo de roteirização

### Entregas

* Cadastro
* Consulta
* Alteração
* Exclusão
* Associação com cliente
* Controle de status

### Paradas

* Cadastro
* Consulta
* Alteração
* Associação com rotas
* Definição da sequência

### Rotas

* Cadastro
* Consulta
* Alteração
* Exclusão
* Associação de motorista
* Associação de veículo
* Associação de entregas/paradas

---

# ⚙️ Funcionalidades

## 👥 Clientes

| Operação          | Método |
| ----------------- | ------ |
| Criar cliente     | POST   |
| Listar clientes   | GET    |
| Consultar cliente | GET    |
| Atualizar cliente | PUT    |
| Excluir cliente   | DELETE |

## 🚚 Motoristas

| Operação            | Método |
| ------------------- | ------ |
| Criar motorista     | POST   |
| Listar motoristas   | GET    |
| Consultar motorista | GET    |
| Atualizar motorista | PUT    |
| Excluir motorista   | DELETE |

## 🚛 Veículos

| Operação          | Método |
| ----------------- | ------ |
| Criar veículo     | POST   |
| Listar veículos   | GET    |
| Consultar veículo | GET    |
| Atualizar veículo | PUT    |
| Excluir veículo   | DELETE |

## 📦 Entregas

| Operação          | Método |
| ----------------- | ------ |
| Criar entrega     | POST   |
| Listar entregas   | GET    |
| Consultar entrega | GET    |
| Atualizar entrega | PUT    |
| Excluir entrega   | DELETE |

## 📍 Paradas

| Operação         | Método |
| ---------------- | ------ |
| Criar parada     | POST   |
| Listar paradas   | GET    |
| Consultar parada | GET    |
| Atualizar parada | PUT    |
| Excluir parada   | DELETE |

## 🛣️ Rotas

| Operação       | Método |
| -------------- | ------ |
| Criar rota     | POST   |
| Listar rotas   | GET    |
| Consultar rota | GET    |
| Atualizar rota | PUT    |
| Excluir rota   | DELETE |

> Os endpoints definitivos devem ser considerados de acordo com os Controllers implementados no projeto.

---

# 🏗️ Arquitetura

O projeto utiliza uma arquitetura baseada em camadas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Entity
    ↓
MySQL
```

### Controller

Responsável por:

* Receber requisições HTTP.
* Validar entradas.
* Retornar respostas da API.

### Service

Responsável pelas:

* Regras de negócio.
* Validações.
* Orquestração das operações.

### Repository

Responsável pela comunicação com o banco através do Spring Data JPA.

### Entity

Representa as entidades persistidas no banco de dados.

---

# 🛠️ Tecnologias

## Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Maven
* Hibernate

## Banco de dados

* MySQL 26.7
* MySQL Workbench

## Testes

* Postman
* Cypress
* SQL

## Documentação

* Swagger
* OpenAPI

## Versionamento

* Git
* GitHub

---

# 🗄️ Banco de Dados

Banco utilizado:

```text
roteirizacao_logistica
```

Tabelas:

```text
clientes
entregas
motoristas
paradas
rotas
veiculos
```

Relacionamentos entre as entidades são utilizados para manter a integridade dos dados.

---

# 📊 Modelo de dados

Visão simplificada:

```text
                  ┌──────────────┐
                  │   CLIENTES   │
                  └──────┬───────┘
                         │
                         │
                         ▼
                  ┌──────────────┐
                  │   ENTREGAS   │
                  └──────┬───────┘
                         │
                         ▼
                  ┌──────────────┐
                  │    PARADAS   │
                  └──────┬───────┘
                         │
                         ▼
                  ┌──────────────┐
                  │    ROTAS     │
                  └──────┬───────┘
                         │
                 ┌───────┴────────┐
                 ▼                ▼
          ┌────────────┐   ┌────────────┐
          │ MOTORISTAS │   │  VEICULOS  │
          └────────────┘   └────────────┘
```

---

# 🔌 API REST

A aplicação disponibiliza uma API REST para gerenciamento das entidades.

Exemplos de operações:

```http
GET /clientes
POST /clientes
GET /clientes/{id}
PUT /clientes/{id}
DELETE /clientes/{id}
```

Exemplo:

```http
GET http://localhost:8080/clientes
```

---

# 📖 Swagger / OpenAPI

A documentação da API pode ser acessada através do Swagger.

Após iniciar o projeto:

```text
http://localhost:8080/swagger-ui.html
```

ou, dependendo da configuração:

```text
http://localhost:8080/swagger-ui/index.html
```

Documentação OpenAPI:

```text
http://localhost:8080/v3/api-docs
```

O Swagger permite:

* Visualizar endpoints.
* Consultar métodos HTTP.
* Informar parâmetros.
* Enviar requisições.
* Visualizar respostas.
* Testar a API.

---

# 🧪 Estratégia de Testes

O projeto utiliza uma estratégia de testes baseada em:

### Testes funcionais

Validar se cada funcionalidade atende ao comportamento esperado.

### Testes de API

Validar:

* Métodos HTTP.
* Status codes.
* Headers.
* Response body.
* Mensagens de erro.

### Testes negativos

Validar o comportamento do sistema diante de dados inválidos.

### Testes de integração

Validar a comunicação:

```text
API
 ↓
Service
 ↓
Repository
 ↓
MySQL
```

### Testes de banco

Validar:

* Persistência.
* Atualização.
* Exclusão.
* Relacionamentos.
* Chaves estrangeiras.

---

# 🧪 Cypress

O Cypress é utilizado para automação dos testes da API.

Exemplo de fluxo:

```text
Cypress
   ↓
POST /clientes
   ↓
Validar HTTP 201
   ↓
Validar response
   ↓
GET /clientes/{id}
   ↓
Validar cliente
```

Também são previstos cenários negativos:

```text
POST /clientes
      ↓
Dados inválidos
      ↓
HTTP 400
      ↓
Validar mensagem de erro
```

---

# 📮 Postman

O Postman pode ser utilizado para execução manual dos testes da API.

Exemplos:

```text
POST /clientes
GET /clientes
GET /clientes/{id}
PUT /clientes/{id}
DELETE /clientes/{id}
```

Os testes devem validar:

* Status HTTP.
* Corpo da resposta.
* Mensagens.
* Dados retornados.
* Persistência no banco.

---

# 🗃️ MySQL Workbench

O MySQL Workbench é utilizado para administração e validação visual do banco de dados.

Banco:

```text
roteirizacao_logistica
```

Tabelas:

```text
clientes
entregas
motoristas
paradas
rotas
veiculos
```

Exemplos de consultas:

```sql
USE roteirizacao_logistica;

SHOW TABLES;
```

Consultar clientes:

```sql
SELECT * FROM clientes;
```

Consultar entregas:

```sql
SELECT * FROM entregas;
```

Consultar rotas:

```sql
SELECT * FROM rotas;
```

O Workbench também pode ser utilizado para validar se uma operação realizada pela API foi corretamente persistida.

---

# 📋 GitHub Project

O projeto utiliza um Board para organização das atividades.

Fluxo:

```text
BACKLOG
   ↓
TODO
   ↓
EM ANDAMENTO
   ↓
EM TESTE
   ↓
BUG
   ↓
DONE
```

As atividades podem ser organizadas por:

* Backend
* QA
* API
* Banco de dados
* Automação
* Documentação
* Bugs

---

# ▶️ Como executar o projeto

## Pré-requisitos

Instalar:

* Java 21
* Maven
* MySQL Server
* MySQL Workbench
* Git
* IDE Eclipse ou IntelliJ IDEA

Verificar Java:

```bash
java -version
```

Verificar Maven:

```bash
mvn -version
```

Verificar MySQL:

```bash
mysql --version
```

---

# 🗄️ Configuração do MySQL

Criar o banco:

```sql
CREATE DATABASE roteirizacao_logistica;
```

Selecionar:

```sql
USE roteirizacao_logistica;
```

O projeto utiliza a porta padrão:

```text
3306
```

---

# ⚙️ Configuração do Spring Boot

Arquivo:

```text
src/main/resources/application.properties
```

Exemplo:

```properties
spring.application.name=roteirizacao-logistica

server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/roteirizacao_logistica?useSSL=false&serverTimezone=America/Sao_Paulo&allowPublicKeyRetrieval=true

spring.datasource.username=root
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

spring.jpa.open-in-view=false

springdoc.swagger-ui.path=/swagger-ui.html
springdoc.api-docs.path=/v3/api-docs
```

> Nunca publique senhas reais no GitHub. Utilize variáveis de ambiente ou um arquivo de configuração que não seja versionado.

---

# ▶️ Executando a aplicação

Na pasta raiz do projeto:

```bash
mvn clean install
```

Depois:

```bash
mvn spring-boot:run
```

A aplicação será executada em:

```text
http://localhost:8080
```

---

# 🧪 Cenários de Teste

## Cliente

### CT01 — Cadastro válido

**Dado:** dados válidos de cliente.

**Quando:** executar POST `/clientes`.

**Então:** cliente deve ser criado com sucesso.

### CT02 — Cadastro sem nome

**Quando:** enviar cliente sem nome.

**Então:** API deve retornar erro de validação.

### CT03 — Consulta de cliente

**Quando:** consultar cliente existente.

**Então:** retornar HTTP `200 OK`.

### CT04 — Cliente inexistente

**Quando:** consultar ID inexistente.

**Então:** retornar HTTP `404 Not Found`.

### CT05 — Atualização

**Quando:** atualizar cliente existente.

**Então:** dados devem ser atualizados.

### CT06 — Exclusão

**Quando:** excluir cliente sem dependências.

**Então:** cliente deve ser removido.

---

# 📦 Entregas

### CT07 — Criar entrega

Criar entrega associada a um cliente existente.

### CT08 — Cliente inexistente

Tentar criar entrega utilizando cliente inexistente.

### CT09 — Consultar entregas

Validar retorno da lista de entregas.

### CT10 — Atualizar entrega

Validar alteração dos dados da entrega.

---

# 🛣️ Rotas

### CT11 — Criar rota válida

Criar rota utilizando motorista e veículo válidos.

### CT12 — Criar rota sem motorista

Validar rejeição da operação.

### CT13 — Criar rota com veículo inexistente

Validar tratamento da inconsistência.

### CT14 — Consultar rota

Validar dados e relacionamentos da rota.

---

# 🔗 Integridade de dados

Validar relacionamentos entre:

```text
Cliente
   ↓
Entrega
   ↓
Parada
   ↓
Rota
   ↓
Motorista
   +
Veículo
```

Também devem ser realizados testes de exclusão envolvendo registros relacionados.

Exemplo:

```text
Cliente
   ↓
Entrega
```

Tentar excluir o cliente enquanto existem entregas relacionadas deve ser tratado de acordo com a regra de integridade definida no sistema.

---

# ✅ Critérios de Aceite

O projeto será considerado pronto para homologação quando:

* [ ] API estiver disponível.
* [ ] CRUDs principais estiverem funcionando.
* [ ] Validações estiverem implementadas.
* [ ] Relacionamentos estiverem funcionando.
* [ ] Banco estiver conectado.
* [ ] Swagger estiver disponível.
* [ ] Testes funcionais forem executados.
* [ ] Testes negativos forem executados.
* [ ] Testes de API forem executados.
* [ ] Testes de banco forem executados.
* [ ] Testes automatizados críticos forem executados.
* [ ] Bugs críticos estiverem tratados.
* [ ] Documentação estiver atualizada.

---

# 📁 Estrutura do projeto

Estrutura esperada:

```text
roteirizacao-logistica/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/
│   │   │       └── com/
│   │   │           └── ...
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│
├── pom.xml
├── README.md
├── .gitignore
└── ...
```

---

# 🔄 Fluxo de desenvolvimento e QA

```text
Requisito
   ↓
Desenvolvimento
   ↓
Pull Request
   ↓
Code Review
   ↓
Testes de API
   ↓
Testes Cypress
   ↓
Validação MySQL
   ↓
Correção de Bugs
   ↓
Regressão
   ↓
Aprovação
   ↓
Done
```

---

# 📊 Ferramentas utilizadas no projeto

| Ferramenta      | Utilização                |
| --------------- | ------------------------- |
| Java 21         | Desenvolvimento           |
| Spring Boot     | Backend                   |
| Maven           | Gerenciamento do projeto  |
| Spring Data JPA | Persistência              |
| Hibernate       | ORM                       |
| MySQL           | Banco de dados            |
| MySQL Workbench | Administração do banco    |
| Swagger/OpenAPI | Documentação da API       |
| Postman         | Testes de API             |
| Cypress         | Automação                 |
| Git             | Versionamento             |
| GitHub          | Repositório e colaboração |
| GitHub Projects | Gestão das atividades     |

---

# 🚀 Melhorias futuras

Possíveis evoluções do projeto:

* Implementação de autenticação e autorização.
* Controle de usuários e perfis.
* Dashboard de acompanhamento.
* Cálculo automático de rotas.
* Integração com APIs de mapas.
* Geolocalização.
* Rastreamento de entregas.
* Otimização de rotas.
* Testes de performance.
* Pipeline CI/CD.
* Integração com GitHub Actions.
* Relatórios de qualidade.
* Cobertura automatizada de testes.

---

# 🎓 Objetivo profissional

Este projeto também tem como objetivo demonstrar conhecimentos práticos em **Qualidade de Software e Desenvolvimento Backend**, incluindo:

* Levantamento de requisitos.
* Planejamento de testes.
* Criação de cenários.
* Testes funcionais.
* Testes de API.
* Testes negativos.
* Testes de integração.
* Validação de banco de dados.
* Automação com Cypress.
* Documentação com Swagger.
* Controle de versão com Git.
* Gestão de atividades com GitHub Projects.

---

# 👨‍💻 Autor

## José Ribamar Vieira Batista

**Analista de Testes Jr.**

Tecnologias e conhecimentos utilizados no projeto:

```text
Java
Spring Boot
MySQL
SQL
Cypress
Playwright
Selenium
Postman
Git
GitHub
Swagger
```

🔗 GitHub: https://github.com/jriba78

---

# 📄 Licença

Projeto desenvolvido para fins de estudo, prática profissional e demonstração de conhecimentos em desenvolvimento e qualidade de software.

---

## ⭐ Projeto

**Roteirização Logística**

Desenvolvido por **José Ribamar Vieira Batista**.
# Roteirização Logística API

API REST em **Java 21**, **Spring Boot 3.5**, **Maven**, **MySQL** e **Swagger**, para cadastro de clientes, motoristas, veículos, entregas e geração de rotas.

A roteirização usa o algoritmo do vizinho mais próximo (proximidade em linha reta, fórmula de Haversine). Não há integração com Google Maps ou OSRM nesta versão.

## Requisitos

- JDK 21
- Maven 3.9+ (ou Eclipse com m2e)
- MySQL 8

## Banco de dados

No MySQL Workbench:

```sql
CREATE DATABASE roteirizacao_logistica
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;
```

O Hibernate também cria/atualiza as tabelas (`ddl-auto=update`). O script completo está em `src/main/resources/db/schema.sql`.

Em `src/main/resources/application.properties`, ajuste usuário e senha:

```properties
spring.datasource.username=root
spring.datasource.password=SUA_SENHA_MYSQL
```

Ou defina as variáveis `MYSQL_USER` e `MYSQL_PASSWORD`.

## Abrir no Eclipse

1. File → Import → Maven → Existing Maven Projects
2. Selecione a pasta `roteirizacao-logistica`
3. Marque o `pom.xml` e clique em Finish
4. Aguarde o Maven baixar as dependências
5. Execute `RoteirizacaoApplication` (Run As → Java Application / Spring Boot App)

Pelo terminal:

```bash
mvn spring-boot:run
```

## Swagger

- UI: http://localhost:8080/swagger-ui/index.html
- OpenAPI: http://localhost:8080/v3/api-docs

O caminho `/swagger-ui.html` redireciona para a UI.

## Fluxo de teste

1. `POST /api/clientes`
2. `POST /api/motoristas`
3. `POST /api/veiculos`
4. `POST /api/entregas` (com `latitude` e `longitude` das paradas)
5. `POST /api/rotas` com `motoristaId`, `veiculoId`, `data` e `entregaIds`

A rota valida capacidade do veículo, ordena as paradas a partir do centro de distribuição (configurado em `app.cd.*`), calcula distância total (incluindo retorno ao CD) e tempo estimado.

Coleção Postman: `postman/RoteirizacaoLogistica.postman_collection.json`

## Endpoints

| Recurso | Base |
| --- | --- |
| Clientes | `/api/clientes` |
| Motoristas | `/api/motoristas` |
| Veículos | `/api/veiculos` |
| Entregas | `/api/entregas` |
| Rotas | `/api/rotas` |

Status de entrega: `PENDENTE`, `EM_ROTA`, `ENTREGUE`, `CANCELADA`  
Status de rota: `PLANEJADA`, `EM_ANDAMENTO`, `CONCLUIDA`, `CANCELADA`

## Fora do escopo desta versão

Autenticação, cálculo de distância por ruas, rastreamento em tempo real e suíte completa de testes de integração.
