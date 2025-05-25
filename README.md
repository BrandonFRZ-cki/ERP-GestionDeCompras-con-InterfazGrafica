# Creación de interfaces gráficas de usuario basada en prototipado

## 📌 Información General

- **Título:**  Creación de interfaces gráficas de usuario basada en prototipado
- **Asignatura:** Programacion Orientada a Objetos
- **Práctica:** 2
- **Carrera:** Computación
- **Estudiantes:** Erick Yunga, Brandon Rivera
- **Fecha:** 05/25/2025
- **Profesor:** Gabriel Alejandro León Paredes


---
# Diagrama UML

![Practica1_POO drawio (3)](https://github.com/user-attachments/assets/9a649960-3820-427a-8390-1aa7a4e4edd2)

---
# Objetivo
**-** El presente proyecto consiste en el desarrollo de un sistema de gestión de compras orientado a facilitar el registro, control y organización de productos, proveedores y solicitudes de compra dentro de una empresa. Este sistema permite la interacción directa con el usuario para llevar a cabo tareas como el registro, listado y gestión de los diferentes elementos que intervienen en el proceso de adquisición de recursos.

La estructura del sistema se basa en una arquitectura modular, compuesta por diversas clases y paquetes que separan claramente la lógica de negocio, la interfaz de usuario y la gestión de datos. Esta separación no solo mejora la eficiencia del sistema, sino que también garantiza una mayor claridad en el código y facilita su mantenimiento y escalabilidad.

Además, se ha incorporado una interfaz gráfica que mejora significativamente la experiencia del usuario, haciendo que el sistema no solo sea funcional, sino también visualmente atractivo y fácil de utilizar.

Crea interfaces gráficas de usuario empleando técnicas de modelado de objetos.

---
**-** Al ejecutar el programa, se mostrará un menú con las siguientes opciones disponibles para el usuario: registrar, listado, búsqueda, aprobación y salir. Estas funcionalidades están integradas en una interfaz gráfica amigable e intuitiva, diseñada para facilitar la interacción del usuario con el sistema. La interfaz no solo mejora la usabilidad, sino que también ofrece una presentación visual clara y ordenada, permitiendo gestionar de manera eficiente el proceso de compras dentro de la empresa.
# ===== SISTEMA DE GESTIÓN DE COMPRAS  =====
# -------- MENU PRINCIPAL -----------
- **1:** Registrar
- **2:** Listado
- **3:** Busqueda
- **4:** Aprobacion
- **5:** Salir
- **Opción:**

## Descripción de las Opciones del Menú:
- **1:** Registrar

**-** La ventana "Registro" permite al usuario ingresar nuevos productos, proveedores y solicitudes de compra en el sistema de gestión. Presenta un diseño sencillo con un encabezado y tres botones que abren ventanas específicas para cada tipo de registro. Está conectada al controlador principal (ListsController), asegurando que los datos ingresados se integren correctamente al sistema. Esta ventana facilita un acceso rápido y organizado para registrar la información necesaria de manera eficiente.

- **2:** Listado

**-** La ventana "Listado" permite al usuario visualizar de forma organizada los proveedores, productos y solicitudes de compra registrados en el sistema. Presenta un diseño simple con un encabezado azul y tres botones principales que, al ser presionados, abren ventanas específicas con la información correspondiente. Cada listado se muestra en una nueva interfaz gráfica, conectada al controlador principal (ListsController), lo que garantiza que los datos mostrados estén actualizados. En el caso de las solicitudes, antes de mostrarse, se actualiza automáticamente la lista para reflejar los registros más recientes. Esta ventana facilita la consulta rápida de datos y contribuye a una mejor organización del sistema de gestión de compras.

- **3:** Busqueda

**-** La ventana "Búsqueda" permite al usuario localizar información específica dentro del sistema de gestión de compras. Presenta un diseño claro con tres botones que ofrecen las siguientes opciones: buscar proveedor por ID, buscar producto por nombre y buscar solicitud por número. Al hacer clic en cualquiera de estos botones, se abre una nueva ventana donde el usuario puede ingresar el dato requerido y obtener los resultados correspondientes. La búsqueda se realiza en tiempo real gracias a la conexión con el controlador principal (ListsController), lo que garantiza precisión y rapidez en la consulta. Esta función mejora la eficiencia del sistema, permitiendo encontrar registros concretos de manera ágil y sencilla.

- **4:** Aprobacion

**-** La ventana "Aprobación" se encarga de verificar la identidad del usuario antes de permitirle acceder a la sección de solicitudes de compra pendientes de aprobación. Presenta un campo para ingresar la contraseña y un botón para continuar. Al hacer clic en el botón "ir", el sistema compara la contraseña ingresada con la del gerente predefinido en el sistema. Si coincide, se abre la ventana de solicitudes para aprobar; en caso contrario, se muestra un mensaje indicando que la contraseña es incorrecta. Esta ventana funciona como una capa de seguridad adicional, asegurando que solo usuarios autorizados puedan acceder a las funcionalidades de aprobación dentro del sistema de gestión de compras.

- **5:** Salir

**-** Esta opción cierra el programa. Al seleccionar esta opción, el sistema terminará la ejecución.


---

# 📊 Rúbrica de Evaluación (8 puntos)
- **Criterio de Evaluación	Puntaje:**
- **1:** Construcción de la interfaz gráfica utilizando únicamente AWT	1.0 pt
- **2:** Diseño funcional e intuitivo de la GUI	1.0 pt
- **3:** Integración correcta con la lógica de negocio (reutilización código)	1.0 pt
- **4:** Manejo adecuado de eventos con clases anónimas o adaptadores	1.0 pt
- **5:** Funcionalidad completa: ingresar datos, listar órdenes, cambiar estados, limpiar y salir	1.0 pt
- **6:** Informe técnico completo y conforme al formato entregado (incluyendo prototipo no funcional)	1.0 pt
- **7:** Estructura y calidad del código: modularidad, nombres descriptivos	1.0 pt
- **8:** Uso de GitHub y trabajo colaborativo reflejado en el proyecto	1.0 pt
- **Total:**	8 pts

---
# ✅ Recomendaciones
**-** Se recomienda utilizar clases anónimas para la implementación de eventos.

**-** No es obligatorio aplicar el patrón MVC, pero sí es importante no mezclar toda la lógica en una única clase.

**-** El prototipo no funcional puede realizarse como un boceto a mano alzada, en herramientas como Figma, Draw.io o incluso en PowerPoint.

**-** Mantener la estructura modular: clases de dominio (lógica) separadas de la interfaz gráfica.





  
