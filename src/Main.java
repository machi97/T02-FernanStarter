import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);

        String usuarioAdmin = "Administrador", contraAdmin = "admin123";
        String usuarioGestor = "gestor", contraGestor = "gestor123";
        String usuarioInversor1 = "inversor 1", contraInversor1 = "inversor123";
        String usuarioInversor2 = "inversor 2", contraInversor2 = "inversor321";


        boolean gestorBloqueado = false;
        boolean inversor1Bloqueado = false;
        boolean inversor2Bloqueado = false;

        boolean salir = false;

        String proyecto1 = "", proyecto2 = "", proyecto3 = "";
        int numProyectos = 0;

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
                    System.out.println("2. Desbloquear Inversor1");
                    System.out.println("3. Desbloquear Inversor2");
                    System.out.println("4. Ver estado de usuarios");
                    System.out.println("5. Salir");
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
                            if (inversor1Bloqueado) {
                                inversor1Bloqueado = false;
                                System.out.println("El usuario inversor 1 ha sido desbloqueado.");
                            } else {
                                System.out.println("El usuario inversor 1 no está bloqueado.");
                            }
                            break;
                        case 3:
                            if (inversor2Bloqueado) {
                                inversor2Bloqueado = false;
                                System.out.println("El usuario inversor 2 ha sido desbloqueado.");
                            } else {
                                System.out.println("El usuario inversor 2 no está bloqueado.");
                            }
                            break;
                        case 4:
                            System.out.println("\n=== ESTADO DE USUARIOS ===");
                            System.out.println("Gestor: " + (gestorBloqueado ? "Bloqueado" : "Activo"));
                            System.out.println("Inversor 1: " + (inversor1Bloqueado ? "Bloqueado" : "Activo"));
                            System.out.println("Inversor 2: " + (inversor2Bloqueado ? "Bloqueado" : "Activo"));
                            break;
                        case 5:
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
                        boolean salirGestor = false;
                        while (!salirGestor) {
                        System.out.println("\n=== MENÚ GESTOR ===");
                            System.out.println("1. Crear proyecto");
                            System.out.println("2. Ver mis proyectos");
                            System.out.println("3. Eliminar proyecto");
                            System.out.println("4. Salir");
                            System.out.println("Elige una opción");
                            int opcion = SC.nextInt();
                            SC.nextLine();

                            switch (opcion) {
                                case 1:
                                    if (numProyectos < 3) {
                                        System.out.println("Nombre del proyecto: ");
                                        String nombre = SC.nextLine();
                                        System.out.println("Descripcion del proyecto: ");
                                        String descripcion = SC.nextLine();
                                        System.out.println("Categoría (arte, tecnología, cine, música, juegos, comida, moda…)");
                                        String categoria = SC.nextLine();
                                        System.out.println("Cantidad necesaria ");
                                        String cantidadNec = SC.nextLine();
                                        System.out.println("Cantidad financiada hasta el momento");
                                        String cantidadHastaMom = SC.nextLine();
                                        System.out.println("Fecha inicio de apertura para recibir inversiones ");
                                        String fechaInicio = SC.nextLine();
                                        System.out.println("Fecha fin de cierre de las inversiones ");
                                        String fechaCierre = SC.nextLine();

                                        //Creacion del proyecto
                                        if (numProyectos == 0) {
                                            proyecto1 = "Nombre: " + nombre + ", Descripción: " + descripcion + ", Categoria: " + categoria + ", Cantidad necesaria: " + cantidadNec + ", Cantidad hasta el momento: " + cantidadHastaMom + ", Fecha de inicio: " + fechaInicio + ", Fecha de inicio: " + fechaCierre;
                                        } else if (numProyectos == 1) {
                                            proyecto2 = "Nombre: " + nombre + ", Descripción: " + descripcion + ", Categoria: " + categoria + ", Cantidad necesaria: " + cantidadNec + ", Cantidad hasta el momento: " + cantidadHastaMom + ", Fecha de inicio: " + fechaInicio + ", Fecha de inicio: " + fechaCierre;
                                        } else if (numProyectos == 2) {
                                            proyecto3 = "Nombre: " + nombre + ", Descripción: " + descripcion + ", Categoria: " + categoria + ", Cantidad necesaria: " + cantidadNec + ", Cantidad hasta el momento: " + cantidadHastaMom + ", Fecha de inicio: " + fechaInicio + ", Fecha de inicio: " + fechaCierre;
                                        }
                                        numProyectos++;
                                        System.out.println("Poyecto creado con éxito");
                                    } else {
                                        System.out.println("Error. Solo se puede crear 3 proyectos");
                                    }
                                    break;
                                case 2:
                                    //Mirar los proyectos que estan creados
                                    if (numProyectos == 0) {
                                        System.out.println("No hay proyectos creados.");

                                    } else {
                                        System.out.println("\n/////PROYECTOS CREADOS/////");
                                        if (!proyecto1.equals("")) System.out.println("Proyecto 1: " + proyecto1);
                                        if (!proyecto2.equals("")) System.out.println("Proyecto 1: " + proyecto1);
                                        if (!proyecto3.equals("")) System.out.println("Proyecto 1: " + proyecto1);
                                        int eliminarProyecto = SC.nextInt();
                                        SC.nextLine();
                                        if (eliminarProyecto == 1 && !proyecto1.equals("")) {
                                            proyecto1 = "";
                                            numProyectos--;
                                            System.out.println("Proyecto 1 eliminado.");
                                        } else if (eliminarProyecto == 2 && !proyecto1.equals("")) {
                                    proyecto2 = "";
                                    numProyectos--;
                                    System.out.println("Proyecto 2 eliminado.");
                                        } else if (eliminarProyecto == 3 && !proyecto1.equals("")) {
                                            proyecto3 = "";
                                            numProyectos--;
                                            System.out.println("Proyecto 3 eliminado.");
                                        } else {
                                            System.out.println("Proyecto eliminado o no válido");
                                        }
                                        break;
                                    }
                                case 3:
                                    System.out.println("Introduce el numero de proyecto que deseas eliminar (1, 2 o 3): ");
                                    int eliminarProyecto = SC.nextInt();
                                    SC.nextLine();
                                    if (eliminarProyecto == 1 && !proyecto1.equals("")) {
                                        proyecto1 = "";
                                        numProyectos--;
                                        System.out.println("Proyecto 1 eliminado.");
                                    } else if (eliminarProyecto == 2 && !proyecto1.equals("")) {
                                        proyecto2 = "";
                                        numProyectos--;
                                        System.out.println("Proyecto 2 eliminado.");
                                    } else if (eliminarProyecto == 3 && !proyecto1.equals("")) {
                                        proyecto3 = "";
                                        numProyectos--;
                                        System.out.println("Proyecto 3 eliminado.");
                                    } else {
                                        System.out.println("Proyecto eliminado o no válido");
                                    }
                                    break;
                                case 4:
                                    salirGestor = true;
                                    break;
                                default:
                                    System.out.println("Opcion no válida");
                            }
                        }

                    } else {
                        gestorBloqueado = true;
                        System.out.println("Demasiados intentos fallidos. El usuario gestor ha sido bloqueado.");
                    }
                }
                // Inversor1
            } else if (usuario.equals(usuarioInversor1)) {
                if (inversor1Bloqueado) {
                    System.out.println("El usuario inversor está bloqueado. Contacta al administrador.");
                } else {
                    boolean accesoCorrecto = false;
                    for (int intentos = 0; intentos < 3; intentos++) {
                        System.out.print("Contraseña: ");
                        contrasena = SC.nextLine();
                        if (contrasena.equals(contraInversor1)) {
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
                        inversor1Bloqueado = true;
                        System.out.println("Demasiados intentos fallidos. El usuario inversor ha sido bloqueado.");
                    }
                }
                // Inversor2
            } else if (usuario.equals(usuarioInversor2)) {
                if (inversor2Bloqueado) {
                    System.out.println("El usuario inversor está bloqueado. Contacta al administrador.");
                } else {
                    boolean accesoCorrecto = false;
                    for (int intentos = 0; intentos < 3; intentos++) {
                        System.out.print("Contraseña: ");
                        contrasena = SC.nextLine();
                        if (contrasena.equals(contraInversor2)) {
                            accesoCorrecto = true;
                            break;
                        } else {
                            System.out.println("Contraseña incorrecta. Intentos restantes: " + (2 - intentos));
                        }
                    }
                    if (accesoCorrecto) {
                        System.out.println("\n=== MENÚ INVERSOR 2 ===");
                        System.out.println("Financiación de proyectos no implementada todavía.");
                    } else {
                        inversor2Bloqueado = true;
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
