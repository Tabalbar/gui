import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //add this for the listener
import java.util.*;

/**
 * Coding and layout for Pokemonframe.java.
 *
 * @author Roderick Tabalba
 * @since 4/30/2018
 *
 */
public class PokemonPanel extends JPanel {

   //int and String variables 
   private static int iGenPoke = -1;
   private String pokeTree = new String(""); //to concatnate Strings
   private String sPokemon = new String(""); //pokemon name

   //labels and button variables
   private JLabel tTitle = new JLabel("Hi! Welcome to my Pokemon game.");
   private JLabel caught = new JLabel(""); //show if caught or not
   private JLabel msg = new JLabel("");
   private JButton bHunt = new JButton("Hunt"); //hunt button
   private JButton bCatch = new JButton("Catch"); //catch button
   private JButton bPokedex = new JButton("  "); //print toString and catch#
   private JButton bBackpack = new JButton("  "); //ordered print
   private JLabel pokemonToString = new JLabel(""); //what pokemon you found
   private JTextArea pokedexText = new JTextArea(""); //print tostring methods

   //stack, priority queue, and poketree
   private static Deque<Pokemon> pokemonStack = new ArrayDeque<Pokemon>();
   private PokeTree pt = new PokeTree();
   private PriorityQueue<Pokemon> pq = new PriorityQueue<>();

   //all variables to make imageIcon and set it to jLabels
   private static ImageIcon eevee = new ImageIcon("eevee.png");
   private static ImageIcon mystery = new ImageIcon("mystery.png");
   private static ImageIcon bulbasaur = new ImageIcon("bulbasaur.png");
   private static ImageIcon ivysaur = new ImageIcon("ivysaur.png");
   private static ImageIcon venusaur = new ImageIcon("venusaur.png");
   private static ImageIcon charmander = new ImageIcon("charmandericon.png");
   private static ImageIcon charmeleon = new ImageIcon("charmeleon.png");
   private static ImageIcon charizard = new ImageIcon("charizard.png");
   private static ImageIcon blastoise = new ImageIcon("blastoise.png");
   private static ImageIcon wartortle = new ImageIcon("wartortle.png");
   private static ImageIcon squirtle = new ImageIcon("squirtle.png");
   private ImageIcon iChar = new ImageIcon("charmander2.png");
   private ImageIcon iiChar = new ImageIcon("charmander.png");
   private ImageIcon pokedex = new ImageIcon("pokedex.png");
   private ImageIcon backpack = new ImageIcon("backpack.png");
   private JLabel jlChar2 = new JLabel(iChar);
   private JLabel jlChar = new JLabel(iiChar);
   private JLabel wildPoke = new JLabel();

   //declaredpanels
   private JPanel rightSubPanel = new JPanel();
   private JPanel topSubPanel = new JPanel();
   private JPanel centerSubPanel = new JPanel();
   private JPanel bottomSubPanel = new JPanel();
   private JPanel leftSubPanel = new JPanel();
   
   //GUIListener class on bottom
   private GUIListener listener = new GUIListener();
   
   //choice to print by recent or number
   private Choice orderChoice = new Choice();
   
