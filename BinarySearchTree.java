/**
 * 
 */
package edu.ics211.h10;

import java.util.ArrayList;
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
  private boolean addReturn;
  private E deleteReturn;
  
  /**
   * Creates a new BinaryTree
   * @param comp the comparator for the tree
   */
  public BinarySearchTree(Comparator<E> comp) {
    this.root = null;
    this.comp = comp;
    this.size = 0;
  }

  @Override
  public List<E> inorder() {
    //create the return list
    //do an in-order traversal of the tree
    //return list
    ArrayList<E> list = new ArrayList<E>();
    inOrderTraversal(root, list);
    return list;
  }
  
  private void inOrderTraversal(BinaryNode node, List<E> list) { //n
    //visit left child
    //visit node
    //visit right child
    if (node != null) {
      inOrderTraversal(node.left, list);
      list.add(node.data);
      inOrderTraversal(node.right, list);
    }
  }

  @Override
  public boolean add(E item) { //nlogn
    root = add(root, item);
    if (addReturn == true) {
      size++;
    }
    return addReturn;
  }
  
  private BinaryNode add(BinaryNode localRoot, E item) {
    if (localRoot == null) {
      addReturn = true;
      return new BinaryNode(item);
    }
    int compare = comp.compare(item, localRoot.data);
    if (compare == 0) {
      addReturn = false;
      return localRoot;
    }
    else if (compare < 0) {
      localRoot.left = add(localRoot.left, item);
      return localRoot;
    }
    else {
      localRoot.right = add(localRoot.right, item);
      return localRoot;
    }
  }

  @Override
  public boolean contains(E item) {
    // TODO Auto-generated method stub
    if (find(item) != null) {
      return true;
    }
    else {
      return false;
    }
  }

  @Override
  public E find(E target) {
    // TODO Auto-generated method stub
    return find(root, target);
  }
  
  private E find(BinaryNode localRoot, E target) {
    if (localRoot == null) {
      return null;
    }
    int compare = comp.compare(target, localRoot.data);
    if (compare == 0) {
      return localRoot.data;
    }
    else if (compare < 0) {
      return find(localRoot.left, target);
    }
    else {
      return find(localRoot.right, target);
    }
  }

  @Override
  public E delete(E target) {
    root = delete(root, target);
    if (deleteReturn != null) {
      size--;
    }
    return deleteReturn;
  }
  
  private BinaryNode delete(BinaryNode localRoot, E target) {
    if (localRoot == null) {
      deleteReturn = null;
      return localRoot;
    }
    int compare = comp.compare(target, localRoot.data);
    if (compare < 0) {
      localRoot.left = delete(localRoot.left, target);
      return localRoot;
    }
    else if (compare > 0) {
      localRoot.right = delete(localRoot.right, target);
      return localRoot;
    }
    else {
      return replaceNode(localRoot);
    }
  }
  
  private BinaryNode replaceNode(BinaryNode localRoot) {
    deleteReturn = localRoot.data;
    if (localRoot.left == null) {
      return localRoot.right;
    }
    else if (localRoot.right == null) {
      return localRoot.left;
    }
    else {
      if (localRoot.left.right == null) {
        localRoot.data = localRoot.left.data;
        localRoot.left = localRoot.left.left;
        return localRoot;
      }
      else {
        localRoot.data = findLargestChild(localRoot.left);
        return localRoot;
      }
    }
  }
  
  private E findLargestChild(BinaryNode parent) {
    if (parent.right.right == null) {
      E returnValue = parent.right.data;
      parent.right = parent.right.left;
      return returnValue;
    }
    else {
      return findLargestChild(parent.right);
    }
  }

  @Override
  public boolean remove(E target) {
    // TODO Auto-generated method stub
    if (delete(target) == null)
      return false;
    else
      return true;
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
    
    public BinaryNode(E data) {
      this.data = data;
    }
  }

}