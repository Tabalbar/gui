import java.util.Scanner;
import java.util.ArrayList;

/**
* This program will create and build an array of pokemon.
* @author Roderick Tabalba
* @since 1/28/2018
*/

public class PokeArray {
   
   //to be accessed throughout the file
   private static ArrayList<Pokemon> pokemonList = new ArrayList<>();
   private static int i = 0; //index
   
   /**
    * This is the main method.
    * @param args not used
    **/
   public static void main(String[] args) {
      
      //Variables to build pokemon
      String sPokemonChoice;
      String yesNo = "";
      String nickname = "";
      int iPokemonChoice = 0;
      
      //userinput
      String sMenuInput = "";
      int iMenuInput = 0;
      Scanner scanInput = new Scanner(System.in);
      boolean exit = false;
      
      //menu. while loop keeps user in menu after invalid input
      while (!exit) {
         System.out.println("1. Add a Pokemon");
         System.out.println("2. Print all Pokemon");
         System.out.println("0. Exit the program");
      
         System.out.print("\nWhat would you like to do: ");
         
         //NFE for String to int.
         try {
            sMenuInput = scanInput.nextLine();
            iMenuInput = Integer.parseInt(sMenuInput);
         } catch (NumberFormatException nfe) {
            System.out.println("\nYou have not entered a number");
            System.out.println("Please try again.\n");
            continue;
         }
          
         //switch statement to:
         //makepokemon
         //print pokemon added
         //exit
         switch(iMenuInput) {
            //option 1 will give a list to the user the choose from
            case 1: 
               System.out.println("Please choose a pokemon you wish to make.");
               System.out.println("1. Bulbasaur");
               System.out.println("2. Ivysaur");
               System.out.println("3. Venasaur");
               System.out.println("4. Charmander");
               System.out.println("5. Charmeleon");
               System.out.println("6. Charizard");
               System.out.println("7. Squirtle");
               System.out.println("8. Wartortle");
               System.out.println("9. Blastoise");
               
               //choosing pokemon try catch. exits out of choose pokemon menu
               try {
                  sPokemonChoice = scanInput.nextLine();
                  iPokemonChoice = Integer.parseInt(sPokemonChoice);
               }
               catch (NumberFormatException nfe) {
                  System.out.println("\nYou have not entered a number");
                  System.out.println("Please try again.\n");
                  continue;
               }
               
               //if user wants to give pokemon a nickname
               System.out.print("\nWould you like to make a nickname?");
               System.out.println(" Enter Yes or No:");
               //just in case of any errors
               yesNo = scanInput.nextLine();
               yesNo = yesNo.trim();
               yesNo = yesNo.toLowerCase();
            
               //if yes
               if (yesNo.equals("yes")) {
                  System.out.println("Please enter Pokemon nickname: ");
                  nickname = scanInput.nextLine();
               } else if (yesNo.equals("no")) {
                  //if nickname answer is no, reset the nickname given
                  nickname = "";
               } else {
                  //if nothing is entered here, empty
                  // string set as nickname to reset
                  nickname = "";
                  System.out.println("You have not entered yes or no.\n");
               }
               
               //switch statement to choose the pokemon
               switch(iPokemonChoice) {
                  case 1:
                     Pokemon bulbasaur = new Bulbasaur(nickname); 
                     addPokemon(bulbasaur);
                     break;
                  case 2:
                     Pokemon ivysaur = new Ivysaur(nickname); 
                     addPokemon(ivysaur);
                     break;
                  case 3:
                     Pokemon venusaur = new Venusaur(nickname); 
                     addPokemon(venusaur);
                     break;
                  case 4:
                     Pokemon charmander = new Charmander(nickname); 
                     addPokemon(charmander);
                     break;
                  case 5:
                     Pokemon charmeleon = new Charmeleon(nickname); 
                     addPokemon(charmeleon);
                     break;
                  case 6:
                     Pokemon charizard = new Charizard(nickname); 
                     pokemonList.add(charizard);
                     i++;
                     break;
                  case 7:
                     Pokemon squirtle = new Squirtle(nickname); 
                     addPokemon(squirtle);
                  
                     break;
                  case 8:
                     Pokemon wartortle = new Wartortle(nickname); 
                     addPokemon(wartortle);
                     i++;
                     break;
                  case 9:
                     Pokemon blastoise = new Blastoise(nickname); 
                     addPokemon(blastoise);
                     break;
                  default:
                     System.out.println("\nYou have not entered a correct ");
                     System.out.println("number. Please try again.\n");
                     break;     
               }
               break;
               
            //option 2 from first menu will print pokemon
            case 2:
               for (i = 0; i < pokemonList.size(); i++) {
                  System.out.println(pokemonList.get(i));
               }
               break;
               //exit
            case 0:
               exit = true;
               break;
               //incorrect values reset to top of menu
            default:
               System.out.println("\nYou have not entered a correct value.");
               System.out.println("Please try again.\n");
               break;
         }
      }
   }
   
   /**
    *This will print the added pokemon for the user.
    *@param pokemon takes in the pokemon to add to array
    */
   public static void addPokemon(Pokemon pokemon) {
      
      //if statement if reach index 6
      //set i back to %6 to keep it in the range of 1-6
      if (i > 5) {
         i = i % 6;
         pokemonList.remove(i);
         pokemonList.add(i, pokemon);
      } else {
         pokemonList.add(pokemon);
         i++;
      }
   }
}