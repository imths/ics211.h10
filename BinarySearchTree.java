/**
 * 
 */
package edu.ics211.h10;

import java.util.Comparator;
import java.util.List;

/**
 * @author isaacsegawa
 *
 */
public class BinarySearchTree<E> implements SearchTree<E>, InOrder<E> {

  private BinaryNode root;
  private Comparator<E> comp;
  private int size;
  
  /**
   * Creates a new BinaryTree
   * @param comp the comparator for the tree
   */
  public BinarySearchTree(Comparator<E> comp) {
    
  }

  @Override
  public List<E> inorder() {
    //create the return list
    //do an in-order traversal of the tree
    //return list
    return null;
  }
  
  private void inOrderTraversal(BinaryNode node, List<E> list) { //n
    //visit left child
    //visit node
    //visit right child
  }

  @Override
  public boolean add(E item) { //nlogn
    
    return false;
  }

  @Override
  public boolean contains(E item) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public E find(E target) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public E delete(E target) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean remove(E target) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int size() {
    //returns size of tree
    return this.size;
  }
  
  private class BinaryNode {
    E data;
    BinaryNode left;
    BinaryNode right;
  }

}
