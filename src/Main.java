import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);

        String usuarioAdmin = "Administrador", contraAdmin = "admin123";
        String usuarioGestor = "gestor", contraGestor = "gestor123";
        String usuarioInversor1 = "inversor1", contraInversor1 = "inversor123";
        String usuarioInversor2 = "inversor2", contraInversor2 = "inversor321";


        boolean gestorBloqueado = false;
        boolean inversor1Bloqueado = false;
        boolean inversor2Bloqueado = false;
        boolean salir = false;

        int intentosGestor = 0, intentosInversor1 = 0, intentosInversor2 = 0;

        String proyecto1 = "", proyecto2 = "", proyecto3 = "";
        String nombre1 = "", nombre2 = "", nombre3 = "";
        String descripcion1 = "", descripcion2 = "", descripcion3 = "";
        String categoria1 = "", categoria2 = "", categoria3 = "";
        double cantidadNec1 = 0, cantidadNec2 = 0, cantidadNec3 = 0;
        double cantidadFinanc1 = 0, cantidadFinanc2 = 0, cantidadFinanc3 = 0;
        String fechaInicio1 = "", fechaInicio2 = "", fechaInicio3 = "";
        String fechaFin1 = "", fechaFin2 = "", fechaFin3 = "";

        int numProyectos = 0;

        String invitaAmigo1 = "";
        String invitaAmigo2 = "";

        while (!salir) {
            System.out.println("\n=== SISTEMA DE LOGIN ===");
            System.out.print("Usuario: ");
            String usuario = SC.nextLine();
            System.out.print("Contraseña: ");
            String contrasena = SC.nextLine();

            if (usuario.equals(usuarioAdmin) && contrasena.equals(contraAdmin)) {
                System.out.println("Acceso concedido");
                boolean salirAdmin = false;
                while (!salirAdmin) {
                    System.out.println("\n=== MENÚ ADMINISTRADOR ===");
                    System.out.println("1. Panel de control");
                    System.out.println("2. Proyectos");
                    System.out.println("3. Configuración");
                    System.out.println("4. Cerrar sesión");
                    System.out.print("Elige una opción: ");
                    int opcionAdmin = SC.nextInt();
                    SC.nextLine(); // Consumir el salto de línea

                    switch (opcionAdmin) {
                        case 1:
                            System.out.println("===PANEL DE CONTROL===");
                            System.out.println("1. Bloquear o desbloquear Gestor");
                            System.out.println("2. Bloquear o desbloquear Inversor 1");
                            System.out.println("3. Bloquear o desbloquear Inversor 2");
                            System.out.println("Elige una opción: ");
                            int opcionBloDes = SC.nextInt();
                            SC.nextLine();
                            if (opcionBloDes == 1) {
                                gestorBloqueado = !gestorBloqueado;
                                if (gestorBloqueado) {
                                    System.out.println("El usuario a sido BLOQUEADO");
                                } else {
                                    System.out.println("El usuario gestor a sido DESBLOQEUADO");
                                }
                            } else if (opcionBloDes == 2) {
                                inversor1Bloqueado = !inversor1Bloqueado;
                                System.out.println("El usuario a sido " + (inversor1Bloqueado ? "bloqueado" : "desbloqueado"));
                            } else if (opcionBloDes == 3) {
                                inversor2Bloqueado = !inversor2Bloqueado;
                                System.out.println("El usuario a sido " + (inversor2Bloqueado ? "bloqueado" : "desbloqueado"));
                                break;
                            } else {
                                System.out.println("Opción no válida. ");
                            }
                            break;

                        case 2:
                            System.out.println("===PROYECTOS===");
                            if (numProyectos == 0) {
                                System.out.println("No hay proyectos creados");
                            } else {
                                if (!proyecto1.equals("")) System.out.println("Proyecto 1: " + proyecto1);
                                if (!proyecto2.equals("")) System.out.println("Proyecto 1: " + proyecto2);
                                if (!proyecto3.equals("")) System.out.println("Proyecto 1: " + proyecto3);

                                System.out.println("Selecciona el proyecto que quieres ver en detalle 1-3: ");
                                int seleccion = SC.nextInt();
                                SC.nextLine();

                                if (seleccion == 1) {
                                    System.out.println("Detalle del proyecto 1: ");
                                    System.out.println("Nombre: " + nombre1);
                                    System.out.println("Descripción: " + descripcion1);
                                    System.out.println("Categoría: " + categoria1);
                                    System.out.println("Cantidad necesaria: " + cantidadNec1);
                                    System.out.println("Cantidad financiada: " + cantidadFinanc1);
                                    System.out.println("Fecha inicio: " + fechaInicio1);
                                    System.out.println("Fecha fin: " + fechaFin1);

                                    System.out.println("¿Quieres modificar el proyecto 1?");
                                    String respuesta = SC.nextLine();
                                    if (respuesta.equalsIgnoreCase("S")) {
                                        System.out.println("Introduce el nuevo nombre del proyecto 1: ");
                                        nombre1 = SC.nextLine();
                                        System.out.println("Introduce la nueva descripción del proyecto 1: ");
                                        descripcion1 = SC.nextLine();
                                        System.out.println("Introduce la nueva categoria del proyecto 1: ");
                                        categoria1 = SC.nextLine();
                                        System.out.println("Introduce la nueva cantidad necesaria del proyecto 1: ");
                                        cantidadNec1 = SC.nextDouble();
                                        System.out.println("Introduce la nueva cantidad financiada del proyecto 1: ");
                                        cantidadFinanc1 = SC.nextDouble();
                                        System.out.println("Introduce la nueva fecha de inicio del proyecto 1: ");
                                        fechaInicio1 = SC.nextLine();
                                        System.out.println("Introduce la nueva fecha fin del proyecto 1: ");
                                        fechaFin1 = SC.nextLine();
                                    }
                                } else if (seleccion == 2) {
                                    System.out.println("Detalle del proyecto 1: ");
                                    System.out.println("Nombre: " + nombre2);
                                    System.out.println("Descripción: " + descripcion2);
                                    System.out.println("Categoría: " + categoria2);
                                    System.out.println("Cantidad necesaria: " + cantidadNec2);
                                    System.out.println("Cantidad financiada: " + cantidadFinanc2);
                                    System.out.println("Fecha inicio: " + fechaInicio2);
                                    System.out.println("Fecha fin: " + fechaFin2);

                                    System.out.println("¿Quieres modificar el proyecto 2?");
                                    String respuesta = SC.nextLine();
                                    if (respuesta.equalsIgnoreCase("S")) {
                                        System.out.println("Introduce el nuevo nombre del proyecto 2: ");
                                        nombre2 = SC.nextLine();
                                        System.out.println("Introduce la nueva descripción del proyecto 2: ");
                                        descripcion2 = SC.nextLine();
                                        System.out.println("Introduce la nueva categoria del proyecto 2: ");
                                        categoria2 = SC.nextLine();
                                        System.out.println("Introduce la nueva cantidad necesaria del proyecto 2: ");
                                        cantidadNec2 = SC.nextDouble();
                                        System.out.println("Introduce la nueva cantidad financiada del proyecto 2: ");
                                        cantidadFinanc2 = SC.nextDouble();
                                        System.out.println("Introduce la nueva fecha de inicio del proyecto 2: ");
                                        fechaInicio2 = SC.nextLine();
                                        System.out.println("Introduce la nueva fecha fin del proyecto 2: ");
                                        fechaFin2 = SC.nextLine();
                                    }

                                } else if (seleccion == 3) {
                                    System.out.println("Detalle del proyecto 1: ");
                                    System.out.println("Nombre: " + nombre3);
                                    System.out.println("Descripción: " + descripcion3);
                                    System.out.println("Categoría: " + categoria3);
                                    System.out.println("Cantidad necesaria: " + cantidadNec3);
                                    System.out.println("Cantidad financiada: " + cantidadFinanc3);
                                    System.out.println("Fecha inicio: " + fechaInicio3);
                                    System.out.println("Fecha fin: " + fechaFin3);

                                    System.out.println("¿Quieres modificar el proyecto 3?");
                                    String respuesta = SC.nextLine();
                                    if (respuesta.equalsIgnoreCase("S")) {
                                        System.out.println("Introduce el nuevo nombre del proyecto 3: ");
                                        nombre3 = SC.nextLine();
                                        System.out.println("Introduce la nueva descripción del proyecto 3: ");
                                        descripcion3 = SC.nextLine();
                                        System.out.println("Introduce la nueva categoria del proyecto 3: ");
                                        categoria3 = SC.nextLine();
                                        System.out.println("Introduce la nueva cantidad necesaria del proyecto 3: ");
                                        cantidadNec3 = SC.nextDouble();
                                        System.out.println("Introduce la nueva cantidad financiada del proyecto 3: ");
                                        cantidadFinanc3 = SC.nextDouble();
                                        System.out.println("Introduce la nueva fecha de inicio del proyecto 3: ");
                                        fechaInicio3 = SC.nextLine();
                                        System.out.println("Introduce la nueva fecha fin del proyecto 3: ");
                                        fechaFin3 = SC.nextLine();
                                    }
                                }
                                System.out.println("Introduce el numero de proyecto que deseas eliminar");
                                int eliminarProyecto = SC.nextInt();
                                SC.nextLine();

                                if (eliminarProyecto == 1) {
                                    proyecto1 = "";
                                    numProyectos--;
                                    System.out.println("Proyecto 1 eliminado.");
                                } else if (eliminarProyecto == 2) {
                                    proyecto2 = "";
                                    numProyectos--;
                                    System.out.println("Proyecto 2 eliminado.");
                                } else if (eliminarProyecto == 3) {
                                    proyecto3 = "";
                                    numProyectos--;
                                    System.out.println("Proyecto 3 eliminado.");
                                } else {
                                    System.out.println("Proyecto eliminado o no válido");
                                }
                            }
                            break;

                        case 3:
                            System.out.println("===CONFIGURACIÓN===");
                            System.out.println("1. Cambiar el nombre de usuario");
                            System.out.println("2. Cambiar contraseña");
                            int opcionCambioAdm = SC.nextInt();
                            SC.nextLine();
                            switch (opcionCambioAdm) {
                                case 1:
                                    System.out.println("Introduce el nuevo usuario");
                                    usuarioAdmin = SC.nextLine();
                                    System.out.println("El nombre de usuario ha sido cambiado");
                                    break;
                                case 2:
                                    System.out.println("Introduce la nueva contraseña");
                                    contraAdmin = SC.nextLine();
                                    System.out.println("La contraseña ha sido cambiada");
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                            }
                            break;

                        case 4:
                            salirAdmin = true;
                            System.out.println("Cerrando sesión...");
                            break;

                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                }


                // Gestor
            } else if (usuario.equals(usuarioGestor)) {
                if (gestorBloqueado) {
                    System.out.println("El usuario gestor está bloqueado. Contacta al administrador.");
                } else {
                    if (intentosGestor < 3) {
                        if (contrasena.equals(contraGestor)) {
                            System.out.println("Contraseña correcta. ");
                            intentosGestor = 0;
                            boolean salirGestor = false;
                            while (!salirGestor) {
                                System.out.println("\n=== MENÚ GESTOR ===");
                                System.out.println("1. Crear proyecto");
                                System.out.println("2. Ver mis proyectos");
                                System.out.println("3. Eliminar proyecto");
                                System.out.println("4. Configuracion");
                                System.out.println("5. Cerrar sesión");
                                System.out.println("Elige una opción");
                                int opcionGestor = SC.nextInt();
                                SC.nextLine();

                                switch (opcionGestor) {
                                    case 1:
                                        if (numProyectos < 3) {
                                            System.out.println("Nombre del proyecto: ");
                                            String nombre = SC.nextLine();
                                            System.out.println("Descripcion del proyecto: ");
                                            String descripcion = SC.nextLine();
                                            System.out.println("Categoría (arte, tecnología, cine, música, juegos, comida, moda…)");
                                            String categoria = SC.nextLine();
                                            System.out.println("Cantidad necesaria ");
                                            double cantidadNec = SC.nextDouble();
                                            System.out.println("Cantidad financiada hasta el momento");
                                            double cantidadHastaMom = SC.nextDouble();
                                            System.out.println("Fecha inicio de apertura para recibir inversiones ");
                                            String fechaInicio = SC.nextLine();
                                            System.out.println("Fecha fin de cierre de las inversiones ");
                                            String fechaCierre = SC.nextLine();

                                            //Creacion del proyecto
                                            if (numProyectos == 0) {
                                                proyecto1 = "Nombre: " + nombre + ", Descripción: " + descripcion + ", Categoria: " + categoria + ", Cantidad necesaria: " + cantidadNec + ", Cantidad hasta el momento: " + cantidadHastaMom + ", Fecha de inicio: " + fechaInicio + ", Fecha de inicio: " + fechaCierre;
                                                nombre1 = nombre;
                                                descripcion1 = descripcion;
                                                categoria1 = categoria;
                                                cantidadNec1 = cantidadNec;
                                                cantidadFinanc1 = cantidadHastaMom;
                                                fechaInicio1 = fechaInicio;
                                                fechaFin1 = fechaCierre;

                                            } else if (numProyectos == 1) {
                                                proyecto2 = "Nombre: " + nombre + ", Descripción: " + descripcion + ", Categoria: " + categoria + ", Cantidad necesaria: " + cantidadNec + ", Cantidad hasta el momento: " + cantidadHastaMom + ", Fecha de inicio: " + fechaInicio + ", Fecha de inicio: " + fechaCierre;
                                                nombre2 = nombre;
                                                descripcion2 = descripcion;
                                                categoria2 = categoria;
                                                cantidadNec2 = cantidadNec;
                                                cantidadFinanc2 = cantidadHastaMom;
                                                fechaInicio2 = fechaInicio;
                                                fechaFin2 = fechaCierre;
                                            } else if (numProyectos == 2) {
                                                proyecto3 = "Nombre: " + nombre + ", Descripción: " + descripcion + ", Categoria: " + categoria + ", Cantidad necesaria: " + cantidadNec + ", Cantidad hasta el momento: " + cantidadHastaMom + ", Fecha de inicio: " + fechaInicio + ", Fecha de inicio: " + fechaCierre;
                                                nombre3 = nombre;
                                                descripcion3 = descripcion;
                                                categoria3 = categoria;
                                                cantidadNec3 = cantidadNec;
                                                cantidadFinanc3 = cantidadHastaMom;
                                                fechaInicio3 = fechaInicio;
                                                fechaFin3 = fechaCierre;
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
                                            if (!proyecto1.equals(""))
                                                System.out.println("Proyecto 1: " + proyecto1);
                                            if (!proyecto2.equals(""))
                                                System.out.println("Proyecto 2: " + proyecto2);
                                            if (!proyecto3.equals(""))
                                                System.out.println("Proyecto 3: " + proyecto3);

                                            System.out.println("Selecciona el proyecto que quieres ver en detalle 1-3: ");
                                            int seleccion = SC.nextInt();
                                            SC.nextLine();

                                            if (seleccion == 1) {
                                                System.out.println("Detalle del proyecto 1: ");
                                                System.out.println("Nombre: " + nombre1);
                                                System.out.println("Descripción: " + descripcion1);
                                                System.out.println("Categoría: " + categoria1);
                                                System.out.println("Cantidad necesaria: " + cantidadNec1);
                                                System.out.println("Cantidad financiada: " + cantidadFinanc1);
                                                System.out.println("Fecha inicio: " + fechaInicio1);
                                                System.out.println("Fecha fin: " + fechaFin1);

                                                System.out.println("¿Quieres modificar el proyecto 1?");
                                                String respuesta = SC.nextLine();
                                                if (respuesta.equalsIgnoreCase("S")) {
                                                    System.out.println("Introduce el nuevo nombre del proyecto 1: ");
                                                    nombre1 = SC.nextLine();
                                                    System.out.println("Introduce la nueva descripción del proyecto 1: ");
                                                    descripcion1 = SC.nextLine();
                                                    System.out.println("Introduce la nueva categoria del proyecto 1: ");
                                                    categoria1 = SC.nextLine();
                                                    System.out.println("Introduce la nueva cantidad necesaria del proyecto 1: ");
                                                    cantidadNec1 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva cantidad financiada del proyecto 1: ");
                                                    cantidadFinanc1 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva fecha de inicio del proyecto 1: ");
                                                    fechaInicio1 = SC.nextLine();
                                                    System.out.println("Introduce la nueva fecha fin del proyecto 1: ");
                                                    fechaFin1 = SC.nextLine();
                                                }
                                            } else if (seleccion == 2) {
                                                System.out.println("Detalle del proyecto 1: ");
                                                System.out.println("Nombre: " + nombre2);
                                                System.out.println("Descripción: " + descripcion2);
                                                System.out.println("Categoría: " + categoria2);
                                                System.out.println("Cantidad necesaria: " + cantidadNec2);
                                                System.out.println("Cantidad financiada: " + cantidadFinanc2);
                                                System.out.println("Fecha inicio: " + fechaInicio2);
                                                System.out.println("Fecha fin: " + fechaFin2);

                                                System.out.println("¿Quieres modificar el proyecto 2?");
                                                String respuesta = SC.nextLine();
                                                if (respuesta.equalsIgnoreCase("S")) {
                                                    System.out.println("Introduce el nuevo nombre del proyecto 2: ");
                                                    nombre2 = SC.nextLine();
                                                    System.out.println("Introduce la nueva descripción del proyecto 2: ");
                                                    descripcion2 = SC.nextLine();
                                                    System.out.println("Introduce la nueva categoria del proyecto 2: ");
                                                    categoria2 = SC.nextLine();
                                                    System.out.println("Introduce la nueva cantidad necesaria del proyecto 2: ");
                                                    cantidadNec2 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva cantidad financiada del proyecto 2: ");
                                                    cantidadFinanc2 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva fecha de inicio del proyecto 2: ");
                                                    fechaInicio2 = SC.nextLine();
                                                    System.out.println("Introduce la nueva fecha fin del proyecto 2: ");
                                                    fechaFin2 = SC.nextLine();
                                                }

                                            } else if (seleccion == 3) {
                                                System.out.println("Detalle del proyecto 1: ");
                                                System.out.println("Nombre: " + nombre3);
                                                System.out.println("Descripción: " + descripcion3);
                                                System.out.println("Categoría: " + categoria3);
                                                System.out.println("Cantidad necesaria: " + cantidadNec3);
                                                System.out.println("Cantidad financiada: " + cantidadFinanc3);
                                                System.out.println("Fecha inicio: " + fechaInicio3);
                                                System.out.println("Fecha fin: " + fechaFin3);

                                                System.out.println("¿Quieres modificar el proyecto 3?");
                                                String respuesta = SC.nextLine();
                                                if (respuesta.equalsIgnoreCase("S")) {
                                                    System.out.println("Introduce el nuevo nombre del proyecto 3: ");
                                                    nombre3 = SC.nextLine();
                                                    System.out.println("Introduce la nueva descripción del proyecto 3: ");
                                                    descripcion3 = SC.nextLine();
                                                    System.out.println("Introduce la nueva categoria del proyecto 3: ");
                                                    categoria3 = SC.nextLine();
                                                    System.out.println("Introduce la nueva cantidad necesaria del proyecto 3: ");
                                                    cantidadNec3 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva cantidad financiada del proyecto 3: ");
                                                    cantidadFinanc3 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva fecha de inicio del proyecto 3: ");
                                                    fechaInicio3 = SC.nextLine();
                                                    System.out.println("Introduce la nueva fecha fin del proyecto 3: ");
                                                    fechaFin3 = SC.nextLine();
                                                }
                                            }
                                        }
                                        break;


                                    case 3:
                                        System.out.println("Introduce el numero de proyecto que deseas eliminar");
                                        int eliminarProyecto = SC.nextInt();
                                        SC.nextLine();

                                        if (eliminarProyecto == 1) {
                                            proyecto1 = "";
                                            numProyectos--;
                                            System.out.println("Proyecto 1 eliminado.");
                                        } else if (eliminarProyecto == 2) {
                                            proyecto2 = "";
                                            numProyectos--;
                                            System.out.println("Proyecto 2 eliminado.");
                                        } else if (eliminarProyecto == 3) {
                                            proyecto3 = "";
                                            numProyectos--;
                                            System.out.println("Proyecto 3 eliminado.");
                                        } else {
                                            System.out.println("Proyecto eliminado o no válido");
                                        }
                                        break;

                                    case 4:
                                        System.out.println("===CONFIGURACIÓN===");
                                        System.out.println("1. Cambiar el nombre de usuario");
                                        System.out.println("2. Cambiar contraseña");
                                        int opcionCambioGestor = SC.nextInt();
                                        SC.nextLine();
                                        switch (opcionCambioGestor) {
                                            case 1:
                                                System.out.println("Introduce el nuevo usuario");
                                                usuarioGestor = SC.nextLine();
                                                System.out.println("El nombre de usuario ha sido cambiado");
                                                break;
                                            case 2:
                                                System.out.println("Introduce la nueva contraseña");
                                                contraGestor = SC.nextLine();
                                                System.out.println("La contraseña ha sido cambiada");
                                                break;
                                            default:
                                                System.out.println("Opción no válida");
                                        }
                                        break;
                                    case 5:
                                        salirGestor = true;
                                        System.out.println("Cerrando sesión...");
                                        break;
                                    default:
                                        System.out.println("Opcion no válida");
                                }
                            }
                        } else {
                            intentosGestor++;
                            System.out.println("Contraseña incorrecta. Intentos restantes: " + (3 - intentosGestor));
                        }

                    } else {
                        gestorBloqueado = true;
                        System.out.println("Has superado el limite de intentos. La cuenta está bloqueada");
                    }
                }

                // Inversor1
            } else if (usuario.equals(usuarioInversor1)) {

                if (inversor1Bloqueado) {
                    System.out.println("El usuario inversor está bloqueado. Contacta al administrador.");
                } else {
                    if (intentosInversor1 < 3) {
                        if (contrasena.equals(contraInversor1)) {
                            System.out.println("Contraseña correcta");
                            intentosInversor1 = 0;
                            boolean salirInversor1 = false;
                            while (!salirInversor1) {
                                System.out.println("\n=== MENÚ INVERSOR 1 ===");
                                System.out.println("1. Mis inversiones");
                                System.out.println("2. Proyectos");
                                System.out.println("3. Cartera digital");
                                System.out.println("4. Invita a un amigo");
                                System.out.println("5. Configuración");
                                System.out.println("6. Cerrar sesión");
                                System.out.println("Elige una opción");

                                int opcionInversor1 = SC.nextInt();
                                SC.nextLine();

                                switch (opcionInversor1) {
                                    case 1:
                                        System.out.println("Mis inversiones: ");
                                        break;
                                    case 2:
                                        if (numProyectos == 0) {
                                            System.out.println("No hay proyectos creados.");
                                        } else {
                                            System.out.println("\n/////PROYECTOS CREADOS/////");
                                            if (!proyecto1.equals(""))
                                                System.out.println("Proyecto 1: " + proyecto1);
                                            if (!proyecto2.equals(""))
                                                System.out.println("Proyecto 2: " + proyecto2);
                                            if (!proyecto3.equals(""))
                                                System.out.println("Proyecto 3: " + proyecto3);

                                            System.out.println("Selecciona el proyecto que quieres ver en detalle 1-3: ");
                                            int seleccion = SC.nextInt();
                                            SC.nextLine();

                                            if (seleccion == 1) {
                                                System.out.println("Detalle del proyecto 1: ");
                                                System.out.println("Nombre: " + nombre1);
                                                System.out.println("Descripción: " + descripcion1);
                                                System.out.println("Categoría: " + categoria1);
                                                System.out.println("Cantidad necesaria: " + cantidadNec1);
                                                System.out.println("Cantidad financiada: " + cantidadFinanc1);
                                                System.out.println("Fecha inicio: " + fechaInicio1);
                                                System.out.println("Fecha fin: " + fechaFin1);

                                                System.out.println("¿Quieres modificar el proyecto 1?");
                                                String respuesta = SC.nextLine();
                                                if (respuesta.equalsIgnoreCase("S")) {
                                                    System.out.println("Introduce el nuevo nombre del proyecto 1: ");
                                                    nombre1 = SC.nextLine();
                                                    System.out.println("Introduce la nueva descripción del proyecto 1: ");
                                                    descripcion1 = SC.nextLine();
                                                    System.out.println("Introduce la nueva categoria del proyecto 1: ");
                                                    categoria1 = SC.nextLine();
                                                    System.out.println("Introduce la nueva cantidad necesaria del proyecto 1: ");
                                                    cantidadNec1 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva cantidad financiada del proyecto 1: ");
                                                    cantidadFinanc1 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva fecha de inicio del proyecto 1: ");
                                                    fechaInicio1 = SC.nextLine();
                                                    System.out.println("Introduce la nueva fecha fin del proyecto 1: ");
                                                    fechaFin1 = SC.nextLine();
                                                }
                                            } else if (seleccion == 2) {
                                                System.out.println("Detalle del proyecto 1: ");
                                                System.out.println("Nombre: " + nombre2);
                                                System.out.println("Descripción: " + descripcion2);
                                                System.out.println("Categoría: " + categoria2);
                                                System.out.println("Cantidad necesaria: " + cantidadNec2);
                                                System.out.println("Cantidad financiada: " + cantidadFinanc2);
                                                System.out.println("Fecha inicio: " + fechaInicio2);
                                                System.out.println("Fecha fin: " + fechaFin2);

                                                System.out.println("¿Quieres modificar el proyecto 2?");
                                                String respuesta = SC.nextLine();
                                                if (respuesta.equalsIgnoreCase("S")) {
                                                    System.out.println("Introduce el nuevo nombre del proyecto 2: ");
                                                    nombre2 = SC.nextLine();
                                                    System.out.println("Introduce la nueva descripción del proyecto 2: ");
                                                    descripcion2 = SC.nextLine();
                                                    System.out.println("Introduce la nueva categoria del proyecto 2: ");
                                                    categoria2 = SC.nextLine();
                                                    System.out.println("Introduce la nueva cantidad necesaria del proyecto 2: ");
                                                    cantidadNec2 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva cantidad financiada del proyecto 2: ");
                                                    cantidadFinanc2 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva fecha de inicio del proyecto 2: ");
                                                    fechaInicio2 = SC.nextLine();
                                                    System.out.println("Introduce la nueva fecha fin del proyecto 2: ");
                                                    fechaFin2 = SC.nextLine();
                                                }

                                            } else if (seleccion == 3) {
                                                System.out.println("Detalle del proyecto 1: ");
                                                System.out.println("Nombre: " + nombre3);
                                                System.out.println("Descripción: " + descripcion3);
                                                System.out.println("Categoría: " + categoria3);
                                                System.out.println("Cantidad necesaria: " + cantidadNec3);
                                                System.out.println("Cantidad financiada: " + cantidadFinanc3);
                                                System.out.println("Fecha inicio: " + fechaInicio3);
                                                System.out.println("Fecha fin: " + fechaFin3);

                                                System.out.println("¿Quieres modificar el proyecto 3?");
                                                String respuesta = SC.nextLine();
                                                if (respuesta.equalsIgnoreCase("S")) {
                                                    System.out.println("Introduce el nuevo nombre del proyecto 3: ");
                                                    nombre3 = SC.nextLine();
                                                    System.out.println("Introduce la nueva descripción del proyecto 3: ");
                                                    descripcion3 = SC.nextLine();
                                                    System.out.println("Introduce la nueva categoria del proyecto 3: ");
                                                    categoria3 = SC.nextLine();
                                                    System.out.println("Introduce la nueva cantidad necesaria del proyecto 3: ");
                                                    cantidadNec3 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva cantidad financiada del proyecto 3: ");
                                                    cantidadFinanc3 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva fecha de inicio del proyecto 3: ");
                                                    fechaInicio3 = SC.nextLine();
                                                    System.out.println("Introduce la nueva fecha fin del proyecto 3: ");
                                                    fechaFin3 = SC.nextLine();
                                                }
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("===CARTERA DIGITAL===");
                                        break;
                                    case 4:
                                        System.out.println("===INVITA A TUS AMIGOS===");
                                        System.out.println("Lista de amigos: ");
                                        if (invitaAmigo1.length() == 0){
                                            System.out.println("No tienes ningún amigo añadido");
                                            System.out.println();
                                        }else{
                                            System.out.println("///" + invitaAmigo1 + "///");
                                        }
                                        System.out.println("Introduce el correo electrónico de un amigo para añadirlo a la lista de amigos: ");
                                        String nuevoAmigo = SC.nextLine();
                                        invitaAmigo1 += nuevoAmigo + " ";
                                        System.out.println("Amigo añadido.");
                                        break;

                                    case 5:
                                        System.out.println("===CONFIGURACIÓN===");
                                        System.out.println("1. Cambiar el nombre de usuario");
                                        System.out.println("2. Cambiar contraseña");
                                        int opcionCambioInversor1 = SC.nextInt();
                                        SC.nextLine();
                                        switch (opcionCambioInversor1) {
                                            case 1:
                                                System.out.println("Introduce el nuevo usuario");
                                                usuarioInversor1 = SC.nextLine();
                                                System.out.println("El nombre de usuario ha sido cambiado");
                                                break;
                                            case 2:
                                                System.out.println("Introduce la nueva contraseña");
                                                usuarioInversor1 = SC.nextLine();
                                                System.out.println("La contraseña ha sido cambiada");
                                                break;
                                            default:
                                                System.out.println("Opción no válida");
                                        }
                                        break;

                                    case 6:
                                        salirInversor1 = true;
                                        System.out.println("Cerrando sesión...");
                                        break;

                                    default:
                                        System.out.println("Opcion no valida");
                                        break;
                                }
                            }
                        } else {
                            intentosGestor++;
                            System.out.println("Contraseña incorrecta. Intentos restantes: " + (3 - intentosGestor));
                        }

                    } else {
                        gestorBloqueado = true;
                        System.out.println("Has superado el limite de intentos. La cuenta está bloqueada");
                    }
                }


                            // Inversor2
            } else if (usuario.equals(usuarioInversor2)) {
                if (inversor1Bloqueado){
                    System.out.println("El usuario inversor está bloqueado. Contacta al administrador.");
                }else{
                    if (intentosInversor2 < 3){
                        if (contrasena.equals(contraInversor2)) {
                            System.out.println("Contraseña correcta");
                            intentosInversor2 = 0;
                            boolean salirInversor2 = false;

                            while (!salirInversor2) {
                                System.out.println("\n=== MENÚ INVERSOR 2 ===");
                                System.out.println("1. Mis inversiones");
                                System.out.println("2. Proyectos");
                                System.out.println("3. Cartera digital");
                                System.out.println("4. Invita a un amigo");
                                System.out.println("5. Configuración");
                                System.out.println("6. Cerrar sesión");
                                System.out.println("Elige una opción");

                                int opcionInversor2 = SC.nextInt();
                                SC.nextLine();

                                switch (opcionInversor2) {
                                    case 1:
                                        System.out.println("Mis inversiones: ");
                                        break;
                                    case 2:
                                        if (numProyectos == 0) {
                                            System.out.println("No hay proyectos creados.");
                                        } else {
                                            System.out.println("\n/////PROYECTOS CREADOS/////");
                                            if (!proyecto1.equals(""))
                                                System.out.println("Proyecto 1: " + proyecto1);
                                            if (!proyecto2.equals(""))
                                                System.out.println("Proyecto 2: " + proyecto2);
                                            if (!proyecto3.equals(""))
                                                System.out.println("Proyecto 3: " + proyecto3);

                                            System.out.println("Selecciona el proyecto que quieres ver en detalle 1-3: ");
                                            int seleccion = SC.nextInt();
                                            SC.nextLine();

                                            if (seleccion == 1) {
                                                System.out.println("Detalle del proyecto 1: ");
                                                System.out.println("Nombre: " + nombre1);
                                                System.out.println("Descripción: " + descripcion1);
                                                System.out.println("Categoría: " + categoria1);
                                                System.out.println("Cantidad necesaria: " + cantidadNec1);
                                                System.out.println("Cantidad financiada: " + cantidadFinanc1);
                                                System.out.println("Fecha inicio: " + fechaInicio1);
                                                System.out.println("Fecha fin: " + fechaFin1);

                                                System.out.println("¿Quieres modificar el proyecto 1?");
                                                String respuesta = SC.nextLine();
                                                if (respuesta.equalsIgnoreCase("S")) {
                                                    System.out.println("Introduce el nuevo nombre del proyecto 1: ");
                                                    nombre1 = SC.nextLine();
                                                    System.out.println("Introduce la nueva descripción del proyecto 1: ");
                                                    descripcion1 = SC.nextLine();
                                                    System.out.println("Introduce la nueva categoria del proyecto 1: ");
                                                    categoria1 = SC.nextLine();
                                                    System.out.println("Introduce la nueva cantidad necesaria del proyecto 1: ");
                                                    cantidadNec1 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva cantidad financiada del proyecto 1: ");
                                                    cantidadFinanc1 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva fecha de inicio del proyecto 1: ");
                                                    fechaInicio1 = SC.nextLine();
                                                    System.out.println("Introduce la nueva fecha fin del proyecto 1: ");
                                                    fechaFin1 = SC.nextLine();
                                                }
                                            } else if (seleccion == 2) {
                                                System.out.println("Detalle del proyecto 1: ");
                                                System.out.println("Nombre: " + nombre2);
                                                System.out.println("Descripción: " + descripcion2);
                                                System.out.println("Categoría: " + categoria2);
                                                System.out.println("Cantidad necesaria: " + cantidadNec2);
                                                System.out.println("Cantidad financiada: " + cantidadFinanc2);
                                                System.out.println("Fecha inicio: " + fechaInicio2);
                                                System.out.println("Fecha fin: " + fechaFin2);

                                                System.out.println("¿Quieres modificar el proyecto 2?");
                                                String respuesta = SC.nextLine();
                                                if (respuesta.equalsIgnoreCase("S")) {
                                                    System.out.println("Introduce el nuevo nombre del proyecto 2: ");
                                                    nombre2 = SC.nextLine();
                                                    System.out.println("Introduce la nueva descripción del proyecto 2: ");
                                                    descripcion2 = SC.nextLine();
                                                    System.out.println("Introduce la nueva categoria del proyecto 2: ");
                                                    categoria2 = SC.nextLine();
                                                    System.out.println("Introduce la nueva cantidad necesaria del proyecto 2: ");
                                                    cantidadNec2 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva cantidad financiada del proyecto 2: ");
                                                    cantidadFinanc2 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva fecha de inicio del proyecto 2: ");
                                                    fechaInicio2 = SC.nextLine();
                                                    System.out.println("Introduce la nueva fecha fin del proyecto 2: ");
                                                    fechaFin2 = SC.nextLine();
                                                }

                                            } else if (seleccion == 3) {
                                                System.out.println("Detalle del proyecto 1: ");
                                                System.out.println("Nombre: " + nombre3);
                                                System.out.println("Descripción: " + descripcion3);
                                                System.out.println("Categoría: " + categoria3);
                                                System.out.println("Cantidad necesaria: " + cantidadNec3);
                                                System.out.println("Cantidad financiada: " + cantidadFinanc3);
                                                System.out.println("Fecha inicio: " + fechaInicio3);
                                                System.out.println("Fecha fin: " + fechaFin3);

                                                System.out.println("¿Quieres modificar el proyecto 3?");
                                                String respuesta = SC.nextLine();
                                                if (respuesta.equalsIgnoreCase("S")) {
                                                    System.out.println("Introduce el nuevo nombre del proyecto 3: ");
                                                    nombre3 = SC.nextLine();
                                                    System.out.println("Introduce la nueva descripción del proyecto 3: ");
                                                    descripcion3 = SC.nextLine();
                                                    System.out.println("Introduce la nueva categoria del proyecto 3: ");
                                                    categoria3 = SC.nextLine();
                                                    System.out.println("Introduce la nueva cantidad necesaria del proyecto 3: ");
                                                    cantidadNec3 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva cantidad financiada del proyecto 3: ");
                                                    cantidadFinanc3 = SC.nextDouble();
                                                    System.out.println("Introduce la nueva fecha de inicio del proyecto 3: ");
                                                    fechaInicio3 = SC.nextLine();
                                                    System.out.println("Introduce la nueva fecha fin del proyecto 3: ");
                                                    fechaFin3 = SC.nextLine();
                                                }
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("===CARTERA DIGITAL===");
                                        break;
                                    case 4:
                                        System.out.println("===INVITA A TUS AMIGOS===");
                                        System.out.println("Lista de amigos: ");
                                        if (invitaAmigo2.length() == 0){
                                            System.out.println("No tienes ningún amigo añadido");
                                            System.out.println();
                                        }else{
                                            System.out.println("///" + invitaAmigo2 + "///");
                                        }
                                        System.out.println("Introduce el correo electrónico de un amigo para añadirlo a la lista de amigos: ");
                                        String nuevoAmigo = SC.nextLine();
                                        invitaAmigo2 += nuevoAmigo + " ";
                                        System.out.println("Amigo añadido.");
                                        break;

                                    case 5:
                                        System.out.println("===CONFIGURACIÓN===");
                                        System.out.println("1. Cambiar el nombre de usuario");
                                        System.out.println("2. Cambiar contraseña");
                                        int opcionCambioInversor2 = SC.nextInt();
                                        SC.nextLine();
                                        switch (opcionCambioInversor2) {
                                            case 1:
                                                System.out.println("Introduce el nuevo usuario");
                                                usuarioInversor2 = SC.nextLine();
                                                System.out.println("El nombre de usuario ha sido cambiado");
                                                break;
                                            case 2:
                                                System.out.println("Introduce la nueva contraseña");
                                                usuarioInversor2 = SC.nextLine();
                                                System.out.println("La contraseña ha sido cambiada");
                                                break;
                                            default:
                                                System.out.println("Opción no válida");
                                        }
                                        break;

                                    case 6:
                                        salirInversor2 = true;
                                        System.out.println("Cerrando sesión...");
                                        break;

                                    default:
                                        System.out.println("Opcion no valida");
                                        break;
                                }
                            }
                        } else {
                            intentosGestor++;
                            System.out.println("Contraseña incorrecta. Intentos restantes: " + (3 - intentosGestor));
                        }

                    } else {
                        gestorBloqueado = true;
                        System.out.println("Has superado el limite de intentos. La cuenta está bloqueada");
                    }
                }
            }
        }
    }
}
