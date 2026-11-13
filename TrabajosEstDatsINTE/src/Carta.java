public class Carta {
        private String palo;
        private int numero;

        public Carta(String palo, int numero) {
            this.palo = palo;
            this.numero = numero;
        }

        public String getPalo() {
            return palo;
        }

        public int getNumero() {
            return numero;
        }

        @Override
        public String toString() {
            String numStr = String.valueOf(numero);
            if (numero == 1) numStr = "A";
            else if (numero == 11) numStr = "J";
            else if (numero == 12) numStr = "Q";
            else if (numero == 13) numStr = "K";

            // Formato visual para la impresión
            return "[" + numStr + " de " + palo + "]";
        }
    }

