public class Queue implements QueueInterface {

    QueueNode head;
    QueueNode tail;
    int size = 0;
    boolean isPriorityQueue;


    public Queue(boolean isPriorityQueue) {
        this.isPriorityQueue = isPriorityQueue;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public Object extract() {

        if (isEmpty()) return null;

        Object dato = this.head.object;
        this.head = this.head.next;

        if (this.head == null) {
            this.tail = null;
        }

        this.size--;
        return dato;
    }

    @Override
    public boolean insert(Object object) {
        QueueNode nuevoNodo = new QueueNode();
        nuevoNodo.object = object;
        nuevoNodo.priority = 0;

        if (isEmpty()) {
            this.head = nuevoNodo;
            this.tail = nuevoNodo;
        } else {
            this.tail.next = nuevoNodo;
            this.tail = nuevoNodo;
        }

        this.size++;
        return true;
    }

    @Override
    public boolean insert(Object object, int prioridad) {

        if (!this.isPriorityQueue) {

            return insert(object);
        }

        QueueNode nuevoNodo = new QueueNode();
        nuevoNodo.object = object;
        nuevoNodo.priority = prioridad;

        if (isEmpty() || prioridad < this.head.priority) {
            nuevoNodo.next = this.head;
            this.head = nuevoNodo;
            if (this.tail == null) {
                this.tail = nuevoNodo;
            }
        }
        else {
            QueueNode iterador = this.head;
            while (iterador.next != null && iterador.next.priority <= prioridad) {
                iterador = iterador.next;
            }

            nuevoNodo.next = iterador.next;
            iterador.next = nuevoNodo;

            if (nuevoNodo.next == null) {
                this.tail = nuevoNodo;
            }
        }

        this.size++;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean search(Object object) {
        QueueNode iterador = this.head;
        while (iterador != null) {
            if (iterador.object.equals(object)) {
                return true;
            }
            iterador = iterador.next;
        }
        return false;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Cola vacía";

        StringBuilder sb = new StringBuilder();
        QueueNode iterador = this.head;
        sb.append("Frente <- ");
        while (iterador != null) {
            if (isPriorityQueue) {
                sb.append("[").append(iterador.object).append("(p:").append(iterador.priority).append(")] <- ");
            } else {
                sb.append("[").append(iterador.object).append("] <- ");
            }
            iterador = iterador.next;
        }
        sb.append("Final");
        return sb.toString();
    }
}