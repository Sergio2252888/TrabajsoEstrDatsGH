import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MiLista baraja = new MiLista();
        String[] palos = {"Corazones", "Picas", "Diamantes", "Tréboles"};

        for (String palo : palos) {
            for (int i = 1; i <= 13; i++) {
                baraja.insertTail(new Carta(palo, i));
            }
        }

        System.out.println("--- BARAJA INICIAL ORDENADA ---");
        System.out.println(baraja.toString());

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Revolver la baraja");
            System.out.println("2. Ordenar por un palo");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número válido.");
                continue;
            }

            if (opcion == 1) {
                baraja.shuffle();
                System.out.println("\n--- BARAJA REVUELTA ---");
                System.out.println(baraja.toString());
            }
            else if (opcion == 2) {
                System.out.print("Escribe la inicial del palo ('C', 'D', 'P', 'T'): ");
                String inicial = scanner.nextLine().toUpperCase();
                String paloBuscado = "";

                if (inicial.equals("C")) paloBuscado = "Corazones";
                else if (inicial.equals("D")) paloBuscado = "Diamantes";
                else if (inicial.equals("P")) paloBuscado = "Picas";
                else if (inicial.equals("T")) paloBuscado = "Tréboles";
                else {
                    System.out.println("Palo no válido.");
                    continue;
                }


                MiLista subLista = new MiLista();
                ListNode iterador = baraja.cabeza;
                while (iterador != null) {
                    Carta c = (Carta) iterador.dato;
                    if (c.getPalo().equals(paloBuscado)) {
                        subLista.insertTail(c);
                    }
                    iterador = iterador.siguiente;
                }
                
                subLista.sortList();
                System.out.println("\n--- CARTAS DE " + paloBuscado.toUpperCase() + " ORDENADAS ---");
                System.out.println(subLista.toString());
            }
            else if (opcion == 3) {
                System.out.println("Saliendo del programa...");
            }
            else {
                System.out.println("Opción incorrecta.");
            }
        }
        scanner.close();
    }
}

