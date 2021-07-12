package AV.task2;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CustomSetTest {
    @Test
    void checkCustomList(){
        Set<String> testSet = new CustomSet();
        testSet.add("one");
        testSet.add("two");
        testSet.add("three");
        assertEquals(3, testSet.size());

        assertFalse(testSet.isEmpty());

        testSet.add("one");

        assertEquals(3, testSet.size());


    }

}