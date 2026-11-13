public class Main {
    public static void main(String[] args) {
        MiListaDoble listaDoble = new MiListaDoble();

        System.out.println("1. Inserción:");
        listaDoble.insertHead(6);
        listaDoble.insertTail(4);
        listaDoble.insertTail(1);
        listaDoble.insertTail(3);
        System.out.println(listaDoble.toString());

        System.out.println("\n2. Búsqueda y Actualización (set 1 a 0):");
        DoubleNode nodoUno = listaDoble.search(1);
        if (nodoUno != null) {
            listaDoble.set(nodoUno, 0);
        }
        System.out.println(listaDoble.toString());

        System.out.println("\n3. Ordenamiento (sortList):");
        listaDoble.sortList();
        System.out.println(listaDoble.toString());

        System.out.println("\n4. Eliminación (remove):");
        DoubleNode nodoCero = listaDoble.search(0);
        listaDoble.remove(nodoCero);
        System.out.println(listaDoble.toString());
    }
}