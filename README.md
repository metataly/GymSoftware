# 📦 Microsserviço - Gym Software

Microsserviços desenvolvida com **Java + Spring Boot**. A documentação dos endpoints está disponível via Swagger.

---

## 🚀 Como rodar o projeto localmente

### 🔧 Pré-requisitos

- Java 17+
- Maven
- PostgreSQL rodando localmente
- IDE de sua preferência (IntelliJ, VSCode, etc.)

---

### 📥 1. Clone o projeto

```bash
git clone https://github.com/metataly/GymSoftware.git
```

---

### 🗝️ 2. Importe os arquivos de chave

Coloque o(s) arquivo(s) `.pem` (por exemplo, `chave.pem`) na pasta:

```
src/main/resources/
```

Esses arquivos são utilizados para autenticação/criptografia no sistema.

---

### ⚙️ 3. Configure o `application.properties`

Abra o arquivo:

```
src/main/resources/application.properties
```

Altere os seguintes parâmetros conforme seu ambiente local:

```properties
# Configuração do banco de dados PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/NOME_DO_SEU_BANCO
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

---

### 📡 4. Rodar a aplicação

Se estiver usando Maven:

```bash
./mvnw spring-boot:run
```

Ou com Gradle:

```bash
./gradlew bootRun
```

A aplicação será iniciada na porta **8080** 
e os serviços seguintes até a **8084**

---

### 📚 5. Acessar a documentação Swagger

Abra no navegador:

```
http://localhost:8080/swagger-ui/index.html
```

> ⚠️ Caso a aplicação esteja rodando em outra porta (como 8081 ou 8082), ajuste a URL manualmente.

---

## 🛠️ Dicas úteis

- Certifique-se de que o PostgreSQL está ativo e com as credenciais corretas.

---

## ✅ Pronto!
