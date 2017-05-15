package Archi_Distri_TP1;

import Archi_Distri_TP1.Client;

public class Main {
	
	public static final int ARRIVEE_CLIENT=1000;
	public static final int NOMBRE_CLIENTS=6;

	   
	//EXECUTION DU PROGRAMME 
	public static void main(String [] args){
		for(int i=0;i<NOMBRE_CLIENTS;i++) {
			//nom des cients
			String nom = Integer.toString(i);
			System.out.println("Un nouveau client arrive : " + nom);
			Client client = new Client(nom);
			
			//thread client run
			client.start();

			//nouveau client toutes les 500ms
			try {Thread.sleep(ARRIVEE_CLIENT);} 
			catch(InterruptedException e){}
		}
		System.out.println("Il n'y aura plus de nouveau client aujourd'hui !");
	}
}
