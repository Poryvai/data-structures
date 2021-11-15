package com.luxsoft.datastructure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LinkedListTest {


    @Test
    void testAddAndSize() {
        LinkedList linkedList  = new LinkedList();

        linkedList.add("A");
        linkedList.add("A");;

        assertEquals(2,linkedList.size());
        linkedList.add("B");
        assertEquals(3,linkedList.size());
    }

    @Test
    void testAddToDefinitePositionAndSize() {
        LinkedList linkedList  = new LinkedList();
        linkedList.add("A");
        linkedList.add("A",0);;

        assertEquals(2,linkedList.size());
        linkedList.add("B",1);
        assertEquals(3,linkedList.size());
    }

    @Test
    public void testAddToListNull() {
        LinkedList linkedList  = new LinkedList();

        Assertions.assertThrows(NullPointerException.class, () ->
                linkedList.add(null));
    }

    @Test
    public void testAddAndGetItems() {
        LinkedList linkedList  = new LinkedList();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        assertEquals("C", linkedList.get(2));
        assertEquals("A", linkedList.get(0));
        assertEquals("B", linkedList.get(1));
    }

    @Test
    public void testSetAndGetItems() {
        LinkedList linkedList  = new LinkedList();

        linkedList.add("A");
        linkedList.add("B");

        linkedList.set("C", 1);
        linkedList.set("D", 0);

        assertEquals("C", linkedList.get(1));
        assertEquals("D", linkedList.get(0));
    }

    @Test
    public void testSetNullItem() {
        LinkedList linkedList  = new LinkedList();

        linkedList.add("A");

        Assertions.assertThrows(NullPointerException.class, () ->
                linkedList.set(null, 0));
        Assertions.assertThrows(NullPointerException.class, () ->
                linkedList.set(null, 1));
    }

    @Test
    public void testGetFromEmptyList() {
        LinkedList linkedList  = new LinkedList();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                linkedList.get(0));
    }

    @Test
    void testSize() {
        LinkedList linkedList  = new LinkedList();

        assertEquals(0,linkedList.size());

        linkedList.add("A");

        assertEquals(1,linkedList.size());

        linkedList.remove(0);

        assertEquals(0,linkedList.size());

    }

    @Test
    void testIsEmptyTrueOnNewList() {
        LinkedList linkedList  = new LinkedList();

        assertTrue(linkedList.isEmpty());
    }

    @Test
    void testIsEmptyFalseOnNewListWithData() {
        LinkedList linkedList  = new LinkedList();

        linkedList.add("A");

        assertFalse(linkedList.isEmpty());
        assertEquals(1, linkedList.size());
    }

    @Test
    void testIsEmptyTrueOnNewListAfterClear() {
        LinkedList linkedList  = new LinkedList();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        assertEquals(3, linkedList.size());
        assertFalse(linkedList.isEmpty());

        linkedList.clear();

        assertEquals(0,  linkedList.size());
        assertTrue(linkedList.isEmpty());
    }

    @Test
    void testContainsTrueOnNewListWithSameData() {
        LinkedList linkedList  = new LinkedList();

        linkedList.add("SUPERMAN");
        linkedList.add("IRONMAN");
        linkedList.add("BATMAN");
        linkedList.add("TOR");
        linkedList.add("CAPTAIN AMERICA");

        assertEquals(5, linkedList.size());
        assertTrue(linkedList.contains("BATMAN"));
    }

    @Test
    void testContainsFalseOnNewListAWithSearchDataNotExsist() {
        LinkedList linkedList  = new LinkedList();

        linkedList.add("SUPERMAN");
        linkedList.add("IRONMAN");
        linkedList.add("BATMAN");
        linkedList.add("TOR");
       linkedList.add("CAPTAIN AMERICA");

        assertEquals(5, linkedList.size());
        assertFalse(linkedList.contains("SUPER WOMAN"));
    }

    @Test
    void testContainsFalseIsEmptyList() {
        LinkedList linkedList  = new LinkedList();

        assertEquals(0, linkedList.size());
        assertFalse(linkedList.contains("SUPER WOMAN"));
    }

    @Test
    void testClearTrueList() {
        LinkedList linkedList  = new LinkedList();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        assertEquals(3, linkedList.size());
        assertFalse(linkedList.isEmpty());

        linkedList.clear();
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
    }

    @Test
    void testClearTrueWithEmptyList() {
        LinkedList linkedList  = new LinkedList();

        assertEquals(0, linkedList.size());
       linkedList.clear();
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testRemove() {
        LinkedList linkedList  = new LinkedList();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        linkedList.remove(2);
        assertEquals(3, linkedList.size());

        assertEquals("A", linkedList.get(0));
        assertEquals("B", linkedList.get(1));
        assertEquals("D", linkedList.get(2));
    }

    @Test
    public void testRemoveFirstItem() {
        LinkedList linkedList  = new LinkedList();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        linkedList.remove(0);
        assertEquals(3, linkedList.size());

        assertEquals("B", linkedList.get(0));
        assertEquals("C", linkedList.get(1));
        assertEquals("D", linkedList.get(2));
    }

    @Test
    public void testRemoveLastItem() {
        LinkedList linkedList  = new LinkedList();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        linkedList.remove(3);
        assertEquals(3, linkedList.size());

        assertEquals("A", linkedList.get(0));
        assertEquals("B", linkedList.get(1));
        assertEquals("C", linkedList.get(2));
    }

    @Test
    public void testIndexOf() {
        LinkedList linkedList  = new LinkedList();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        assertEquals(0, linkedList.indexOf("A"));
        assertEquals(1, linkedList.indexOf("B"));
        assertEquals(1, linkedList.indexOf("B"));
        assertEquals(3, linkedList.indexOf("D"));

        assertEquals(-1, linkedList.indexOf("E"));
        assertEquals(-1, linkedList.indexOf("F"));
    }

    @Test
    public void testIndexOfValueIsNull() {
        LinkedList linkedList  = new LinkedList();

        Assertions.assertThrows(NullPointerException.class, () ->
                linkedList.indexOf(null));
    }

    @Test
    public void testIndexOfListIsEmpty() {
        LinkedList linkedList  = new LinkedList();

        assertEquals(-1, linkedList.indexOf("Search"));
    }

    @Test
    public void testLastIndexOf() {
        LinkedList linkedList  = new LinkedList();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        assertEquals(0, linkedList.lastIndexOf("A"));
        assertEquals(2, linkedList.lastIndexOf("C"));
        assertEquals(2, linkedList.lastIndexOf("C"));
        assertEquals(3, linkedList.lastIndexOf("D"));

        assertEquals(-1,linkedList.lastIndexOf("E"));
        assertEquals(-1,linkedList.lastIndexOf("F"));
    }

    @Test
    public void testLastIndexOfValueIsNull() {
        LinkedList linkedList  = new LinkedList();

        Assertions.assertThrows(NullPointerException.class, () ->
                linkedList.lastIndexOf(null));
    }

}
