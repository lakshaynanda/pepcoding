import java.util.NoSuchElementException;

// File Header comes here
/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * PokemonTree.
 *
 */

public class PokemonTreeTester {

  /**
   * Checks the correctness of the implementation of both addPokemon() and toString() methods
   * implemented in the PokemonTree class. This unit test considers at least the following
   * scenarios. (1) Create a new empty PokemonTree, and check that its size is 0, it is empty, and
   * that its string representation is an empty string "". (2) try adding one Pokemon and then check
   * that the addPokemon() method call returns true, the tree is not empty, its size is 1, and the
   * .toString() called on the tree returns the expected output. (3) Try adding another Pokemon
   * which is more powerful than the one at the root, (4) Try adding a third Pokemon which is less
   * powerful than the one at the root, (5) Try adding at least two further Pokemons such that one
   * must be added at the left subtree, and the other at the right subtree. For all the above
   * scenarios, and more, double check each time that size() method returns the expected value, the
   * add method call returns true, and that the .toString() method returns the expected string
   * representation of the contents of the binary search tree in an ascendant order from the most
   * powerful Pokemon to the least powerful one. (6) Try adding a Pokemon whose CP value was used as
   * a key for a Pokemon already stored in the tree. Make sure that the addPokemon() method call
   * returned false, and that the size of the tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPokemonToStringSize() {

    PokemonTree t = new PokemonTree();
    // Case number 1: checking if its empty
    if (!t.isEmpty()) {
      return false;
    }
    // Empty string case
    if (!t.toString().equals("")) {
      return false;
    }
    // Case number 2: adding 1 Pokemon
    Pokemon p1 = new Pokemon("Pikachu", "1,2,3");
    t.addPokemon(p1);
    if (t.size() != 1) {
      return false;
    }
    if (!t.toString().equals("[Pikachu CP:123 (A:1 S:2 D:3)]\n")) { // testing toString method
      return false;
    }
    // Adding 4 more pokemons
    Pokemon p2 = new Pokemon("Eevee", "2,2,4"); // stronger than root
    Pokemon p3 = new Pokemon("Snorlax", "4,4,8"); // stronger than previous
    Pokemon p4 = new Pokemon("Charmander", "3,2,1"); // weaker than previous
    Pokemon p5 = new Pokemon("Lapras", "1,1,1"); // left subtree
    t.addPokemon(p2);
    t.addPokemon(p3);
    t.addPokemon(p4);
    t.addPokemon(p5);
    if (t.size() != 5) {
      return false;
    }
    // same key case
    Pokemon p6 = new Pokemon("Squirtle", "1,1,1");

    if (t.addPokemon(p6)) { // false case
      return false;
    }
    if (t.size() != 5) { // size should be the same
      return false;
    }
    // testing toString method
    if (!t.toString()
        .equals("[Lapras CP:111 (A:1 S:1 D:1)]\n" + "[Pikachu CP:123 (A:1 S:2 D:3)]\n"
            + "[Eevee CP:224 (A:2 S:2 D:4)]\n" + "[Charmander CP:321 (A:3 S:2 D:1)]\n"
            + "[Snorlax CP:448 (A:4 S:4 D:8)]" + "\n")) {
      return false;
    }
    return true;
  }

  /**
   * This method checks mainly for the correctness of the PokemonTree.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new PokemonTree. Then, check that
   * calling the lookup() method with any valid CP value must throw a NoSuchElementException. (2)
   * Consider a PokemonTree of height 3 which consists of at least 5 PokemonNodes. Then, try to call
   * lookup() method to search for the Pokemon at the root of the tree, then a Pokemon at the right
   * and left subtrees at different levels. Make sure that the lookup() method returns the expected
   * output for every method call. (3) Consider calling .lookup() method on a non-empty PokemonTree
   * with a CP value not stored in the tree, and ensure that the method call throws a
   * NoSuchElementException.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPokemonAndLookup() {
    PokemonTree t = new PokemonTree();
    Pokemon p1 = new Pokemon("Eevee", "2,2,4");

    t.addPokemon(p1);
    try { // NsEe case
      t.lookup(345);
    } catch (NoSuchElementException e) {
      System.out.println("No pokemon with this CP");
    }
    // 5 nodes, height = 3
    Pokemon p2 = new Pokemon("Snorlax", "4,4,8"); // stronger than previous
    Pokemon p3 = new Pokemon("Charmander", "1,1,2"); // weaker than previous
    Pokemon p4 = new Pokemon("Lapras", "1,1,1"); // left subtree
    Pokemon p5 = new Pokemon("Pikachu", "3,3,5");
    t.addPokemon(p2);
    t.addPokemon(p3);
    t.addPokemon(p4);
    t.addPokemon(p5);

    if (t.lookup(224) != p1) { // looking for root
      return false;
    }
    if (t.lookup(448) != p2) { // right subtree
      return false;
    }
    if (t.lookup(112) != p3) { // left subtree
      return false;
    }
    if (t.lookup(335) != p5) { // subtree of right subtree ( level 3)
      return false;
    }
    if (t.lookup(111) != p4) { // subtree of left subtree ( level 3)
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of PokemonTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty Pokemon tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a PokemonTree with the following structure for instance, is 4. (*) / \ (*) (*) \ / \ (*)(*) (*)
   * / (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {

    PokemonTree t = new PokemonTree();

    if (t.height() != 0) { // empty tree
      return false;
    }
    Pokemon p1 = new Pokemon("Eevee", "2,2,4");
    t.addPokemon(p1);

    if (t.height() != 1) { // tree consists of only 1 node
      return false;
    }

    Pokemon p2 = new Pokemon("Snorlax", "4,4,8");
    Pokemon p3 = new Pokemon("Charmander", "1,1,2"); // weaker than previous
    Pokemon p4 = new Pokemon("Lapras", "1,1,1"); // left subtree
    Pokemon p5 = new Pokemon("Pikachu", "3,3,5"); // right subtree
    t.addPokemon(p2);
    t.addPokemon(p3);
    t.addPokemon(p4);
    t.addPokemon(p5);

    if (t.height() != 3) { // height should be 3
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of PokemonTree.getLeastPowerfulPokemon() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetLeastPowerfulPokemon() {
    PokemonTree t = new PokemonTree();

    Pokemon p1 = new Pokemon("Eevee", "2,2,4");
    Pokemon p2 = new Pokemon("Snorlax", "4,4,8");
    Pokemon p3 = new Pokemon("Charmander", "1,1,2"); // weaker than previous
    Pokemon p4 = new Pokemon("Lapras", "1,1,1"); // left subtree
    Pokemon p5 = new Pokemon("Pikachu", "3,3,5"); // right subtree
    t.addPokemon(p1);
    t.addPokemon(p2);
    t.addPokemon(p3);
    t.addPokemon(p4);
    t.addPokemon(p5);
    if (t.getLeastPowerfulPokemon() != p4) { // Lapras is least powerful with CP 111
      return false;
    }

    return true;
  }

  /**
   * Checks for the correctness of PokemonTree.getMostPowerfulPokemon() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetMostPowerfulPokemon() {

    PokemonTree t = new PokemonTree();

    Pokemon p1 = new Pokemon("Eevee", "2,2,4");
    Pokemon p2 = new Pokemon("Snorlax", "4,4,8");
    Pokemon p3 = new Pokemon("Charmander", "1,1,2"); // weaker than previous
    Pokemon p4 = new Pokemon("Lapras", "1,1,1"); // left subtree
    Pokemon p5 = new Pokemon("Pikachu", "3,3,5"); // right subtree
    t.addPokemon(p1);
    t.addPokemon(p2);
    t.addPokemon(p3);
    t.addPokemon(p4);
    t.addPokemon(p5);
    if (t.getMostPowerfulPokemon() != p2) { // Snorlax is the most powerful with CP 111
      return false;
    }

    return true;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println(testAddPokemonToStringSize());
    System.out.println(testAddPokemonAndLookup());
    System.out.println(testHeight());
    System.out.println(testGetLeastPowerfulPokemon());
    System.out.println(testGetMostPowerfulPokemon());
  }

}
