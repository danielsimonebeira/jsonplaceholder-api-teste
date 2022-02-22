Feature: feature para validar consulta de array

  Scenario: validar dados consultados
    Given acesse o site jsonplaceholder
    And selecione o menu "Guide"
    When acessar o link "/albums/1/photos"
#    Then sistema apresenta no retorno o id "6"