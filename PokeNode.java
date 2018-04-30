/**
 * This if the PokeNode Pokemon class.
 * 
 * @author Roderick Tabalba
 * @since 4/16/2018
 */

/**
 * PokeNode class.
 */
public class PokeNode {

   //private data fields 
   private Pokemon poke;
   private int key; //key is Pokemon number
   private int numCaught = 1; //how many times user caught pokemon
   private PokeNode lChild;
   private PokeNode rChild;
   

   /**
    * This is the PokeNode constructor.
    * @param p is the pokemon held in pokeNode
    * @param numC is the number of times pokemon is caught
    * @param l is the left child of root
    * @param r is the right child of root
    * @throws PokemonException if pokemon data is null
    */
   public PokeNode(Pokemon p, int numC, PokeNode l, PokeNode r)
      throws PokemonException {
      
      //if PokeNode pokemon is null, throw expceiton here
      if (p != null) {
         poke = p;
      } else {
         throw new PokemonException("ERROR: Pokemon value cannot be null.");
      }
      
      //throws exception if numCaught is less than 1.
      if (numCaught >= 1) {
         numCaught = numC;
      } else {
         throw new PokemonException("ERROR: Pokemon Caught is less than 1.");
      }
      
      //left = left; right = right
      lChild = l;
      rChild = r;
   }
   
   /**
    * @return poke the pokemon in the PokeNode.
    */
   public Pokemon getPokemon() {
      return poke;
   }
   
   /**
    * This is the Pokemon number.
    * @return key is the number of pokemon for PokeTree class
    */
   public int getKey() {
      key = poke.getNumber();
      return key;
   }
   
   /**
    * Num Caught is the numebr of times pokemon is caught.
    * @return numCaught is the data for how many times poke is caught
    */
   public int getNumCaught() {
      return numCaught;
   }
   /**
    * left child data.
    * @return lChild is the left child of root
    */ 
   public PokeNode getLChild() {
      return lChild;
   }
   
   /**
    * right child data.
    * @return rChlid is the right child of root
    */ 
   public PokeNode getRChild() {
      return rChild;
   }
   
   //set Method***************
   
   
   /**
    * Could not figure out a way to remove node so had.
    * had to use set method for pokemon
    * @param p is the pokemon to be removed or set.
    */
   public void setPoke(Pokemon p) {
      poke = p;
   }
   
   /**
    * increments the number of times pokemon is caught.
    */ 
   public void increaseNumCaught() {
      numCaught++;
   }
   
   /**
    * decrements the number of times pokemon is caught.
    * @throws PokemonException if numCaught goes below 1
    */    
   public void decreaseNumCaught() throws PokemonException {
      numCaught--;
      
      //numCaught should not reach below 1.
      if (numCaught < 1) {
         throw new 
         PokemonException("ERROR: Pokemon caughtcannot be less than 1.");
      }
   }
   /**
    * Setting the left child.
    * @param newLChild is the new data to be set for left child
    */ 
   public void setLChild(PokeNode newLChild) {
      lChild = newLChild;
   }
   
   /**
    * Setting the right child.
    * @param newRChild is the new data to be set for right child
    */   
   public void setRChild(PokeNode newRChild) {
      rChild = newRChild;
   }
}