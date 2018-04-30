import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //add this for the listener
import java.util.*;

public class PokemonFrame {
   public static void main(String[] args) {
      JFrame frm = new JFrame("Rj's Pokemon Game");
         frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frm.getContentPane().add(new PokemonPanel());
         frm.pack();
         frm.setVisible(true);
   
   }

}