import java.util.LinkedHashMap;

import static org.junit.Assert.*;

public class BigramTest {

    @org.junit.Test
    public void testPopulateHashMap1() throws Exception {
        assertEquals(null, Bigram.populateHashMap("arun"));
    }

    @org.junit.Test
    public void testPopulateHashMap2() throws Exception {
        LinkedHashMap<String, Integer> lMap = new LinkedHashMap<>();
        lMap.put("arun manohar",1);
        assertEquals(lMap, Bigram.populateHashMap("arun manohar"));
    }

    @org.junit.Test
    public void testPopulateHashMap3() throws Exception {
        LinkedHashMap<String, Integer> lMap = new LinkedHashMap<>();
        lMap.put("arun manohar", 1);
        lMap.put("manohar manoharan", 1);
        assertEquals(lMap, Bigram.populateHashMap("arun manohar manoharan"));
    }

    @org.junit.Test
    public void testPopulateHashMap4() throws Exception {
        LinkedHashMap<String, Integer> lMap = new LinkedHashMap<>();
        lMap.put("the quick", 2);
        lMap.put("quick brown", 1);
        lMap.put("brown fox", 1);
        lMap.put("fox and", 1);
        lMap.put("and the", 1);
        lMap.put("quick blue", 1);
        lMap.put("blue hare", 1);
        assertEquals(lMap, Bigram.populateHashMap("The quick brown fox and the quick blue hare"));
    }
}