Feature: Testa comments via api no site jsonplaceholder

  Description: Validar dados recebidos da api

  Scenario: Consultar name do comments
    Given usuario deseje efetuar uma consulta via get na api jsonplaceholder
    When inserir no eindpoint "/comments" o valor "?name=alias%20odio%20sit"
    Then sistema deve retornar os status como "200"
    And o e-mail "Lew@alysha.tv"