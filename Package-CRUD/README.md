CRUD de Artículos - Java POO

Este proyecto es una aplicación de consola desarrollada en Java que implementa un sistema CRUD (Crear, Leer, Actualizar, Eliminar) para la gestión de artículos y categorías.

Datos del Alumno

Nombre: Simón Kaczmarczyk

Comisión: 26223

Características del Sistema

El sistema permite gestionar un catálogo de productos con sus respectivas categorías, diferenciando entre distintos tipos de artículos. Cuenta con un menú interactivo que permite:

Ingresar un nuevo artículo: Soporta artículos electrónicos (con meses de garantía) y alimenticios (con días para su vencimiento).

Listar artículos: Muestra el catálogo completo con sus detalles específicos.

Consultar: Búsqueda individual de artículos a través de su código único.

Modificar: Actualización de precios, nombres y atributos específicos según el tipo de artículo.

Eliminar: Baja de registros del sistema.

Conceptos de POO Aplicados

Este proyecto fue diseñado aplicando los pilares fundamentales de la Programación Orientada a Objetos:

Encapsulamiento: Uso de modificadores de acceso (private) para proteger los datos de las clases y exposición controlada a través de métodos getters y setters.

Composición: Relación "tiene un" establecida entre las clases Articulo y Categoria.

Herencia: Creación de una jerarquía de clases donde ArticuloElectronico y ArticuloAlimenticio extienden de la clase base Articulo para reutilizar código.

Polimorfismo: Sobrescritura de métodos como getTipoArticulo() y getDetalleEspecifico() en las clases hijas para lograr comportamientos específicos, así como el uso de toString() para la representación de los objetos.

Manejo de Colecciones: Uso de genéricos (ArrayList) para el almacenamiento seguro y tipado de los datos en memoria.