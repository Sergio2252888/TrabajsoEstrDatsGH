import java.util.Scanner;

public class TallerParte4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Punto 31 - Primeros 10 numeros naturales:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }

        System.out.println("\n\nPunto 32 - Primeros 10 numeros naturales impares:");
        for (int i = 1; i <= 19; i += 2) {
            System.out.print(i + " ");
        }

        System.out.println("\n\nPunto 33 - Primeros 10 numeros naturales pares:");
        for (int i = 2; i <= 20; i += 2) {
            System.out.print(i + " ");
        }

        System.out.println("\n\nPunto 34 - Solicitar entero positivo:");
        int numeroPositivo;
        do {
            System.out.print("Ingresa un numero entero positivo: ");
            numeroPositivo = scanner.nextInt();
        } while (numeroPositivo <= 0);
        System.out.println("Valor valido ingresado: " + numeroPositivo);

        System.out.print("\nPunto 35 - Convertir decimal a binario. Ingresa un decimal: ");
        int decimal = scanner.nextInt();
        String binario = "";
        int temp = decimal;
        if (temp == 0) {
            binario = "0";
        }
        while (temp > 0) {
            binario = (temp % 2) + binario;
            temp = temp / 2;
        }
        System.out.println("Binario: " + binario);

        System.out.print("\nPunto 36 - Convertir binario a decimal. Ingresa un binario: ");
        String textoBinario = scanner.next();
        int resultadoDecimal = 0;
        int base = 1;
        for (int i = textoBinario.length() - 1; i >= 0; i--) {
            if (textoBinario.charAt(i) == '1') {
                resultadoDecimal = resultadoDecimal + base;
            }
            base = base * 2;
        }
        System.out.println("Decimal: " + resultadoDecimal);

        System.out.println("\nPunto 37 - Patron numerico:");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.print("\nPunto 38 - Triangulo invertido con @. Numero de filas: ");
        int filas38 = scanner.nextInt();
        for (int i = filas38; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("@");
            }
            System.out.println();
        }

        System.out.print("\nPunto 39 - Triangulo invertido con *. Numero de filas: ");
        int filas39 = scanner.nextInt();
        for (int i = filas39; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\n--- PROBLEMA FINAL: BOING 747 ---");
        double capacidadAvion = 18000;
        double cargaActual = 0;
        int totalBultos = 0;
        double pesoMayor = 0;
        double pesoMenor = 500;
        double totalPesos = 0;
        double tasaDolar = 4000;

        System.out.println("Ingresa el peso de cada bulto (0 para terminar el embarque):");
        while (cargaActual < capacidadAvion) {
            System.out.print("Peso del bulto: ");
            double pesoBulto = scanner.nextDouble();

            if (pesoBulto == 0) {
                break;
            }

            if (pesoBulto > 500) {
                System.out.println("Error: El bulto excede los 500 Kg permitidos.");
            } else if (cargaActual + pesoBulto > capacidadAvion) {
                System.out.println("Error: El bulto excede la capacidad restante del avion.");
            } else {
                cargaActual = cargaActual + pesoBulto;
                totalBultos++;

                if (pesoBulto > pesoMayor) {
                    pesoMayor = pesoBulto;
                }
                if (pesoBulto < pesoMenor) {
                    pesoMenor = pesoBulto;
                }

                double costoBulto = 0;
                if (pesoBulto >= 26 && pesoBulto <= 300) {
                    costoBulto = pesoBulto * 1500;
                } else if (pesoBulto >= 301 && pesoBulto <= 500) {
                    costoBulto = pesoBulto * 2500;
                }
                totalPesos = totalPesos + costoBulto;

                System.out.println("Ingresado. Capacidad restante: " + (capacidadAvion - cargaActual) + " Kg");
            }
        }

        System.out.println("\n--- REPORTE DEL VUELO ---");
        System.out.println("a. Numero total de bultos: " + totalBultos);
        if (totalBultos > 0) {
            System.out.println("b. Peso del bulto mas pesado: " + pesoMayor + " Kg | Mas liviano: " + pesoMenor + " Kg");
            System.out.println("c. Peso promedio de los bultos: " + (cargaActual / totalBultos) + " Kg");
            System.out.println("d. Ingreso por carga: $" + totalPesos + " Pesos | $" + (totalPesos / tasaDolar) + " Dolares");
        }

        scanner.close();
    }
}
