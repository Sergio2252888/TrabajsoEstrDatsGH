import java.util.Scanner;

public class Parte3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Punto 25 - Ingresa un texto largo para invertirlo: ");
        String texto25 = scanner.nextLine();
        System.out.println("Texto invertido: " + invertirTexto(texto25));

        System.out.print("\nPunto 26 - Ingresa un texto para poner mayusculas: ");
        String texto26 = scanner.nextLine();
        String resultado26 = "";
        boolean esPrimeraLetra = true;
        for (int i = 0; i < texto26.length(); i++) {
            char letra = texto26.charAt(i);
            if (letra == ' ') {
                resultado26 = resultado26 + letra;
                esPrimeraLetra = true;
            } else if (esPrimeraLetra) {
                resultado26 = resultado26 + Character.toUpperCase(letra);
                esPrimeraLetra = false;
            } else {
                resultado26 = resultado26 + letra;
            }
        }
        System.out.println("Texto modificado: " + resultado26);

        System.out.print("\nPunto 27 - Ingresa un texto para buscar la penultima palabra: ");
        String texto27 = scanner.nextLine();
        String[] palabras = texto27.split(" ");
        if (palabras.length >= 2) {
            System.out.println("La penultima palabra es: " + palabras[palabras.length - 2]);
        } else {
            System.out.println("El texto no tiene suficientes palabras.");
        }

        System.out.print("\nPunto 28 - Ingresa el primer texto (el que vamos a buscar): ");
        String textoA = scanner.nextLine();
        System.out.print("Ingresa el segundo texto (donde vamos a buscar): ");
        String textoB = scanner.nextLine();
        if (textoB.contains(textoA)) {
            System.out.println("El segundo texto SI contiene al primero.");
        } else {
            System.out.println("El segundo texto NO contiene al primero.");
        }

        System.out.print("\nPunto 29 - Ingresa una palabra para saber si es palindromo: ");
        String palabra = scanner.next();
        if (esPalindromo(palabra)) {
            System.out.println("SI es palindromo.");
        } else {
            System.out.println("NO es palindromo.");
        }

        System.out.print("\nPunto 30 - Area de un poligono regular. Ingresa el perimetro: ");
        double perimetro = scanner.nextDouble();
        System.out.print("Ingresa el apotema: ");
        double apotema = scanner.nextDouble();
        System.out.println("El area del poligono es: " + areaPoligono(perimetro, apotema));

        scanner.close();
    }

    public static String invertirTexto(String texto) {
        String invertido = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            invertido = invertido + texto.charAt(i);
        }
        return invertido;
    }

    public static boolean esPalindromo(String palabra) {
        String palabraLimpia = palabra.toLowerCase();
        int inicio = 0;
        int fin = palabraLimpia.length() - 1;
        while (inicio < fin) {
            if (palabraLimpia.charAt(inicio) != palabraLimpia.charAt(fin)) {
                return false;
            }
            inicio++;
            fin--;
        }
        return true;
    }

    public static double areaPoligono(double perimetro, double apotema) {
        return (perimetro * apotema) / 2.0;
    }
}
