import com.skit.AnagramFinder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnagramFinderTest {

    @Test
    void testBasicAnagrams() {
        List<String> list1 = Arrays.asList("rat", "tar", "art");
        List<String> list2 = Arrays.asList("car", "arc", "rac");

        List<String> expected = Arrays.asList("rat", "tar", "art", "car", "arc", "rac");
        List<String> actual = AnagramFinder.findAnagrams(list1, list2);

        assertEquals(expected, actual);
    }

    @Test
    void testEmptyListsBoth() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        List<String> expected = new ArrayList<>();
        List<String> actual = AnagramFinder.findAnagrams(list1, list2);

        assertEquals(expected, actual);
    }

    @Test
    void testCaseInsensitivity() {
        List<String> list1 = Arrays.asList("Listen", "Silent");
        List<String> list2 = Arrays.asList("hello", "Enlist");

        List<String> expected = Arrays.asList("Listen", "Silent", "Enlist");
        List<String> actual = AnagramFinder.findAnagrams(list1, list2);

        assertEquals(expected, actual);
    }

    @Test
    void testNoAnagrams() {
        List<String> list1 = Arrays.asList("apple", "banana", "grape");
        List<String> list2 = Arrays.asList("cherry", "peach", "melon");

        List<String> actual = AnagramFinder.findAnagrams(list1, list2);

        assertTrue(actual.isEmpty(), "Expected an empty list but got: " + actual);
    }

    @Test
    void testDuplicatesInInput() {
        List<String> list1 = Arrays.asList("dusty", "study", "silent");
        List<String> list2 = Arrays.asList("hello", "hello", "tinsel");

        List<String> expected = Arrays.asList("dusty", "study", "silent", "tinsel");
        List<String> actual = AnagramFinder.findAnagrams(list1, list2);

        assertEquals(expected, actual);
    }

    @Test
    void testEmptyLists() {
        List<String> list1 = Collections.emptyList();
        List<String> list2 = Arrays.asList("dog", "god", "cat");

        List<String> expected = Arrays.asList("dog", "god");
        List<String> actual = AnagramFinder.findAnagrams(list1, list2);

        assertEquals(expected, actual);
    }

    @Test
    void testPerformanceLargeInput() {
        List<String> list1 = Arrays.asList("listen", "silent", "enlist");
        List<String> list2 = Arrays.asList("silent", "world", "tinsel");

        List<String> expected = Arrays.asList("listen", "silent", "enlist", "tinsel");
        List<String> actual = AnagramFinder.findAnagrams(list1, list2);

        assertEquals(expected, actual);
    }



    @Test
    void testBCC4Example() {
        List<String> list1 = Arrays.asList("earth", "hearth", "heart");
        List<String> list2 = new ArrayList<>();

        List<String> expected = Arrays.asList("earth", "heart");
        List<String> actual = AnagramFinder.findAnagrams(list1, list2);

        assertEquals(expected, actual);
    }

    @Test
    void testBCC7Example() {
        List<String> list1 = Arrays.asList("earth", "hearth", "heart", "earth");
        List<String> list2 = Arrays.asList("hearth", "earth", "hearth", "rathe");

        List<String> expected = Arrays.asList("earth", "heart", "rathe");
        List<String> actual = AnagramFinder.findAnagrams(list1, list2);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindAnagrams_NullInput_ThrowsNullPointerException_List1() {
        List<String> list2 = List.of("listen", "silent");


        Exception exception = assertThrows(NullPointerException.class, () -> {
            AnagramFinder.findAnagrams(null, list2);
        });

        assertEquals("One or both inputs is null!", exception.getMessage());
    }

    @Test
    public void testFindAnagrams_NullInput_ThrowsNullPointerException_List2() {
        List<String> list1 = List.of("listen", "silent");


        Exception exception = assertThrows(NullPointerException.class, () -> {
            AnagramFinder.findAnagrams(list1, null);
        });

        assertEquals("One or both inputs is null!", exception.getMessage());
    }

    @Test
    public void anagramsInOneListTest() {
        List<String> list1 = Arrays.asList("some", "words", "not", "anagrams");
        List<String> list2 = Arrays.asList("ahfdhdfh", "post", "vcbcvb", "stop");

        List<String> expected = Arrays.asList("post", "stop");
        List<String> actual = AnagramFinder.findAnagrams(list1, list2);

        assertEquals(expected, actual);
    }


}
