# Cerro Verde — Laboratorio Spring Boot con PostgreSQL

Proyecto adaptado del laboratorio Spring Boot al sistema de monitoreo hídrico de Cerro Verde. Implementa la estructura **Entidad → Repositorio → Servicio → Controlador REST**, conexión a PostgreSQL, generación de tablas con JPA y datos demostrativos.

## Requisitos
- JDK 17
- IntelliJ IDEA (o editor compatible)
- PostgreSQL y una base de datos llamada `cerro_verde`
- Maven (o usar `mvnw.cmd` en Windows)

## 1. Crear la base de datos
En pgAdmin, abra Query Tool y ejecute:

```sql
CREATE DATABASE cerro_verde;
```

Si la base de datos ya existe, no vuelva a crearla.

## 2. Configurar conexión
Edite `src/main/resources/application.properties`. Por defecto:
- URL: `jdbc:postgresql://localhost:5432/cerro_verde`
- Usuario: `postgres`
- Contraseña: `postgres`

Cambie la contraseña por la que usa en su instalación. También puede configurar las variables `DB_URL`, `DB_USER` y `DB_PASSWORD`.

## 3. Abrir y ejecutar
1. Descomprima el proyecto.
2. Abra la carpeta `cerro-verde` desde IntelliJ IDEA.
3. Espere a que Maven descargue las dependencias.
4. Ejecute `src/main/java/com/cerro/verde/Application.java`.
5. Al iniciar, Hibernate crea/actualiza las tablas y se insertan datos de prueba si las tablas están vacías.

## 4. Probar la API
Abra `http://localhost:8080/`. Para ver recursos:
- `GET http://localhost:8080/api/areas`
- `GET http://localhost:8080/api/regiones`
- `GET http://localhost:8080/api/zonas`
- `GET http://localhost:8080/api/puntos-monitoreo`
- `GET http://localhost:8080/api/parametros`
- `GET http://localhost:8080/api/monitoreos`
- `GET http://localhost:8080/api/lecturas`
- `GET http://localhost:8080/api/alertas`

Cada recurso tiene CRUD:
- `GET /api/{recurso}` lista
- `GET /api/{recurso}/{id}` consulta uno
- `POST /api/{recurso}` registra JSON
- `PUT /api/{recurso}/{id}` actualiza
- `DELETE /api/{recurso}/{id}` elimina

Ejemplo de `POST /api/parametros`:
```json
{
  "nombre": "Conductividad",
  "descripcion": "Conductividad eléctrica del agua",
  "unidadMedida": "µS/cm",
  "rangoMin": 0,
  "rangoMax": 1500,
  "estado": true
}
```

## 5. Tablas incluidas en esta primera implementación
`area`, `region`, `zona`, `punto_monitoreo`, `parametro`, `monitoreo`, `lectura_parametro`, `alerta`.

Este es el núcleo funcional para demostrar el procedimiento del laboratorio. El documento de avance describe un modelo ampliado de 20 entidades; las tablas y módulos restantes (usuario/rol, documentos, notificaciones, seguimiento, reportes, mapa 2D, entidades externas e historial) deben incorporarse en siguientes iteraciones para completar el modelo de tesis.

## Consideraciones
- No se usa MySQL; el driver y URL corresponden a PostgreSQL.
- `ddl-auto=update` es práctico para el laboratorio, no es la estrategia recomendada para producción.
- La API aún no incorpora autenticación/autorización. No exponerla públicamente sin implementar Spring Security.
- Los datos iniciales son demostrativos y no representan mediciones reales de Cerro Verde.
