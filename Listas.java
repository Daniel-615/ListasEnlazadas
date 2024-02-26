/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nodo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author suyan
 */
public class Listas {
    private Nodo inicio,fin;
    public Listas(){
        inicio=null;
        fin=null;
    }
    public void agregarInicio(int elemento){
        inicio=new Nodo(elemento,inicio);
        if(fin==null){
            fin=inicio;
        }
    }
    public void mostrarLista(){
        Nodo recorrer=inicio;
        while(recorrer!=null){
            System.out.println("["+recorrer.dato+"]");
            recorrer=recorrer.siguiente;
        }
    }
    public int buscarElemento(int elemento) {
        Nodo actual = inicio;
        int posicion = 0;
        while (actual != null) {
            if (actual.dato == elemento) {
                return posicion; 
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1; 
    }
   public void Agregar(JTextField elemento, Listas lista) {
        String filePath = "C:\\Users\\suyan\\OneDrive\\Documentos\\NetBeansProjects\\Nodo\\src\\main\\java\\com\\mycompany\\nodo\\Datos.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int el = Integer.parseInt(linea.trim());
                lista.agregarInicio(el);
            }
            JOptionPane.showMessageDialog(null, "Elementos agregados.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
        }
    }
    public void buscar(JTextField elemento,Listas lista,JTextField pos){
        int el=Integer.parseInt(elemento.getText());
        elemento.setText("");
        int posicion=lista.buscarElemento(el);
        if(posicion!=-1){
            String element="";
            element=Integer.toString(posicion);
            pos.setText(element);
            JOptionPane.showMessageDialog(null, "El elemento "+el+" se encuentra en la posicion: "+posicion);
        }else{
            JOptionPane.showMessageDialog(null, "El elemento "+el+" no se encuentra en la lista");
        }
    }
     public void eliminarEnPosicion(int posicion) {
        if (inicio == null) {
            return;
        }
        
        if (posicion == 0) {
            inicio = inicio.siguiente;
            return;
        }

        Nodo actual = inicio;
        Nodo anterior = null;
        int contador = 0;

        while (actual != null) {
            if (contador == posicion) {
                anterior.siguiente = actual.siguiente;
                if (actual == fin) {
                    fin = anterior;
                }
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
            contador++;
        }
    }
    public void eliminar(JTextField elemento, Listas lista) {
        int el = Integer.parseInt(elemento.getText());
        int posicion = lista.buscarElemento(el);
        if (posicion != -1) {
            lista.eliminarEnPosicion(posicion);
            JOptionPane.showMessageDialog(null, "El elemento " + el + " ha sido eliminado de la lista.");
        } else {
            JOptionPane.showMessageDialog(null, "El elemento " + el + " no se encuentra en la lista.");
        }
    }
}
