/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradodesclase;

/**
 *
 * @author Ares
 */
public class Recorrer {
    public int [] recorre1(int [] arregloaRecorrer)
    {
       String recorrer="";
       int contador = arregloaRecorrer.length;
       int posicion1= arregloaRecorrer[0];
       int[] arregloRecorrido = new int[contador];
       for(int i=0; i<contador-1; ++i)
       {
           arregloRecorrido[i] = arregloaRecorrer[i+1];
           recorrer = recorrer + arregloRecorrido[i];
       }
       arregloRecorrido[contador-1] = posicion1;
       recorrer = recorrer + arregloRecorrido[contador-1];
     
       return arregloRecorrido;
    }
    public int[] recorre2(int[] arregloaRecorrer)
    {
        String recorrer="";
        int contador = arregloaRecorrer.length;
        int posicion1=arregloaRecorrer[0],posicion2=arregloaRecorrer[1];
        int[] arregloRecorrido = new int[contador];
        for(int i=0; i<contador-2; ++i)
        {
            arregloRecorrido[i] = arregloaRecorrer[i+2];
            recorrer = recorrer + arregloRecorrido[i];
        }
        arregloRecorrido[contador-2] = posicion1;
        arregloRecorrido[contador-1] = posicion2;
        
        recorrer = recorrer + arregloRecorrido[contador-2];
        recorrer = recorrer + arregloRecorrido [contador-1];
       System.out.println(recorrer);
        
        return arregloRecorrido;
    }
}
