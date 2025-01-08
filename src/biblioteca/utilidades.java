package biblioteca;

import java.util.Scanner;

public class utilidades {
    static Scanner SC = new Scanner(System.in);
    public static String usuarioAdmin = "administrador", contraAdmin = "admin123";
    public static String usuarioGestor = "gestor", contraGestor = "gestor123";
    public static String usuarioInversor1 = "inversor1", contraInversor1 = "inversor123";
    public static String usuarioInversor2 = "inversor2", contraInversor2 = "inversor321";

    public static boolean gestorBloqueado = false;
    public static boolean inversor1Bloqueado = false;
    public static boolean inversor2Bloqueado = false;

    public static int intentosGestor = 0, intentosInversor1 = 0, intentosInversor2 = 0;

    public static String invitaAmigo1 = "";
    public static String invitaAmigo2 = "";

    public static double saldoCartera1 = 0.0;
    public static double saldoCartera2 = 0.0;

    public static String proyecto1 = "", proyecto2 = "", proyecto3 = "";
    public static String nombre1 = "", nombre2 = "", nombre3 = "";
    public static String descripcion1 = "", descripcion2 = "", descripcion3 = "";
    public static String categoria1 = "", categoria2 = "", categoria3 = "";
    public static double cantidadNec1 = 0, cantidadNec2 = 0, cantidadNec3 = 0;
    public static double cantidadInvertida1 = 0, cantidadInvertida2 = 0, cantidadInvertida3 = 0;
    public static double cantidadFinanc1 = 0, cantidadFinanc2 = 0, cantidadFinanc3 = 0;
    public static String fechaInicio1 = "", fechaInicio2 = "", fechaInicio3 = "";
    public static String fechaFin1 = "", fechaFin2 = "", fechaFin3 = "";

    public static int numProyectos = 0;

    static String recompensa1P1 = "", recompensa2P1 = "", recompensa3P1 = "";
    static String recompensa1P2 = "", recompensa2P2 = "", recompensa3P2 = "";
    static String recompensa1P3 = "", recompensa2P3 = "", recompensa3P3 = "";
    static String recompensaDesc1P1 = "", recompensaDesc2P1 = "",recompensaDesc3P1 = "";
    static String recompensaDesc1P2 = "", recompensaDesc2P2 = "",recompensaDesc3P2 = "";
    static String recompensaDesc1P3 = "", recompensaDesc2P3 = "",recompensaDesc3P3 = "";
    static double precioRecompensa1P1 = 0, precioRecompensa2P1 = 0, precioRecompensa3P1 = 0;
    static double precioRecompensa1P2 = 0, precioRecompensa2P2 = 0, precioRecompensa3P2 = 0;
    static double precioRecompensa1P3 = 0, precioRecompensa2P3 = 0, precioRecompensa3P3 = 0;



    /**
     * Muestra el menu del administrador con distintas opciones.
     */
    public static void menuAdministrador (){
        System.out.println("\n=== MENÚ ADMINISTRADOR ===");
        System.out.println("1. Panel de control");
        System.out.println("2. Proyectos");
        System.out.println("3. Configuración");
        System.out.println("4. Cerrar sesión");
        System.out.print("Elige una opción: ");
    }

    public static void panelControlUsuarios(){
        System.out.println("===PANEL DE CONTROL===");
        System.out.println("1. Bloquear o desbloquear Gestor");
        System.out.println("2. Bloquear o desbloquear Inversor 1");
        System.out.println("3. Bloquear o desbloquear Inversor 2");
        System.out.println("Elige una opción: ");
        int opcionBloDes = SC.nextInt();
        SC.nextLine();

        switch (opcionBloDes){
            case 1:
                bloqueoDesbloqueoGestor();
                break;
            case 2:
                bloqueoDesbloqueoInversor1();
                break;
            case 3:
                bloqueoDesbloqueoInversor2();
                break;
            default:
                System.out.println("Opcion no válida");
                break;
        }
    }

    /**
     * Muestra el bloqueo y desbloqueo del gestor.
     */
    public static  void bloqueoDesbloqueoGestor(){
        gestorBloqueado = !gestorBloqueado;
        if (!gestorBloqueado){
            intentosGestor = 0;
        }
        System.out.println("El usuario a sido " + (gestorBloqueado ? "bloqueado" : "desbloqueado"));

    }

    /**
     * Muestra el bloqueo y desbloqueo del inversor1.
     */
    public static  void bloqueoDesbloqueoInversor1(){
        inversor1Bloqueado = !inversor1Bloqueado;
        if (!inversor1Bloqueado){
            intentosInversor1 = 0;
        }
        System.out.println("El usuario a sido " + (inversor1Bloqueado ? "bloqueado" : "desbloqueado"));
    }

