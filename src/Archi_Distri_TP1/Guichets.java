package Archi_Distri_TP1;

import Archi_Distri_TP1.Client;


/*
 * nombre limité de guichets.
 * 
 * • entrer(Client c) : affecte le client à un guichet s’il y en a un de libre ;
 *  si c’est le cas, la méthode doit retourné le numéro du guichet choisi. 
 *  
 *  
 */
public class Guichets {
	
	private int nb_guichets;

   public Guichets(int nb_guichets) {
	   this.nb_guichets=nb_guichets;
   }
   
   /*
    * affecte le client à un guichet s’il y en a un de libre
    * si c’est le cas, la méthode doit retourné le numéro du guichet choisi.
    */
   public int entrer(Client client) {
      int guichet = -1;
   
         // A completer
      
      return guichet;
   }
   
   
   /*
    * retourne vrai si le client est associé au guichet donné en paramètre
    *  Si oui, le guichet devient libre.
    */
   public boolean quitter(Client client, int guichet) {
      boolean res = false;
      
         // A completer
      return false;
   }
}
