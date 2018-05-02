import java.util.Random;

/**
* Jolteon Pokemon object class.
* Subclass of Eevee
* @author Roderick Tabalba
* @version 1.0
* @since 2/22/2018
*/
public class Jolteon extends Eevee implements ElectricType {

   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 232;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 201;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 130;
   
   //booleans for telling which type attack to use for dual type Pokemon
   //In this case, Jolteon is always ElectricType
   /** Indicator for fast attack type. */
   protected boolean fastIsElectric = true;
   /** Indicator for special attack type. */
   protected boolean specialIsElectric = true;
   
   /** Constructor with no name. */
   public Jolteon() {
      super("Jolteon", "Jolteon", 135, ELECTRIC_COLOR, 0.8, 24.5, ELECTRIC_TYPE,
            BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   
   /** Constructor with name.
   * @param name The user-defined name.
   */
   public Jolteon(String name) {
      super("Jolteon", name, 135, ELECTRIC_COLOR, 0.8, 23.5, ELECTRIC_TYPE, 
           BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }
   /**
   * Normal specific fast attack chooser.
   * Randomly picks an attack from type interface attack arrays
   */
   protected void chooseFastAttack() {
      //Generate Random FireFastAttack[]
      Random randGen = new Random();
      int index;
   
      index = randGen.nextInt(ELECTRIC_FAST_ATTACKS.length);
      fastAttack = ELECTRIC_FAST_ATTACKS[index];
      fastAttackPower = ELECTRIC_FAST_ATK_POWER[index];
      
   }
   
  /**
   * Normal special attack.
   * Randomly picks an attack from type interface attack arrays
   */
   protected void chooseSpecialAttack() {
      //Generate random FireSpecialAttack[]
      Random randGen = new Random();
      int index;
   
      index = randGen.nextInt(ELECTRIC_SPECIAL_ATTACKS.length);
      specialAttack = ELECTRIC_SPECIAL_ATTACKS[index];
      specialAttackPower = ELECTRIC_SPECIAL_ATK_POWER[index];
       
   }
   
   /**
   * Game-play fast attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokemon's type and attack type
   * (only need to check latter for dual-type)
   * Calls beAttacked method on attacked victim.
   *
   * @param victim the Pokemon being attacked
   * @return String explaining attack and effectiveness
   */
   public String performFastAttack(Pokemon victim) {
      
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;      
      s = name + " performed " + fastAttack + " on " + victim.getSpecies();
      //check effectiveness of attack
      if (fastIsElectric) { //if attack is Electric
         if (vType.equals("Steel") || vType.equals("Flying")) {
            
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } else if (vType.equals("Ground")) { 
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      } 
      //check for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
         * attackPower * (specialAttackPower + 2) * modifier;      
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   }
   
  /**
   * Game-play special attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokemon's type and attack type
   * (only need to check latter for dual-type)
   * uses Damage formula from here: 
   * http://bulbapedia.bulbagarden.net/wiki/Damage
   * Calls beAttacked method on attacked victim.
   * @param victim the Pokemon being attacked.
   * @return String explaining attack and effectiveness.
   */
   public String performSpecialAttack(Pokemon victim) {
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;      
      s = name + " performed " + fastAttack + " on " + victim.getSpecies();
      //check effectiveness of attack
      if (fastIsElectric) { //if attack is Electric
         if (vType.equals("Steel") || vType.equals("Flying")) {
            
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } else if (vType.equals("Ground")) { 
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      } 
   
      //check for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
          * attackPower * (specialAttackPower + 2) * modifier;
     
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   }
}
   
