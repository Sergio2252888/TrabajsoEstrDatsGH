import java.util.Iterator;

public class MiLista implements ListInterface{
    ListNode cabeza;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getSize() {
        ListNode iterador = this.cabeza;
        int contador = 1;
        while (iterador.siguiente != null){
            iterador = iterador.siguiente;
            contador = contador + 1;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;

    }

    @Override
    public Object getHead() {
        return null;
    }

    @Override
    public Object getTail() {
        return null;
    }

    @Override
    public Object get(ListNode node) {
        return null;
    }

    @Override
    public Object search(Object object) {
        return null;
    }

    @Override
    public boolean add(Object object) {
        return false;
    }

    @Override
    public boolean insert(ListNode node, Object object) {
        return false;
    }

    @Override
    public boolean insert(Object ob, Object object) {
        return false;
    }

    @Override
    public boolean insertHead(Object object) {
        try {
            // 1er paso: Crear el nuevo nodo con la información recibida
            ListNode nuevaCabeza = new ListNode(object);
            //2do paso: Conectar el nodo a la cabeza
            nuevaCabeza.siguiente = this.cabeza;
            //3er paso: redefinir la cabeza
            this.cabeza = nuevaCabeza;
            return true;
        } catch (Exception e){
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {
        if(this.cabeza == null){
            ListNode nuevaCabeza = new ListNode(object);
            this.cabeza = nuevaCabeza;
        }else {
            ListNode nuevaCola = new ListNode(object);
            ListNode iterador = this.cabeza;
            while (iterador.siguiente != null) {
                iterador = iterador.siguiente;

            }
            iterador.siguiente = nuevaCola;
        }
        return true;

    }

    @Override
    public boolean set(ListNode node, Object object) {
        return false;
    }

    @Override
    public boolean remove(ListNode node) {
        return false;
    }

    @Override
    public boolean contains(Object object) {
        return false;
    }

    @Override
    public Iterator<ListNode> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] object) {
        return new Object[0];
    }

    @Override
    public Object getBeforeTo() {
        return null;
    }

    @Override
    public Object getBeforeTo(ListNode node) {
        return null;
    }

    @Override
    public Object getNextTo() {
        return null;
    }

    @Override
    public Object getNextTo(ListNode node) {
        return null;
    }

    @Override
    public MiLista subList(ListNode from, ListNode to) {
        return null;
    }

    @Override
    public MiLista sortList() {
        if (this.cabeza == null || this.cabeza.siguiente == null) {
            return this; // Si la lista está vacía o tiene un solo elemento, ya está ordenada
        }

        boolean intercambiado;
        do {
            intercambiado = false;
            ListNode actual = this.cabeza;
            ListNode siguiente = this.cabeza.siguiente;
            ListNode anterior = null;

            while (siguiente != null) {

                Carta cartaActual = (Carta) actual.dato;
                Carta cartaSiguiente = (Carta) siguiente.dato;

                if (cartaActual.getNumero() > cartaSiguiente.getNumero()) {

                    if (anterior != null) {
                        anterior.siguiente = siguiente;
                    } else {
                        this.cabeza = siguiente;
                    }
                    actual.siguiente = siguiente.siguiente;
                    siguiente.siguiente = actual;

                    anterior = siguiente;
                    siguiente = actual.siguiente;
                    intercambiado = true;
                } else {
                    anterior = actual;
                    actual = siguiente;
                    siguiente = actual.siguiente;
                }
            }
        } while (intercambiado);
        return this;
    }

    public void shuffle() {
        if (this.cabeza == null) return;

        int tamaño = getSize();
        Object[] temporal = new Object[tamaño];

        ListNode iterador = this.cabeza;
        for (int i = 0; i < tamaño; i++) {
            temporal[i] = iterador.dato;
            iterador = iterador.siguiente;
        }
        java.util.Random rnd = new java.util.Random();
        for (int i = temporal.length - 1; i > 0; i--) {
            int indice = rnd.nextInt(i + 1);
            Object temp = temporal[indice];
            temporal[indice] = temporal[i];
            temporal[i] = temp;
        }
        this.clear();
        for (Object obj : temporal) {
            this.insertTail(obj);
        }
    }

    @Override
    public String toString() {
        if (this.cabeza == null) {
            return "Lista vacía";
        }
        StringBuilder sb = new StringBuilder();
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            sb.append(iterador.dato.toString()).append("\n");
            iterador = iterador.siguiente;
        }
        return sb.toString();
    }
}
