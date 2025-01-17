import static utilidades.funcionesCadenas.*;
import static utilidades.funcionesCorreos.*;

import java.util.Scanner;

public class fernanStarterT04 {

    static Scanner sc = new Scanner(System.in);

    static String[] usuarios = new String[10];
    static String[] contrasenas = new String[10];
    static String[] tipoUsuarios = new String[10];
    static boolean[] bloqueoUsuarios = new boolean[10];
    static boolean[] correoValido = new boolean[10];
    static double[] saldoUsuarios = new double[10];
    static String[][] amigosUsuarios = new String[10][10];
    static int[] numAmigos = new int[10];
    static int[] intentosFallidos = new int[10];
    static int cantidadUsarios = 0;

    static String[] proyectos = new String[20];
    static String[] nombresProyecto = new String[20];
    static String[] descripcionProyectos = new String[20];
    static String[] categoriaProyectos = new String[20];
    static double[] cantidadNecesarias = new double[20];
    static double[] cantidadFinanciadas = new double[20];
    static String[] fechaInicio = new String[20];
    static String[] fechaFin = new String[20];

    static String[][] recompensas = new String[20][3];
    static String[][] descripcionRecompensas = new String[20][3];
    static double[][] preciosRecompensas = new double[20][3];

    static String[][] inversiones = new String[20][3];

    static int cantidadProyectos = 0;

    public static void main(String[] args) {
        crearUsuario();

        while (true) {
            System.out.println("\n=== SISTEMA DE LOGIN ===");
            System.out.println("1. Iniciar sesión. ");
            System.out.println("2. Registrarse. ");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            if (opcion == 1) {
                inicioSesion();
            } else if (opcion == 2) {
                registrarUsario();
            } else {
                System.out.println("Opción no válida");
            }
        }
    }

    static int inicioUsuario = -1;