    /**
     * Muestra el bloqueo y desbloqueo del inversor2.
     */
    public static  void bloqueoDesbloqueoInversor2(){
        inversor2Bloqueado = !inversor2Bloqueado;
        if (!inversor2Bloqueado){
            intentosInversor2 = 0;
        }
        System.out.println("El usuario a sido " + (inversor2Bloqueado ? "bloqueado" : "desbloqueado"));
    }

    /**
     * Muestra los proyectos que estan creados.
     */
    public static void dirigirProyecto() {
        System.out.println("===PROYECTOS===");
        if (numProyectos == 0) {
            System.out.println("No hay proyectos creados");
        }else{
            mostrarProyectos();
            System.out.println("Selecciona el proyecto que quieres ver en detalle 1-3: ");
            int seleccion = SC.nextInt();
            SC.nextLine();

            if (seleccion >= 1 && seleccion <= 3){
                detallesProyecto(seleccion);
            }else{
                System.out.println("Opcion no valida");
            }
        }
    }

    public static void mostrarProyectos(){
        if (!proyecto1.equals("")) System.out.println("Proyecto 1: Nombre: " + nombre1 + ", Descripción: " + descripcion1 + ", Categoría: " + categoria1 + ", Cantidad necesaria: "
                + cantidadNec1 + " Cantidad financiada: " + cantidadFinanc1 + ", Fecha inicio: " + fechaInicio1 + " Fecha fin: " + fechaFin1);
        if (!proyecto2.equals("")) System.out.println("Proyecto 1: Nombre: " + nombre2 + ", Descripción: " + descripcion2 + ", Categoría: " + categoria2 + ", Cantidad necesaria: "
                + cantidadNec1 + " Cantidad financiada: " + cantidadFinanc2 + ", Fecha inicio: " + fechaInicio2 + " Fecha fin: " + fechaFin2);
        if (!proyecto3.equals("")) System.out.println("Proyecto 1: Nombre: " + nombre3 + ", Descripción: " + descripcion3 + ", Categoría: " + categoria3 + ", Cantidad necesaria: "
                + cantidadNec1 + " Cantidad financiada: " + cantidadFinanc3 + ", Fecha inicio: " + fechaInicio3 + " Fecha fin: " + fechaFin3);;

    }

    /**
     * Muestra detallado los proyectos disponibles y la opcion de modificar los proyectos.
     */
    public static void detallesProyecto(int seleccion){
        String nombre = "", descripcion = "", categoria = "", fechaInicio = "", fechaFin = "";
        double cantidadNec = 0, cantidadFinanc = 0;

        if (seleccion == 1){
            nombre = nombre1; descripcion = descripcion1; categoria = categoria1;
            cantidadNec = cantidadNec1; cantidadFinanc = cantidadFinanc1;
            fechaInicio = fechaInicio1; fechaFin = fechaFin1;
        }else if (seleccion == 2){
            nombre = nombre2; descripcion = descripcion2; categoria = categoria2;
            cantidadNec = cantidadNec2; cantidadFinanc = cantidadFinanc2;
            fechaInicio = fechaInicio2; fechaFin = fechaFin2;
        }else if (seleccion == 3){
            nombre = nombre3; descripcion = descripcion3; categoria = categoria3;
            cantidadNec = cantidadNec3; cantidadFinanc = cantidadFinanc3;
            fechaInicio = fechaInicio3; fechaFin = fechaFin3;
        }
        System.out.println("Detalle del proyecto: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Categoría: " + categoria);
        System.out.println("Cantidad necesaria: " + cantidadNec);
        System.out.println("Cantidad financiada: " + cantidadFinanc);
        System.out.println("Fecha inicio: " + fechaInicio);
        System.out.println("Fecha fin: " + fechaFin);
        System.out.println("¿Quieres modificar el proyecto" + seleccion + "? (S/N)");
        String respuesta = SC.nextLine();
        if (respuesta.equalsIgnoreCase("S")) {
            modificaProyecto(seleccion);
        }
    }

