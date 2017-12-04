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
public class transformarStringHexa {
    public String[] transformaStringHexa(String[] texto)
    {
        int tamaño = texto.length;
        String [] hexa = new String [tamaño];
        for(int i=0; i<tamaño; ++i)
        {
            String elementoArreglo = "";
            String convertido="";
             elementoArreglo = texto [i];
            for(int j=0; j<elementoArreglo.length(); ++j)
            { 
               char convierte = elementoArreglo.charAt(j);
               convertido = convertido + charHexa(convierte);
            }
            if(convertido.length()<8)
            {
                if(convertido.length() == 2)
                convertido = convertido + "000000";
            else  if(convertido.length() == 4)
                convertido = convertido + "0000";
            else
                 if(convertido.length() == 6)
                convertido = convertido + "00";
            }
            hexa [i] = convertido;
            
        }
        
        return hexa;
    }
    
    public String charHexa (char caracter)
    {
        String transformado="";
        int numero = (int)(caracter);
        int numeroDividido = numero;
        if(numero > 16)
        {
         for(int i=0; i<2; ++i)
        {
            String individual = "";
            int residuo = numeroDividido-(((int)(numeroDividido/16))*16);
            if(residuo > 9)
            {
               if(residuo == 10)
                        individual = "a";
               else if(residuo == 11)  
                        individual = "b";
               else if(residuo == 12)    
                        individual = "c";
               else if(residuo == 13)     
                        individual = "d";
               else if(residuo == 14)    
                        individual = "e";
               else if(residuo == 15)    
                        individual = "f";
                }
           
            else
                individual = String.valueOf(residuo);
            
           transformado = transformado + individual; 
           numeroDividido = numeroDividido / 16;
        }
        }
        else
        {
            switch(numero)
            {
                case 1:
                    transformado = "01";
                case 2:
                    transformado = "02";
                case 3:
                    transformado = "03";
                case 4: 
                    transformado = "04";
                case 5:
                    transformado = "05";
                case 6:
                    transformado = "06";
                case 7:
                    transformado = "07";
                case 8:
                    transformado = "08";
                case 9:
                    transformado = "09";
                case 10:
                    transformado = "0a";
                case 11:
                    transformado = "0b";
                case 12:
                    transformado = "0c";
                case 13:
                    transformado = "0d";
                case 14:
                    transformado = "0e";
                case 15:
                    transformado = "0f";
                case 16:
                    transformado = "10";
                  
            }       
        }
        transformado = String.valueOf(transformado.charAt(1)) + String.valueOf(transformado.charAt(0));
       
        
        return transformado;
    }
    
    public String[] capturarDatos(){
        capturarDatos capturar = new capturarDatos();
        String aTransformar = capturar.capturarTexto() ;
        int tamaño = (int)(aTransformar.length() / 4);
        if(aTransformar.length()%4 == 0)
            tamaño = tamaño;
        else 
            tamaño = tamaño + 1;
        
        String arreglito [] = new String[tamaño];
        String parteArre="";
        int contador = 0;
        for(int i=1; i<=aTransformar.length(); ++i)
        {
            parteArre = parteArre + aTransformar.charAt(i-1);
            if(i%4 == 0)
            { 
                arreglito[contador] = parteArre;
                ++ contador;
                parteArre="";
              
            }
        }
        if(parteArre.equals(""))
        {
            System.out.println("Valores justos");
            
        }
        else
        { 
            arreglito[contador] = parteArre;
        }
       
       String [] arreglitoTransformado = transformaStringHexa(arreglito); 
       int cantidad = arreglitoTransformado.length % 2;
       int cuantos = 0;
       
       if(cantidad == 0) 
       {
           cuantos = arreglitoTransformado.length/2;
       }
       else
       {
           cuantos = (arreglitoTransformado.length/2)+1;
           
       }
       String [] arregloaCifrar = new String[cuantos];
       int conti = 0;
       for(int i=0; i<(int)(arreglitoTransformado.length/2); ++i)
       {
           arregloaCifrar[i] = arreglitoTransformado[conti] + arreglitoTransformado[conti+1];
           conti = conti + 2;
       }
       
        if(cantidad !=0)
        {
            int donde = arreglitoTransformado.length -1;
            arregloaCifrar[cuantos-1] = arreglitoTransformado[donde] + "00000000";
        }
       return arregloaCifrar;
    }  
    }

