package com.luxsoft.datastructure.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayQueueTest {


    @Test
    void testEnqueueAndSize() {
        ArrayQueue arrayQueue  = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("A");

        assertEquals(2,arrayQueue.size());
        arrayQueue.enqueue("B");
        assertEquals(3,arrayQueue.size());
    }

    @Test
    void testEnqueueAndDequeueAndSize() {
        ArrayQueue arrayQueue  = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        assertEquals(3, arrayQueue.size());
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        assertEquals(0, arrayQueue.size());
    }

    @Test
    void testEnqueueAndPeek() {
        ArrayQueue arrayQueue  = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        assertEquals(3, arrayQueue.size());
        assertEquals("A",arrayQueue.peek());
        assertEquals(3, arrayQueue.size());
    }

    @Test
    void testSize() {
        ArrayQueue arrayQueue  = new ArrayQueue();

        assertEquals(0,arrayQueue.size());

        arrayQueue.enqueue("A");

        assertEquals(1,arrayQueue.size());

        arrayQueue.dequeue();

        assertEquals(0,arrayQueue.size());

    }

    @Test
    void testIsEmptyTrueOnNewQueue() {
        ArrayQueue arrayQueue  = new ArrayQueue();

        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    void testIsEmptyFalseOnNewQueueWithData() {
        ArrayQueue arrayQueue  = new ArrayQueue();
        arrayQueue.enqueue("A");

        assertFalse(arrayQueue.isEmpty());
        assertEquals(1, arrayQueue.size());
    }
    @Test
    void testIsEmptyTrueOnNewQueueAfterClear() {
        ArrayQueue arrayQueue  = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        assertEquals(3, arrayQueue.size());
        assertFalse(arrayQueue.isEmpty());

        arrayQueue.clear();

        assertEquals(0,  arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    void testContainsTrueOnNewQueueWithSameData() {
        ArrayQueue arrayQueue  = new ArrayQueue();
        arrayQueue.enqueue("SUPERMAN");
        arrayQueue.enqueue("IRONMAN");
        arrayQueue.enqueue("BATMAN");
        arrayQueue.enqueue("TOR");
        arrayQueue.enqueue("CAPTAIN AMERICA");

        assertEquals(5, arrayQueue.size());
        assertTrue(arrayQueue.contains("BATMAN"));
    }

    @Test
    void testContainsFalseOnNewQueueAWithSearchDataNotExsist() {
        ArrayQueue arrayQueue  = new ArrayQueue();
        arrayQueue.enqueue("SUPERMAN");
        arrayQueue.enqueue("IRONMAN");
        arrayQueue.enqueue("BATMAN");
        arrayQueue.enqueue("TOR");
        arrayQueue.enqueue("CAPTAIN AMERICA");

        assertEquals(5, arrayQueue.size());
        assertFalse(arrayQueue.contains("SUPER WOMAN"));
    }

    @Test
    void testContainsFalseIsEmptyQueue() {
        ArrayQueue arrayQueue  = new ArrayQueue();

        assertEquals(0, arrayQueue.size());
        assertFalse(arrayQueue.contains("SUPER WOMAN"));
    }

    @Test
    void testClearTrueQueue() {
        ArrayQueue arrayQueue  = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        assertEquals(3, arrayQueue.size());
        assertFalse(arrayQueue.isEmpty());

        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
        assertEquals(0, arrayQueue.size());
    }

    @Test
    void testClearTrueWithEmptyQueue() {
        ArrayQueue arrayQueue  = new ArrayQueue();

        assertEquals(0, arrayQueue.size());
        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
        assertEquals(0, arrayQueue.size());
    }
}
