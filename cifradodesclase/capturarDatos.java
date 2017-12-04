/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradodesclase;

/**
 *
 * @author Administrador
 */
import java.util.*;

public class capturarDatos {
    public String capturarTexto(){
        String textoaCifrar="";
        Scanner leer = new Scanner(System.in); 
        System.out.println("Introduzca el texto que desea cifrar:");
        textoaCifrar = leer.nextLine();
        for(int i=0; i<textoaCifrar.length();++i)
        {
            char valor = textoaCifrar.charAt(i);
           
        }
        
        return textoaCifrar;
    }
    
    public String capturarClave(){
        String clave="";
        Scanner leer = new Scanner(System.in);
        boolean continuar = true;
        while(continuar == true)
        {
        System.out.println("Introduzca la clave secreta que desea usar en el cifrado(Debe estar en hexadecimal):");
        clave = leer.nextLine();
        for(int i=0; i<clave.length();++i)
        {
            char valor = clave.charAt(i);
            int valoor = (int)(valor);
            if((valoor > 47 && valor < 58) || (valor > 64 && valor < 71) || (valor > 96 && valor < 103))
            {
                continuar = false;
            }
            else
            {
                System.out.println("Clave no válida " + valor );
                System.out.println("Escriba su clave nuevamente");
                continuar = true;
                break;
            }
        }
        }
        if(clave.length() < 16)
        {
            while(clave.length() < 17)
                clave = clave + "0";
        }
        return clave;
    }
}
