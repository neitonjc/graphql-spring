# graphql-spring
Projeto demonstração de implementação GraphQL com Spring e base MySQL

query{
  findAllPets{
    cod
    nome
    dono {
      nome
    }
  }
  
  findPetById(cod:18){
    nome
    dono {
      nome
      email
      bairro
    }
  }
  
  findAllPeople {
    cod
    nome
  }
  
  findPeopleById(cod:1){
    nome
    email
    bairro
    genero
  }
}
