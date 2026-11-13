import java.util.Scanner;

    public class Parte1 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // 1.
            System.out.print("Punto 1 - Ingresa primer texto: ");
            String texto1 = scanner.next();
            System.out.print("Ingresa segundo texto: ");
            String texto2 = scanner.next();
            System.out.println(texto1 + " " + texto2);

            // 2.
            System.out.print("\nPunto 2 - Ingresa tu nombre: ");
            String nombre = scanner.next();
            System.out.println("Hola " + nombre);

            // 3.
            System.out.print("\nPunto 3 - Numero para elevar al cuadrado: ");
            int numero = scanner.nextInt();
            System.out.println("Cuadrado: " + (numero * numero));

            // 4 y 5.
            System.out.print("\nPuntos 4 y 5 - Ingresa dos numeros separados por espacio: ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Suma: " + (a + b));
            System.out.println("Resta: " + (a - b));
            System.out.println("Multiplicacion: " + (a * b));
            System.out.println("Division: " + (a / b));
            System.out.println("Residuo: " + (a % b));

            // 6.
            System.out.print("\nPunto 6 - Ingresa un numero decimal (usa coma o punto segun tu PC): ");
            double decimalNum = scanner.nextDouble();
            int parteEntera = (int) decimalNum;
            double parteDecimal = decimalNum - parteEntera;
            System.out.println("Entera: " + parteEntera + " | Decimal: " + parteDecimal);

            // 7.
            System.out.print("\nPunto 7 - Ingresa 5 notas separadas por espacio: ");
            double n1 = scanner.nextDouble();
            double n2 = scanner.nextDouble();
            double n3 = scanner.nextDouble();
            double n4 = scanner.nextDouble();
            double n5 = scanner.nextDouble();
            double notaFinal = calcularPromedio(n1, n2, n3, n4, n5);
            System.out.println("La nota final es: " + notaFinal);

            // 8.
            System.out.print("\nPunto 8 - Ingresa el precio bruto para el IVA: ");
            double precioBruto = scanner.nextDouble();
            calcularIVA(precioBruto);

            // 9.
            System.out.print("\nPunto 9 - Ingresa el radio del circulo: ");
            double radio = scanner.nextDouble();
            System.out.println("Area: " + (3.14159 * radio * radio));
            System.out.println("Perimetro: " + (2 * 3.14159 * radio));

            // 10.
            System.out.print("\nPunto 10 - Ingresa el lado del hexagono: ");
            double lado = scanner.nextDouble();
            double areaHex = (3 * 1.73205 / 2) * (lado * lado); // 1.73205 es la raiz de 3
            System.out.println("Area del hexagono: " + areaHex);

            // 11.
            System.out.print("\nPunto 11 - Cuantos numeros vas a promediar? ");
            int cantidad = scanner.nextInt();
            double sumaPromedio = 0;
            for (int i = 1; i <= cantidad; i++) {
                System.out.print("Ingresa el numero " + i + ": ");
                sumaPromedio = sumaPromedio + scanner.nextDouble();
            }
            System.out.println("El promedio de esos " + cantidad + " numeros es: " + (sumaPromedio / cantidad));

            // 12.
            System.out.print("\nPunto 12 - Ingresa x1 y y1 (separados por espacio): ");
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            System.out.print("Ingresa x2 y y2 (separados por espacio): ");
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            double distancia = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
            System.out.println("La distancia es: " + distancia);

            // 13.
            System.out.print("\nPunto 13 - Ingresa un solo digito (ejemplo 5): ");
            int digito = scanner.nextInt();
            int d1 = digito;
            int d2 = (digito * 10) + digito;
            int d3 = (digito * 100) + (digito * 10) + digito;
            System.out.println("Generados: " + d1 + ", " + d2 + ", " + d3);
            System.out.println("Suma de ellos: " + (d1 + d2 + d3));

            // 14.
            System.out.print("\nPunto 14 - Ingresa cantidad de segundos: ");
            int totalSegundos = scanner.nextInt();
            int horas = totalSegundos / 3600;
            int residuo = totalSegundos % 3600;
            int minutos = residuo / 60;
            int segundos = residuo % 60;
            System.out.println("Formato: " + horas + ":" + minutos + ":" + segundos);

            scanner.close();
        }

        // Funcion Punto 7.
        public static double calcularPromedio(double n1, double n2, double n3, double n4, double n5) {
            return (n1 * 0.15) + (n2 * 0.20) + (n3 * 0.15) + (n4 * 0.30) + (n5 * 0.20);
        }

        // Funcion Punto 8.
        public static double calcularIVA(double precioBruto) {
            double iva = precioBruto * 0.19;
            double precioTotal = precioBruto + iva;
            System.out.println("Precio bruto: " + precioBruto);
            System.out.println("IVA (19%): " + iva);
            System.out.println("Precio con IVA: " + precioTotal);
            return precioTotal;
        }
    }

