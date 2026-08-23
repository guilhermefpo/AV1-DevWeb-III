# AutoManager

> Projeto AV1 Dev Web — Início dos trabalhos.

## Documentação da API

### 1. Clientes (`/cliente`)

| Método     | Endpoint        | Status | Descrição               |
| :--------- | :-------------- | :----- | :---------------------- |
| **GET**    | `/cliente`      | `200`  | Lista todos os clientes |
| **GET**    | `/cliente/{id}` | `200`  | Busca cliente por ID    |
| **POST**   | `/cliente`      | `201`  | Cadastra novo cliente   |
| **PUT**    | `/cliente/{id}` | `200`  | Atualiza cliente        |
| **DELETE** | `/cliente/{id}` | `204`  | Remove cliente          |

---

### 2. Documentos (`/documento`)

| Método     | Endpoint          | Status | Descrição                 |
| :--------- | :---------------- | :----- | :------------------------ |
| **GET**    | `/documento`      | `200`  | Lista todos os documentos |
| **GET**    | `/documento/{id}` | `200`  | Busca documento por ID    |
| **POST**   | `/documento`      | `201`  | Cadastra novo documento   |
| **PUT**    | `/documento/{id}` | `200`  | Atualiza documento        |
| **DELETE** | `/documento/{id}` | `204`  | Remove documento          |

> **Nota:** Certifique-se de informar corretamente os parâmetros de caminho (`{id}`) e o formato do payload em JSON no software de testes de requisições de sua preferência (ex: Postman, Insomnia ou Swagger).
