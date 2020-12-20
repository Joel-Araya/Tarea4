package com.example.myapplication;

public class Nodo {

    private int valor;
    private Nodo next;
    private Nodo prev;

    public Nodo(int valor) {
        this.valor = valor;
    }

    public Nodo(){}

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getPrev() {
        return prev;
    }

    public void setPrev(Nodo prev) {
        this.prev = prev;
    }
}
