import b.stringsort.StringSort;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tomag on 10.07.2016.
 */
public class StringSortTest {
    @Test
    public void init() {
        assertEquals(new StringSort().sort("zzzzz","b","aaaa","cc","ggg"),"[b, cc, ggg, aaaa, zzzzz]");
        assertEquals(new StringSort().sort("eeeee","ccc","dddd","bb","ffffff"),"[bb, ccc, dddd, eeeee, ffffff]");
        assertEquals(new StringSort().sort("z","xx","ccc","vvvv","bbbbb"),"[z, xx, ccc, vvvv, bbbbb]");
        assertEquals(new StringSort().sort("bbbbb","vvvv","ccc","xx","z"),"[z, xx, ccc, vvvv, bbbbb]");
        assertEquals(new StringSort().sort("qqqqqqqqqqqqqqqqqqqq","b","dddddddd","cc","aaa"),"[b, cc, aaa, dddddddd, qqqqqqqqqqqqqqqqqqqq]");
    }
}