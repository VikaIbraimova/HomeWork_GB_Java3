import a.stack.GenericStack;
import a.stack.StackException;
import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by tomag on 10.07.2016.
 */
public class StackTest {
    GenericStack<Integer> genericStack;
    int size = Integer.MAX_VALUE/1024;

    @Before
    public void init() throws StackException {        genericStack = new GenericStack<Integer>(size);    }

    @Test
    public void someTests() throws StackException {

    }

    @Test
    public void pushTest() throws StackException {
        for (int i=0;i<size;i++) {
            genericStack.push(i);
        }
    }

    @Test (expected = StackException.class)
    public void pushErrorTest() throws StackException {
        for (int i=0;i<size+1;i++) {
            genericStack.push(i);
        }
    }

    @Test
    public void popTest() throws StackException {
        for (int i=0;i<size;i++) {
            genericStack.push(i);
        }
        for (int i=0;i<size;i++) {
            genericStack.pop();
        }
    }

    @Test (expected = StackException.class)
    public void popErrorTest() throws StackException {
        for (int i=0;i<size;i++) {
            genericStack.push(i);
        }
        for (int i=0;i<size+1;i++) {
            genericStack.pop();
        }
    }

    @Test
    public void peekTest() throws StackException {
        for (int i=0;i<size;i++) {
            genericStack.push(i);
        }
        for (int i=0;i<size;i++) {
            genericStack.peek();
        }
    }

    @Test (expected = StackException.class)
    public void peekErrorTest() throws StackException {
            genericStack.peek();
    }

    @Test
    public void getSizeTest() throws StackException {
        genericStack = new GenericStack<>(77);
        assertEquals(genericStack.getSize(),77);
        genericStack = new GenericStack<>(Integer.MAX_VALUE/1024);
        assertEquals(genericStack.getSize(),Integer.MAX_VALUE/1024);
    }

    @Test (expected = StackException.class)
    public void getSizeErrorTest() throws StackException {
        genericStack = new GenericStack<>(0);
        assertEquals(genericStack.getSize(),0);
        genericStack = new GenericStack<>(-1);
        assertEquals(genericStack.getSize(),-1);
    }

    @Test
    public void isEmptyTest() throws StackException {
        assertTrue(genericStack.isEmpty());
        genericStack.push(1);
        assertFalse(genericStack.isEmpty());
        genericStack.peek();
        assertFalse(genericStack.isEmpty());
        genericStack.pop();
        assertTrue(genericStack.isEmpty());
    }

    @Test
    public void isFullTest() throws StackException {
        assertFalse(genericStack.isFull());
        for (int i=0;i<size;i++) {
            genericStack.push(i);
        }
        assertTrue(genericStack.isFull());
        genericStack.peek();
        assertTrue(genericStack.isFull());
        genericStack.pop();
        assertFalse(genericStack.isFull());
        genericStack = new GenericStack<>(3);
        assertFalse(genericStack.isFull());
        genericStack.push(1);
        assertFalse(genericStack.isFull());
        genericStack.push(2);
        assertFalse(genericStack.isFull());
        genericStack.push(3);
        assertTrue(genericStack.isFull());
        genericStack.peek();
        assertTrue(genericStack.isFull());
        genericStack.pop();
        assertFalse(genericStack.isFull());
    }

    @Test
    public void pushAllTest() throws StackException {
        genericStack.push(1);
        genericStack.push(2);
        genericStack.push(3);
        ArrayList<Integer> arrayList = new ArrayList<>();
        genericStack.popAll(arrayList);
        assertArrayEquals(arrayList.toArray(), new Object[]{3, 2, 1});
    }

    @Test
    public void popAllTest() throws StackException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        genericStack.pushAll(arrayList);
        assertEquals(genericStack.pop(),(Object) 3);
        assertEquals(genericStack.pop(),(Object) 2);
        assertEquals(genericStack.pop(),(Object) 1);
    }

}
