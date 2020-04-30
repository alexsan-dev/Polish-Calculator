/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

public class Notacion {

    private String[] prefija;
    private Pila pila = new Pila();

    public Notacion(String[] prefija) {
        this.prefija = prefija;
        this.pila = pila;
    }

    public double rpn() {
        String derecho, izquierdo;

        for (int i = 1; i < prefija.length; i++) {
            String aux = prefija[i];

            if (esOperador(aux)) {
                derecho = pila.pop();

                izquierdo = pila.pop();
                double resultado = operar(izquierdo, aux, derecho);
                pila.push("" + resultado);
            } else {
                pila.push(aux);
            }
        }

        return Double.parseDouble(pila.pop());
    }

    private boolean esOperador(String aux) {
        return aux.equals("+") || aux.equals("-") || aux.equals("*") || aux.equals("/");
    }

    private double operar(String izquierdo, String operador, String derecho) {
        double a = Double.parseDouble(izquierdo);
        double b = Double.parseDouble(derecho);

        switch (operador) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return -1;
        }
    }
}
