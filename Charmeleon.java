/**
* Charmeleon Pokemon object class.
* Subclass of Charmander
* @author Roderick Tabalba
* @version 1.0
* @since 2/14/2018
*/
public class Charmeleon extends Charmander {

   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 158;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 129;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 116;
   
   /** Constructor with no name. */
   public Charmeleon() {
      super("Charmeleon", "Charmeleon", 5, FIRE_COLOR, 1.1, 19.0, FIRE_TYPE,
          "", BASE_ATTACK_POWER, 
          BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   
   /** Constructor with name.
   * @param name The user-defined name.
   */
   public Charmeleon(String name) {
      super("Charmeleon", name, 5, FIRE_COLOR, 1.1, 19.0, FIRE_TYPE,
             "", BASE_ATTACK_POWER, 
             BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }
   /** 
   * Constructor with species and name for subclasses.
   *@param species The Pokemon's species.
   *@param name The optional user-given name.
   *@param num The Pokedex number for this species.
   *@param ht The height of this Pokemon.
   *@param wt The weight of this Pokemon. 
   *@param baseAttackPwr The low limit of Attack Power for species.
   *@param baseDefensePwr The low limit of Defense Power for species.
   *@param baseStaminaPwr The low limit of Stamina Power for speices. 
   */
   protected Charmeleon(String species, String name, int num, 
         String color, double ht, double wt, String type1, String type2,
         int baseAttackPwr, int baseDefensePwr, int baseStaminaPwr) {
      
      super(species, name, num, color, ht, wt, type1, type2, baseAttackPwr, 
          baseDefensePwr, baseStaminaPwr);
   }
   

}
   
