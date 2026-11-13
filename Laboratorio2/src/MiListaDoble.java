public class MiListaDoble implements ListInterface {
    DoubleNode cabeza;
    DoubleNode cola;
    int size = 0; // Para llevar la cuenta del tamaño fácilmente

    @Override
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    @Override
    public Object getHead() {
        if (isEmpty()) return null;
        return this.cabeza.dato;
    }

    @Override
    public Object getTail() {
        if (isEmpty()) return null;
        return this.cola.dato;
    }

    @Override
    public Object get(DoubleNode node) {
        return node != null ? node.dato : null;
    }

    @Override
    public DoubleNode search(Object object) {
        DoubleNode iterador = this.cabeza;
        while (iterador != null) {
            if (iterador.dato.equals(object)) {
                return iterador;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        return insertTail(object); // Por defecto agregamos al final
    }

    @Override
    public boolean insert(DoubleNode node, Object object) {
        // Implementación pendiente
        return false;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        // Implementación pendiente
        return false;
    }

    @Override
    public boolean set(DoubleNode node, Object object) {
        if (node != null) {
            node.dato = object;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(DoubleNode node) {
        // Implementación pendiente
        return false;
    }

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        DoubleNode iterador = this.cabeza;
        int i = 0;
        while (iterador != null) {
            array[i++] = iterador.dato;
            iterador = iterador.siguiente;
        }
        return array;
    }

    @Override
    public Object[] toArray(Object[] object) {
        return toArray();
    }

    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to) {
        // Implementación pendiente
        return null;
    }

    @Override
    public MiListaDoble sortList() {
        // Implementación pendiente
        return null;
    }

    @Override
    public boolean insertHead(Object object) {
        DoubleNode nuevoNodo = new DoubleNode(object);
        if (isEmpty()) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = this.cabeza;
            this.cabeza.anterior = nuevoNodo;
            this.cabeza = nuevoNodo;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        DoubleNode nuevoNodo = new DoubleNode(object);
        if (isEmpty()) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
        } else {
            nuevoNodo.anterior = this.cola;
            this.cola.siguiente = nuevoNodo;
            this.cola = nuevoNodo;
        }
        this.size++;
        return true;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Lista doblemente enlazada vacía";
        StringBuilder sb = new StringBuilder();
        DoubleNode iterador = this.cabeza;
        sb.append("null <-> ");
        while (iterador != null) {
            sb.append("[").append(iterador.dato).append("] <-> ");
            iterador = iterador.siguiente;
        }
        sb.append("null");
        return sb.toString();
    }
}
