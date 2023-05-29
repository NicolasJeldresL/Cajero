import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int opcionErrada = 0;
        boolean terminoSesion = false;
        double saldo = 10000; //Saldo Inicial
        double cantidadRestada = 200.10;
        double cantidadRestada2 = 666.22;
        String ultimoMovimiento;
        ultimoMovimiento = "No hay movimientos";
        Scanner scan = new Scanner(System.in);

        //Menú cajero automático
        do {
            //Opciones del Menú
            System.out.println("---------------------------------");
            System.out.println("Bienvenido a su Cajero Automático");
            System.out.println("---------------------------------");
            System.out.println("1. Retirar Dinero");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Estado de Cuenta");
            System.out.println("4. Quejas");
            System.out.println("5. Último Movimiento");
            System.out.println("6. Hablar con un asesor ");
            System.out.println("7. Salir del Cajero");
            System.out.println("---------------------------------------------------------");
            System.out.println("Ingrese la opción que prefiera a continuación, por favor:");
            System.out.println("---------------------------------------------------------");
            opcion = scanner.nextInt();

            switch (opcion) {
                //Opción retiro
                case 1:
                    System.out.println("Su saldo actual es: " + saldo);
                    System.out.println("-----------------------------");
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = scanner.nextDouble();

                    if (cantidadRetiro <=0) {
                        System.out.println("----------------------------------");
                        System.out.println("La cantidad ingresada no es válida");
                    } else if (cantidadRetiro > saldo) {
                        System.out.println("-------------------------------");
                        System.out.println("Excede el monto del saldo total");
                    } else if (cantidadRetiro > 6000) {
                        System.out.println("-----------------------------------");
                        System.out.println("El monto máximo a retirar es $6000");
                    } else if (cantidadRetiro % 50 != 0 && cantidadRetiro % 100 != 0) {
                        System.out.println("--------------------------------------");
                        System.out.println("El monto debe ser multiplo de 50 o 100");
                    } else {
                        saldo -= cantidadRetiro;
                        ultimoMovimiento = "Retiro de $" + cantidadRetiro;
                        System.out.println("---------------------------------------------");
                        System.out.println("Retiro exitoso. Su saldo actual es: $" + saldo);
                        System.out.println("---------------------------------------------");
                    }
                    System.out.println("Presione cualquier número para volver al menú principal");
                    scan.next();

                    break;
                //Submenú
                //Opciones del Submenú
                case 2:
                    System.out.println("¿Dónde desea depositar?");
                    System.out.println("-----------------------");
                    System.out.println("1. Cuenta de Cheques");
                    System.out.println("2. Tarjeta de Crédito");
                    System.out.println("3. Cuenta de Terceros");
                    int opcionSubMenu = scanner.nextInt();

                    switch (opcionSubMenu) {
                        //Depósito a cheques
                        case 1:
                            System.out.println("Depósito a cheques");
                            System.out.println("--------------------------------");
                            System.out.println("Ingrese la cantidad a depositar:");
                            double cantidadDepositarCheque = scanner.nextDouble();
                            if (cantidadDepositarCheque % 50 == 0 || cantidadDepositarCheque % 100 == 0) {
                                saldo += cantidadDepositarCheque;
                                ultimoMovimiento = "Depósito de $" + cantidadDepositarCheque;
                                System.out.println("-----------------------------------------------");
                                System.out.println("Depósito exitoso. Su saldo actual es: $" + saldo);
                                System.out.println("------------------------------------------------");
                            } else {
                                System.out.println("-------------------------------------");
                                System.out.println("Favor ingrese multiplos de 50 o 100'.");
                                System.out.println("-------------------------------------");
                            }
                            System.out.println("Presione cualquier número para volver al menú principal");
                            scan.next();
                            break;
                        //Depósito a tarjetas
                        case 2:
                            System.out.println("Depósito a tarjetas");
                            System.out.println("--------------------------------");
                            System.out.println("Ingrese la cantidad a depositar:");
                            double cantidadDepositarTarjeta = scanner.nextDouble();
                            if (cantidadDepositarTarjeta <= saldo) {
                                saldo += cantidadDepositarTarjeta;
                                saldo -= cantidadRestada;
                                ultimoMovimiento = "Depósito de $" + cantidadDepositarTarjeta;
                                System.out.println("-----------------------------------------------");
                                System.out.println("Depósito exitoso. Su saldo actual es: $" + saldo);
                                System.out.println("-----------------------------------------------");
                            } else {
                                System.out.println("------------------------------------------------------");
                                System.out.println("No se puede depositar un monto mayor a su saldo actual");
                                System.out.println("------------------------------------------------------");
                            }
                            System.out.println("Presione cualquier número para volver al menú principal");
                            scan.next();
                            break;
                        //Depósito a terceros
                        case 3:
                            System.out.println("Depósito a cuenta de tercero");
                            System.out.println("-------------------------------");
                            System.out.println("Ingrese la cantidad a depositar");
                            double cantidadDepositarTerceros = scanner.nextDouble();
                            ultimoMovimiento = "Depósito de $" + cantidadDepositarTerceros;
                            if (cantidadDepositarTerceros <= saldo) {
                                saldo += cantidadDepositarTerceros;
                                saldo -= cantidadRestada2;
                                System.out.println("Depósito exitoso. Su saldo actual es: " + saldo);
                            } else {
                                System.out.println("------------------------------------------------------");
                                System.out.println("No se puede depositar un monto mayor a su saldo actual");
                                System.out.println("------------------------------------------------------");
                            }
                            System.out.println("Presione cualquier número para volver al menú principal");
                            scan.next();
                            break;

                        default:
                            System.out.println("---------------------------");
                            System.out.println("Opción inválida del submenú");
                            System.out.println("---------------------------");
                            opcionErrada++;
                            break;
                    }
                    break;
                //Estado de cuenta
                case 3:
                    System.out.println("----------------------------------------");
                    System.out.println("Su estado de cuenta actual es: $" + saldo);
                    System.out.println("----------------------------------------");
                    System.out.println("Presione cualquier número para volver al menú principal");
                    scan.next();
                    break;
                //Quejas
                case 4:
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Esta opción no está disponible por el momento, intentelo más tarde");
                    System.out.println("------------------------------------------------------------------");
                    terminoSesion = true;
                    break;
                //Último movimiento
                case 5:
                    System.out.println("Su último movimiento realizado fue :");
                    LocalDateTime fechaHora = LocalDateTime.now();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    String formatoFechaHora = fechaHora.format(formato);
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.println("Fecha, Hora: "+ formatoFechaHora + " h.  Último movimiento realizado: " + ultimoMovimiento );
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.println("Presione cualquier número para volver al menú principal");
                    scan.next();
                    break;
                //Asesores Contacto
                case 6:
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("En este momento nuestros asesores están fuera de servicio, intentelo más tarde");
                    System.out.println("------------------------------------------------------------------------------");
                    terminoSesion = true;
                    break;
                //Despedida
                case 7:
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Gracias por utilizar nuestro cajero automático. ¡Hasta luego!");
                    System.out.println("-------------------------------------------------------------");
                    System.exit(0);
                    //Fallos
                default:
                    System.out.println("--------------------");
                    System.out.println("Opción no disponible");
                    System.out.println("--------------------");
                    opcionErrada++;
                    if (opcionErrada >= 3) {
                        System.out.println("---------------------------------------------");
                        System.out.println("Ha sobrepasado el número de intentos fallidos");
                        System.out.println("---------------------------------------------");
                        terminoSesion = true;

                    }
                    break;
            }
            //Final sesión
        } while (!terminoSesion);
        System.out.println("-----------------");
        System.out.println("Sesión finalizada");
        System.out.println("-----------------");

        scanner.close();
    }

}
