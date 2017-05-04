package Archi_Distri_TP1;

import Archi_Distri_TP1.Client;
import Archi_Distri_TP1.FileAttente;
import Archi_Distri_TP1.Guichets;

public class Main implements Runnable {
	
	//const
	public static final int ARRIVEE_CLIENT=500;
	public static final int PLACES_FILE_ATTENTE = 4;
	public static final int NOMBRE_GUICHETS = 2;
	

	//var
	   private static Guichets guichets = new Guichets(NOMBRE_GUICHETS);
	   private static FileAttente file = new FileAttente(PLACES_FILE_ATTENTE);
	
	   public void run()
	    {
	        int somme = 0;
	        
	        for(int i = offset; i < longueur; i++)
	        {
	            somme += tableau[i];
	        }
	        
	       //total+=somme;
	        
	        synchronized(total) {
	        	total+=somme;
	        }
	    }   
	   
	//EXECUTION DU PROGRAMME 
	public static void main(String [] args){
		
	}
	
}
