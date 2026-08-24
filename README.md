# AutoManager

> **Projeto AV1 Dev Web — Início dos trabalhos.**

## Documentação da API

### 1. Clientes (`/cliente`)

| Método     | Endpoint        | Status | Descrição               |
| :--------- | :-------------- | :----: | :---------------------- |
| **GET**    | `/cliente`      | `200`  | Lista todos os clientes |
| **GET**    | `/cliente/{id}` | `200`  | Busca cliente por ID    |
| **POST**   | `/cliente`      | `201`  | Cadastra novo cliente   |
| **PUT**    | `/cliente/{id}` | `200`  | Atualiza cliente        |
| **DELETE** | `/cliente/{id}` | `204`  | Remove cliente          |

<details>
<summary>📋 <b>Clique aqui para abrir o JSON de Cadastro (POST)</b></summary>

**Cadastrar:**

```json
{
  "nome": "João da Silva",
  "nomeSocial": "João",
  "dataNascimento": "1990-05-15T00:00:00.000+00:00",
  "dataCadastro": "2026-08-24T00:00:00.000+00:00",
  "endereco": {
    "estado": "SP",
    "cidade": "São José dos Campos",
    "bairro": "Centro",
    "rua": "Avenida Central",
    "numero": "123",
    "codigoPostal": "12200-000",
    "informacoesAdicionais": "Apto 42"
  },
  "documentos": [
    {
      "tipo": "CPF",
      "numero": "12345678901"
    },
    {
      "tipo": "RG",
      "numero": "987654321"
    }
  ],
  "telefones": [
    {
      "ddd": "12",
      "numero": "999998888"
    }
  ]
}
```

</details>

<details>
<summary>📋 <b>Clique aqui para abrir o JSON de Atualização (PUT)</b></summary>

**Atualizar:**

```json
{
  "id": 2,
  "nome": "João da Silva Sauro",
  "nomeSocial": "João",
  "dataNascimento": "1990-05-15T00:00:00.000+00:00",
  "dataCadastro": "2026-08-24T00:00:00.000+00:00",
  "endereco": {
    "id": 2,
    "estado": "SP",
    "cidade": "São José dos Campos",
    "bairro": "Jardim das Indústrias",
    "rua": "Rua das Flores",
    "numero": "456",
    "codigoPostal": "12230-000",
    "informacoesAdicionais": "Bloco B"
  },
  "documentos": [
    {
      "id": 2,
      "tipo": "CPF",
      "numero": "12345678901"
    }
  ],
  "telefones": [
    {
      "id": 2,
      "ddd": "12",
      "numero": "988887777"
    }
  ]
}
```

</details>

---

### 2. Documentos (`/documento`)

| Método     | Endpoint          | Status | Descrição                 |
| :--------- | :---------------- | :----: | :------------------------ |
| **GET**    | `/documento`      | `200`  | Lista todos os documentos |
| **GET**    | `/documento/{id}` | `200`  | Busca documento por ID    |
| **POST**   | `/documento`      | `201`  | Cadastra novo documento   |
| **PUT**    | `/documento/{id}` | `200`  | Atualiza documento        |
| **DELETE** | `/documento/{id}` | `204`  | Remove documento          |

<details>
<summary>📋 <b>Clique aqui para abrir o JSON de Cadastro (POST)</b></summary>

**Cadastrar:**

```json
{
  "tipo": "CPF",
  "numero": "12345678901"
}
```

</details>

<details>
<summary>📋 <b>Clique aqui para abrir o JSON de Atualização (PUT)</b></summary>

**Atualizar:**

```json
{
  "id": 2,
  "tipo": "CPF",
  "numero": "98765432100"
}
```

</details>

---

### 3. Endereços (`/endereco`)

| Método     | Endpoint         | Status | Descrição                |
| :--------- | :--------------- | :----: | :----------------------- |
| **GET**    | `/endereco`      | `200`  | Lista todos os endereços |
| **GET**    | `/endereco/{id}` | `200`  | Busca endereço por ID    |
| **POST**   | `/endereco`      | `201`  | Cadastra novo endereço   |
| **PUT**    | `/endereco/{id}` | `200`  | Atualiza endereço        |
| **DELETE** | `/endereco/{id}` | `204`  | Remove endereço          |

<details>
<summary>📋 <b>Clique aqui para abrir o JSON de Cadastro (POST)</b></summary>

**Cadastrar:**

```json
{
  "estado": "SP",
  "cidade": "São José dos Campos",
  "bairro": "Centro",
  "rua": "Avenida Central",
  "numero": "123",
  "codigoPostal": "12200-000",
  "informacoesAdicionais": "Apto 42"
}
```

</details>

<details>
<summary>📋 <b>Clique aqui para abrir o JSON de Atualização (PUT)</b></summary>

**Atualizar:**

```json
{
  "id": 2,
  "estado": "SP",
  "cidade": "São José dos Campos",
  "bairro": "Jardim das Indústrias",
  "rua": "Rua das Flores",
  "numero": "456",
  "codigoPostal": "12230-000",
  "informacoesAdicionais": "Bloco B, Apto 12"
}
```

</details>

---

### 4. Telefones (`/telefone`)

| Método     | Endpoint         | Status | Descrição                |
| :--------- | :--------------- | :----: | :----------------------- |
| **GET**    | `/telefone`      | `200`  | Lista todos os telefones |
| **GET**    | `/telefone/{id}` | `200`  | Busca telefone por ID    |
| **POST**   | `/telefone`      | `201`  | Cadastra novo telefone   |
| **PUT**    | `/telefone/{id}` | `200`  | Atualiza telefone        |
| **DELETE** | `/telefone/{id}` | `204`  | Remove telefone          |

<details>
<summary>📋 <b>Clique aqui para abrir o JSON de Cadastro (POST)</b></summary>

**Cadastrar:**

```json
{
  "ddd": "12",
  "numero": "999998888"
}
```

</details>

<details>
<summary>📋 <b>Clique aqui para abrir o JSON de Atualização (PUT)</b></summary>

**Atualizar:**

```json
{
  "id": 2,
  "ddd": "12",
  "numero": "988887777"
}
```

</details>

---

> **Nota:** Certifique-se de informar corretamente os parâmetros de caminho (`{id}`) e o formato do payload em JSON no software de testes de requisições de sua preferência, como Postman, Insomnia ou Swagger.
>
> Caso ocorra algum erro no terminal, adicione `/automager` antes do endpoint.
