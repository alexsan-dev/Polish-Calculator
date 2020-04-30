
package Source;

public class Cola {
    NodoCola inicio, fin;
    int tamanio;

    public Cola() {
        inicio = fin = null;
        tamanio = 0;
    }

    public boolean isEmpty() {// METODO PARA SABER SI
        return inicio == null;
    }

    public void push(String ele) { // PARA INSERTAR ELEMENTO
        NodoCola nuevo = new NodoCola(ele);
        if (isEmpty()) {
            inicio = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        tamanio++;
    }

    public String get(int index) {
        NodoCola aux = inicio;
        int count = 0;

        while (aux.siguiente != null && count < index) {
            aux = aux.siguiente;
            count++;
        }

        return aux.dato;
    }

    public String pop() {
        String aux = inicio.dato;
        inicio = inicio.siguiente;
        tamanio--;
        return aux;
    }

    public String start() {// METODO PARA SABER EL DATO DEL INICIO
        return inicio.dato;
    }

    public int size() { // jMETODO PARA CONOCER EL DE LA COLA
        return tamanio;
    }

}
