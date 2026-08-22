# AutoManager

> Projeto AV1 Dev Web inicio dos trabalhos.

# Documentação da API - Gerenciamento de Clientes

Esta seção detalha os endpoints disponíveis no controller `ClienteControle` para a gestão de clientes na aplicação **AutoManager**.

## Rotas Mapeadas

| Método HTTP | Endpoint        | Status HTTP      | Descrição                                           | Corpo da Requisição (Payload) | Resposta           |
| :---------- | :-------------- | :--------------- | :-------------------------------------------------- | :---------------------------- | :----------------- |
| **GET**     | `/cliente`      | `200 OK`         | Retorna a lista de todos os clientes cadastrados.   | _Nenhum_                      | `List<ClienteDTO>` |
| **GET**     | `/cliente/{id}` | `200 OK`         | Busca os detalhes de um cliente específico pelo ID. | _Nenhum_                      | `ClienteDTO`       |
| **POST**    | `/cliente`      | `201 CREATED`    | Cadastra um novo cliente no sistema.                | `ClienteDTO`                  | `ClienteDTO`       |
| **PUT**     | `/cliente/{id}` | `200 OK`         | Atualiza os dados de um cliente existente pelo ID.  | `ClienteDTO`                  | `ClienteDTO`       |
| **DELETE**  | `/cliente/{id}` | `204 NO CONTENT` | Remove um cliente do sistema pelo ID.               | _Nenhum_                      | _Nenhum_           |

> **Nota:** Certifique-se de ajustar a anotação dos métodos http no Softwere de requisições de sua preferência.