    public static void modificaProyecto(int seleccion) {

            System.out.println("Introduce el nuevo nombre del proyecto 1: ");
            String nombre = SC.nextLine();
            System.out.println("Introduce la nueva descripción del proyecto 1: ");
            String descripcion = SC.nextLine();
            System.out.println("Introduce la nueva categoria del proyecto 1: ");
            String categoria = SC.nextLine();
            System.out.println("Introduce la nueva cantidad necesaria del proyecto 1: ");
            double cantidadNec = SC.nextDouble();
            System.out.println("Introduce la nueva cantidad financiada del proyecto 1: ");
            double cantidadFinanc = SC.nextDouble();
            SC.nextLine();
            System.out.println("Introduce la nueva fecha de inicio del proyecto 1: ");
            String fechaInicio = SC.nextLine();
            System.out.println("Introduce la nueva fecha fin del proyecto 1: ");
            String fechaFin = SC.nextLine();
            if (seleccion == 1) {
                nombre1 = nombre; descripcion1 = descripcion; categoria1 = categoria;
                cantidadNec1 = cantidadNec; cantidadFinanc1 = cantidadFinanc;
                fechaInicio1 = fechaInicio; fechaFin1 = fechaFin;
            }else if (seleccion == 2){
                nombre2 = nombre; descripcion2 = descripcion; categoria2 = categoria;
                cantidadNec2 = cantidadNec; cantidadFinanc2 = cantidadFinanc;
                fechaInicio2 = fechaInicio; fechaFin2 = fechaFin;
            }else if (seleccion == 3){
                nombre3 = nombre; descripcion3 = descripcion; categoria3 = categoria;
                cantidadNec3 = cantidadNec; cantidadFinanc3 = cantidadFinanc;
                fechaInicio3 = fechaInicio; fechaFin3 = fechaFin;
            }
        System.out.println("Proyecto " + seleccion + " modificado.");
    }

