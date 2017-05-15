package Archi_Distri_TP1;

import java.util.ArrayList;

public class Guichets {

//var
	ArrayList<Client> listGuichets;
	private int nb_guichets;
	

   public Guichets(int nb_guichets) {
	   listGuichets = new ArrayList<Client>(nb_guichets);
	   this.nb_guichets = nb_guichets;
   }
   
   /*
    * /!\ SECTION CRITIQUE
    * Retourne le num du guicher s’il y en a un de libre et qu'un client y est affecté
    * Sinon retourne -1 car il n'y a pas de guichet dispo
    */
   synchronized public int entrer(Client client) {
	  int num_guichet = -1;
	  //test de la dispo du guichet en fonction de la liste reçue
      if(listGuichets.size()<nb_guichets){
    	  listGuichets.add(client);
    	  //on retourne le num du guichet
    	  num_guichet = listGuichets.indexOf(client);
    	  if(listGuichets.size()==2){
    		  System.out.println("(Guichets tous occupés !)");
    	  }
    	 
    	  //ajout du client au guichet
      } else{
    	  //sinon on attend qu'un guichet se libère
       	  try {wait();}
       	  catch (InterruptedException e) {}
      }
      return num_guichet;
   }
   
   
   /*
    * pour que le client quitte le guichet
    */
   synchronized public void quitter(Client client, int guichet) {
	 //S'il quitte le guichet, on réveil les autres clients
      if (listGuichets.remove(client)) {
    	  notifyAll();
    	  System.out.println(client.getName()+" quitte le guichet n°"+guichet);
      }
   }
}
