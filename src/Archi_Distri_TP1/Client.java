package Archi_Distri_TP1;

import java.util.Arrays;
import java.util.List;

import Archi_Distri_TP1.Guichets;
import Archi_Distri_TP1.FileAttente;

public class Client extends Thread {
	
//ajout
	//const
	public static final String NOUVEAU = "Nouveau client.";
	public static final String ATTENTE = "En attente.";
	public static final String GUICHET = "Au guichet.";
	
	public static final int ARRIVEE_CLIENT=500;
	
	//var
	private String etat=NOUVEAU;
	private int places_file_attente;
	private int nb_guichets;
	private String nom_thread;

//base
   private static Guichets guichet = new Guichets(2);
   private static FileAttente file = new FileAttente(3);

	public Client(String nom){
		super();
		this.nom = nom;
	}

   public void run() {   
      boolean fin = false;
   
      while (! fin) {
      }
   }
   
   public void entrerGuichet(int numGuichet) {
	   
   }
}