/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

public class Pila {
    private NodoPila cima;
    int tama;

    public Pila() {
        cima = null;
        tama = 0;
    }

    public boolean estaVacia() { // VERIFICA SI LA PILA ESTA VACIA
        return cima == null;
    }

    public void push(String elemento) { // INGRESA LOS ELEMENTOS A LA PILA
        NodoPila nuevo = new NodoPila(elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
        tama++;

    }

    public String pop() { // ELIMINA ELEMENTOS DE LA PILA
        String aux = cima.dato;
        cima = cima.siguiente;
        tama--;
        return aux;
    }

    public String cima() { // MUESTRA EL ULTIMO ELEMENTO DE LA PILA
        return cima.dato;
    }

    public int tamanio() {// DEVUELVE EL TAMAÑO DE LA PILA
        return tama;
    }

    public void limpiar() { // LIMPIA LA PILA
        while (!estaVacia()) {
            pop();
        }
    }
}
