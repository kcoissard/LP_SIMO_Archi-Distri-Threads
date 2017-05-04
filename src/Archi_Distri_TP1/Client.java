package Archi_Distri_TP1;

import java.util.Arrays;
import java.util.List;

import Archi_Distri_TP1.Guichets;
import Archi_Distri_TP1.FileAttente;

public class Client extends Thread {
	
//ajout
	//const
	public static final String ETAT_NOUVEAU = "Nouveau client.";
	public static final String ETAT_ATTENTE = "En attente.";
	public static final String ETAT_GUICHET = "Au guichet.";
	public static final String ETAT_PARTIR = "sort du bureau de poste.";
	
	public static final int PLACES_FILE_ATTENTE = 4;
	public static final int NOMBRE_GUICHETS = 2;
	
	//var
	private String etat=ETAT_NOUVEAU;
	private int places_file_attente;
	private int nb_guichets;
	private String nom;
	
	private static Guichets guichets = new Guichets(NOMBRE_GUICHETS);
	private static FileAttente file = new FileAttente(PLACES_FILE_ATTENTE);

	
	public Client(String nom){
		super();
		this.nom = nom;
	}

   public void run() {   
	   boolean fin = false;
	  
	      while (! fin) {
	    	  // Si la file d'attente est vide et que le client est nouveau
	    	  if(file.estVide() && etat.equals("Nouveau client.")) {
	    		  System.out.println(this.nom +" voit que la file est vide);
	    		  
	    		  int guichet = this.guichet.entrer(this);
	    		  
	    		  // Le client va directement au guichet
	    		  if (guichet != -1) { 
	    			  entrerGuichet(guichet);
	        		  fin = true;
	    		  }
	    		  //s'il n'y a plus de place, il attend
	    		  else if (file.entrer(this)!=-1) {
	    			  System.out.println(this.nom +" voit que tous les guichets sont occupés");
	        		  System.out.println(this.nom +" entre dans la file et attend");
	        		  //maj de son état
	        		  this.etat = ETAT_ATTENTE;
	    		  }
	    		  // si le client qui attend est premier de la file
	    	  } else if (etat.equals("En attente.")) {
	    		  //manque une condition ici
	    		  int guichet = this.guichet.entrer(this);
	    		  
	    		  // on réessaie de le faire aller au guichet
	    		  if (guichet != -1) {
	    			  entrerGuichet(guichet);
	        		  fin = true;
	    		  }
	    		// Si la file d'attente n'est pas vide et que le client est nouveau
	    	  } else { 
	    		  // si la file n'est pas pleine, le client y rentre
	    		  if (file.entrer(this)!=-1) {
	    			  System.out.println(this.nom +" voit que tous les guichets sont occupés");
	        		  System.out.println(this.nom +" entre dans la file et attend");
	        		  //maj de son état
	        		  this.etat = ETAT_ATTENTE;
	        		// Sinon il ressort du bureau de poste
	    		  } else {
	    			  System.out.println(this.nom +" voit qu'il y a trop de monde dans la file d'attente et décide de revenir un autre jour");
	        		  this.etat = ETAT_PARTIR;
	        		  fin = true;
	    		  }
	    	  }
   }
   
   public void entrerGuichet(int numGuichet) {
		
	  //le client sort de la file d'attente
	  file.sortir(this);
	  //puis il entre au guichet envoyé en param
	  System.out.println(this.nom +" entre au guichet n°"+(numGuichet+1));
	  //maj de son état
	  this.etat = ETAT_GUICHET;
	  
	 //CF énoncé - Le client se met en attente 2 secondes plus un temps aléatoire compris entre 0 et 1 secondes 
	 //pour simuler le temps passé au guichet. 
	  //temps aléatoire
	  int timeToWait = (int)(Math.random()*(1000));
	  //le client attend 2secs + temps aléatoire
	  try {sleep(2000 + timeToWait);}catch(InterruptedException e){}
	  
	  //une fois terminé, le client quitte le guicher puis le bureau de poste
	  this.guichet.quitter(this, numGuichet);
	  //maj de son état
	  this.etat = ETAT_PARTIR;
	  System.out.println(this.nom + " " + this.etat);
   }
}