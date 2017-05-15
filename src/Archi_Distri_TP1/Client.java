package Archi_Distri_TP1;

import Archi_Distri_TP1.Guichets;
import Archi_Distri_TP1.FileAttente;

public class Client extends Thread {
	
//ajout
	//const
	public static final String ETAT_NOUVEAU = "Nouveau client.";
	public static final String ETAT_ATTENTE = "En attente.";
	public static final String ETAT_GUICHET = "Au guichet.";
	public static final String ETAT_PARTIR = "sort du bureau de poste.";
	
	public static final int PLACES_FILE_ATTENTE = 2;
	public static final int NOMBRE_GUICHETS = 1;
	
	private String thread;
	private String etat=ETAT_NOUVEAU;
	
	private static Guichets guichets = new Guichets(NOMBRE_GUICHETS);
	private static FileAttente file = new FileAttente(PLACES_FILE_ATTENTE);

	
	public Client(String thread){
		super();
		this.thread = thread;
	}

	public void run() {   
	   boolean fin = false;
	  
	      while (! fin) {
	    	  //en arrivant ici tout le monde est nouveau
	    	  if(etat.equals(ETAT_NOUVEAU)){
	    		  //si la file d'attende est vide
	    		  if(file.estVide()){
	    			//guichet dispo -> on récupère son numéro et on entre dedans
		    		  int guichet = Client.guichets.entrer(this);
		    		  // Le client va directement au guichet si y'en a un de dispo
		    		  if (guichet != -1) { 
		    			  entrerGuichet(guichet);
		        		  fin = true;
		        		//si guichet pas dispo
		    		  }else{
		    			  //si la file d'attente n'est pas pleine, on y rentre
		    			  if(file.entrer(this)!=-1){
		    				  System.out.println(this.thread +" voit que tous les guichets sont occupés");
			        		  System.out.println(this.thread +" entre dans la file et attend");
			        		  //maj de son état
			        		  this.etat = ETAT_ATTENTE;
		    			  }
		    			  else{
		    				//maj de son état
		    				  System.out.println("Il n'y a pas de place dans la file d'attente.");
			        		  this.etat = ETAT_PARTIR;
			        		  System.out.println(this.thread + " " + this.etat);
			        		  fin = true;
		    			  }
		    		  }
	    		  }
	    		  //si la file n'est pas vide, il y va
	    		  else{
	    			  if(file.entrer(this)!=-1){
	    				  System.out.println(this.thread +" voit que tous les guichets sont occupés");
		        		  System.out.println(this.thread +" entre dans la file et attend");
		        		  //maj de son état
		        		  this.etat = ETAT_ATTENTE;
	    			  }
	    			  else{
	    				//maj de son état
	    				  System.out.println("Il n'y a pas de place dans la file d'attente.");
		        		  this.etat = ETAT_PARTIR;
		        		  System.out.println(this.thread + " " + this.etat);
		        		  fin = true;
	    			  }
	    		  }
	    	  }
    		  //client en attente
    		  else if(etat.equals(ETAT_ATTENTE)){
    			  //s'il est premeir, go test dispo guichet
    			  if(Client.file.estPremier(this)){
    				  //guichet dispo -> on récupère son numéro et on entre dedans
		    		  int guichet = Client.guichets.entrer(this);
		    		  // Le client va directement au guichet si y'en a un de dispo
		    		  if (guichet != -1) { 
		    			  entrerGuichet(guichet);
		        		  fin = true;
		        		//si guichet pas dispo
		    		  }else{
		    			  //si la file d'attente est pas pleine, on y reste
		    				  System.out.println(this.thread +" voit que tous les guichets sont occupés");
			        		  System.out.println(this.thread +" reste dans la file d'attente et attend encore.");
		    		  }
    			  }
    		  }
    		  else{
    			  fin = true;
    		  }
    	  }
	      System.out.println(this.thread+": process terminé");
   }    	  

   public void entrerGuichet(int numGuichet) {
		
	  //le client sort de la file d'attente
	  file.sortir(this);
	  System.out.println(this.thread + " quitte la file d'attente.");
	  
	  //puis il entre au guichet envoyé en param
	  System.out.println(this.thread +" entre au guichet n°"+(numGuichet+1));
	  //maj de son état
	  this.etat = ETAT_GUICHET;
	  
	 //CF énoncé - Le client se met en attente 2 secondes plus un temps aléatoire compris entre 0 et 1 secondes 
	 //pour simuler le temps passé au guichet. 
	  //temps aléatoire
	  int timeToWait = (int)(Math.random()*(1000));
	  //le client attend 2secs + temps aléatoire
	  try {sleep(2000 + timeToWait);}catch(InterruptedException e){}
	  
	  //une fois terminé, le client quitte le guicher puis le bureau de poste
	  Client.guichets.quitter(this, numGuichet);
	  System.out.println("(Guichet n°:"+numGuichet+" disponible)");
	  
	  //maj de son état
	  this.etat = ETAT_PARTIR;
	  System.out.println(this.thread + " " + this.etat);
   }
}