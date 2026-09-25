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
