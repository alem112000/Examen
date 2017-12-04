package cifradodesclase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Cifrado {
    public void cifrar(){
        transformarStringHexa generar = new transformarStringHexa();
        capturarDatos captura = new capturarDatos();
        String [] arregloTexto = generar.capturarDatos();
        int repeticionesTotales = arregloTexto.length;
        String cifradoCompleto="";
        String clavee = captura.capturarClave();
        for(int repes=0; repes<repeticionesTotales; ++repes)
        {
        //Variables
         
         String textoCifrar = arregloTexto[repes];
         String clave = clavee;
         System.out.println("El texto a cifrar es:" + textoCifrar);
         int c0[] = new int [28];
         int d0[] = new int [28];
         int l0[] = new int [32];
         int r0[] = new int [32];
         
         String clavePermutadaa = "";
         String textoPermutadoo = "";
         int contadorAuxiliar =0;
        //Se Convierten a binario la clave y el texto
        
         HexaBinario convierte = new HexaBinario();
         clave = convierte.hexaBin(clave);
         textoCifrar =convierte.hexaBin(textoCifrar);
        
       
        //Se imprimen la clave y el texto en binario
        
         System.out.println("Clave original:"+clave);
         System.out.println("Texto a cifrar Original:"+textoCifrar);
        
        // Se hace la primera permutacion a la clave y al texto (PC1, P)
        
         Permutador cambiar = new Permutador();
         int tipoPermutacion = 1;
         int [] clavePermutada = cambiar.permutar(clave,tipoPermutacion);
        // Se asigna c0 y d0
        c0 = cambiar.dividirArreglosa(clavePermutada);
        d0 = cambiar.dividirArreglosb(clavePermutada);
        clavePermutadaa = cambiar.comas(clavePermutada);
        System.out.println("La clave permutada es:"+clavePermutadaa);
       
       
       
       // Se asigna l0 y r0
        Permutador cambiar2 = new Permutador();
        tipoPermutacion = 3;
        int [] textoPermutado = cambiar2.permutar(textoCifrar , tipoPermutacion);
        l0 = cambiar2.dividirArreglosa(textoPermutado);
        r0 = cambiar2.dividirArreglosb(textoPermutado);
        textoPermutadoo = cambiar2.comas(textoPermutado);
        System.out.println("El texto permutado es:"+ textoPermutadoo);
       
       
       //Se generan c1-c16, d1-d16 , k1-k16
        int izquierdo [] = new int[28];
        int derecho [] = new int[28];
        int rXorK[] = new int[48];
        int rAuxiliar [] = new int[32];
        for(int i=0; i<16; ++i)
        {
         rAuxiliar = r0;
         contadorAuxiliar=0;
         String concatenadaa="";
         String textoConcatenada="";
         String Xorr ="";
         Permutador cambiar3 = new Permutador();
         tipoPermutacion = 2;
         Recorrer mover = new Recorrer();
        
         if(i==0)
         {
          izquierdo  =  mover.recorre1(c0);
          derecho = mover.recorre1(d0);
         }
         else if(i==1 || i== 8 || i==15)
         {
            izquierdo  =  mover.recorre1(izquierdo);
            derecho = mover.recorre1(derecho);
          }
        else 
        {
            izquierdo  =  mover.recorre2(izquierdo);
            derecho = mover.recorre2(derecho); 
        }
        
        
         String izquierdoo = cambiar3.comas(izquierdo);
         String derechoo = cambiar3.comas(derecho);
        
        for(int k=0; k<56; ++k)
        {
            if(k<28)
            concatenadaa= concatenadaa + izquierdo[k] ;
            else
            {
             concatenadaa = concatenadaa +derecho[contadorAuxiliar];
            ++ contadorAuxiliar;
            }
        }
        int claveK [] = cambiar3.permutar(concatenadaa , tipoPermutacion);
        String claveek = cambiar3.comas(claveK);
        System.out.println("C,D,K"+(i+1)+":");
        System.out.println(izquierdoo);
        System.out.println(derechoo);
        System.out.println(claveek);
        // Hacer Expansion de claves
           tipoPermutacion = 6;
            Xor operacion = new Xor();
            
            for(int k=0; k<32; ++k)
        {
            textoConcatenada = textoConcatenada+r0[k];   
        }
            r0 = cambiar3.permutar(textoConcatenada,tipoPermutacion);
            rXorK = operacion.xorOperacion(r0, claveK);
            String expansion = cambiar3.comas(r0);
         
            Xorr = cambiar3.comas(rXorK);
            System.out.println(expansion);
            System.out.println("Xor"+i+": "+Xorr);
            
            // Permutacion en tabla grande
            Eses megaPermu = new Eses();
            String BSS = megaPermu.permu(rXorK);
            System.out.println("NuevasBS:"+ BSS);
            
            //Nueva Permutacion P
            int [] BSSarray = new int[32];
            for(int j=0; j<32; ++j)
            {
                BSSarray[i]=BSS.charAt(i);
            }
            tipoPermutacion = 4;
            BSSarray = cambiar3.permutar(BSS,tipoPermutacion );
            String permutacionP = cambiar3.comas(BSSarray);
            System.out.println("Despues de permutar las B´S"+permutacionP);
            
            //OR Exclusiva entre Permutacion P y l(i-1)
            r0 = operacion.xorOperacion(BSSarray, l0);
            l0 = rAuxiliar;
            int[] rl = new int[64];
            contadorAuxiliar=0;
            for(int j=0; j<64; ++j)
            {
                if(j<32)
                
                rl[j]=l0[j];
                else
                {
                    rl[j]=r0[contadorAuxiliar];
                    ++contadorAuxiliar;
                }
            }
            String rls = cambiar3.comas(rl);
            System.out.println("Siguiente seccion a codificar: "+rls);
       }
       // Texto final
       
       int [] textoFinal = new int[64];
       String textoEncriptadoo="";
         contadorAuxiliar=0;
         tipoPermutacion = 5;
            for(int j=0; j<64; ++j)
            {
                if(j<32)
                {
                   textoFinal[j]=r0[j];
                   
                }
               
                else
                {
                    textoFinal[j]=l0[contadorAuxiliar]; 
                    ++contadorAuxiliar;
                }
                textoEncriptadoo = textoEncriptadoo + textoFinal[j];
            }
           //Ultima permutacion
            Permutador cambiar4 = new Permutador(); 
            String textoFinall = cambiar4.comas(textoFinal);
            
            
            System.out.println("Texto plano"+textoFinall);
            Permutador cambiar5= new Permutador();
            int [] textoEncriptado = cambiar5.permutar(textoEncriptadoo ,tipoPermutacion);
            HexaBinario transformar = new HexaBinario();
            String hexadecimall="";
            for(int i=0; i<64; ++i)
            {
                hexadecimall = hexadecimall + textoEncriptado[i];
            }
            //Resultado en Hexadecimal
            String hexadecimal = transformar.transformar2(hexadecimall);
            String textooEncriptadoo = cambiar5.comas(textoEncriptado);
            System.out.println("El texto cifrado es: "+textooEncriptadoo);
            System.out.println("El texto cifrado en hexadecimal es: "+ hexadecimal); 
            cifradoCompleto = cifradoCompleto + hexadecimal+" , ";
              System.out.println("El cifrado completo es: "+cifradoCompleto);
    }
    } 
    }
