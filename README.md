# Diseño y desarrollo de una aplicación orientada a objetos utilizando Java

## 📌 Información General

- **Título:** Diseño y desarrollo de una aplicación orientada a objetos utilizando Java
- **Asignatura:** Programacion Orientada a Objetos
- **Práctica:** 1
- **Carrera:** Computación
- **Estudiantes:** Erick Yunga, Brandon Rivera
- **Fecha:** 4/28/2025
- **Profesor:** Gabriel Alejandro León Paredes


---
# Diagrama UML

![Practica1_POO drawio (3)](https://github.com/user-attachments/assets/9a649960-3820-427a-8390-1aa7a4e4edd2)

---
# Objetivo 
**-** El proyecto es un sistema de gestión de compras que permite registrar productos, proveedores y solicitudes de compra. Facilita el control y la organización de los recursos necesarios para la empresa, permitiendo la interacción con el usuario para registrar, listar y gestionar estos elementos. El sistema está compuesto por diversas clases y paquetes que separan la lógica de negocio, la interfaz de usuario y la gestión de datos, garantizando eficiencia, claridad y facilidad de mantenimiento.

---
**-** Al ejecutar el programa, se mostrará un menú con las siguientes opciones disponibles:
# ===== SISTEMA DE GESTIÓN DE COMPRAS  =====
# -------- MENU PRINCIPAL -----------
- **1:** Registrar proveedor
- **2:** Registrar producto
- **3:** Registrar solicitud de compra
- **4:** Listar proveedores
- **5:** Listar productos
- **6:** Listar solicitudes de compra
- **7:** Buscar proveedor por ID
- **8:** Buscar producto por nombre
- **9:** Buscar solicitud por número
- **10:** Aprobar / Rechazar solicitud de compra
- **11:** Salir
- **Opción:**
  
## Descripción de las Opciones del Menú:
- **1:** Registrar Proveedor

**-** Esta opción te permite registrar un nuevo proveedor para los productos disponibles. Primero, el sistema te muestra los productos que no tienen proveedor asignado. Luego, debes seleccionar el producto y proporcionar los detalles del proveedor (ID, nombre, apellido, dirección, teléfono)

- **2:** Registrar Producto

**-** Permite registrar un nuevo producto en el sistema. Te pregunta si deseas crear solo el producto o si deseas asignarle un proveedor también. En el caso de elegir asignar un proveedor, debes ingresar los datos correspondientes al proveedor.

- **3:** Registrar Solicitud de Compra

**-** Esta opción te permite registrar una solicitud de compra. Actualmente, solo se muestra un mensaje indicando que la opción está disponible. (En una versión completa, podrás ingresar productos y cantidades para generar una solicitud).

- **4:** Listar Proveedores

**-** Te muestra una lista de todos los proveedores registrados en el sistema. El sistema muestra los proveedores asociados a productos.

- **5:** Listar Productos

**-** Esta opción muestra todos los productos registrados en el sistema. Te da información como el ID, nombre, precio, IVA y el proveedor asignado a cada producto.

- **6:** Listar Solicitudes de Compra

**-** Muestra todas las solicitudes de compra registradas. Cada solicitud incluye el número de solicitud, los productos solicitados, las cantidades y su estado (si está aprobada o no). Además, muestra el costo total de cada solicitud.

- **7:** Buscar Proveedor por ID

**-** Permite buscar un proveedor específico ingresando su ID. El sistema muestra los datos del proveedor si lo encuentra registrado.

- **8:** Buscar Producto por Nombre

**-** Te permite buscar un producto por su nombre. El sistema muestra el producto correspondiente si está registrado.

- **9:** Buscar Solicitud por Número

**-** Permite buscar una solicitud de compra usando su número. El sistema muestra la solicitud con sus detalles si se encuentra registrada.

- **10:** Aprobar/Rechazar Solicitud de Compra

**-** Aquí podrás aprobar o rechazar las solicitudes de compra. El sistema debería permitirte ingresar el número de la solicitud y cambiar su estado a "Aprobada" o "Rechazada". (Esta opción podría no estar completamente implementada aún).

- **11:** Salir

**-** Esta opción cierra el programa. Al seleccionar esta opción, el sistema terminará la ejecución.


---

# 📊 Rúbrica de Evaluación (10 puntos)
- **Criterio de Evaluación	Puntaje:** 
- **1:** Diseño del Diagrama de Clases (UML)	
-**Aplicación de abstracción, herencia, agregación, polimorfismo. Claridad y coherencia del modelo.	2.0 pts**
- **2:**. Codificación en Java	
-**Correcta implementación del diseño, uso de clases abstractas, interfaces, enums, y estructuras adecuadas.	4.0 pts**
- **3:** Buenas prácticas y convenciones de Java	
-**Encapsulamiento, nombres descriptivos, claridad estructural, modularidad, entre otros.	1.0 pt**
- **4:** Menú funcional en consola	
-**Registro, búsqueda, y listado de datos desde menú con navegación clara y controlada.	1.0 pt**
- **5:** Uso de GitHub y trabajo colaborativo	
-**Flujo de trabajo en equipo reflejado en commits, responsabilidades compartidas, y estructura ordenada.	1.0 pt**
- **6:** Presentación y sustentación oral del código	
-**Explicación clara del diseño, roles, decisiones técnicas y funcionamiento general del sistema.	1.0 pts**
- **Total:**	10 pts

---

# 📋 Guía Visual del Menú en Consola
## ===== SISTEMA DE GESTIÓN DE COMPRAS ERP =====
- **1:** Registrar proveedor
- **2:** Registrar producto
- **3:** Registrar solicitud de compra
- **4:** Listar proveedores
- **5:** Listar productos
- **6:** Listar solicitudes de compra
- **7:** Buscar proveedor por ID
- **8:** Buscar producto por nombre
- **9:** Buscar solicitud por número
- **10:** Aprobar / Rechazar solicitud de compra
- **11:** Salir
- **Seleccione una opción:**

  
