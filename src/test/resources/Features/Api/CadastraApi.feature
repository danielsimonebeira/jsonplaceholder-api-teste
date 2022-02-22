Feature: Testa users via api no site jsonplaceholder

  Description: Validar dados inseridos na api

  Scenario:  Inserir usuario novo
    Given usuario deseje inserir um novo usuario via get na api jsonplaceholder pelo eindpoint "/users"
    When enviar a chave name com o valor "Igor Márcio Carlos"
    And a chave email com o valor "teste@teste.biz"
    And a chave street com o valor "Rua Antônio Euflasino dos Santos"
    And a chave suite com o valor "Apto. 556"
    And a chave city com o valor "João Pessoa"
    And a chave phone com o valor "(48) 91234-1234"
    And a chave website com o valor "testetesteteste.org"
    And a chave name com o valor "Romaguera-teste"
    Then sistema deve retornar o status como "201"
    And o id "11"