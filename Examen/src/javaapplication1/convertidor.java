/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Alumno
 */
 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

  

public class convertidor extends JFrame implements ActionListener{
	private JTextField pesos;
	private JButton uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,cero, convertir,borrar;
        private JLabel titulo;
public convertidor(){
        setLayout(null);
	setBounds(200,250,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	
         
        pesos = new JTextField();
        pesos.setBounds(10,10,400,50);
        add(pesos);
        pesos.setVisible(true);
        pesos.setEditable(false);
        
        
        
         uno = new JButton("1");
         uno.setBounds(50,100,50,50);
         uno.addActionListener(this);
         add(uno);
         uno.setVisible(true);
         
         dos = new JButton("2");
         dos.setBounds(100,100,50,50);
         dos.addActionListener(this);
         add(dos);
         dos.setVisible(true);
         
         tres = new JButton("3");
         tres.setBounds(150,100,50,50);
         tres.addActionListener(this);
         add(tres);
         tres.setVisible(true);
         
         cuatro = new JButton("4");
         cuatro.setBounds(50,150,50,50);
         cuatro.addActionListener(this);
         add(cuatro);
         cuatro.setVisible(true);
         
         cinco = new JButton("5");
         cinco.setBounds(100,150,50,50);
         cinco.addActionListener(this);
         add(cinco);
         cinco.setVisible(true);
         
         seis = new JButton("6");
         seis.setBounds(150,150,50,50);
         seis.addActionListener(this);
         add(seis);
         seis.setVisible(true);
         
         siete = new JButton("7");
         siete.setBounds(50,200,50,50);
         siete.addActionListener(this);
         add(siete);
         siete.setVisible(true);
         
         ocho= new JButton("8");
         ocho.setBounds(100,200,50,50);
         ocho.addActionListener(this);
         add(ocho);
         ocho.setVisible(true);
         
         nueve = new JButton("9");
         nueve.setBounds(150,200,50,50);
         nueve.addActionListener(this);
         add(nueve);
         nueve.setVisible(true);
         
         cero = new JButton("0");
         cero.setBounds(100,250,50,50);
         cero.addActionListener(this);
         add(cero);
         cero.setVisible(true);
         
         convertir = new JButton("convertir");
         convertir.setBounds(250,150,200,50);
         convertir.addActionListener(this);
         add(convertir);
         convertir.setVisible(true);
         
         borrar = new JButton("borrar");
         borrar.setBounds(250,200,200,50);
         borrar.addActionListener(this);
         add(borrar);
         borrar.setVisible(true);
         
         titulo = new JLabel("Convertidor de pesos a dolares");
         titulo.setBounds(300,350,200,100);
         add(titulo);
         titulo.setVisible(true);
         
         setVisible(true);
} 

    @Override
    public void actionPerformed(ActionEvent e) {
         String numero = pesos.getText();
      if(e.getSource()==uno){
        pesos.setText(numero+"1");
        }
      else if(e.getSource()==dos){
        pesos.setText(numero+"2");  
      }
      else if(e.getSource()==tres){
        pesos.setText(numero+"3");
        }
      else if(e.getSource()==cuatro){
        pesos.setText(numero+"4");
        }
      else if(e.getSource()==cinco){
        pesos.setText(numero+"5");
        }
      else if(e.getSource()==seis){
        pesos.setText(numero+"6");
        }
      else if(e.getSource()==siete){
        pesos.setText(numero+"7");
        }
      else if(e.getSource()==ocho){
        pesos.setText(numero+"8");
        }
      else if(e.getSource()==nueve){
        pesos.setText(numero+"9");
        }
      else if(e.getSource()==cero){
        pesos.setText(numero+"o");
        }
      else if(e.getSource()== convertir)
      {
          float numa = Integer.parseInt(pesos.getText());
          numa=numa/19;
          String dolares = Float.toString(numa);
          pesos.setText(dolares);
      }
      else if(e.getSource() == borrar){
          pesos.setText("");
      }
    }

  

   

}