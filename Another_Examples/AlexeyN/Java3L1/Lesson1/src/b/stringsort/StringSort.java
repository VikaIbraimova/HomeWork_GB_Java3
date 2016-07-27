package b.stringsort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by tomag on 10.07.2016.
 */
public class StringSort {
    public static <T extends String> String sort(T... t) {
        List<String> s = Arrays.asList(t);
        Collections.sort(s, new LengthComparator<>());
        return s.toString();
    }
}
