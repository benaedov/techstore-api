# TechStore API 🛒

Microservicio RESTful para gestión de productos de TechStore Chile.
Desarrollado con Java 17, Spring Boot 3.2.5, PostgreSQL y Docker.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.2.5
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL 15
- Docker & Docker Compose
- Maven

## Requisitos previos

- Java 17
- Maven
- Docker Desktop

## Clonar el repositorio

```bash
git clone https://github.com/benaedov/techstore-api.git
cd techstore-api
```

## Ejecutar la aplicación

### Opción 1 — Docker Compose (recomendado)

```bash
docker compose up --build
```

### Opción 2 — Manual

Primero levanta PostgreSQL:
```bash
docker run --name techstore_db \
  -e POSTGRES_DB=techstore \
  -e POSTGRES_USER=admin \
  -e POSTGRES_PASSWORD=admin123 \
  -p 5432:5432 \
  -d postgres:15
```

Luego genera el JAR y ejecuta:
```bash
./mvnw clean package -DskipTests
java -jar target/techstore-api-1.0.0.jar
```

## Endpoints disponibles

### Autenticación
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | /auth/login | Obtener token JWT |

### Productos
| Método | Endpoint | Descripción | HTTP |
|--------|----------|-------------|------|
| GET | /api/productos | Listar todos | 200 |
| POST | /api/productos | Crear producto | 201 |
| PUT | /api/productos/{id} | Modificar producto | 200 |
| DELETE | /api/productos/{id} | Eliminar (lógico) | 204 |

## Autenticación

Hacer POST a `/auth/login`:
```json
{
    "username": "admin@techstore.cl",
    "password": "Admin1234"
}
```

Usar el token en cada petición:
```
Authorization: Bearer <token>
```

## Estructura del proyecto

```
src/main/java/cl/techstore/api/
├── controller/
│   ├── AuthController.java
│   └── ProductoController.java
├── service/
│   └── ProductoService.java
├── repository/
│   └── ProductoRepository.java
├── model/
│   └── Producto.java
├── security/
│   ├── JwtUtil.java
│   ├── JwtFilter.java
│   └── SecurityConfig.java
└── dto/
    ├── LoginRequest.java
    ├── LoginResponse.java
    └── ProductoDTO.java
```

## Autor

Benjamin Aedo — TechStore Chile 🇨🇱
