public class MiListaCircular implements ListInterface {
    Node cabeza;
    Node cola;
    int size = 0;

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
        return isEmpty() ? null : this.cabeza.dato;
    }

    @Override
    public Object getTail() {
        return isEmpty() ? null : this.cola.dato;
    }

    @Override
    public Object get(Node node) {
        return node != null ? node.dato : null;
    }

    @Override
    public Node search(Object object) {
        if (isEmpty()) return null;
        Node iterador = this.cabeza;
        do {
            if (iterador.dato.equals(object)) {
                return iterador;
            }
            iterador = iterador.siguiente;
        } while (iterador != this.cabeza);
        return null;
    }

    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }

    @Override
    public boolean insert(Node node, Object object) {
        // Implementación pendiente si se requiere insertar después de un nodo específico
        return false;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        // Implementación pendiente si se requiere buscar y luego insertar
        return false;
    }

    @Override
    public boolean insertHead(Object object) {
        Node nuevoNodo = new Node(object);
        if (isEmpty()) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
            this.cola.siguiente = this.cabeza; // Conexión circular
        } else {
            nuevoNodo.siguiente = this.cabeza;
            this.cabeza = nuevoNodo;
            this.cola.siguiente = this.cabeza; // Actualizamos la conexión circular
        }
        this.size++;
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        Node nuevoNodo = new Node(object);
        if (isEmpty()) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
            this.cola.siguiente = this.cabeza; // Conexión circular
        } else {
            this.cola.siguiente = nuevoNodo;
            this.cola = nuevoNodo;
            this.cola.siguiente = this.cabeza; // Actualizamos la conexión circular
        }
        this.size++;
        return true;
    }

    @Override
    public boolean set(Node node, Object object) {
        if (node != null) {
            node.dato = object;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Node node) {
        if (node == null || isEmpty()) return false;

        // Caso 1: Único elemento en la lista
        if (this.cabeza == this.cola && node == this.cabeza) {
            clear();
            return true;
        }

        // Caso 2: El nodo es la cabeza
        if (node == this.cabeza) {
            this.cabeza = this.cabeza.siguiente;
            this.cola.siguiente = this.cabeza; // Mantener la circularidad
            this.size--;
            return true;
        }

        // Caso 3: El nodo está en el medio o es la cola
        Node iterador = this.cabeza;
        while (iterador.siguiente != this.cabeza && iterador.siguiente != node) {
            iterador = iterador.siguiente;
        }

        if (iterador.siguiente == node) {
            iterador.siguiente = node.siguiente;
            if (node == this.cola) {
                this.cola = iterador; // Actualizar la cola si fue el eliminado
            }
            this.size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        if (isEmpty()) return array;
        Node iterador = this.cabeza;
        int i = 0;
        do {
            array[i++] = iterador.dato;
            iterador = iterador.siguiente;
        } while (iterador != this.cabeza);
        return array;
    }

    @Override
    public Object[] toArray(Object[] object) {
        return toArray();
    }

    @Override
    public MiListaCircular subList(Node from, Node to) {
        // Implementación pendiente
        return null;
    }

    @Override
    public MiListaCircular sortList() {
        // Implementación pendiente (se puede adaptar el Bubble Sort de listas anteriores)
        return null;
    }
}
