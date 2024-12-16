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

    String invitaAmigo1 = "";
    String invitaAmigo2 = "";

    double saldoCartera1 = 0.0;
    double saldoCartera2 = 0.0;

    static String proyecto1 = "", proyecto2 = "", proyecto3 = "";
    static String nombre1 = "", nombre2 = "", nombre3 = "";
    static String descripcion1 = "", descripcion2 = "", descripcion3 = "";
    static String categoria1 = "", categoria2 = "", categoria3 = "";
    static double cantidadNec1 = 0, cantidadNec2 = 0, cantidadNec3 = 0;
    static double cantidadInvertida1 = 0, cantidadInvertida2 = 0, cantidadInvertida3 = 0;
    static double cantidadFinanc1 = 0, cantidadFinanc2 = 0, cantidadFinanc3 = 0;
    static String fechaInicio1 = "", fechaInicio2 = "", fechaInicio3 = "";
    static String fechaFin1 = "", fechaFin2 = "", fechaFin3 = "";

    static int numProyectos = 0;

    static String recompensa1P1 = "", recompensa2P1 = "", recompensa3P1 = "";
    static String recompensa1P2 = "", recompensa2P2 = "", recompensa3P2 = "";
    static String recompensa1P3 = "", recompensa2P3 = "", recompensa3P3 = "";
    static String recompensaDesc1P1 = "", recompensaDesc2P1 = "",recompensaDesc3P1 = "";
    static String recompensaDesc1P2 = "", recompensaDesc2P2 = "",recompensaDesc3P2 = "";
    static String recompensaDesc1P3 = "", recompensaDesc2P3 = "",recompensaDesc3P3 = "";
    static double precioRecompensa1P1 = 0, precioRecompensa2P1 = 0, precioRecompensa3P1 = 0;
    static double precioRecompensa1P2 = 0, precioRecompensa2P2 = 0, precioRecompensa3P2 = 0;
    static double precioRecompensa1P3 = 0, precioRecompensa2P3 = 0, precioRecompensa3P3 = 0;


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

    public static  void bloqueoDesbloqueoGestor(){
        gestorBloqueado = !gestorBloqueado;
        System.out.println("El usuario a sido " + (gestorBloqueado ? "bloqueado" : "desbloqueado"));

    }

    public static  void bloqueoDesbloqueoInversor1(){
        inversor1Bloqueado = !inversor1Bloqueado;
        System.out.println("El usuario a sido " + (inversor1Bloqueado ? "bloqueado" : "desbloqueado"));
    }

    public static  void bloqueoDesbloqueoInversor2(){
        inversor2Bloqueado = !inversor2Bloqueado;
        System.out.println("El usuario a sido " + (inversor2Bloqueado ? "bloqueado" : "desbloqueado"));
    }

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
                modificaProyecto(seleccion);
            }else{
                System.out.println("Opcion no valida");
            }
            eliminarProyecto();
        }
    }

    public static void mostrarProyectos(){
        if (!proyecto1.equals("")) System.out.println("Proyecto 1: " + proyecto1);
        if (!proyecto2.equals("")) System.out.println("Proyecto 1: " + proyecto2);
        if (!proyecto3.equals("")) System.out.println("Proyecto 1: " + proyecto3);
    }

    public static void detallesProyecto(int seleccion){
        String nombre = "", descripcion = "", categoria = "", fechaInicio = "", fechaFin = "";
        double cantidadNec = 0, cantidadFinanc = 0;
        String recompensa1 = "", recompensa2 = "", recompensa3 = "";

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
    }

    public static void modificaProyecto(int seleccion) {
        System.out.println("¿Quieres modificar el proyecto 1?");
        String respuesta = SC.nextLine();
        if (respuesta.equalsIgnoreCase("S")) {
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
        }
    }

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

    public static void menuGestor(){
        System.out.println("\n=== MENÚ GESTOR ===");
        System.out.println("1. Crear proyecto");
        System.out.println("2. Ver mis proyectos");
        System.out.println("3. Eliminar proyecto");
        System.out.println("4. Configuracion");
        System.out.println("5. Cerrar sesión");
        System.out.println("Elige una opción");
        SC.nextLine();
    }

    public static void creacionProyecto(){

    }

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








    public static void menuInversor1(){
        System.out.println("\n=== MENÚ INVERSOR 1 ===");
        System.out.println("1. Mis inversiones");
        System.out.println("2. Proyectos");
        System.out.println("3. Cartera digital");
        System.out.println("4. Invita a un amigo");
        System.out.println("5. Configuración");
        System.out.println("6. Cerrar sesión");
        System.out.println("Elige una opción");
        SC.nextLine();
    }

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





    public static void menuInversor2(){
        System.out.println("\n=== MENÚ INVERSOR 2 ===");
        System.out.println("1. Mis inversiones");
        System.out.println("2. Proyectos");
        System.out.println("3. Cartera digital");
        System.out.println("4. Invita a un amigo");
        System.out.println("5. Configuración");
        System.out.println("6. Cerrar sesión");
        System.out.println("Elige una opción");
        SC.nextLine();
    }

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
