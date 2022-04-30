package edu.ics211.h10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import edu.ics211.h02.Cheese;
import edu.ics211.h02.FatComparator;
import edu.ics211.h02.ManoaCheeseFromager;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    private ManoaCheeseFromager fromager;
    private Comparator<Cheese> comp;

    @BeforeEach
    void setUp() throws Exception {
        fromager = ManoaCheeseFromager.getInstance();
        comp = new FatComparator();
    }


    @Test
    void testBinarySearchTree() {
        BinarySearchTree<Cheese> tree = new BinarySearchTree<Cheese>(comp);
        assertNotNull(tree);
        assertEquals(0, tree.size());
    }


    @Test
    void testAdd() {
        BinarySearchTree<Cheese> tree = new BinarySearchTree<Cheese>(comp);
        assertNotNull(tree);
        assertEquals(0, tree.size());
        Cheese cheese = fromager.makeBrie("Cheese1", 10.0);
        assertTrue(tree.add(cheese));
        assertEquals(1, tree.size());
        assertFalse(tree.add(cheese));
        assertEquals(1, tree.size());
        assertTrue(tree.contains(cheese));
        cheese = fromager.makeCheddar("Cheese2", 5.2);
        assertTrue(tree.add(cheese));
        assertEquals(2, tree.size());
        assertTrue(tree.contains(cheese));
        assertFalse(tree.add(cheese));
        cheese = fromager.makeMozzarella("Cheese3", 25.2);
        assertTrue(tree.add(cheese));
        assertEquals(3, tree.size());
        assertTrue(tree.contains(cheese));
        assertFalse(tree.add(cheese));
    }


    @Test
    void testContains() {
        BinarySearchTree<Cheese> tree = new BinarySearchTree<Cheese>(comp);
        assertNotNull(tree);
        assertEquals(0, tree.size());
        Cheese cheese = fromager.makeBrie("Cheese1", 10.0);
        assertFalse(tree.contains(cheese));
        assertTrue(tree.add(cheese));
        assertEquals(1, tree.size());
        assertTrue(tree.contains(cheese));
        cheese = fromager.makeCheddar("Cheese2", 5.2);
        assertFalse(tree.contains(cheese));
        assertTrue(tree.add(cheese));
        assertEquals(2, tree.size());
        assertTrue(tree.contains(cheese));
        cheese = fromager.makeMozzarella("Cheese3", 25.2);
        assertTrue(tree.add(cheese));
        assertEquals(3, tree.size());
        assertTrue(tree.contains(cheese));
    }


    @Test
    void testFind() {
        BinarySearchTree<Cheese> tree = new BinarySearchTree<Cheese>(comp);
        Cheese cheese = fromager.makeBrie("Cheese1", 10.0);
        tree.add(cheese);
        Cheese cheese2 = fromager.makeCheddar("Cheese2", 5.2);
        tree.add(cheese2);
        Cheese cheese3 = fromager.makeMozzarella("Cheese3", 25.2);
        tree.add(cheese3);
        assertEquals(cheese, tree.find(cheese));
        assertEquals(cheese2, tree.find(cheese2));
        assertEquals(cheese3, tree.find(cheese3));
        Cheese cheese4 = fromager.makeParmesan("Not in tree", 4.2);
        assertNull(tree.find(cheese4));
    }


    @Test
    void testDelete() {
        BinarySearchTree<Cheese> tree = new BinarySearchTree<Cheese>(comp);
        Cheese cheese = fromager.makeBrie("Cheese1", 10.0);
        tree.add(cheese);
        Cheese cheese2 = fromager.makeCheddar("Cheese2", 5.2);
        tree.add(cheese2);
        Cheese cheese3 = fromager.makeMozzarella("Cheese3", 25.2);
        tree.add(cheese3);
        Cheese cheese4 = fromager.makeParmesan("Cheese4", 6.3);
        tree.add(cheese4);
        Cheese cheese5 = fromager.makeCheddar("Cheese5", 20.1);
        tree.add(cheese5);
        assertEquals(5, tree.size());
        assertEquals(cheese4, tree.delete(cheese4));
        assertEquals(4, tree.size());
        assertNull(tree.delete(cheese4));
    }


    @Test
    void testRemove() {
        BinarySearchTree<Cheese> tree = new BinarySearchTree<Cheese>(comp);
        Cheese cheese = fromager.makeBrie("Cheese1", 10.0);
        tree.add(cheese);
        Cheese cheese2 = fromager.makeCheddar("Cheese2", 5.2);
        tree.add(cheese2);
        Cheese cheese3 = fromager.makeMozzarella("Cheese3", 25.2);
        tree.add(cheese3);
        Cheese cheese4 = fromager.makeParmesan("Cheese4", 6.3);
        tree.add(cheese4);
        Cheese cheese5 = fromager.makeCheddar("Cheese5", 20.1);
        tree.add(cheese5);
        assertTrue(tree.remove(cheese5));
        assertEquals(4, tree.size());
        assertFalse(tree.remove(cheese5));
    }


    @Test
    void testInorder() {
        BinarySearchTree<Cheese> tree = new BinarySearchTree<Cheese>(comp);
        Cheese cheese = fromager.makeBrie("Cheese1", 10.0);
        tree.add(cheese);
        Cheese cheese2 = fromager.makeCheddar("Cheese2", 5.2);
        tree.add(cheese2);
        Cheese cheese3 = fromager.makeMozzarella("Cheese3", 25.2);
        tree.add(cheese3);
        Cheese cheese4 = fromager.makeParmesan("Cheese4", 6.3);
        tree.add(cheese4);
        Cheese cheese5 = fromager.makeCheddar("Cheese5", 20.1);
        tree.add(cheese5);
        List<Cheese> inorder = tree.inorder();
        assertEquals(cheese2, inorder.get(0));
        assertEquals(cheese4, inorder.get(1));
        assertEquals(cheese, inorder.get(2));
        assertEquals(cheese5, inorder.get(3));
        assertEquals(cheese3, inorder.get(4));
    }


    @Test
    void testSize() {
        BinarySearchTree<Cheese> tree = new BinarySearchTree<Cheese>(comp);
        assertEquals(0, tree.size());
        Cheese cheese = fromager.makeBrie("Cheese1", 10.0);
        tree.add(cheese);
        assertEquals(1, tree.size());
        Cheese cheese2 = fromager.makeCheddar("Cheese2", 5.2);
        tree.add(cheese2);
        Cheese cheese3 = fromager.makeMozzarella("Cheese3", 25.2);
        tree.add(cheese3);
        Cheese cheese4 = fromager.makeParmesan("Cheese4", 6.3);
        tree.add(cheese4);
        Cheese cheese5 = fromager.makeCheddar("Cheese5", 20.1);
        tree.add(cheese5);
        assertEquals(5, tree.size());
        tree.remove(cheese5);
        assertEquals(4, tree.size());
    }

}