   //for text area.
   private JScrollPane scroll = new JScrollPane(pokedexText, 
       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   
   public PokemonPanel() {
   
      //setting up variables to be added
      setLayout(new BorderLayout()); //Border panel layout
      setPreferredSize(new Dimension(1200, 800)); //window wize
      leftSubPanel.setBackground(Color.black); //left area color
      topSubPanel.setBackground(Color.black); //north area color
      centerSubPanel.setBackground(Color.white); //center area color
      bottomSubPanel.setBackground(Color.black); //bottomSubPanel area color   
      rightSubPanel.setBackground(Color.black); //right area color
      pokedexText.setPreferredSize(new Dimension(150, 500)); //set text area size
      bPokedex.setIcon(pokedex); //setting up buttons
      bBackpack.setIcon(backpack); //setting up backpack button
      tTitle.setForeground(Color.white); //white text on black background
      pokedexText.setEditable(false); //non-editable textarea field
      
      //adding choices
      orderChoice.add(""); //start off empty
      orderChoice.add("Recent"); //order recent
      orderChoice.add("Number"); //order number
   
      //adding north panel and variables
      add("North", topSubPanel); //add to top
      topSubPanel.add(jlChar2); //picture
      topSubPanel.add(bHunt); //hunt button
      topSubPanel.add(tTitle); //title
      topSubPanel.add(bCatch); //catch button
      topSubPanel.add(jlChar); //picture
      bHunt.addActionListener(listener);
      bCatch.addActionListener(listener);
      
      //adding center panel and variables
      add("Center", centerSubPanel); //add to center
      centerSubPanel.add(pokemonToString); //to show what pokemon appeared
      centerSubPanel.add(msg); //you caught a
      centerSubPanel.add(caught); //show if caught or not
      centerSubPanel.add(wildPoke); //what pokemon showed
   
      //adding south panel and variables
      add("South", bottomSubPanel); //add to bottom
      bottomSubPanel.add(bPokedex); //pokedex button
      bottomSubPanel.add(bBackpack); //backpack button
      bottomSubPanel.add(orderChoice); //show ordered choices
      //listeners for buttons
      bPokedex.addActionListener(listener); 
      bBackpack.addActionListener(listener);
      
      //adding West Panel
      add("West", leftSubPanel); //add to left side
      pokedexText.setText(pokeTree); //textarea to show what pokemon caught
      leftSubPanel.add(scroll); //adding textarea
      
     
   }


 /**
 * Private ActionListener class.
 */
   private class GUIListener implements ActionListener {
   
   /**
   * ActionPerformed method.
   * @param event what button is clicked.
   */ 
      public void actionPerformed(ActionEvent event) {
      
         Random genRan = new Random();
         int getCaught = 0;
         
         if (event.getSource() == bBackpack) {
            String sChoice = new String("");
            sChoice = orderChoice.getSelectedItem();
            if(sChoice == "Recent") {
               String s = new String("");
               Deque<Pokemon> pokemonStack2 = new ArrayDeque<Pokemon>();
               while(pokemonStack.size() > 0) {
                  Pokemon curr = pokemonStack.pop();
                  pokemonStack2.push(curr);
                  s = s + curr.toString();
               }
               pokedexText.setText(s);
               while(pokemonStack2.size() > 0 ) {
                  Pokemon curr = pokemonStack2.pop();
                  pokemonStack.push(curr);
               }
            }
         }
         
         if(event.getSource() == bPokedex) {
            pokedexText.setText(pt.printPokeTree());
         }
      
         if(event.getSource() == bHunt) {
            iGenPoke = genRan.nextInt(10);
            Pokemon newPoke = genNewPokemon(iGenPoke);
            sPokemon = newPoke.getName();
            pokemonToString.setText("A wild " + sPokemon + " has appeared!");
            wildPoke.setIcon(printPokePic(iGenPoke));
            caught.setText("");
            msg.setText("");
         }
         
         if(event.getSource() == bCatch) {
            if(iGenPoke == -1){
               msg.setText("");
               pokemonToString.setText("");
               wildPoke.setIcon(mystery);
               caught.setText("You need to hunt for a pokemon first!");
               
            } else {
               getCaught = genRan.nextInt(2);
               Pokemon newPoke = genNewPokemon(iGenPoke);
               if(getCaught == 0){
                  pokemonToString.setText("");
                  msg.setText("You caught a: ");
                  wildPoke.setIcon(printPokePic(iGenPoke));
                  caught.setText(newPoke.toString());
                  pt.add(newPoke);
                  pokemonStack.push(newPoke);
                  iGenPoke = -1;
               } else {
                  caught.setText(newPoke.getName() + " ran away");
                  pokemonToString.setText("");
                  msg.setText("");
                  wildPoke.setIcon(mystery);
                  iGenPoke = -1;
               }
            }
         }
      }
   }   public static Pokemon genNewPokemon(int p) {
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
      } //close switch
   }//close genPoke
   public static ImageIcon printPokePic(int p) {
      switch(p){
         case 1:
            return bulbasaur;
         case 2:
            return ivysaur;
         case 3:
            return venusaur;
         case 4:
            return charmander;
         case 5:
            return charmeleon;
         case 6:
            return charizard;
         case 7:
            return squirtle;
         case 8:
            return wartortle;
         case 9:
            return blastoise;
         default:
            return eevee;
      } //close picture switch 
   } //close image icon
}//close PokemonPanel