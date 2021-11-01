package com.luxsoft.datastructure.list;

import com.luxsoft.datastructure.queue.ArrayQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListTest {

    @Test
    void testAddAndSize() {
        ArrayList arrayList  = new ArrayList();
        arrayList.add("A");
        arrayList.add("A");;

        assertEquals(2,arrayList.size());
        arrayList.add("B");
        assertEquals(3,arrayList.size());
    }

    @Test
    void testAddToDefinitePositionAndSize() {
        ArrayList arrayList  = new ArrayList();
        arrayList.add("A");
        arrayList.add("A",0);;

        assertEquals(2,arrayList.size());
        arrayList.add("B",1);
        assertEquals(3,arrayList.size());
    }

    @Test
    public void testAddToListNull() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(NullPointerException.class, () ->
                arrayList.add(null));
    }

    @Test
    public void testAddAndGetItems() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals("C", arrayList.get(2));
        assertEquals("A", arrayList.get(0));
        assertEquals("B", arrayList.get(1));
    }

    @Test
    public void testSetAndGetItems() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("A");
        arrayList.add("B");

        arrayList.set("C", 1);
        arrayList.set("D", 0);

        assertEquals("C", arrayList.get(1));
        assertEquals("D", arrayList.get(0));
    }

    @Test
    public void testSetNullItem() {
        ArrayList arrayList = new ArrayList();

        arrayList.add("A");

        Assertions.assertThrows(NullPointerException.class, () ->
                arrayList.set(null, 0));
        Assertions.assertThrows(NullPointerException.class, () ->
                arrayList.set(null, 1));
    }

    @Test
    public void testGetFromEmptyList() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                arrayList.get(0));
    }

    @Test
    void testSize() {
        ArrayList arrayList = new ArrayList();

        assertEquals(0,arrayList.size());

        arrayList.add("A");

        assertEquals(1,arrayList.size());

        arrayList.remove(0);

        assertEquals(0,arrayList.size());

    }

    @Test
    void testIsEmptyTrueOnNewList() {
        ArrayList arrayList = new ArrayList();

        assertTrue(arrayList.isEmpty());
    }

    @Test
    void testIsEmptyFalseOnNewListWithData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");

        assertFalse(arrayList.isEmpty());
        assertEquals(1, arrayList.size());
    }

    @Test
    void testIsEmptyTrueOnNewListAfterClear() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals(3, arrayList.size());
        assertFalse(arrayList.isEmpty());

        arrayList.clear();

        assertEquals(0,  arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

    @Test
    void testContainsTrueOnNewListWithSameData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("SUPERMAN");
        arrayList.add("IRONMAN");
        arrayList.add("BATMAN");
        arrayList.add("TOR");
        arrayList.add("CAPTAIN AMERICA");

        assertEquals(5, arrayList.size());
        assertTrue(arrayList.contains("BATMAN"));
    }

    @Test
    void testContainsFalseOnNewListAWithSearchDataNotExsist() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("SUPERMAN");
        arrayList.add("IRONMAN");
        arrayList.add("BATMAN");
        arrayList.add("TOR");
        arrayList.add("CAPTAIN AMERICA");

        assertEquals(5, arrayList.size());
        assertFalse(arrayList.contains("SUPER WOMAN"));
    }

    @Test
    void testContainsFalseIsEmptyList() {
        ArrayList arrayList = new ArrayList();

        assertEquals(0, arrayList.size());
        assertFalse(arrayList.contains("SUPER WOMAN"));
    }

    @Test
    void testClearTrueList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals(3, arrayList.size());
        assertFalse(arrayList.isEmpty());

        arrayList.clear();
        assertTrue(arrayList.isEmpty());
        assertEquals(0, arrayList.size());
    }

    @Test
    void testClearTrueWithEmptyList() {
        ArrayList arrayList = new ArrayList();

        assertEquals(0, arrayList.size());
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testRemove() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        arrayList.remove(2);
        assertEquals(3, arrayList.size());

        assertEquals("A", arrayList.get(0));
        assertEquals("B", arrayList.get(1));
        assertEquals("D", arrayList.get(2));
    }

    @Test
    public void testRemoveFirstItem() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        arrayList.remove(0);
        assertEquals(3, arrayList.size());

        assertEquals("B", arrayList.get(0));
        assertEquals("C", arrayList.get(1));
        assertEquals("D", arrayList.get(2));
    }

    @Test
    public void testRemoveLastItem() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        arrayList.remove(3);
        assertEquals(3, arrayList.size());

        assertEquals("A", arrayList.get(0));
        assertEquals("B", arrayList.get(1));
        assertEquals("C", arrayList.get(2));
    }

    @Test
    public void testIndexOf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        assertEquals(0, arrayList.indexOf("A"));
        assertEquals(1, arrayList.indexOf("B"));
        assertEquals(1, arrayList.indexOf("B"));
        assertEquals(3, arrayList.indexOf("D"));

        assertEquals(-1, arrayList.indexOf("E"));
        assertEquals(-1, arrayList.indexOf("F"));
    }

    @Test
    public void testIndexOfValueIsNull() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(NullPointerException.class, () ->
                arrayList.indexOf(null));
    }

    @Test
    public void testIndexOfListIsEmpty() {
        ArrayList arrayList = new ArrayList();
        assertEquals(-1, arrayList.indexOf("Search"));
    }

    @Test
    public void testLastIndexOf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        assertEquals(0, arrayList.lastIndexOf("A"));
        assertEquals(2, arrayList.lastIndexOf("C"));
        assertEquals(2, arrayList.lastIndexOf("C"));
        assertEquals(3, arrayList.lastIndexOf("D"));

        assertEquals(-1, arrayList.lastIndexOf("E"));
        assertEquals(-1, arrayList.lastIndexOf("F"));
    }

    @Test
    public void testLastIndexOfValueIsNull() {
        ArrayList arrayList = new ArrayList();
        Assertions.assertThrows(NullPointerException.class, () ->
                arrayList.lastIndexOf(null));
    }
}
