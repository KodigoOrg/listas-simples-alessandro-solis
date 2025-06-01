public class Main {
    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        // Insertar elementos
        lista.insertarAlInicio(30);
        lista.insertarAlInicio(20);
        lista.insertarAlInicio(10);
        lista.insertarAlFinal(40);
        lista.insertarAlFinal(50);

        // Imprimir lista
        lista.imprimir();

        // Eliminar un nodo
        System.out.println("Eliminando 20: " + lista.eliminar(20));
        lista.imprimir();

        // Buscar un nodo
        System.out.println("¿Está 40 en la lista?: " + lista.buscar(40));
        System.out.println("¿Está 100 en la lista?: " + lista.buscar(100));

        // Tamaño
        System.out.println("Tamaño de la lista: " + lista.tamanio());

        // Información de memoria
        System.out.println(lista.informacionMemoria());
    }
}
