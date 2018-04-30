import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //add this for the listener
import java.util.*;

public class PokemonPanel extends JPanel {

   private JLabel tTitle = new JLabel("Hi! Welcome to my Pokemon game.");
   private JLabel caught = new JLabel("                ");
   private JLabel msg = new JLabel ("");
   private JButton bHunt = new JButton("Hunt");
   private JButton bCatch = new JButton("Catch");
   private JButton bPokedex = new JButton("  ");
   private JButton bBackpack = new JButton ("  ");

   private PokeTree pt = new PokeTree();

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

   private JPanel topSubPanel = new JPanel();
   private JPanel centerSubPanel = new JPanel();
   private JPanel bottomSubPanel = new JPanel();
   private GUIListener listener = new GUIListener();
   private static int iGenPoke = -1;
   
   private String pokeTree = new String("");
   private String sPokemon = new String("");
   private JLabel pokemonToString = new JLabel("");
   private JTextArea pokedexText = new JTextArea("");
   private JScrollPane scroll = new JScrollPane(pokedexText, 
       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   
   public PokemonPanel(){
   
      setLayout(new BorderLayout()); //Border panel layout
      setPreferredSize(new Dimension(1200, 800));
      topSubPanel.setBackground(Color.black); //north area color
      centerSubPanel.setBackground(Color.white); //center area color
      bottomSubPanel.setBackground(Color.black); //bottomSubPanel area color   
      pokedexText.setPreferredSize(new Dimension(150,500));
      bPokedex.setIcon(pokedex);   
      bBackpack.setIcon(backpack);
      tTitle.setForeground(Color.white);
   
      add("North", topSubPanel);
      topSubPanel.add(jlChar2);
      topSubPanel.add(bHunt);
      bHunt.addActionListener(listener);
      topSubPanel.add(tTitle);
      topSubPanel.add(bCatch);
      bCatch.addActionListener(listener);
      centerSubPanel.add(caught);
      topSubPanel.add(jlChar);
      
      add("Center", centerSubPanel);
      centerSubPanel.add(pokemonToString);
      centerSubPanel.add(msg);
      centerSubPanel.add(caught);
      centerSubPanel.add(wildPoke);
      pokedexText.setText(pokeTree);
      pokedexText.setEditable(false);
      

      centerSubPanel.add(scroll);
      
      add("South", bottomSubPanel);
      bottomSubPanel.add(bPokedex);
      bPokedex.addActionListener(listener);
      bottomSubPanel.add(bBackpack);
     
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
         
         if(event.getSource() == bPokedex){
            pokedexText.setText(pt.printPokeTree());
         }
      
         if(event.getSource() == bHunt){
            iGenPoke = genRan.nextInt(10);
            Pokemon newPoke = genNewPokemon(iGenPoke);
            sPokemon = newPoke.getName();
            pokemonToString.setText("A wild " + sPokemon + " has appeared!");
            wildPoke.setIcon(printPokePic(iGenPoke));
            caught.setText("");
            msg.setText("");
         }
         
         if(event.getSource() == bCatch){
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
                  iGenPoke = -1;
               } else {
                  caught.setText(newPoke.getName() + " ran away");
                  pokemonToString.setText("");
                  msg.setText("");
//                   wildPoke.setIcon(mystery);
                  iGenPoke = -1;
               }
            }
         }
      }
   }
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
   public static ImageIcon printPokePic(int p){
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
            return squirtle;
      }
   }


}