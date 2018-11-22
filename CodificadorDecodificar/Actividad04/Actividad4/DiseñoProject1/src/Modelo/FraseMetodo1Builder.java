/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import libcomunicacion.DTOTraduccion;

/**
 *
 * @author Sebastian
 */
public class FraseMetodo1Builder extends FraseBuilder{
    
    @Override
    public void buildDTOTraduccion(DTOTraduccion dto) {
        frase.setDto(dto);
        String alf = frase.getAlf().getSimbolos();
//        int cantChars = frase.getAlf().getCantChar();
//        String resultado = generarFraseMetodo1(alf, cantChars);
//        //Guardar resultado en el dto
//        frase.getDto().setFraseEntrada(resultado);
    }

    @Override
    public void buildAlfabeto(Alfabeto alf) {
        frase.setAlf(alf);
    }

   
public static String generarFraseMetodo1(String alfabeto, int cantChars){
    int numero;
    String resultado = "";
    boolean sirve;        
    int pasadoPos = 150000000;
    ArrayList<String> listaChars = new ArrayList<>(); 
    if (alfabeto.contains(" ")){
        alfabeto = alfabeto.replaceAll(" ", "");
        alfabeto = alfabeto + " ";
    }
    if (cantChars <= alfabeto.length()){
        for(int i = 0 ; i < cantChars;i++){            
            sirve = true;
            while (sirve){
                numero = (int) (Math.random() * alfabeto.length());
                if(!listaChars.contains(String.valueOf(alfabeto.charAt(numero)))){
                    if(!(numero == pasadoPos + 1)){
                        listaChars.add(String.valueOf(alfabeto.charAt(numero)));
                        resultado += String.valueOf(alfabeto.charAt(numero));
                        sirve = false;
                        pasadoPos = numero;
                    }else{
                        //Si es el siguiente que continue !!
                    }
                }
            }            
        }
    }else{
        System.out.print("La cantidad de caracteres no permite generar este metodo.");
    }
    return resultado;
    }
}