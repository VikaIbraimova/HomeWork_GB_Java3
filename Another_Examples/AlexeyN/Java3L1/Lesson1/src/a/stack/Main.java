package a.stack;

import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tomag on 10.07.2016.
 */
public class Main {
    public static void main(String[] args) throws StackException {
        GenericStack<Integer> stack = new GenericStack<>(5);
    }
}
