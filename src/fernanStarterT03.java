import java.util.Scanner;

import static bibliotecaT03.utilidades.*;


public class fernanStarterT03 {



    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        boolean salir = false;

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
                    menuAdministrador();
                    int opcionAdmin = SC.nextInt();
                    SC.nextLine();

                    switch (opcionAdmin) {
                        case 1:
                            panelControlUsuarios();
                            break;
                        case 2:
                            dirigirProyecto();
                            break;
                        case 3:
                            admConfiguracion();
                            break;
                        case 4:
                            salirAdmin = true;
                            System.out.println("Cerrando sesión...");
                            break;
                    }
                }
            } else if (usuario.equals(usuarioGestor)) {
                if (gestorBloqueado){
                    System.out.println("La cuenta del gestor está bloqueada");
                }else{
                    if (intentosGestor < 3) {
                        if (contrasena.equals(contraGestor)) {
                            System.out.println("Contraseña correcta. ");
                            boolean salirGestor = false;
                            while (!salirGestor) {
                                menuGestor();
                                int opcionGestor = SC.nextInt();
                                SC.nextLine();

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
                                        gestorConfiguracion();
                                        break;
                                    case 5:
                                        salirGestor = true;
                                        System.out.println("Cerrando sesión...");
                                        break;
                                    default:
                                        System.out.println("opcion no válida");
                                        break;
                                }
                            }
                        } else {
                            intentosGestor++;
                            System.out.println("Contraseña incorrecta. Intentos restantes: " + (3 - intentosGestor));
                            if (intentosGestor == 3) {
                                gestorBloqueado = true;
                                System.out.println("Has superado el limite de intentos. La cuenta está bloqueada");

                            }
                        }
                    }
                }
            } else if (usuario.equals(usuarioInversor1)) {
                if (intentosInversor1 < 3) {
                    if (contrasena.equals(contraInversor1)) {
                        System.out.println("Contraseña correcta. ");
                        boolean salirinversor1 = false;
                        while (!salirinversor1) {
                            menuInversor1();
                            int opcionInversor1 = SC.nextInt();
                            SC.nextLine();
                            switch (opcionInversor1) {
                                case 1:
                                    misInversiones1();
                                    break;
                                case 2:
                                    verProyectosInv1();
                                    break;
                                case 3:
                                    carteraDigital1();
                                    break;
                                case 4:
                                    invitaAmigoInv1();
                                    break;
                                case 5:
                                    inversor1Configuracion();
                                    break;
                                case 6:
                                    salirinversor1 = true;
                                    System.out.println("Cerrando sesión...");
                                    break;
                                default:
                                    System.out.println("opcion no válida");
                                    break;
                            }
                        }
                        inversor1Bloqueado = true;
                    } else {
                        intentosInversor1++;
                        System.out.println("Contraseña incorrecta. Intentos restantes: " + (3 - intentosInversor1));
                        if (intentosInversor1 == 3) {
                            inversor1Bloqueado= true;
                            System.out.println("Has superado el limite de intentos. La cuenta está bloqueada");
                        }
                    }
                }
            } else if (usuario.equals(usuarioInversor2)) {
                if (intentosInversor2 < 3) {
                    if (contrasena.equals(contraInversor2)) {
                        System.out.println("Contraseña correcta. ");
                        boolean salirInversor2 = false;
                        while (!salirInversor2) {
                            menuInversor2();
                            int opcionInversor2 = SC.nextInt();
                            SC.nextLine();
                            switch (opcionInversor2) {
                                case 1:
                                    misInversiones2();
                                    break;
                                case 2:
                                    verProyectosInv2();
                                    break;
                                case 3:
                                    carteraDigital2();
                                    break;
                                case 4:
                                    invitaAmigoInve2();
                                    break;
                                case 5:
                                    inversor2Configuracion();
                                    break;
                                case 6:
                                    salirInversor2 = true;
                                    System.out.println("Cerrando sesión...");
                                    break;
                                default:
                                    System.out.println("opcion no válida");
                                    break;
                            }
                        }
                    } else {
                        intentosInversor2++;
                        System.out.println("Contraseña incorrecta. Intentos restantes: " + (3 - intentosInversor2));
                        if (intentosInversor2 == 3) {
                            inversor2Bloqueado = true;
                            System.out.println("Has superado el limite de intentos. La cuenta está bloqueada");
                        }
                    }
                }
            } else {
                System.out.println("Usuario o contraseña incorrectos. ");
            }
        }
    }
}
