# CRUD 1 - Herencia, Polimorfismo y ToString

**Alumno:** Simon Kaczmarczyk  
**Comisión:** 26223

---

## Descripción del proyecto

Este proyecto corresponde al **CRUD 1 de artículos**, cuyo objetivo principal es aplicar conceptos fundamentales de **Programación Orientada a Objetos (POO)** utilizando Java.

En esta etapa se trabajan principalmente los siguientes conceptos:

- Clases y objetos
- Encapsulamiento
- Herencia
- Polimorfismo
- Sobrescritura de métodos
- Método `toString()`
- Uso de `instanceof`
- Composición entre clases

El proyecto consiste en desarrollar un CRUD de artículos utilizando diferentes tipos de artículos que heredan de una clase principal.

---

## Objetivo

El objetivo del CRUD es comprender cómo se puede mejorar la estructura de un programa mediante el uso de **herencia y polimorfismo**.

En esta etapa se trabaja con una clase general `Articulo` y diferentes tipos de artículos que heredan de ella:

- `ArticuloElectronico`
- `ArticuloAlimenticio`

Esto permite reutilizar atributos y comportamientos comunes, al mismo tiempo que cada tipo de artículo puede tener características específicas.

---

## Estructura del proyecto

La estructura principal del proyecto es:

```text
src/
└── com/
    └── techlab/
        └── articulo/
            ├── App.java
            └── model/
                ├── Articulo.java
                ├── ArticuloElectronico.java
                ├── ArticuloAlimenticio.java
                └── Categoria.java
