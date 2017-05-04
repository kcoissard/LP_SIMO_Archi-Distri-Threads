package Archi_Distri_TP1;

import java.util.ArrayList;

import Archi_Distri_TP1.Client;

public class FileAttente {

	private int taille_file;
	ArrayList<Client> fileAttente; 
	
   public FileAttente(int taille_file) {
	   fileAttente = new ArrayList<Client>(taille_file);
	   this.taille_file=taille_file;
   }
   
   
   /*
    * retourne vrai si la file est vide 
    */
   public boolean estVide() {
	   //test sur la liste directement
	   return this.fileAttente.isEmpty();
   }

   
   /*
    * retourne vrai si le client est premie
    */
   public boolean estPremier(Client client) {     
	   //on récupère le premier de la liste - First in First out
	   return fileAttente.get(0) == client;
   }
   
   
   /*
    * retourne 0 si le client peut entrer dans la file
    * Si oui, le client est alors automatiquement inséré dans la file.
    * sinon retourne -1 
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
    * retourne vrai si le client est premier de la file
    * Si oui, le client est alors automatiquement retiré de la file.
    */
   synchronized public boolean sortir(Client client) {
      boolean res = false;
      if (fileAttente.remove(client)) {
    	  notifyAll();
    	  res = false; 
      }
          
      return false;
   }
}
