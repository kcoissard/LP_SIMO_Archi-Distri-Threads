package Archi_Distri_TP1;

import Archi_Distri_TP1.Client;
import Archi_Distri_TP1.FileAttente;
import Archi_Distri_TP1.Guichets;

public class Main {
	
	public static final int ARRIVEE_CLIENT=500;

	   
	//EXECUTION DU PROGRAMME 
	public static void main(String [] args){
		for(int i=0;1==1;i++) {
			//nom des cients
			String nom = "Client"+Integer.toString(i);
			System.out.println("Nouveau client " + nom);
			Client client = new Client(nom);
			//thread client run
			client.start();
			//
			try {Thread.sleep(ARRIVEE_CLIENT);} 
			catch(InterruptedException e){}
		}
	}
	
}
