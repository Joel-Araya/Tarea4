package com.example.myapplication;

public class mainStructure {

    public static void main(String[] args) {

        DoubleLinkedList lista = new DoubleLinkedList();

        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(6);
        lista.agregarAlFinal(4);
        lista.agregarAlFinal(5);
        lista.agregarAlFinal(15);
        lista.agregarAlFinal(7);
        lista.listar();

        lista.eliminarNodo(6);
        lista.listar();

        lista.eliminar(5);
        lista.listar();

        lista.agregarPosicion(3,27);
        lista.listar();
    }
}
