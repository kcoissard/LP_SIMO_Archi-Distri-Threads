package Archi_Distri_TP1;

import Archi_Distri_TP1.Client;


/*
 * nombre limit� de guichets.
 * 
 * � entrer(Client c) : affecte le client � un guichet s�il y en a un de libre ;
 *  si c�est le cas, la m�thode doit retourn� le num�ro du guichet choisi. 
 *  
 *  
 */
public class Guichets {
	
	private int nb_guichets;

   public Guichets(int nb_guichets) {
	   this.nb_guichets=nb_guichets;
   }
   
   /*
    * affecte le client � un guichet s�il y en a un de libre
    * si c�est le cas, la m�thode doit retourn� le num�ro du guichet choisi.
    */
   public int entrer(Client client) {
      int guichet = -1;
   
         // A completer
      
      return guichet;
   }
   
   
   /*
    * retourne vrai si le client est associ� au guichet donn� en param�tre
    *  Si oui, le guichet devient libre.
    */
   public boolean quitter(Client client, int guichet) {
      boolean res = false;
      
         // A completer
      return false;
   }
}
