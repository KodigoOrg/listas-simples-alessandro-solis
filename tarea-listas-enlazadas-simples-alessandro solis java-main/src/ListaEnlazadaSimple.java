public class ListaEnlazadaSimple {
    private Nodo cabeza;

    /**
     * Constructor: Inicializa la lista vacía
     */
    public ListaEnlazadaSimple() {
        this.cabeza = null;
    }

    /**
     * Verifica si la lista está vacía
     * @return true si la lista está vacía
     */
    public boolean esListaVacia() {
        return cabeza == null;
    }

    /**
     * Inserta un nuevo nodo al inicio de la lista
     * @param dato el valor a insertar
     */
    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
    }

    /**
     * Inserta un nuevo nodo al final de la lista
     * @param dato el valor a insertar
     */
    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (esListaVacia()) {
            cabeza = nuevoNodo;
            return;
        }

        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevoNodo);
    }

    /**
     * Elimina el nodo al inicio de la lista
     * @return true si se eliminó correctamente, false si la lista estaba vacía
     */
    public boolean eliminarAlInicio() {
        if (esListaVacia()) {
            return false;
        }
        cabeza = cabeza.getSiguiente();
        return true;
    }

    /**
     * Elimina la primera aparición de un nodo con el valor especificado
     * @param dato el valor a eliminar
     * @return true si se eliminó, false si no se encontró
     */
    public boolean eliminar(int dato) {
        if (esListaVacia()) {
            return false;
        }

        if (cabeza.getDato() == dato) {
            cabeza = cabeza.getSiguiente();
            return true;
        }

        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato() == dato) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Retorna el número de nodos en la lista
     * @return el tamaño de la lista
     */
    public int tamanio() {
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    /**
     * Busca si existe un nodo con el valor dado
     * @param dato el valor a buscar
     * @return true si se encontró, false si no
     */
    public boolean buscar(int dato) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getDato() == dato) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Imprime todos los valores de la lista
     */
    public void imprimir() {
        if (esListaVacia()) {
            System.out.println("Lista vacía");
            return;
        }

        System.out.println("Lista:");
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println("Dato: " + actual.getDato());
            if (actual.getSiguiente() != null) {
                System.out.println(" ↓ ");
            }
            actual = actual.getSiguiente();
        }
    }

    /**
     * Muestra información sobre el uso de memoria en tiempo de ejecución
     * @return String con datos de memoria
     */
    public String informacionMemoria() {
        Runtime runtime = Runtime.getRuntime();
        long memoriaTotal = runtime.totalMemory();
        long memoriaLibre = runtime.freeMemory();
        long memoriaUsada = memoriaTotal - memoriaLibre;

        return String.format(
                "Memoria total: %d bytes\nMemoria libre: %d bytes\nMemoria usada: %d bytes",
                memoriaTotal, memoriaLibre, memoriaUsada
        );
    }
}
