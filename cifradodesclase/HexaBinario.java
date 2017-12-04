/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradodesclase;

/**
 *
 * @author Alumno
 */
public class HexaBinario {
   
   
    
    public String hexaBin(String Hexa)
    {
     String binario = "";   
    for(int i=0; i<16 ; ++i )
    {
        char digito = Hexa.charAt(i);
        binario = binario + transformar(digito);
    }
    
    return binario;
        }
    
    public String transformar (char digito)
    {
        String bin="";
        if(digito=='0')
            bin="0000";
        else if(digito=='1')
            bin="0001";
        else if(digito=='2')
            bin="0010";
        else if(digito=='3')
            bin="0011";
        else if(digito=='4')
            bin="0100";
        else if(digito=='5')
            bin="0101";
        else if(digito=='6')
            bin="0110";
        else if(digito=='7')
            bin="0111";
        else if(digito=='8')
            bin="1000";
        else if(digito=='9')
            bin="1001";
        else if(digito=='A' || digito =='a')
            bin="1010";
        else if(digito=='B' || digito == 'b')
            bin="1011";
        else if(digito=='C' || digito == 'c')
            bin="1100";
        else if(digito=='D' || digito=='d')
            bin="1101";
        else if(digito=='E' || digito=='e')
            bin="1110";
        else if(digito=='F' || digito=='f')
            bin="1111";
        
        return bin;
    }
    public String transformar2(String cadena){
        String anidar="";
        String auxiliar="";
        
        for(int i=1; i<=64; ++i)
        {
            auxiliar= auxiliar + cadena.charAt(i-1);
             
            if(i%4==0 && i!=0)
            {
                
                if(auxiliar.equals("0000"))
                    anidar = anidar + "0";
                else if(auxiliar.equals("0001"))
                    anidar = anidar + "1";
                else if(auxiliar.equals("0010"))
                    anidar = anidar + "2";
                else if(auxiliar.equals("0011"))
                    anidar = anidar + "3";
                else if(auxiliar.equals("0100"))
                    anidar = anidar + "4";
                else if(auxiliar.equals("0101"))
                    anidar = anidar + "5";
                else if(auxiliar.equals("0110"))
                    anidar = anidar + "6";
                else if(auxiliar.equals("0111"))
                    anidar = anidar + "7";
                else if(auxiliar.equals("1000"))
                    anidar = anidar + "8";
                else if(auxiliar.equals("1001"))
                    anidar = anidar + "9";
                else if(auxiliar.equals("1010"))
                    anidar = anidar + "A";
                else if(auxiliar.equals("1011"))
                    anidar = anidar + "B";
                else if(auxiliar.equals("1100"))
                    anidar = anidar + "C";
                else if(auxiliar.equals("1101"))
                    anidar = anidar + "D";
                else if(auxiliar.equals("1110"))
                    anidar = anidar + "E";
                else if(auxiliar.equals("1111"))
                    anidar = anidar + "F";
                
              auxiliar = "";  
            }
         
        } 
         
       return anidar;
    }
}
