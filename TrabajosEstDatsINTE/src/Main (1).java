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
        System.out.println("Total de cartas: " + baraja.getSize());
        System.out.println(baraja.toString());
    }
}

