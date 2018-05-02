/**
 * An Exception for use with the Pokemon class.
 * 
 * @author Roderick Tabalba
 * @since 4/7/2018
 */
public class PokemonException extends RuntimeException {
   /**
    * Constructor.
    * 
    * @param message Describes the cause of the error
    */
   public PokemonException(String message) {
      super(message);
   }
} // end of class

