Tecnologias Utilizadas
Backend:

Spring Boot (Java)
Spring Web (para criar a API REST)
Spring Data JPA (para persistência de dados)
Frontend:

React (JavaScript/JSX)
Axios (para consumir a API REST)

Banco de Dados (opcional):
PostgreSQL
- O banco postgreSQL teve os seguintes atributos:
-  id: Integer,
-  name: character varying
-  image: character varying
-  price_night: integer
-  state: character varying
-  city: character varying



Como Rodar o Projeto
Backend - Spring Boot
Clone este repositório:

git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio/backend


Abra o projeto com sua IDE (ex.: IntelliJ IDEA, Eclipse).

Execute a aplicação:
No IntelliJ: clique no botão de Run ou execute a classe principal Application.java.

Com Maven/CLI:
mvn spring-boot:run
A API estará disponível em: http://localhost:8080


Frontend - React
Navegue até a pasta do frontend:

cd frontend
Instale as dependências:

npm install
Inicie o servidor de desenvolvimento:

npm start
O frontend estará disponível em: http://localhost:3000

O frontend irá consumir os dados da API hospedada no backend (banco de dados PostgreSQL) e exibir as acomodações.


Endpoints da API
GET /acomodacoes: Retorna uma lista de todas as acomodações.
GET /acomodacoes/{id}: Retorna detalhes de uma acomodação específica.
GET /acomodacoes?cidade={nome}: Filtra acomodações pela cidade.
