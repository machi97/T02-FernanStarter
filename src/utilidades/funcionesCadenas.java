package utilidades;

public class funcionesCadenas {
    public static boolean contrasenaIguales(String contrasena1, String contrasena2){
        return contrasena1.equals(contrasena2);
    }

    public static boolean esContrasenaFuerte(String contrasena){
        if (contrasena.length() < 8){
            return false;
        }

        boolean tieneMinuscula = false;
        boolean tieneMayuscula = false;
        boolean tieneNumero = false;
        boolean tieneSimbolo = false;

        for (int i = 0; i < contrasena.length(); i++) {
            char c = contrasena.charAt(i);
            if (Character.isLowerCase(c)) tieneMayuscula = true;
            if (Character.isUpperCase(c)) tieneMinuscula = true;
            if (Character.isDigit(c)) tieneNumero = true;
            if (esSimbolo(c)) tieneSimbolo = true;
        }
        return tieneMinuscula && tieneMayuscula && tieneNumero && tieneSimbolo;
    }

    public static boolean esSimbolo(char c){
        return "-_.,*+@".indexOf(c) >= 0;
    }

    public static boolean esContrasenaValida(String texto, int min, int max){
        int longitud = texto.length();
        return longitud >= min && longitud <= max;
    }

    public static boolean esFormatoValido(String texto, String simbolo){
        return texto.contains(simbolo);
    }
}
