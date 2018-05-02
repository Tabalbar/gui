import java.util.Random;
import java.util.Scanner;

/**
 * This is the main method Pokedex.
 * 
 * @author Roderick Tabalba
 * @since 4/16/2018
 */

public class Pokedex {

   /**
    * This is the main driver method.
    * @param args not used.
    */
   public static void main(String [] args) {
   
      //variables declared here
      PokeTree pt = new PokeTree();
      boolean exit = false;
      int iPlayerChoice;
      int randPoke;
      Scanner userInput = new Scanner(System.in);
      String sPlayerChoice;
      Random genRan = new Random();
      
      //while to keep user in menu option
      while (!exit) {
         System.out.println("Please Choose what you would like to do:");
         System.out.println("----------------------------------------");
         System.out.println("1. Catch Pokemon");
         System.out.println("2. Trade Pokemon");
         System.out.println("3. Print Pokedex");
         System.out.println("0. Exit the program.");
      
         //try/catch for NumberFormatException
         try {
            sPlayerChoice = userInput.nextLine();
            iPlayerChoice = Integer.parseInt(sPlayerChoice);
         } catch (NumberFormatException nfe) {
            System.out.print('\n' + "You have enetered");
            System.out.println(" an incorrect number." + '\n');
            continue;
         }
         
         //Switch menu for player's choices
         switch(iPlayerChoice) {
            case 1:
               //creates a random integer from 0 - 9.
               randPoke = genRan.nextInt(10);
               //sends that random int to make random pokemon
               Pokemon newPoke = genNewPokemon(randPoke);
               //shows what pokemon user caught
               System.out.println('\n' + "The pokemon you found is: ");
               System.out.println('\n' + newPoke.toString());
               //add it to the tree
               pt.add(newPoke);
               break;
               
            //case 2 trades the pokemon and starts with printing
            //all the pokemons with number caught
            case 2:
               pt.printPokeTree();
               System.out.println("Choose a pokemon you wish to remove.");
               System.out.println("***** 1. Bulbasaur");
               System.out.println("***** 2. Ivysaur");
               System.out.println("***** 3. Venasaur");
               System.out.println("***** 4. Charmander");
               System.out.println("***** 5. Charmeleon");
               System.out.println("***** 6. Charizard");
               System.out.println("***** 7. Squirtle");
               System.out.println("***** 8. Wartortle");
               System.out.println("***** 9. Blastoise");
               System.out.println("***** 0. Eevee");
               try {
                  sPlayerChoice = userInput.nextLine();
                  iPlayerChoice = Integer.parseInt(sPlayerChoice);
               } catch (NumberFormatException nfe) {
                  System.out.print('\n' + "You have not ");
                  System.out.println("entered a valid number." + '\n');
                  continue;
               }
               
               //made a switch menu and used genNewPokemon 
               //but player gets to choose what pokemon to remove
               switch(iPlayerChoice) {
                  case 1: //bulbasaur
                     Pokemon newPoke1 = genNewPokemon(1);
                     pt.remove(newPoke1);
                     break;
                  case 2: //ivysaur
                     Pokemon newPoke2 = genNewPokemon(2);
                     pt.remove(newPoke2);
                     break;
                  case 3: //venusaur
                     Pokemon newPoke3 = genNewPokemon(3);
                     pt.remove(newPoke3);
                     break;
                  case 4: //charmander
                     Pokemon newPoke4 = genNewPokemon(4);
                     pt.remove(newPoke4);
                     break;
                  case 5: //charmeleon
                     Pokemon newPoke5 = genNewPokemon(5);
                     pt.remove(newPoke5);
                     break;
                  case 6: //charizard
                     Pokemon newPoke6 = genNewPokemon(6);
                     pt.remove(newPoke6);
                     break;
                  case 7: //squirtle
                     Pokemon newPoke7 = genNewPokemon(7);
                     pt.remove(newPoke7);
                     break;
                  case 8: //wartortle
                     Pokemon newPoke8 = genNewPokemon(8);
                     pt.remove(newPoke8);
                     break;
                  case 9: //blastoise
                     Pokemon newPoke9 = genNewPokemon(9);
                     pt.remove(newPoke9);
                     break;
                  case 0: //default which is eevee
                     Pokemon newPoke0 = genNewPokemon(0);
                     pt.remove(newPoke0);
                     break;
                  default: //incorrect number
                     System.out.println("You have entered an incorrect number");
                     break;
               }
               break;
            //case 3 will just call poketree print method
            case 3:
               pt.printPokeTree();
               break;
            
            //exit the game
            case 0:
               exit = true;
               break;
            default:
               System.out.println("You have entered a incorrect number.");
               break;
         
         }
      }
   }
   
   /**
    * This will generate the pokemon for user.
    * @param p will be sent to switch menu to print 1 pokemon
    * @return Pokemon new pokemon made
    */
   public static Pokemon genNewPokemon(int p) {
      switch(p) {
         case 1:
            Pokemon b = new Bulbasaur();
            return b;
         case 2:
            Pokemon i = new Ivysaur();
            return i;
         case 3:
            Pokemon v = new Venusaur();
            return v;
         case 4:
            Pokemon c = new Charmander();
            return c;
         case 5:
            Pokemon cl = new Charmeleon();
            return cl;
         case 6:
            Pokemon ca = new Charizard();
            return ca;
         case 7:
            Pokemon s = new Squirtle();
            return s;
         case 8:
            Pokemon w = new Wartortle();
            return w;
         case 9:
            Pokemon bs = new Blastoise();
            return bs;
         default:
            Pokemon e = new Eevee();
            return e;
      }
   }
}