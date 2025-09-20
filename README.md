
# Hospedaje Oasis

Este programa en Java simula un sistema básico de reservas de hotel, permitiendo al usuario registrar, cancelar y consultar el estado de las habitaciones disponibles.

**Funcionalidades**

•	Registrar reserva: Permite elegir una habitación disponible, ingresar el nombre del cliente y el número de noches.

•	Cancelar reserva: Libera una habitación ocupada y elimina los datos asociados.

•	Ver estado de habitaciones: Muestra qué habitaciones están ocupadas o disponibles, con precios y totales.

•	Generar reporte: Informa la cantidad de habitaciones ocupadas y disponibles.

•	Salir: Cierra el sistema.

**Tecnologías usadas**

•	Lenguaje: Java

•	Clase de utilidad: Scanner para la entrada de datos desde consola

**Estructura del código**

•	HotelReservas1: Clase principal donde está el menú interactivo y la lógica de reservas.

•	leerEnteroSeguro(Scanner sc): Método auxiliar para validar que los datos ingresados sean números enteros válidos.

**Habitaciones y precios**

•	Habitaciones 101 a 203 → $100.000 por noche (Habitación normal)

•	Habitaciones 301 en adelante → $500.000 por noche (Suite)

**Variables principales**

Variable	Tipo	Descripción
numHabitaciones	int[]	Números de habitaciones disponibles
nombresClientes	String[]	Nombre del cliente que reservó cada habitación
noches	int[]	Número de noches reservadas
ocupada	boolean[]	Estado de ocupación de las habitaciones
precioPorNoche	double[]	Precio asignado a cada habitación
tipoHabitacion	String[]	Tipo de habitación: Normal o Suite

**Ejecución**

1.	Compila el programa:
2.	javac HotelReservas1.java
3.	Ejecútalo:
4.	java HotelReservas1
5. Usa el menú para interactuar con el sistema.

**Ejemplo de Uso**

===== SISTEMA DE RESERVAS DE HOTEL =====
1. Registrar reserva
2. Cancelar reserva
3. Ver estado de habitaciones
4. Generar reporte
5. Salir
Seleccione una opción:


**Historial de versiones**
- v0.1: Menú principal con opciones básicas.
- v0.2: Agregado manejo de entradas inválidas.
- v0.3: Validación robusta con método leerEnteroSeguro.
- v1.0: Versión final estable.





## Autores

## Autores

- [Nataly Angarita](https://github.com/HxNat)
- [Skarik Barbosa](https://github.com/Skarik-L)
- [Yeray Álvarez](https://github.com/Yeray-f)


