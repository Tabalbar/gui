import java.util.PriorityQueue;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Program will generate 100 pokemon and place them into a stack and PQ.
 *
 * @author Roderick Tabalba
 * @since 4/2/2018
 */
 
public class PokemonQueue {
   
   /**
    * This is the main method.
    * @param args not used
    */
   public static void main(String [] args) {
   
      //Stack and deque variables
      Deque<Pokemon> pokemonStack = new ArrayDeque<Pokemon>();
      PriorityQueue<Pokemon> pq = new PriorityQueue<>();
   
      //for loop that calls createpokemon 100 times
      //and puts them in both stack and pq
      for (int i = 0; i <= 99; i++) {
         Pokemon p = createPokemon(i);
         pokemonStack.push(p);
         pq.add(p);
      } 
      
      //Print out the pq pokemon toString
      while (pq.size() > 0) {
         Pokemon curr = pq.poll();
         System.out.println(curr.toString());
      }      
      
      //print out stack pokemon toString
      System.out.println("----------------------------");
      while (pokemonStack.size() > 0) {
         Pokemon curr = pokemonStack.pop();
         System.out.println(curr.toString());
      }
   
      
   }
   
   /**
    * Create a hundred pokemon.
    * @return pokemon being created
    * @param i number being sent in to create pokemon in switch
    */
   public static Pokemon createPokemon(int i) {
      
      //divide by ten to distribute to other pokemon
      i = i / 10;
      
      //switch method will create 10 of each pokemon with
      //the division of i
      switch (i) {
         case 0:
            Pokemon bulbasaur = new Bulbasaur();
            return bulbasaur;
         case 1:
            Pokemon ivysaur = new Ivysaur();
            return ivysaur;
         case 2:
            Pokemon venusaur = new Venusaur();
            return venusaur;
         case 3:
            Pokemon squirtle = new Squirtle();
            return squirtle;
         case 4:
            Pokemon wartortle = new Wartortle();
            return wartortle;
         case 5:
            Pokemon blastoise = new Blastoise();
            return blastoise;
         case 6:
            Pokemon charmander = new Charmander();
            return charmander;
         case 7:
            Pokemon charmeleon = new Charmeleon();
            return charmeleon;
         case 8: 
            Pokemon charizard = new Charizard();
            return charizard;
         case 9:
            Pokemon eevee = new Eevee();
            return eevee;
         default:
            break;
            
      }
      
      //Complains about return statement here so just added eevee
      Pokemon eevee = new Eevee();
      return eevee;
     
   }
   

}