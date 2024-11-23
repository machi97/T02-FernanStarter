import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);

        String usuarioAdmin = "Administrador", contraAdmin = "admin123";
        String usuarioGestor = "gestor", contraGestor = "gestor123";
        String usuarioInversor = "inversor", contraInversor = "inversor123";

        boolean gestorBloqueado = false;
        boolean inversorBloqueado = false;

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== SISTEMA DE LOGIN ===");
            System.out.print("Usuario: ");
            String usuario = SC.nextLine();
            System.out.print("Contraseña: ");
            String contrasena = SC.nextLine();

            if (usuario.equals(usuarioAdmin) && contrasena.equals(contraAdmin)) {
                boolean salirAdmin = false;
                while (!salirAdmin) {
                    System.out.println("\n=== MENÚ ADMINISTRADOR ===");
                    System.out.println("1. Desbloquear Gestor");
                    System.out.println("2. Desbloquear Inversor");
                    System.out.println("3. Ver estado de usuarios");
                    System.out.println("4. Salir");
                    System.out.print("Elige una opción: ");
                    int opcion = SC.nextInt();
                    SC.nextLine(); // Consumir el salto de línea

                    switch (opcion) {
                        case 1:
                            if (gestorBloqueado) {
                                gestorBloqueado = false;
                                System.out.println("El usuario gestor ha sido desbloqueado.");
                            } else {
                                System.out.println("El usuario gestor no está bloqueado.");
                            }
                            break;
                        case 2:
                            if (inversorBloqueado) {
                                inversorBloqueado = false;
                                System.out.println("El usuario inversor ha sido desbloqueado.");
                            } else {
                                System.out.println("El usuario inversor no está bloqueado.");
                            }
                            break;
                        case 3:
                            System.out.println("\n=== ESTADO DE USUARIOS ===");
                            System.out.println("Gestor: " + (gestorBloqueado ? "Bloqueado" : "Activo"));
                            System.out.println("Inversor: " + (inversorBloqueado ? "Bloqueado" : "Activo"));
                            break;
                        case 4:
                            salirAdmin = true;
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                }
                // Gestor
            } else if (usuario.equals(usuarioGestor)) {
                if (gestorBloqueado) {
                    System.out.println("El usuario gestor está bloqueado. Contacta al administrador.");
                } else {
                    boolean accesoCorrecto = false;
                    for (int intentos = 0; intentos < 3; intentos++) {
                        System.out.print("Contraseña: ");
                        contrasena = SC.nextLine();
                        if (contrasena.equals(contraGestor)) {
                            accesoCorrecto = true;
                            break;
                        } else {
                            System.out.println("Contraseña incorrecta. Intentos restantes: " + (2 - intentos));
                        }
                    }
                    if (accesoCorrecto) {
                        System.out.println("\n=== MENÚ GESTOR ===");
                        System.out.println("Gestión de proyectos no implementada todavía.");
                    } else {
                        gestorBloqueado = true;
                        System.out.println("Demasiados intentos fallidos. El usuario gestor ha sido bloqueado.");
                    }
                }
                // Inversor
            } else if (usuario.equals(usuarioInversor)) {
                if (inversorBloqueado) {
                    System.out.println("El usuario inversor está bloqueado. Contacta al administrador.");
                } else {
                    boolean accesoCorrecto = false;
                    for (int intentos = 0; intentos < 3; intentos++) {
                        System.out.print("Contraseña: ");
                        contrasena = SC.nextLine();
                        if (contrasena.equals(contraInversor)) {
                            accesoCorrecto = true;
                            break;
                        } else {
                            System.out.println("Contraseña incorrecta. Intentos restantes: " + (2 - intentos));
                        }
                    }
                    if (accesoCorrecto) {
                        System.out.println("\n=== MENÚ INVERSOR ===");
                        System.out.println("Financiación de proyectos no implementada todavía.");
                    } else {
                        inversorBloqueado = true;
                        System.out.println("Demasiados intentos fallidos. El usuario inversor ha sido bloqueado.");
                    }
                }
                // Usuario o contraseña incorrectos
            } else {
                System.out.println("Usuario o contraseña incorrectos.");
            }

            // Salir del sistema
            System.out.print("\n¿Deseas salir del sistema? (s/n): ");
            String opcionSalir = SC.nextLine();
            salir = opcionSalir.equalsIgnoreCase("s");
        }

        System.out.println("-------------");
        System.out.println(" SALIENDO DEL SISTEMA ");
        }
    }
