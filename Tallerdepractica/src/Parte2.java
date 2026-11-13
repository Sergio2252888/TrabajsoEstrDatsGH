import java.util.Scanner;

public class Parte2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 15.
        System.out.print("Punto 15 - Ingresa un numero para saber si es par o impar: ");
        int num15 = scanner.nextInt();
        if (num15 % 2 == 0) {
            System.out.println("El numero es par.");
        } else {
            System.out.println("El numero es impar.");
        }

        // 16.
        System.out.print("\nPunto 16 - Ingresa un numero para saber su signo: ");
        int num16 = scanner.nextInt();
        if (num16 > 0) {
            System.out.println("Es positivo.");
        } else if (num16 < 0) {
            System.out.println("Es negativo.");
        } else {
            System.out.println("El numero es cero.");
        }

        // 17.
        System.out.print("\nPunto 17 - Ingresa el precio bruto de la venta: ");
        double venta = scanner.nextDouble();
        double precioConIva = calcularIVA(venta); // Llama a la funcion de abajo
        if (precioConIva > 150000) {
            double descuento = precioConIva * 0.05;
            double precioFinal = precioConIva - descuento;
            System.out.println("¡Aplica descuento del 5%! Descuento: $" + descuento);
            System.out.println("Total a pagar con descuento: $" + precioFinal);
        }

        // 18.
        System.out.print("\nPunto 18 - Ingresa 5 notas separadas por espacio: ");
        double n1 = scanner.nextDouble();
        double n2 = scanner.nextDouble();
        double n3 = scanner.nextDouble();
        double n4 = scanner.nextDouble();
        double n5 = scanner.nextDouble();
        double notaFinal = calcularPromedio(n1, n2, n3, n4, n5);
        System.out.println("Nota final: " + notaFinal);

        if (notaFinal < 2.0) {
            System.out.println("No puede habilitar.");
        } else if (notaFinal < 3.0) {
            System.out.println("Reprobo.");
        } else if (notaFinal >= 3.0 && notaFinal <= 4.5) {
            System.out.println("Aprobo.");
        } else if (notaFinal > 4.5) {
            System.out.println("Aprobo. ¡Felicitaciones al estudiante!");
        }

        // 19.
        System.out.print("\nPunto 19 - Ecuacion cuadratica. Ingresa a, b y c (separados por espacio): ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        resolverCuadratica(a, b, c);

        // 20.
        System.out.print("\nPunto 20 - Ingresa usuario: ");
        String usuario = scanner.next();
        System.out.print("Ingresa contrasena: ");
        String contrasena = scanner.next();

        if (usuario.equals("carlos") && contrasena.equals("1234")) {
            System.out.println("Acceso concedido. Bienvenido.");
        } else {
            System.out.println("Acceso denegado. Usuario o contrasena incorrectos.");
        }

        // 21.
        System.out.print("\nPunto 21 - Ingresa un numero entre 0 y 10: ");
        int num21 = scanner.nextInt();
        switch (num21) {
            case 0: System.out.println("CERO"); break;
            case 1: System.out.println("UNO"); break;
            case 2: System.out.println("DOS"); break;
            case 3: System.out.println("TRES"); break;
            case 4: System.out.println("CUATRO"); break;
            case 5: System.out.println("CINCO"); break;
            case 6: System.out.println("SEIS"); break;
            case 7: System.out.println("SIETE"); break;
            case 8: System.out.println("OCHO"); break;
            case 9: System.out.println("NUEVE"); break;
            case 10: System.out.println("DIEZ"); break;
            default: System.out.println("Numero fuera de rango.");
        }

        // 22.
        System.out.print("\nPunto 22 - Ingresa un numero menor a 100.000: ");
        int num22 = scanner.nextInt();
        if (num22 < 10) {
            System.out.println("Tiene 1 digito.");
        } else if (num22 < 100) {
            System.out.println("Tiene 2 digitos.");
        } else if (num22 < 1000) {
            System.out.println("Tiene 3 digitos.");
        } else if (num22 < 10000) {
            System.out.println("Tiene 4 digitos.");
        } else {
            System.out.println("Tiene 5 digitos.");
        }

        // 23.
        System.out.print("\nPunto 23 - Ingresa 3 numeros separados por espacio: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        if (x < y && y < z) {
            System.out.println("Esta incrementando.");
        } else if (x > y && y > z) {
            System.out.println("Esta disminuyendo.");
        } else {
            System.out.println("Ni se incrementa ni se disminuye.");
        }

        // 24.
        System.out.print("\nPunto 24 - Ingresa numero del dia de la semana (1-7): ");
        int dia = scanner.nextInt();
        switch (dia) {
            case 1: System.out.println("Lunes"); break;
            case 2: System.out.println("Martes"); break;
            case 3: System.out.println("Miercoles"); break;
            case 4: System.out.println("Jueves"); break;
            case 5: System.out.println("Viernes"); break;
            case 6: System.out.println("Sabado"); break;
            case 7: System.out.println("Domingo"); break;
            default: System.out.println("Dia no valido.");
        }

        scanner.close();
    }

    // Funciones requeridas
    public static double calcularIVA(double precioBruto) {
        double iva = precioBruto * 0.19;
        return precioBruto + iva;
    }

    public static double calcularPromedio(double n1, double n2, double n3, double n4, double n5) {
        return (n1 * 0.15) + (n2 * 0.20) + (n3 * 0.15) + (n4 * 0.30) + (n5 * 0.20);
    }

    // Funcion primitiva para la ecuacion cuadratica
    public static void resolverCuadratica(double a, double b, double c) {
        double discriminante = (b * b) - (4 * a * c);

        if (discriminante < 0) {
            System.out.println("La ecuacion no tiene soluciones reales (raices negativas).");
        } else if (discriminante == 0) {
            double raizUnica = -b / (2 * a);
            System.out.println("Tiene una unica solucion: " + raizUnica);
        } else {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Solucion 1 (x1): " + raiz1);
            System.out.println("Solucion 2 (x2): " + raiz2);
        }
    }
}
