/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nodo;



/**
 *
 * @author suyan
 */
public class Nodo {
    public int dato;
    public Nodo siguiente;
    //Constructor para insertar al final
    public Nodo(int d){
        this.dato=d;
    }
    //Constructor para insertar al inicio
    public Nodo(int d,Nodo n){
        dato=d;
        siguiente=n;
    }
   
    public static void main(String[] args) {
        ListaForm lista=new ListaForm();
        lista.setVisible(true);
    }
}
