package proyecto;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import proyecto.graphics.*;


/**
 * 
 * @author Gustavo Saavedra
 *
 */

public class Principal {

	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable()
	    {
	      public void run()
	      {
	    	  CuadroDialogo.displayJFrame();
	      }
	    });
	}
	
	
	/**
	 * Genera un numero entero aleatorio entre min y max
	 * @param min, minimo valor posible
	 * @param max, maximo valor posible
	 * @return randomNum, un numero aleatorio
	 */
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}


