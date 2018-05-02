import javax.swing.JFrame;

/**
 * This is the main method to run pokemonPanel.
 * @author Roderick Tabalba
 * @since 5/1/2018
 */
public class PokemonFrame {

   /**
    * This is the main method.
    * @param args not used
    */
   public static void main(String[] args) {
   
      //Title of the fram
      JFrame frm = new JFrame("Rj's Pokemon Game");
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to close
      frm.getContentPane().add(new PokemonPanel()); //add pokemonpanel.java
      frm.pack();
      frm.setVisible(true);
   
   }

}