package a.stack;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Collection;

/**
 * Created by tomag on 10.07.2016.
 */
public class GenericStack<E> implements Stack<E> {

    private E[] objects;
    private int size;
    private int topElement;

    public GenericStack(int size) throws StackException {
        if (size>=0) {
            this.size = size;
            objects = (E[]) new Object[this.size];
            topElement = -1;
        } else throw new StackException("Wrong stack size");
    }

    public GenericStack() {
        this.size = 10;
        objects = (E[]) new Object[this.size];
        topElement = -1;
    }

    @Override
    public void push(E element) throws StackException {
        if (!isFull()) {
            topElement++;
            objects[topElement] = element;
        } else throw new StackException("Stack size is full");
    }

    @Override
    public E pop() throws StackException {
        if (!isEmpty()) {
            E pop = objects[topElement];
            objects[topElement] = null;
            topElement--;
            return pop;
        } else throw new StackException("Out of bounds: stack is empty");
    }

    @Override
    public E peek() throws StackException {
        if (!isEmpty()) { return objects[topElement]; }
        else throw new StackException("Out of bounds: stack is empty");
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return topElement == -1;
    }

    @Override
    public boolean isFull() {
        return topElement == size-1; //size correction
    }

    @Override
    public void pushAll(Collection<? extends E> src) throws StackException {
        for (E element : src
             ) {
            push(element);
        }
    }

    @Override
    public void popAll(Collection<? super E> dst) throws StackException {
        while (!isEmpty()) { dst.add(pop()); }
        /*for (E element : objects
             ) {
            dst.add(pop());
        }*/
    }
}
