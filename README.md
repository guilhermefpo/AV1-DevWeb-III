# AutoManager

> **Projeto AV1 Dev Web — Início dos trabalhos.**

## Passos para utilizar o Microsserviço

### 1. Clonar o repositório

Clone o repositório do projeto utilizando o comando:

```bash
git clone https://github.com/guilhermefpo/AV1-DevWeb-III.git
```

### 2. Acessar a pasta do projeto

Entre no diretório do projeto:

```bash
cd automanager
```

### 3. Executar o projeto

Inicie a aplicação Spring Boot com o Maven Wrapper:

```bash
.\mvnw.cmd spring-boot:run
```

Após a inicialização, aguarde até que a aplicação esteja disponível para receber requisições.

### 4. Utilizar a API

Com o microsserviço em execução, utilize as **rotas e requisições da API** para realizar os testes.

Você pode utilizar ferramentas como **Postman**, **Insomnia** ou outra ferramenta de sua preferência para enviar as requisições HTTP.

> **💡 Obs:** Verifique a documentação das rotas da API para saber quais endpoints estão disponíveis, quais métodos HTTP devem ser utilizados e quais dados devem ser enviados nas requisições.

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
  "dataCadastro": "2026-08-24T00:00:00.000+00:00"
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
  "dataCadastro": "2026-08-24T00:00:00.000+00:00"
}
```

</details>

---

### 2. Documentos (`/documento`)

| Método     | Endpoint          | Status | Descrição                 |
| :--------- | :---------------- | :----: | :------------------------ |
| **GET**    | `/documento`      | `200`  | Lista todos os documentos |
| **GET**    | `/documento/{id}` | `200`  | Busca documento por ID    |
| **POST**   | `/documento/{id}` | `201`  | Cadastra novo documento   |
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
| **POST**   | `/endereco/{id}` | `201`  | Cadastra novo endereço   |
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
| **POST**   | `/telefone/{id}` | `201`  | Cadastra novo telefone   |
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

> **Nota:** Quando passar o id no caminho, lembresse que se trata do id do cliente. Ao atualizar, colocar no json o id do que vc quer aatualizar. Para postar não precisa.

> Está tendo um erro de Crud em documento, mas a ideia correta é exatamente a passada nas rotas.
