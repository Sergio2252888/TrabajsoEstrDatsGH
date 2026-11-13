public class ListStack implements StackInterface {

    StackNode top;
    int size = 0;

    @Override
    public void clear() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public Object peek() {
        // Retorna el elemento en el tope sin eliminarlo
        if (isEmpty()) return null;
        return this.top.object;
    }

    @Override
    public Object pop() {
        // Retorna y ELIMINA el elemento en el tope
        if (isEmpty()) return null;

        Object dato = this.top.object;
        this.top = this.top.above; // El nuevo tope es el nodo que estaba abajo
        this.size--;

        return dato;
    }

    @Override
    public boolean push(Object object) {
        // Inserta un nuevo elemento en el tope de la pila
        StackNode nuevoNodo = new StackNode();
        nuevoNodo.object = object;

        nuevoNodo.above = this.top; // Conectamos el nuevo nodo al tope actual
        this.top = nuevoNodo;       // Redefinimos el tope
        this.size++;

        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean search(Object object) {
        StackNode iterador = this.top;
        while (iterador != null) {
            if (iterador.object.equals(object)) {
                return true; // Lo encontró
            }
            iterador = iterador.above;
        }
        return false;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Pila vacía";

        StringBuilder sb = new StringBuilder();
        StackNode iterador = this.top;
        sb.append("--- TOPE (TOP) ---\n");
        while (iterador != null) {
            sb.append("[ ").append(iterador.object).append(" ]\n");
            iterador = iterador.above;
        }
        sb.append("--- BASE ---");
        return sb.toString();
    }
}