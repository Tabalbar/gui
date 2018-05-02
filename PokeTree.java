/**
 * This is the PokeTree class
 * ****used BinaryNodeTree as template****
 * 
 * @author Roderick Tabalba
 * @since 4/16/2018
 */

/**
 * This is the PokeTree class.
 */
public class PokeTree {

   //To start tree
   private PokeNode root = null;
   
   /**
    * This is the add method to add pokemon to tree.
    * @param node is the top of the tree
    * @param p is the pokemon being added to the tree
    * @return PokeNode with new added pokemon
    */
   private PokeNode add(PokeNode node, Pokemon p) {
      //if it is the top node, add it in
      //if left child and right child is null add pokemon there(leaf node)
      if (node == null) {
         return new PokeNode(p, 1, null, null);
       
      //if pokemon is already in the tree, just increment the num caught
      } else if (node.getKey() == p.getNumber()) {
         node.increaseNumCaught();
         return node;
      
      //These next two will check is number is less, recursive call left add
      //and if pokemon number is more, recursively call right branch
      } else if (p.getNumber() < node.getKey()) {
         node.setLChild(this.add(node.getLChild(), p));
         return node;
      }
      else {
         node.setRChild(this.add(node.getRChild(), p));
         return node;
      }
   }
   
   /**
    * get method will search for the pokemon in the tree.
    * @param node is the start of the tree(caller node)
    * @param searchKey is the pokemon user is looking for
    * @return Pokemon if found in the tree
    */
   private Pokemon get(PokeNode node, Pokemon searchKey)
      throws PokemonException {
      // if not found, throw exception
      if (node == null) {
         throw new PokemonException("Item not found!");
      } 
      else {
      //if the search key matches, call PokeNode.getPokemon() method
         if (node.getKey() == searchKey.getNumber()) {
            return node.getPokemon();
         }
         
         //next two will check pokemon number is less the search,
         //call again with left branch, and vice versa
         else if (node.getKey() < searchKey.getNumber()) {
            return this.get(node.getLChild(), searchKey);
         }
         else {
            return this.get(node.getRChild(), searchKey);
         }
      }
   }
   
   /**
    * This is the private remove method to remove pokemon and.
    * change the PokeTree if necessary
    * @param node is the root
    * @param searchKey is the pokemon to remove
    * @return PokeNode with decremented numcaught or removed pokemon
    */
   private PokeNode remove(PokeNode node, Pokemon searchKey) {
   // if item not found, throw exception
      if (node == null) {
         throw new PokemonException("Item not found!");
      }
      
      //next two will recursively call left branch is the pokemon number is less
      //and right branch is pokemon number is more
      else if (searchKey.getNumber() < node.getKey()) {
         node.setLChild(this.remove(node.getLChild(), searchKey));
         return node;
      }
      else if (searchKey.getNumber() > node.getKey()) {
         node.setRChild(this.remove(node.getRChild(), searchKey));
         return node;
      }

      //else means it equals so delete it
      else {
         //unless the numcaught is more than 1, then just decremeny
         //num caught
         if (node.getNumCaught() > 1) {
            node.decreaseNumCaught();
            return node;
         } else {
            node = this.remove(node);
            return node;
         }
      }
   }
   
   /**
    * This remove method actaully removes the PokeNode.
    * by setting it to null.
    * @param node is the node containing the pokemon to remove
    * @return PokeNode set to null
    */
   private PokeNode remove(PokeNode node) {
      if (node.getLChild() == null && node.getRChild() == null) {
         return null;
      }
      
      //if the node has a left ot right child, set the node to that child
      else if (node.getLChild() == null) {
         return node.getRChild();
      }
      else if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if the node has two child nodes, this else case
      //will find the pokemon the highest number in the left subtree of
      //that node and set that node to the node to remove
      else {
      
         //Finding the pokemon and assigning to variable
         Pokemon largestItemInLeftSubtree = 
            this.getItemWithLargestSearchKey(node.getLChild());
         //that variable then is set the node
         node.setPoke(largestItemInLeftSubtree);
         //does same thing if that child had other left and right nodes
         //so recursively calls
         node.setLChild(this.removeNodeWithLargestSearchKey(node
             .getLChild()));
         return node;
      }
   }
   
  /**
   * This method searches the node to remove's left subtree.
   * and searches as far down the right os that left subtree as
   * far as possible
   * @param node The root of the tree/subtree
   * @return Pokemon with largest number to be saved so not lost
   */
   private Pokemon getItemWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains the largest item
      if (node.getRChild() == null) {
         return node.getPokemon();
      }
      // if not, keep looking on the right
      else {
         return this.getItemWithLargestSearchKey(node.getRChild());
      }
   }

  /**
   * Does the same thing has getting the Node with largest.
   * pokemon number bus this actually removes it
   *
   * @param node The root of the tree/subtree
   * @return PokeNode
   */
   private PokeNode removeNodeWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains the largest item
   // so replace it with its left child
      if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if not, keep looking on the right
      else {
         node.setRChild(this.removeNodeWithLargestSearchKey(node
             .getRChild()));
         return node;
      }
   }
   
   /**
    * This method will print the tree "in order".
    * if traced it will print the first time node is seen
    * @param root is the top of the tree
    */
   private String preorderPokeTree(PokeNode node) {
      String s = new String("");
      
      if (node != null) {
         s = s + node.getPokemon().toString();
         s = s + "\nCaught: " + node.getNumCaught() + '\n';
         s = s + preorderPokeTree(node.getLChild());
         s = s + preorderPokeTree(node.getRChild());
      }
      return s;
   }

   /**
    * Empty constructor to make tree.
    */
   public PokeTree() {
      //empty constructor
   }
   
   /**
    * This will call the private add with root.
    * @param p is the pokemon being added
    */
   public void add(Pokemon p) {
      root = add(root, p);
   }
   
   /**
    * This will call private get method to serach for pokemon.
    * @param searchKey is the pokemon being search for
    * @return Pokemon the pokemon that was being searched for
    */
   public Pokemon get(Pokemon searchKey) {
      return this.get(root, searchKey);
   }
   
   /**
    * This will call private method preorderPokeTree.
    */
   public String printPokeTree() {
      String s = new String("");
      return s + preorderPokeTree(root);
      
   }
   
   /**
    * This will call private removed method with.
    * and pokemon to be removed
    * @param p is the pokemon to be removed
    */
   public void remove(Pokemon p) {
      this.remove(root, p);
   }
}