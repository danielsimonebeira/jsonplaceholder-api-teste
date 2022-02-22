Feature: Testa comments via api no site jsonplaceholder

  Scenario Outline: Alterar dados do usuarios
    Given usuario deseje alterar um dado do usuario via put na api jsonplaceholder
    When inserir no eindpoint "<eindpoint>" a chave com o valor id "<id>"
    And a chave e-mail com valor "<email>"
    And a chave latitude com o valor "<latitude>"
    And a chave longitude com o valor "<longitude>"
    Then sistema deve retornar o status como "<statuscode>"
    And o valor "<email>"
    And o valor "<latitude>"
    And o valor "<longitude>"

    Examples:
    | eindpoint | id | email          | latitude | longitude | statuscode |
    | /users    | 5  | teste@annie.ca | -37.9999 | 81.9999   | 200        |