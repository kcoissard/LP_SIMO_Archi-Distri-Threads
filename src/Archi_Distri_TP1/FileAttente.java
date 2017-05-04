package Archi_Distri_TP1;

import java.util.ArrayList;

import Archi_Distri_TP1.Client;

public class FileAttente {
	
//ajout
	//const
	public static final int PLACES_FILE_ATTENTE = 4;
	
	//var
	private int taille_file=PLACES_FILE_ATTENTE;
	ArrayList<Client> fileAttente; 
	
   public FileAttente(int taille_file) {
	   fileAttente = new ArrayList<Client>(taille_file);
	   this.taille_file=taille_file;
   }
   
   
   /*
    * Retourne vrai si la file est vide
    */
   public boolean estVide() {
	   //test sur la liste directement
	   return this.fileAttente.isEmpty();
   }

   
   /*
    * Retourne vrai si le client est premier
    */
   public boolean estPremier(Client client) {     
	   //on récupère le premier de la liste - First in First out
	   return fileAttente.get(0) == client;
   }
   
   
   /*
    * Retourne 0 si le client peut entrer dans la file
    * Si oui, le client est alors automatiquement inséré dans la file.
    * Si non retourne -1 
    */
   public int entrer(Client client) {
	   int file = -1;
	   	//on test s'il y a de la place dans la file
	      if(fileAttente.size()<taille_file){
	    	  //si oui, on l'ajoute à la file
	    	  fileAttente.add(client);
	    	  //index of --> si le client est présent dans l'ArrayList fileAttente return 0 sinon -1
	    	  file = fileAttente.indexOf(client);
	    	  System.out.println("Nb de personnes dans la file : "+fileAttente.size()+".");
	      } else{
	    	  //si non, on le fait attendre puis on le fera sortir dans la main
	       	  try {wait();}
	       	  catch (InterruptedException e) {}
	      } 
	    return file; 
   }
   
   
   /*
    * /!\ SECTION CRITIQUE
    */
   synchronized public void sortir(Client client) {
      //S'il y a suppression de la file, on réveil les autres clients
      if (fileAttente.remove(client)) {
    	  notifyAll();
      }
   }
}
