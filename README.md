# ST-CHALLENGE

Backend para la prescripción de medicamentos a pacientes

>  #rest #java #prescriptions
---
## Tabla de Contenido
- [Descripción](#descripción)
- [Detalle de Funcionalidades](#detalle-de-funcionalidades)
- [Arquitectura](#arquitectura)
- [Construido con](#construido-con)
- [Desarrollo](#desarrollo)
- [Seguridad](#seguridad)
- [Endpoints](#endpoints)
- [Licencia](#licencia)
---
## Descripción

Este aplicación define las API's necesarias para la administración de los pacientes y la asignación de medicamentos.

## Detalle de Funcionalidades

Las siguientes son las funcionalidades encontradas en este repositorio:

### Pacientes

- Listado
- Creación
- Actualización
- Eliminación

### Medicamentos

- Listado

### Prescripciones 

- Prescripción de medicamento a pacientes
- Listado de prescripciones del paciente

---

## Arquitectura
Este proyecto se compone de una arquitectura cliente-servidor.

Esta aplicación hace uso de una base de datos embebida (H2)

## Construido con

El código se encuentra implementado con Java 11 y Gradle 6.9.1 usando las siguientes librerías:

- Gradle en su versión 7.6
- Lombok - Para simplificar la creación de los medios de acceso a datos de un objeto
- Log4j - Para escribir mensajes de registro
- H2 - Base de datos embebida y en memoria 
- JPA - Api de persistencia para facilitar la administración de los datos en la DB
- GSON - Para el mapeo de objetos JSON a clases Java
- Actuator - Información operacional de la aplicación 

## Desarrollo
1. Instale Java 17 y un IDE de desarrollo como Eclipse o IntelliJ.
2. Clone este repositorio.
3. Permita la descarga de dependencias y la construcción del proyecto con gradle.
4. Inicialice el proyecto ./gradlew bootRun
5. Abra http://localhost/st/health para revisar si la aplicación está arriba

Para ejecutar las pruebas unitarias:

1. /gradlew test

---

## Endpoints

---

## Autor

Andrés Felipe Flórez Caro
- 2022 ©