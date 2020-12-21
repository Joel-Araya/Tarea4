package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    TextView helloWorld;
    Button button;
    EditText number;
    DoubleLinkedList lista = new DoubleLinkedList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloWorld = (TextView) findViewById(R.id.helloWorld);
        number = findViewById(R.id.numero);

        helloWorld.setText("No ha introducido un número");


    }

    public void addElement(View view) {

        try {

            int numero = Integer.parseInt(number.getText().toString());
            lista.agregarAlFinal(numero);
            helloWorld.setText(lista.listarString());
            number.setText("");

        } catch (Exception e) {
            helloWorld.setText(lista.listarString() + "\n\nPara agregar otro valor, debe ingresar un número");
        }
    }

    public void delElement(View view) {
        try {
            if (number.getText().toString() == "") {
                helloWorld.setText(lista.listarString() + "\n\nNo se pudo eliminar ese elemento");
            } else {
                int numero = Integer.parseInt(number.getText().toString());
                lista.eliminarNodo(numero);
                helloWorld.setText(lista.listarString());
                number.setText("");
            }
        } catch (Exception e){
            helloWorld.setText(lista.listarString() + "\n\nNo se pudo eliminar ese elemento");
        }
    }


}