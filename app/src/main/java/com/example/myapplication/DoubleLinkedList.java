package com.example.myapplication;

public class DoubleLinkedList {

    private Nodo first;
    private int lenght;

    public DoubleLinkedList() {
    }

    public int getLenght() {
        return lenght;
    }

    public boolean esVacia() {
        return first == null;
    }


    public void agregarAlFinal(int valor) {

        Nodo nuevo = new Nodo();
        nuevo.setValor(valor);

        if (esVacia()) {
            first = nuevo;

        } else if (lenght == 1) {
            first.setNext(nuevo);
            first.setPrev(nuevo);
            nuevo.setNext(first);
            nuevo.setPrev(first);
        } else {
            Nodo aux = first;

            while (aux.getNext() != first) {
                aux = aux.getNext();
            }
            aux.setNext(nuevo);
            nuevo.setPrev(aux);
            nuevo.setNext(first);
            first.setPrev(nuevo);
        }
        lenght++;
    }

    public void listar() {
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            Nodo aux = first;
            int i = 0;
            System.out.println("\nLos elementos de la lista son ");

            while (aux != null && i < lenght) {
                System.out.printf("[ %d ]", aux.getValor());

                if (i != lenght - 1) {
                    System.out.print(" <-> ");
                }

                aux = aux.getNext();
                i++;
            }
            System.out.println("");
        }
    }
    public String listarString() {
        String listaString="\nLos elementos de la lista son \n";

        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            Nodo aux = first;
            int i = 0;
            //System.out.println("\nLos elementos de la lista son ");

            while (aux != null && i < lenght) {
                listaString+=String.format("[ %d ]", aux.getValor());

                if (i != lenght - 1) {
                    listaString+=String.format(" <-> ");
                }

                aux = aux.getNext();
                i++;
            }
            //System.out.println("");
        }
        return listaString;
    }

    public void eliminarNodo(int valor) {
        Nodo aux = first;
        boolean indicador = true;

        if (lenght == 1 || aux.getValor()==valor) {
            if (aux.getValor()==valor) {
                first = first.getNext();
                first.setPrev(null);
            }
        } else {

            while (indicador) {
                aux = aux.getNext();

                if (aux.getNext().getValor() == valor) {
                    Nodo nuevoSiguiente = aux.getNext().getNext();

                    aux.setNext(nuevoSiguiente);
                    nuevoSiguiente.setPrev(aux);

                    indicador = false;
                    lenght--;
                    break;
                }

                if (aux.getNext() == null) {
                    indicador = false;
                    break;
                }

            }
        }
    }


    public void eliminar(int n) {
        Nodo aux = getNodo(n - 1);
        Nodo nuevoSiguiente = aux.getNext().getNext();

        aux.setNext(nuevoSiguiente);
        nuevoSiguiente.setPrev(aux);

        lenght--;
    }

    public Nodo getNodo(int posicion) {
        Nodo aux = first;


        if (posicion == 0) {
            return aux;
        }

        int residuo = posicion % getLenght();
        //System.out.println(residuo);

        if (residuo == 0) {
            return aux;
        } else {
            for (int i = 0; i < residuo; i++) {
                aux = aux.getNext();
            }
        }
        return aux;
    }

    public void agregarPosicion(int posicion, int valor) {
        Nodo nuevo = new Nodo();
        nuevo.setValor(valor);


        Nodo aux = first;
        int i = 0;

        if (posicion == 0) {


            Nodo finale = first.getPrev();

            finale.setNext(nuevo);
            nuevo.setPrev(finale);

            nuevo.setNext(first);
            first.setPrev(nuevo);

            first = nuevo;
            lenght++;
        } else if (posicion == 1 || posicion == 2) {

            while (i < posicion) {
                aux = aux.getNext();
                Nodo auxAnterior = aux.getPrev();

                aux.setPrev(nuevo);
                nuevo.setNext(aux);

                auxAnterior.setNext(nuevo);
                nuevo.setPrev(auxAnterior);

                i++;

                if (i == posicion) {
                    lenght++;
                }
            }
        } else {
            agregarAlFinal(nuevo.getValor());
        }
    }
}