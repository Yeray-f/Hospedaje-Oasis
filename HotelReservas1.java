import java.util.Scanner;

public class HotelReservas1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Números de habitaciones
        int[] numHabitaciones = {101, 102, 103, 201, 202, 203, 301, 302, 303};

        // Datos de reservas
        String[] nombresClientes = new String[numHabitaciones.length];
        int[] noches = new int[numHabitaciones.length];
        boolean[] ocupada = new boolean[numHabitaciones.length];

        // Precios: habitaciones normales = 100000, suites = 500000
        final double[] precioPorNoche = new double[numHabitaciones.length];
        final String[] tipoHabitacion = new String[numHabitaciones.length]; // Normal o Suite

        for (int i = 0; i < numHabitaciones.length; i++) {
            if (numHabitaciones[i] >= 301) {
                precioPorNoche[i] = 500000;
                tipoHabitacion[i] = "Suite";
            } else {
                precioPorNoche[i] = 100000;
                tipoHabitacion[i] = "Habitación";
            }
        }

        boolean salir = false;

        while (!salir) {
            System.out.println("===== SISTEMA DE RESERVAS DEL HOSPEDAJE OASIS =====");
            System.out.println("1. Registrar reserva");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Ver estado de habitaciones");
            System.out.println("4. Generar reporte");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = leerEnteroSeguro(sc);

            switch (opcion) {
                case 1:
                    // Mostrar habitaciones disponibles antes de elegir
                    System.out.println("\n--- Habitaciones disponibles ---");
                    boolean hayDisponibles = false;
                    for (int i = 0; i < numHabitaciones.length; i++) {
                        if (!ocupada[i]) {
                            System.out.println(tipoHabitacion[i] + " " + numHabitaciones[i] +
                                    " | Precio/noche: $" + precioPorNoche[i]);
                            hayDisponibles = true;
                        }
                    }

                    if (!hayDisponibles) {
                        System.out.println("No hay habitaciones disponibles.");
                        break;
                    }

                    // Pedir la habitación hasta que sea valida o este disponible
                    int index = -1;
                    while (index == -1) {
                        System.out.print("\nIngrese el número de habitación: ");
                        int numeroHabitacion = leerEnteroSeguro(sc);

                        for (int i = 0; i < numHabitaciones.length; i++) {
                            if (numHabitaciones[i] == numeroHabitacion) {
                                index = i;
                                break;
                            }
                        }

                        if (index == -1) {
                            System.out.println("Habitación inválida. Intente nuevamente.");
                        } else if (ocupada[index]) {
                            System.out.println("La habitación ya está ocupada. Elija otra.");
                            index = -1;
                        }
                    }

                    // Registrar la reserva
                    System.out.print("Nombre del cliente: ");
                    String nombreCliente = sc.nextLine().trim();
                    while (nombreCliente.isEmpty()) {
                        System.out.print("El nombre no puede estar vacío. Ingrese de nuevo: ");
                        nombreCliente = sc.nextLine().trim();
                    }
                    nombresClientes[index] = nombreCliente;

                    System.out.print("Número de noches: ");
                    int nochesReserva = leerEnteroSeguro(sc);
                    while (nochesReserva <= 0) {
                        System.out.print("El número de noches debe ser mayor que 0. Intente nuevamente: ");
                        nochesReserva = leerEnteroSeguro(sc);
                    }
                    noches[index] = nochesReserva;
                    ocupada[index] = true;

                    double total = noches[index] * precioPorNoche[index];
                    System.out.println("Reserva registrada con éxito.");
                    System.out.println(tipoHabitacion[index] + " " + numHabitaciones[index]);
                    System.out.println("Cliente: " + nombresClientes[index]);
                    System.out.println("Noches: " + noches[index]);
                    System.out.println("Precio por noche: $" + precioPorNoche[index]);
                    System.out.println("Total a pagar: $" + total);
                    break;

                case 2:
                    // Cancelar la reserva
                    int cancelarIndex = -1;
                    while (cancelarIndex == -1) {
                        System.out.print("Ingrese el número de habitación a cancelar: ");
                        int habCancelar = leerEnteroSeguro(sc);

                        for (int i = 0; i < numHabitaciones.length; i++) {
                            if (numHabitaciones[i] == habCancelar) {
                                cancelarIndex = i;
                                break;
                            }
                        }

                        if (cancelarIndex == -1) {
                            System.out.println("Habitación inválida. Intente nuevamente.");
                        } else if (!ocupada[cancelarIndex]) {
                            System.out.println("La habitación ya está libre. Elija otra.");
                            cancelarIndex = -1;
                        }
                    }

                    ocupada[cancelarIndex] = false;
                    nombresClientes[cancelarIndex] = null;
                    noches[cancelarIndex] = 0;
                    System.out.println("Reserva cancelada.");
                    break;

                case 3:
                    System.out.println("--- Estado de las habitaciones ---");
                    for (int i = 0; i < numHabitaciones.length; i++) {
                        if (ocupada[i]) {
                            double totalOcupada = noches[i] * precioPorNoche[i];
                            System.out.println(tipoHabitacion[i] + " " + numHabitaciones[i] +
                                    ": Ocupada por " + nombresClientes[i] +
                                    " | Noches: " + noches[i] +
                                    " | Precio/noche: $" + precioPorNoche[i] +
                                    " | Total: $" + totalOcupada);
                        } else {
                            System.out.println(tipoHabitacion[i] + " " + numHabitaciones[i] +
                                    ": Disponible | Precio/noche: $" + precioPorNoche[i]);
                        }
                    }
                    break;

                case 4:
                    int ocupadas = 0, disponibles = 0;
                    for (boolean estado : ocupada) {
                        if (estado) ocupadas++;
                        else disponibles++;
                    }
                    System.out.println("\n--- Reporte del hotel ---");
                    System.out.println("Habitaciones ocupadas: " + ocupadas);
                    System.out.println("Habitaciones disponibles: " + disponibles);
                    break;

                case 5:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }

    // leer números enteros válidos
    private static int leerEnteroSeguro(Scanner sc) {
        while (true) {
            String entrada = sc.nextLine().trim();
            boolean esNumero = true;

            if (entrada.isEmpty()) {
                esNumero = false;
            } else {
                for (int i = 0; i < entrada.length(); i++) {
                    if (!Character.isDigit(entrada.charAt(i))) {
                        esNumero = false;
                        break;
                    }
                }
            }

            if (esNumero) {
                return Integer.parseInt(entrada);
            } else {
                System.out.print("Entrada inválida, ingrese solo números: ");
            }
        }
    }
}