    /**
     * Opcion para eliminar los proyectos.
     */
    public static void eliminarProyecto(){
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

    /**
     * Muestra la configuracion de cambio de nombre y conttraseña.
     */
    public static void admConfiguracion(){
        System.out.println("===CONFIGURACIÓN===");
        System.out.println("1. Cambiar el nombre de usuario");
        System.out.println("2. Cambiar contraseña");
        int opcionCambioAdm = SC.nextInt();
        SC.nextLine();

        switch (opcionCambioAdm){
            case 1: admCambioUsuario();
            case 2: admCambioContrasena();
            default: System.out.println("Opción no válida");
        }
    }

    public static void admCambioUsuario(){
        System.out.println("Introduce el nuevo usuario");
        String nuevoUsuario = SC.nextLine();
        usuarioAdmin = nuevoUsuario;
        System.out.println("El nombre de usuario ha sido cambiado");
    }

    public static void admCambioContrasena(){
        System.out.println("Introduce la nueva contraseña");
        String nuevaContrasena = SC.nextLine();
        contraAdmin = nuevaContrasena;
        System.out.println("La contraseña ha sido cambiada");
    }

    /**
     * Muestra el menu del gestor con distintas opciones.
     */
    public static void menuGestor(){
        System.out.println("\n=== MENÚ GESTOR ===");
        System.out.println("1. Crear proyecto");
        System.out.println("2. Ver mis proyectos");
        System.out.println("3. Eliminar proyecto");
        System.out.println("4. Configuracion");
        System.out.println("5. Cerrar sesión");
        System.out.println("Elige una opción");
    }

    /**
     * Muestra la creacion de proyectos, hasta 3 proyectos maximo.
     */
    public static void creacionProyecto(){
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
            SC.nextLine();
            System.out.println("Fecha inicio de apertura para recibir inversiones ");
            String fechaInicio = SC.nextLine();
            System.out.println("Fecha fin de cierre de las inversiones ");
            String fechaCierre = SC.nextLine();

            String recompensa1 = "", descripcionR1 = "";
            double precioR1 = 0;

            System.out.println("Introduce el nombre de la recompensa 1: ");
            recompensa1 = SC.nextLine();

            if (!recompensa1.equals("")){
                System.out.println("Descripción de la recompensa 1: ");
                descripcionR1 = SC.nextLine();

                System.out.println("Precio de la recompensa 1: ");
                precioR1 = SC.nextDouble();
                SC.nextLine();
            }

            String recompensa2 = "", descripcionR2 = "";
            double precioR2 = 0;

            System.out.println("Introduce el nombre de la recompensa 2: ");
            recompensa2 = SC.nextLine();

            if (!recompensa2.equals("")){
                System.out.println("Descripción de la recompensa 2: ");
                descripcionR2 = SC.nextLine();

                System.out.println("Precio de la recompensa 2: ");
                precioR2 = SC.nextDouble();
                SC.nextLine();
            }

            String recompensa3 = "", descripcionR3 = "";
            double precioR3 = 0;

            System.out.println("Introduce el nombre de la recompensa 1: ");
            recompensa3 = SC.nextLine();

            if (!recompensa3.equals("")){
                System.out.println("Descripción de la recompensa 1: ");
                descripcionR3 = SC.nextLine();

                System.out.println("Precio de la recompensa 1: ");
                precioR3 = SC.nextDouble();
                SC.nextLine();
            }

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

                recompensa1P1 = recompensa1;
                recompensa2P1 = recompensa2;
                recompensa3P1 = recompensa3;
                recompensaDesc1P1 = descripcionR1;
                recompensaDesc2P1 = descripcionR2;
                recompensaDesc3P1 = descripcionR3;
                precioRecompensa1P1 = precioR1;
                precioRecompensa2P1 = precioR1;
                precioRecompensa3P1 = precioR1;


            } else if (numProyectos == 1) {
                proyecto2 = "Nombre: " + nombre + ", Descripción: " + descripcion + ", Categoria: " + categoria + ", Cantidad necesaria: " + cantidadNec + ", Cantidad hasta el momento: " + cantidadHastaMom + ", Fecha de inicio: " + fechaInicio + ", Fecha de inicio: " + fechaCierre;
                nombre2 = nombre;
                descripcion2 = descripcion;
                categoria2 = categoria;
                cantidadNec2 = cantidadNec;
                cantidadFinanc2 = cantidadHastaMom;
                fechaInicio2 = fechaInicio;
                fechaFin2 = fechaCierre;

                recompensa1P2 = recompensa1;
                recompensa2P2 = recompensa2;
                recompensa3P2 = recompensa3;
                recompensaDesc1P2 = descripcionR1;
                recompensaDesc2P2 = descripcionR2;
                recompensaDesc3P2 = descripcionR3;
                precioRecompensa1P2 = precioR1;
                precioRecompensa2P2 = precioR2;
                precioRecompensa3P2 = precioR3;

            } else if (numProyectos == 2) {
                proyecto3 = "Nombre: " + nombre + ", Descripción: " + descripcion + ", Categoria: " + categoria + ", Cantidad necesaria: " + cantidadNec + ", Cantidad hasta el momento: " + cantidadHastaMom + ", Fecha de inicio: " + fechaInicio + ", Fecha de inicio: " + fechaCierre;
                nombre3 = nombre;
                descripcion3 = descripcion;
                categoria3 = categoria;
                cantidadNec3 = cantidadNec;
                cantidadFinanc3 = cantidadHastaMom;
                fechaInicio3 = fechaInicio;
                fechaFin3 = fechaCierre;

                recompensa1P3 = recompensa1;
                recompensa2P3 = recompensa2;
                recompensa3P3 = recompensa3;
                recompensaDesc1P3 = descripcionR1;
                recompensaDesc2P3 = descripcionR2;
                recompensaDesc3P3 = descripcionR3;
                precioRecompensa1P3 = precioR1;
                precioRecompensa2P3 = precioR1;
                precioRecompensa3P3 = precioR1;

            }
            numProyectos++;
            System.out.println("Poyecto creado con éxito");

            if (numProyectos == 1){
                System.out.println(proyecto1);
                System.out.println("Recompensas: ");
                if (!recompensa1P1.equals("")){
                    System.out.println("Recompensa 1: " + recompensa1P1 + ",Descripción " + recompensaDesc1P1 + ",Precio " + precioRecompensa1P1);
                }
                if (!recompensa2P1.equals("")){
                    System.out.println("Recompensa 2: " + recompensa2P1 + ",Descripción " + recompensaDesc2P1 + ",Precio " + precioRecompensa2P1);
                }
                if (!recompensa3P1.equals("")){
                    System.out.println("Recompensa 3: " + recompensa3P1 + ",Descripción " + recompensaDesc3P1 + ",Precio " + precioRecompensa3P1);
                }
            }else if (numProyectos == 2){
                System.out.println(proyecto2);
                System.out.println("Recompensas:");
                if (!recompensa1P2.equals("")){
                    System.out.println("Recompensa 1: " + recompensa1P2 + "Descripción " + recompensaDesc1P2 + "Precio " + precioRecompensa1P2);
                }
                if (!recompensa2P2.equals("")){
                    System.out.println("Recompensa 2: " + recompensa2P2 + "Descripción " + recompensaDesc2P2 + "Precio " + precioRecompensa2P2);
                }
                if (!recompensa3P2.equals("")){
                    System.out.println("Recompensa 3: " + recompensa3P2 + "Descripción " + recompensaDesc3P2 + "Precio " + precioRecompensa3P2);
                }
            }else if (numProyectos == 3){
                System.out.println(proyecto1);
                System.out.println("Recompensas");
                if (!recompensa1P3.equals("")){
                    System.out.println("Recompensa 1: " + recompensa1P3 + "Descripción " + recompensaDesc1P3 + "Precio " + precioRecompensa1P3);
                }
                if (!recompensa2P3.equals("")){
                    System.out.println("Recompensa 2: " + recompensa2P3 + "Descripción " + recompensaDesc2P3 + "Precio " + precioRecompensa2P3);
                }
                if (!recompensa2P3.equals("")){
                    System.out.println("Recompensa 3: " + recompensa3P3 + "Descripción " + recompensaDesc3P3 + "Precio " + precioRecompensa3P3);
                }
            }

        } else {
            System.out.println("Error. Solo se puede crear 3 proyectos");
        }
    }

    /**
     * Muestra la configuracion de cambio de nombre y conttraseña.
     */
    public static void gestorConfiguracion(){
        System.out.println("===CONFIGURACIÓN===");
        System.out.println("1. Cambiar el nombre de usuario");
        System.out.println("2. Cambiar contraseña");
        int opcionCambioGestor = SC.nextInt();
        SC.nextLine();

        switch (opcionCambioGestor){
            case 1: gestorCambioUsuario();
            case 2: gestorCambioContrasena();
            default: System.out.println("Opción no válida");
        }
    }

    public static void gestorCambioUsuario(){
        System.out.println("Introduce el nuevo usuario");
        String nuevoUsuario = SC.nextLine();
        usuarioGestor = nuevoUsuario;
        System.out.println("El nombre de usuario ha sido cambiado");
    }

    public static void gestorCambioContrasena(){
        System.out.println("Introduce la nueva contraseña");
        String nuevaContrasena = SC.nextLine();
        contraGestor = nuevaContrasena;
        System.out.println("La contraseña ha sido cambiada");
    }

    /**
     * Muestra el menu del inversor1 con distintas opciones.
     */
    public static void menuInversor1(){
        System.out.println("\n=== MENÚ INVERSOR 1 ===");
        System.out.println("1. Mis inversiones");
        System.out.println("2. Proyectos");
        System.out.println("3. Cartera digital");
        System.out.println("4. Invita a un amigo");
        System.out.println("5. Configuración");
        System.out.println("6. Cerrar sesión");
        System.out.println("Elige una opción");
    }

    /**
     * Muestra las inversiones de los proyectos en los que a invertido.
     */
    public static void misInversiones1(){
        boolean hayInversiones = false;

        if (cantidadInvertida1 > 0) {
            System.out.println("1. " + nombre1 + " | Categoria: " + categoria1 + " | Necesaria:" + cantidadNec1 + " | Financiada: " + cantidadFinanc1);
            hayInversiones = true;
        }
        if (cantidadInvertida2 > 0){
            System.out.println("2. " + nombre2 + " | Categoria: " + categoria2 + " | Necesaria:" + cantidadNec2 + " | Financiada: " + cantidadFinanc2);
            hayInversiones = true;
        }
        if (cantidadInvertida3 > 0){
            System.out.println("3. " + nombre3 + " | Categoria: " + categoria3 + " | Necesaria:" + cantidadNec3 + " | Financiada: " + cantidadFinanc3);
            hayInversiones = true;
        }

        if (!hayInversiones){
            System.out.println("No has realizado ninguna inversion");
        }else {
            System.out.println("Selecciona el proyecto que quieres ver en detalle (0 para volver): ");
            int seleccionInv = SC.nextInt();
            SC.nextLine();

            if (seleccionInv == 1 && cantidadInvertida1 < 0) {
                System.out.println("Detalle del proyecto 1: ");
                System.out.println("Nombre: " + nombre1);
                System.out.println("Descripción: " + descripcion1);
                System.out.println("Categoría: " + categoria1);
                System.out.println("Cantidad necesaria: " + cantidadNec1);
                System.out.println("Cantidad financiada: " + cantidadFinanc1);
                System.out.println("Fecha inicio: " + fechaInicio1);
                System.out.println("Fecha fin: " + fechaFin1);
            } else if (seleccionInv == 2 && cantidadInvertida2 < 0) {
                System.out.println("Detalle del proyecto 2: ");
                System.out.println("Nombre: " + nombre2);
                System.out.println("Descripción: " + descripcion2);
                System.out.println("Categoría: " + categoria2);
                System.out.println("Cantidad necesaria: " + cantidadNec2);
                System.out.println("Cantidad financiada: " + cantidadFinanc2);
                System.out.println("Fecha inicio: " + fechaInicio2);
                System.out.println("Fecha fin: " + fechaFin2);
            } else if (seleccionInv == 3 && cantidadInvertida3 < 0) {
                System.out.println("Detalle del proyecto 3: ");
                System.out.println("Nombre: " + nombre3);
                System.out.println("Descripción: " + descripcion3);
                System.out.println("Categoría: " + categoria3);
                System.out.println("Cantidad necesaria: " + cantidadNec3);
                System.out.println("Cantidad financiada: " + cantidadFinanc3);
                System.out.println("Fecha inicio: " + fechaInicio3);
                System.out.println("Fecha fin: " + fechaFin3);
            }
        }
    }

    /**
     * Muestra los proyectos que hay disponibles para invertir en ellos.
     */
    public static void verProyectosInv1(){
        System.out.println("Proyectos disponibles: ");

        boolean hayProyectos = false;

        if (cantidadNec1 > 0){
            System.out.println("1. " + nombre1 + " | Categoria: " + categoria1 + " | Necesaria:" + cantidadNec1 + " | Financiada: " + cantidadFinanc1);
            hayProyectos = true;
        }
        if (cantidadNec2 > 0){
            System.out.println("2. " + nombre2 + " | Categoria: " + categoria2 + " | Necesaria:" + cantidadNec2 + " | Financiada: " + cantidadFinanc2);
            hayProyectos = true;
        }
        if (cantidadNec3 > 0){
            System.out.println("3. " + nombre3 + " | Categoria: " + categoria3 + " | Necesaria:" + cantidadNec3 + " | Financiada: " + cantidadFinanc3);
            hayProyectos = true;

        }

        if (!hayProyectos){
            System.out.println("No hay proyectos disponibles.");
        }else {

            System.out.println("Selecciona el proyecto que quieres ver en detalle (0 para volver): ");
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

                System.out.println("¿Deseas invertir en este proyecto? (si/no)");
                String respuesta = SC.nextLine();
                if (respuesta.equalsIgnoreCase("Si")) {
                    System.out.println("Cuanto deseas invertir");
                    double cantidad1 = SC.nextDouble();
                    if (cantidad1 <= saldoCartera1 && cantidad1 + cantidadFinanc1 <= cantidadNec1) {
                        saldoCartera1 -= cantidad1;
                        cantidadFinanc1 += cantidad1;
                        cantidadInvertida1 += cantidad1;
                        System.out.println("Inversión realizada");
                    } else {
                        System.out.println("No tienes suficiente saldo o el proyecto ya esta financidado");
                    }
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

                System.out.println("¿Deseas invertir en este proyecto? (si/no)");
                String respuesta = SC.nextLine();
                if (respuesta.equalsIgnoreCase("Si")) {
                    System.out.println("Cuanto deseas invertir");
                    double cantidad1 = SC.nextDouble();
                    if (cantidad1 <= saldoCartera1 && cantidad1 + cantidadFinanc2 <= cantidadNec2) {
                        saldoCartera1 -= cantidad1;
                        cantidadFinanc2 += cantidad1;
                        cantidadInvertida2 += cantidad1;
                        System.out.println("Inversión realizada");
                    } else {
                        System.out.println("No tienes suficiente saldo o el proyecto ya esta financidado");
                    }
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

                System.out.println("¿Deseas invertir en este proyecto? (si/no)");
                String respuesta = SC.nextLine();
                if (respuesta.equalsIgnoreCase("Si")) {
                    System.out.println("Cuanto deseas invertir");
                    double cantidad1 = SC.nextDouble();
                    if (cantidad1 <= saldoCartera1 && cantidad1 + cantidadFinanc3 <= cantidadNec3) {
                        saldoCartera1 -= cantidad1;
                        cantidadFinanc3 += cantidad1;
                        cantidadInvertida3 += cantidad1;
                        System.out.println("Inversión realizada");
                    } else {
                        System.out.println("No tienes suficiente saldo o el proyecto ya esta financidado");
                    }
                }
            }
        }
    }

    /**
     * Muestra el saldo que tiene y puede añadir mas saldo.
     */
    public static void carteraDigital1(){
        System.out.println("===CARTERA DIGITAL===");
        boolean salirCartera = false;

        while (!salirCartera){
            System.out.println("1. Ver saldo");
            System.out.println("2. Añadir saldo");
            System.out.println("3. Salir");

            int opcionCD = SC.nextInt();
            SC.nextLine();

            switch (opcionCD){
                case 1:
                    System.out.println("Saldo actual: " + saldoCartera1);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Introduce la cantidad de dinero que quieres introducir en la cartera digital: ");
                    double cantidadDinero = SC.nextDouble();


                    if (cantidadDinero > 0){
                        saldoCartera1 += cantidadDinero;
                        System.out.println("Has añadido " + cantidadDinero + "a tu cartera digital.");
                        System.out.println("Tu nuevo saldo es de: " + saldoCartera1);
                    }else{
                        System.out.println("Debes de introducir un valor mayor que 0.");
                    }
                    break;

                case 3:
                    salirCartera = true;
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("Opción no válida. ");
                    break;
            }
        }
    }

    /**
     * Muestra la opcion de invitar a amigos.
     */
    public static void invitaAmigoInv1(){
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
    }

    /**
     * Muestra la configuracion de cambio de nombre y contraseña.
     */
    public static void inversor1Configuracion(){
        System.out.println("===CONFIGURACIÓN===");
        System.out.println("1. Cambiar el nombre de usuario");
        System.out.println("2. Cambiar contraseña");
        int opcionCambioInversor1 = SC.nextInt();
        SC.nextLine();

        switch (opcionCambioInversor1){
            case 1: inversor1CambioUsuario();
            case 2: inversor1CambioContrasena();
            default: System.out.println("Opción no válida");
        }
    }

    public static void inversor1CambioUsuario(){
        System.out.println("Introduce el nuevo usuario");
        String nuevoUsuario = SC.nextLine();
        usuarioInversor1 = nuevoUsuario;
        System.out.println("El nombre de usuario ha sido cambiado");
    }

    public static void inversor1CambioContrasena(){
        System.out.println("Introduce la nueva contraseña");
        String nuevaContrasena = SC.nextLine();
        contraInversor1 = nuevaContrasena;
        System.out.println("La contraseña ha sido cambiada");
    }

    /**
     * Muestra el menu del inversor2 con distintas opciones.
     */
    public static void menuInversor2(){
        System.out.println("\n=== MENÚ INVERSOR 1 ===");
        System.out.println("1. Mis inversiones");
        System.out.println("2. Proyectos");
        System.out.println("3. Cartera digital");
        System.out.println("4. Invita a un amigo");
        System.out.println("5. Configuración");
        System.out.println("6. Cerrar sesión");
        System.out.println("Elige una opción");
    }

    /**
     * Muestra las inversiones de los proyectos en los que a invertido.
     */
    public static void misInversiones2(){
        System.out.println("Mis inversiones: ");

        boolean hayInversiones = false;

        if (cantidadInvertida1 > 0) {
            System.out.println("1. " + nombre1 + " | Categoria: " + categoria1 + " | Necesaria:" + cantidadNec1 + " | Financiada: " + cantidadFinanc1);
            hayInversiones = true;
        }
        if (cantidadInvertida2 > 0){
            System.out.println("2. " + nombre2 + " | Categoria: " + categoria2 + " | Necesaria:" + cantidadNec2 + " | Financiada: " + cantidadFinanc2);
            hayInversiones = true;
        }
        if (cantidadInvertida3 > 0){
            System.out.println("3. " + nombre3 + " | Categoria: " + categoria3 + " | Necesaria:" + cantidadNec3 + " | Financiada: " + cantidadFinanc3);
            hayInversiones = true;
        }

        if (!hayInversiones){
            System.out.println("No has realizado ninguna inversion");
        }else {
            System.out.println("Selecciona el proyecto que quieres ver en detalle (0 para volver): ");
            int seleccionInv = SC.nextInt();
            SC.nextLine();

            if (seleccionInv == 1 && cantidadInvertida1 < 0) {
                System.out.println("Detalle del proyecto 1: ");
                System.out.println("Nombre: " + nombre1);
                System.out.println("Descripción: " + descripcion1);
                System.out.println("Categoría: " + categoria1);
                System.out.println("Cantidad necesaria: " + cantidadNec1);
                System.out.println("Cantidad financiada: " + cantidadFinanc1);
                System.out.println("Fecha inicio: " + fechaInicio1);
                System.out.println("Fecha fin: " + fechaFin1);
            } else if (seleccionInv == 2 && cantidadInvertida2 < 0) {
                System.out.println("Detalle del proyecto 2: ");
                System.out.println("Nombre: " + nombre2);
                System.out.println("Descripción: " + descripcion2);
                System.out.println("Categoría: " + categoria2);
                System.out.println("Cantidad necesaria: " + cantidadNec2);
                System.out.println("Cantidad financiada: " + cantidadFinanc2);
                System.out.println("Fecha inicio: " + fechaInicio2);
                System.out.println("Fecha fin: " + fechaFin2);
            } else if (seleccionInv == 3 && cantidadInvertida3 < 0) {
                System.out.println("Detalle del proyecto 3: ");
                System.out.println("Nombre: " + nombre3);
                System.out.println("Descripción: " + descripcion3);
                System.out.println("Categoría: " + categoria3);
                System.out.println("Cantidad necesaria: " + cantidadNec3);
                System.out.println("Cantidad financiada: " + cantidadFinanc3);
                System.out.println("Fecha inicio: " + fechaInicio3);
                System.out.println("Fecha fin: " + fechaFin3);
            }
        }
    }

    /**
     * Muestra los proyectos que hay disponibles para invertir en ellos.
     */
    public static void verProyectosInv2(){
        System.out.println("Proyectos disponibles: ");

        boolean hayProyectos = false;

        if (cantidadNec1 > 0){
            System.out.println("1. " + nombre1 + " | Categoria: " + categoria1 + " | Necesaria:" + cantidadNec1 + " | Financiada: " + cantidadFinanc1);
            hayProyectos = true;
        }
        if (cantidadNec2 > 0){
            System.out.println("2. " + nombre2 + " | Categoria: " + categoria2 + " | Necesaria:" + cantidadNec2 + " | Financiada: " + cantidadFinanc2);
            hayProyectos = true;
        }
        if (cantidadNec3 > 0){
            System.out.println("3. " + nombre3 + " | Categoria: " + categoria3 + " | Necesaria:" + cantidadNec3 + " | Financiada: " + cantidadFinanc3);
            hayProyectos = true;

        }

        if (!hayProyectos){
            System.out.println("No hay proyectos disponibles.");
        }else {

            System.out.println("Selecciona el proyecto que quieres ver en detalle (0 para volver): ");
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

                System.out.println("¿Deseas invertir en este proyecto? (si/no)");
                String respuesta = SC.nextLine();
                if (respuesta.equalsIgnoreCase("Si")) {
                    System.out.println("Cuanto deseas invertir");
                    double cantidad2 = SC.nextDouble();
                    if (cantidad2 <= saldoCartera2 && cantidad2 + cantidadFinanc1 <= cantidadNec1) {
                        saldoCartera2 -= cantidad2;
                        cantidadFinanc1 += cantidad2;
                        cantidadInvertida1 += cantidad2;
                        System.out.println("Inversión realizada");
                    } else {
                        System.out.println("No tienes suficiente saldo o el proyecto ya esta financidado");
                    }
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

                System.out.println("¿Deseas invertir en este proyecto? (si/no)");
                String respuesta = SC.nextLine();
                if (respuesta.equalsIgnoreCase("Si")) {
                    System.out.println("Cuanto deseas invertir");
                    double cantidad1 = SC.nextDouble();
                    if (cantidad1 <= saldoCartera1 && cantidad1 + cantidadFinanc2 <= cantidadNec2) {
                        saldoCartera1 -= cantidad1;
                        cantidadFinanc2 += cantidad1;
                        cantidadInvertida2 += cantidad1;
                        System.out.println("Inversión realizada");
                    } else {
                        System.out.println("No tienes suficiente saldo o el proyecto ya esta financidado");
                    }
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

                System.out.println("¿Deseas invertir en este proyecto? (si/no)");
                String respuesta = SC.nextLine();
                if (respuesta.equalsIgnoreCase("Si")) {
                    System.out.println("Cuanto deseas invertir");
                    double cantidad2 = SC.nextDouble();
                    if (cantidad2 <= saldoCartera1 && cantidad2 + cantidadFinanc3 <= cantidadNec3) {
                        saldoCartera2 -= cantidad2;
                        cantidadFinanc3 += cantidad2;
                        cantidadInvertida3 += cantidad2;
                        System.out.println("Inversión realizada");
                    } else {
                        System.out.println("No tienes suficiente saldo o el proyecto ya esta financidado");
                    }
                }
            }
        }
    }

    /**
     * Muestra el saldo que tiene y puede añadir mas saldo.
     */
    public static void carteraDigital2(){
        System.out.println("===CARTERA DIGITAL===");
        boolean salirCartera = false;

        while (!salirCartera){
            System.out.println("1. Ver saldo");
            System.out.println("2. Añadir saldo");
            System.out.println("3. Salir");

            int opcionCD = SC.nextInt();
            SC.nextLine();

            switch (opcionCD){
                case 1:
                    System.out.println("Saldo actual: " + saldoCartera2);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Introduce la cantidad de dinero que quieres introducir en la cartera digital: ");
                    double cantidadDinero2 = SC.nextDouble();


                    if (cantidadDinero2 > 0){
                        saldoCartera2 += cantidadDinero2;
                        System.out.println("Has añadido " + cantidadDinero2 + "a tu cartera digital.");
                        System.out.println("Tu nuevo saldo es de: " + saldoCartera2);
                    }else{
                        System.out.println("Debes de introducir un valor mayor que 0.");
                    }
                    break;

                case 3:
                    salirCartera = true;
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("Opción no válida. ");
                    break;
            }
        }
    }

    /**
     * Muestra la opcion de invitar a amigos.
     */
    public static void invitaAmigoInve2(){
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
    }

    /**
     * Muestra la configuracion de cambio de nombre y contraseña.
     */
    public static void inversor2Configuracion() {
        System.out.println("===CONFIGURACIÓN===");
        System.out.println("1. Cambiar el nombre de usuario");
        System.out.println("2. Cambiar contraseña");
        int opcionCambioInversor2 = SC.nextInt();
        SC.nextLine();

        switch (opcionCambioInversor2) {
            case 1:
                inversor2CambioUsuario();
            case 2:
                inversor2CambioContrasena();
            default:
                System.out.println("Opción no válida");
        }
    }

    public static void inversor2CambioUsuario(){
        System.out.println("Introduce el nuevo usuario");
        String nuevoUsuario = SC.nextLine();
        usuarioInversor2 = nuevoUsuario;
        System.out.println("El nombre de usuario ha sido cambiado");
    }

    public static void inversor2CambioContrasena(){
        System.out.println("Introduce la nueva contraseña");
        String nuevaContrasena = SC.nextLine();
        contraInversor2 = nuevaContrasena;
        System.out.println("La contraseña ha sido cambiada");
    }


}
