/**
* interface for Normal type Pokemon.
* Fails checkstyle because no methods.
* @author Roderick Tabalba
* @since 2/22/2018
*/
public interface NormalType {
   /** constants **/
   /** Type name String. */
   String NORMAL_TYPE = new String("Normal");
   /** Type color String. */
   String NORMAL_COLOR = new String("Brown");
   /** Array of type fast attack names. */
   String[] NORMAL_FAST_ATTACKS = {"Tackle", "Quick Attack", "Cut",
      "Pound", "Scratch"};
   /** Array of type special attack names. */
   String[] NORMAL_SPECIAL_ATTACKS = {"Wrap", "Hyper Beam", "Vice-Grip", 
      "Swift", "Horn Attack", "Stomp", 
      "Hyper Fang", "Body Slam", "Struggle"};
   /** Array of fast attack powers, coincides with name array. */
   int[] NORMAL_FAST_ATK_POWER = {12, 10, 12, 7, 6}; 
   /** Array of special attack powers, coincides with name array. */     
   int[] NORMAL_SPECIAL_ATK_POWER = {25, 120, 25, 30, 25, 30, 35, 40, 35, 15};

}