    public static void inicioSesion() {
        System.out.print("Usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = sc.nextLine();

        boolean accesoValido = false;
        inicioUsuario = -1;

        for (int i = 0; i < cantidadUsarios; i++) {
            if (usuarios[i].equals(usuario)){
                if (bloqueoUsuarios[i]){
                    System.out.println("Tu cuenta a sido bloqueada porque has superado el número de intentos. ");
                    return;
                }
                if (contrasenaIguales(contrasenas[i], contrasena)) {
                    inicioUsuario = i;
                    accesoValido = true;
                    break;
                }else{
                    intentosFallidos[i]++;
                    if (intentosFallidos[i] >= 3){
                        bloqueoUsuarios[i] = true;
                        System.out.println("Contraseña incorrecta, Tu cuenta a sido bloqueada, porque has superado el número de intentos. ");
                        return;
                    }else{
                        System.out.println("Contraseña incorrecta. Te quedan" + (3 - intentosFallidos[i]) + " intentos. ");
                    }
                }
            }
        }

        if (accesoValido) {
            if (tipoUsuarios[inicioUsuario].equals("Administrador")) {
                System.out.println("Acceso concedido");
                menuAdministrador();
            } else if (tipoUsuarios[inicioUsuario].equals("Gestor")) {
                System.out.println("Acceso concedido");
                menuGestor();
            }else if (tipoUsuarios[inicioUsuario].equals("Inversor")) {
                System.out.println("Acceso concedido");
                menuInversor();
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }
    }

    public static void registrarUsario() {
        System.out.print("Nombre de usuario: ");
        String nuevoUsuario = sc.nextLine();
        System.out.print("Contraseña: ");
        String nuevaContrasena = sc.nextLine();
        System.out.print("Repetir contraseña: ");
        String repetirContrasena = sc.nextLine();

        if (!contrasenaIguales(nuevaContrasena, repetirContrasena)) {
            System.out.println("Las constraseñas no coinciden");
            return;
        }

        if (!esContrasenaFuerte(nuevaContrasena)) {
            System.out.println("La contraseña no es suficientemente fuerte.");
            return;
        }

        System.out.println("Tipo de usuario (Gestor o Inversor): ");
        String tipoUsuario = sc.nextLine();

        if (!tipoUsuario.equals("Gestor") && !tipoUsuario.equals("Inversor")) {
            System.out.println("Solo los gestores e inversores pueden registrarse");
            return;
        }

        int codigoVerificacion = (int) (Math.random() * 10000);
        String asunto = "Verificación para registrarse";
        String cuerpo = "<h1>Gracias por registrarte. Tu código de verificación es:</h1>" +
                        "<p><strong>Código: " + codigoVerificacion + "</strong></h1>";

        enviarConGMail("paablo.quesada@gmail.com", asunto, cuerpo);



        if (cantidadUsarios < usuarios.length) {
            usuarios[cantidadUsarios] = nuevoUsuario;
            contrasenas[cantidadUsarios] = nuevaContrasena;
            tipoUsuarios[cantidadUsarios] = tipoUsuario;
            bloqueoUsuarios[cantidadUsarios] =false;
            correoValido[cantidadUsarios] = false;
            cantidadUsarios++;

            System.out.println("Usuario registrado. Se envió un correo con un código para verificarlo, para poder iniciar sesión. ");
            System.out.println("Introduce el código de verificación que se envió al correo: ");
            int codigoIntroducido = sc.nextInt();

            if (codigoIntroducido == codigoVerificacion){
                correoValido[cantidadUsarios - 1] = true;
                System.out.println("Correo verificado con éxito. ");
            } else{
                System.out.println("Codigo incorrecto. El proceso de resgistro no se completo correctamente");
            }
        } else {
            System.out.println("No hay espacio para más usuarios");
        }
    }

    public static void crearUsuario() {
        usuarios[0] = "administrador";
        contrasenas[0] = "admin123";
        tipoUsuarios[0] = "Administrador";
        bloqueoUsuarios[0] = false;

        usuarios[1] = "gestor";
        contrasenas[1] = "gestor123";
        tipoUsuarios[1] = "Gestor";
        bloqueoUsuarios[1] = false;

        bloqueoUsuarios[2] = false;
        usuarios[2] = "inversor";
        contrasenas[2] = "inversor123";
        tipoUsuarios[2] = "Inversor";

        cantidadUsarios = 3;
    }


    public static void menuAdministrador() {
        while (true){
            System.out.println("\n=== MENÚ ADMINISTRADOR ===");
            System.out.println("1. Panel de control");
            System.out.println("2. Proyectos");
            System.out.println("3. Configuración");
            System.out.println("4. Cerrar sesión");
            System.out.print("Elige una opción: ");
            int opcionAdmin = sc.nextInt();
            sc.nextLine();

            switch (opcionAdmin) {
                case 1:
                    panelControlUsuarios();
                    break;
                case 2:
                    dirigirProyecto();
                    break;
                case 3:
                    usuariosConfiguracion();
                    break;
                case 4:
                    System.out.println("Cerrando sesión...");
                    return;
            }
        }
    }



    public static void panelControlUsuarios(){
        System.out.println("===PANEL DE CONTROL===");
        System.out.println("1. Bloquear o desbloquear Usuarios. ");
        System.out.println("2. Salir. ");
        System.out.println("Elige una opción: ");
        int opcionBloDes = sc.nextInt();
        sc.nextLine();

        switch (opcionBloDes){
            case 1:
                bloqueoDesbloqueoUsuarios();
                break;
            case 2:
                System.out.println("Saliendo del panel de control...");
                break;
            default:
                System.out.println("Opcion no válida");
                break;
        }
    }

    public static void bloqueoDesbloqueoUsuarios(){
        System.out.println("Selecciona el usuario que deseas bloquear o desbloquear: ");
        for (int i = 0; i < cantidadUsarios; i++) {
            if (!usuarios[i].equals("administrador")){
                System.out.println((i + 1) + ". " + usuarios[i]);
            }
        }

        int seleccion =sc.nextInt();
        sc.nextLine();

        if (seleccion >= 1 && seleccion <= cantidadUsarios){
            int indexUsuario = seleccion - 1;
            bloqueoUsuarios[indexUsuario] = !bloqueoUsuarios[indexUsuario];
            System.out.println("El usuario" + usuarios[indexUsuario] + " ha sido " +
                    (bloqueoUsuarios[indexUsuario] ? "bloqueado" : "desbloqueado"));
        }
    }

    public static void dirigirProyecto(){

        System.out.println("===PROYECTOS===");
        if (cantidadProyectos == 0) {
            System.out.println("No hay proyectos creados");
        }else{
            mostrarProyecto();
            System.out.println("Selecciona el proyecto que quieres ver en detalle " + cantidadProyectos + ":");
            int seleccion = sc.nextInt();
            sc.nextLine();

            if (seleccion >= 1 && seleccion <= 20){
                destalleModificaProyecto(seleccion - 1);
            }else{
                System.out.println("Opcion no valida");
            }
        }
    }

    public static void mostrarProyecto(){
        if (cantidadProyectos == 0) {
            System.out.println("No hay proyectos creados. ");
        }else{
            for (int i = 0; i < cantidadProyectos; i++) {
                System.out.println("Proyecto: " + (i + 1) + "Nombre: " + nombresProyecto[i]
                        + "//// Descripción: " + descripcionProyectos[i]
                        + "//// Categoría: " + categoriaProyectos[i]
                        + "//// Cantidad necesaria: " + cantidadNecesarias[i]
                        + "//// Cantidad financiada: " + cantidadFinanciadas[i]
                        + "//// Fecha inicio: " + fechaInicio[i]
                        + "//// Fecha fin: " + fechaFin[i]);
            }
        }
    }

    public static void destalleModificaProyecto(int seleccion){
            System.out.println("===DETALLE DEL PROYECTO===");
            System.out.println("Nombre: " + nombresProyecto[seleccion]);
            System.out.println("Descripción: " + descripcionProyectos[seleccion]);
            System.out.println("Categoría: " + categoriaProyectos[seleccion]);
            System.out.println("Cantidad necesaria: " + cantidadNecesarias[seleccion]);
            System.out.println("Cantidad financiada: " + cantidadFinanciadas[seleccion]);
            System.out.println("Fecha inicio: " + fechaInicio[seleccion]);
            System.out.println("Fecha fin: " + fechaFin[seleccion]);
            System.out.println("==================================");
        System.out.println("¿Quieres modificar el proyecto" + seleccion + "? (S/N)");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("Si")) {
            modificaProyecto(seleccion);
        }
    }

    public static void modificaProyecto(int seleccion){
        System.out.println("Introduce el nuevo nombre del proyecto: ");
        nombresProyecto[seleccion] = sc.nextLine();
        System.out.println("Introduce la nueva descripcion del proyecto: ");
        descripcionProyectos[seleccion] = sc.nextLine();
        System.out.println("Introduce la nueva categoría (arte, tecnología, cine, música, juegos, comida, moda…)");
        categoriaProyectos[seleccion] = sc.nextLine();
        System.out.println("Introduce la nueva antidad necesaria del proyectos");
        cantidadNecesarias[seleccion] = sc.nextDouble();
        System.out.println("Introduce la nueva cantidad financiada hasta el momento");
        cantidadFinanciadas[seleccion] = sc.nextDouble();
        sc.nextLine();
        System.out.println("Introduce la nueva fecha inicio de las inversiones ");
        fechaInicio[seleccion] = sc.nextLine();
        System.out.println("Introduce la nueva fecha fin de cierre de las inversiones ");
        fechaFin[seleccion] = sc.nextLine();

        System.out.println("Proyecto " + (seleccion + 1) + " modificado. ");

    }



    public static void menuGestor(){
        while (true){
            System.out.println("\n=== MENÚ GESTOR ===");
            System.out.println("1. Crear proyecto");
            System.out.println("2. Ver mis proyectos");
            System.out.println("3. Eliminar proyecto");
            System.out.println("4. Configuracion");
            System.out.println("5. Cerrar sesión");
            System.out.print("Elige una opción: ");

            int opcionGestor = sc.nextInt();
            sc.nextLine();

            switch (opcionGestor) {
                case 1:
                    creacionProyecto();
                    break;
                case 2:
                    dirigirProyecto();
                    break;
                case 3:
                    eliminarProyecto();
                    break;
                case 4:
                    usuariosConfiguracion();
                    break;
                case 5:
                    System.out.println("Cerrando sesión...");
                    return;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    /**
     * Muestra la creacion de proyectos, hasta 3 proyectos maximo.
     */
    public static void creacionProyecto() {
        if (cantidadProyectos < 20) {
            System.out.println("Nombre del proyecto: ");
            nombresProyecto[cantidadProyectos] = sc.nextLine();
            System.out.println("Descripcion del proyecto: ");
            descripcionProyectos[cantidadProyectos] = sc.nextLine();
            System.out.println("Categoría (arte, tecnología, cine, música, juegos, comida, moda…)");
            categoriaProyectos[cantidadProyectos] = sc.nextLine();
            System.out.println("Cantidad necesaria ");
            cantidadNecesarias[cantidadProyectos] = sc.nextDouble();
            System.out.println("Cantidad financiada hasta el momento");
            cantidadFinanciadas[cantidadProyectos] = sc.nextDouble();
            sc.nextLine();
            System.out.println("Fecha inicio de apertura para recibir inversiones ");
            fechaInicio[cantidadProyectos] = sc.nextLine();
            System.out.println("Fecha fin de cierre de las inversiones ");
            fechaFin[cantidadProyectos] = sc.nextLine();

            for (int i = 0; i < 3; i++) {
                System.out.println("Introduce nombre de la recompensa #" + (i + 1) + ": ");
                recompensas[cantidadProyectos][i] = sc.nextLine();
                System.out.println("Descripción de la recompensa #" + (i + 1) + ": ");
                descripcionRecompensas[cantidadProyectos][i] = sc.nextLine();
                System.out.println("Precio de la recompensa #" + (i + 1) + ": ");
                preciosRecompensas[cantidadProyectos][i] = sc.nextDouble();
                sc.nextLine();
            }
            cantidadProyectos++;
            System.out.println("Proyecto creado con éxito. ");
        }else{
            System.out.println("Has alcanzado el límite de proyectos");
        }
    }

    public static void eliminarProyecto(){
        System.out.println("Introduce el numero de proyecto que deseas eliminar ( " + cantidadProyectos + " )");
        int eliminarProyecto = sc.nextInt();
        sc.nextLine();

        if (eliminarProyecto > 0 && eliminarProyecto <= cantidadProyectos) {
            for (int i = eliminarProyecto - 1; i < cantidadProyectos - 1; i++) {
                proyectos[i] = proyectos[i + 1];
                nombresProyecto[i] = nombresProyecto[i + 1];
                descripcionProyectos[i] = descripcionProyectos[i + 1];
                categoriaProyectos[i] = categoriaProyectos[i + 1];
                cantidadNecesarias[i] = cantidadNecesarias[i + 1];
                cantidadFinanciadas[i] = cantidadFinanciadas[i + 1];
                fechaInicio[i] = fechaInicio[i + 1];
                fechaFin[i] = fechaFin[i + 1];
            }
            cantidadProyectos--;

            System.out.println("Proyecto " + eliminarProyecto + " eliminado. ");
        }else{
            System.out.println("Número de proyecto no válido");
        }
    }









    public static void menuInversor(){
        while (true){
            System.out.println("\n=== MENÚ INVERSOR ===");
            System.out.println("1. Mis inversiones. ");
            System.out.println("2. Proyectos. ");
            System.out.println("3. Cartera digital. ");
            System.out.println("4. Invita a un amigo. ");
            System.out.println("5. Configuración. ");
            System.out.println("6. Cerrar sesión. ");
            System.out.print("Elige una opción: ");
            int opcionInversor = sc.nextInt();
            sc.nextLine();

            switch (opcionInversor) {
                case 1:
                    misInversiones(inicioUsuario);
                    break;
                case 2:
                    verProyectos(inicioUsuario);
                    break;
                case 3:
                    carteraDigital(inicioUsuario);
                    break;
                case 4:
                    invitaAmigo(inicioUsuario);
                    break;
                case 5:
                    usuariosConfiguracion();
                    break;
                case 6:
                    System.out.println("Cerrando sesión...");
                    return;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public static void misInversiones(int indexUsuario){
        System.out.println("===MIS INVERSIONES===");
        boolean tieneInversiones = false;
        for (int i = 0; i < cantidadProyectos; i++) {
            if (inversiones[i][indexUsuario] != null){
                tieneInversiones = true;
                System.out.println("Proyecto: " + nombresProyecto[i]);
                System.out.println("Categoría:  " + categoriaProyectos[i]);
                System.out.println("Cantidad Invertida " + inversiones[i][indexUsuario]);
                System.out.println("====================================");
            }
        }
        if (!tieneInversiones) {
            System.out.println("No has realizado inversiones. ");
        }else{
            System.out.println("Elige un proyecto para verlo en detalles (0 para salir)");
            int seleccion = sc.nextInt();
            sc.nextLine();
            if (seleccion > 0 && seleccion <= cantidadProyectos){
                detalleProyecto(seleccion - 1);
            }
        }
    }

    public static void detalleProyecto(int indexProyecto){
        System.out.println("===DETALLE DEL PROYECTO===");
        System.out.println("Nombre: " + nombresProyecto[indexProyecto]);
        System.out.println("Descripción: " + descripcionProyectos[indexProyecto]);
        System.out.println("Categoría: " + categoriaProyectos[indexProyecto]);
        System.out.println("Cantidad necesaria: " + cantidadNecesarias[indexProyecto]);
        System.out.println("Cantidad financiada: " + cantidadFinanciadas[indexProyecto]);
        System.out.println("Fecha inicio: " + fechaInicio[indexProyecto]);
        System.out.println("Fecha fin: " + fechaFin[indexProyecto]);
        System.out.println("==================================");
    }

    public static void verProyectos(int indexProyecto){
        System.out.println("===DETALLE DEL PROYECTO===");
        for (int i = 0; i < cantidadProyectos; i++) {
            System.out.println("Nombre: " + nombresProyecto[i]);
            System.out.println("Descripción: " + descripcionProyectos[i]);
            System.out.println("Categoría: " + categoriaProyectos[i]);
            System.out.println("Cantidad necesaria: " + cantidadNecesarias[i]);
            System.out.println("Cantidad financiada: " + cantidadFinanciadas[i]);
            System.out.println("Fecha inicio: " + fechaInicio[i]);
            System.out.println("Fecha fin: " + fechaFin[i]);
            System.out.println("==================================");
        }

        System.out.println("Elige una opcion para invertir en un proyecto: ");
        int seleccionProyecto = sc.nextInt();
        sc.nextLine();

        if(seleccionProyecto >= 1 && seleccionProyecto <= cantidadProyectos){
            System.out.println("¿Deseas invertir en este proyecto?");
            String respuesta = sc.nextLine().toLowerCase();
            if (respuesta.equalsIgnoreCase("Si")) {
                System.out.println("Cuanto deseas invertir");
                double cantidadInversion = sc.nextDouble();
                if (cantidadInversion > 0 && cantidadInversion <= saldoUsuarios[inicioUsuario]) {
                    inversiones[indexProyecto][inicioUsuario] = String.valueOf(cantidadInversion);
                    saldoUsuarios[inicioUsuario] -= cantidadInversion;
                    cantidadFinanciadas[indexProyecto] += cantidadInversion;
                    System.out.println("Inversión realizada. Has invertido " + cantidadInversion + " en el proyecto: " + nombresProyecto[indexProyecto]);
                } else {
                    System.out.println("No tienes suficiente saldo o el proyecto ya esta financidado");
                }
            }else{
                System.out.println("No se realizó la inversión.");
            }
        }
    }

    public static void carteraDigital(int indexUsuario){
        System.out.println("===CARTERA DIGITAL===");
        boolean salirCartera = false;

        while (!salirCartera){
            System.out.println("1. Ver saldo");
            System.out.println("2. Añadir saldo");
            System.out.println("3. Salir");

            int opcionCD = sc.nextInt();
            sc.nextLine();

            switch (opcionCD){
                case 1:
                    System.out.println("Saldo actual: " + saldoUsuarios[indexUsuario]);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Introduce la cantidad de dinero que quieres introducir en la cartera digital: ");
                    double cantidadDinero = sc.nextDouble();


                    if (cantidadDinero > 0){
                        saldoUsuarios[indexUsuario] += cantidadDinero;
                        System.out.println("Has añadido " + cantidadDinero + "a tu cartera digital.");
                        System.out.println("Tu nuevo saldo es de: " + saldoUsuarios[indexUsuario]);
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


    public static void invitaAmigo(int indexUsuario){
        System.out.println("===INVITA A TUS AMIGOS===");
        System.out.println("Lista de amigos: ");
        if (numAmigos[indexUsuario] == 0){
            System.out.println("No tienes ningún amigo añadido");
        }else{
            for (int i = 0; i < numAmigos[indexUsuario]; i++) {
                System.out.println(amigosUsuarios[indexUsuario][i]);
            }
        }
        System.out.println("Introduce el correo electrónico de un amigo para añadirlo a la lista de amigos: ");
        String nuevoAmigo = sc.nextLine();

        if (numAmigos[indexUsuario] < amigosUsuarios[indexUsuario].length) {
            boolean yaEsAmigo = false;
            for (int i = 0; i < numAmigos[indexUsuario]; i++) {
                if (amigosUsuarios[indexUsuario][i].equals(nuevoAmigo)) {
                    yaEsAmigo = true;
                    break;
                }
            }
            if (yaEsAmigo){
                System.out.println("Este correo ya está en tu lista de amigos. ");
            }else{
                amigosUsuarios[indexUsuario][numAmigos[indexUsuario]] = nuevoAmigo;
                numAmigos[indexUsuario]++;
                System.out.println("Amigo añadido.");
            }
        }else{
            System.out.println("Has alcanzado el número límite máximo de amigos.");
        }
    }



    public static void usuariosConfiguracion(){
        System.out.println("===CONFIGURACIÓN===");
        System.out.println("1. Cambiar el nombre de usuario. ");
        System.out.println("2. Cambiar contraseña. ");
        System.out.println("3. Salir. ");
        int opcionCambioGestor = sc.nextInt();
        sc.nextLine();

        switch (opcionCambioGestor){
            case 1: usuariosCambioUsuario();
                break;
            case 2: UsuariosCambioContrasena();
                break;
            case 3:
                System.out.println("Saliendo de configuración...");
                break;
            default: System.out.println("Opción no válida");
        }
    }

    public static void usuariosCambioUsuario(){
        System.out.println("Introduce el nuevo usuario");
        String nuevoUsuario = sc.nextLine();
        usuarios[inicioUsuario] = nuevoUsuario;
        System.out.println("El nombre de usuario ha sido cambiado");
    }

    public static void UsuariosCambioContrasena(){
        System.out.println("Introduce la nueva contraseña");
        String nuevaContrasena = sc.nextLine();
        if (esContrasenaFuerte(nuevaContrasena)) {
            contrasenas[inicioUsuario] = nuevaContrasena;
            System.out.println("La contraseña ha sido cambiada");
        }else{
            System.out.println("La contraseña no es lo suficientemente fuerte.");
        }
    }
}


