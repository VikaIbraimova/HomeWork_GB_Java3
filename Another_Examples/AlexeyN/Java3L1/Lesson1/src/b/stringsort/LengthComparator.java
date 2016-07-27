package b.stringsort;

import java.util.Comparator;

/**
 * Created by tomag on 10.07.2016.
 */
public class LengthComparator<T extends String> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
		//FIXME: у вас 0 возвращается и при равно и при o1 > o2
        //return o1.length()<o2.length() ? -1 : 0;
        int len1 = o1.length(), len2 = o2.length();
        return len1<len2 ? -1 : len1 == len2 ? 0 : 1; //fixed?
    }
}
