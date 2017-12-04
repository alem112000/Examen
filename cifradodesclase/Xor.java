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
public class Xor {
    
    public int[] xorOperacion(int[] arreglo1, int[] arreglo2)
    {
        int tamaño = arreglo1.length;
        int []xor = new int[tamaño];
        for(int i=0; i<tamaño; ++i)
        {
            if(arreglo1[i] == arreglo2[i])
                xor[i] = 0;
            else 
                xor[i] = 1;
        }
        
        return xor;
    }
    
}
