import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FireTest {
    @Test
    public void testTimeToBurnExample() {
        char[][] forest = {
                { 't', '.', '.', 't', 't', 't', 't', '.', 't' },
                { '.', '.', 't', 't', '.', '.', '.', '.', 't' },
                { '.', '.', 't', 't', 't', 't', 't', 't', 't' },
                { 't', 't', 't', 't', '.', '.', '.', '.', '.' }
        };

        int matchR = 2;
        int matchC = 6;

        int expected = 8;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnSingleTree() {
        char[][] forest = {
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', 't', '.', '.', '.', '.', '.' },
                { '.', '.', '.', 't', '.', '.', '.', '.', '.' }
        };

        int matchR = 3;
        int matchC = 3;

        int expected = 1;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnOneTree() {
        char[][] forest = {
                { 't' }
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnBlockedByEmptySpace() {
        char[][] forest = {
                { 't', '.', 't' }
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testStrightLine() {
        char[][] forest = {
                { 't', 't', 't', 't' }
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 3;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    // Add more tests!
}
