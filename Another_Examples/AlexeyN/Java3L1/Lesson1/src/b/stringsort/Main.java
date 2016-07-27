package b.stringsort;

/**
 * Created by tomag on 14.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        LengthComparator<String> lengthComparator = new LengthComparator<>();
        System.out.println("a < bb: "+lengthComparator.compare("a","bb"));
        System.out.println("aa > b: "+lengthComparator.compare("aa","b"));
        System.out.println("a == b: "+lengthComparator.compare("a","b"));
    }
}
