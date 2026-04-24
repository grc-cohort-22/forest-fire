import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FireTest {
    @Test
    public void testTimeToBurnExample() {
        char[][] forest = {
            {'t','.','.','t','t','t','t','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = 2;
        int matchC = 6;

        int expected = 8;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    // Add more tests!
    @Test
    public void testTimeToBurnEverything() {
        char[][] forest = {
            {'t','t','t','t','t','t','t','t','t'},
            {'t','t','t','t','t','t','t','t','t'},
            {'t','t','t','t','t','t','t','t','t'},
            {'t','t','t','t','t','t','t','t','t'}
        };

        int matchR = 2;
        int matchC = 6;

        int expected = 8;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnNothing() {
        char[][] forest = {
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'}
        };

        int matchR = 2;
        int matchC = 6;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnLine() {
        char[][] forest = {
            {'t','t','t','t','t','t','t','t','t'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 8;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnEdge() {
        char[][] forest = {
            {'t','t','t','t','t','t','t','t','t'},
            {'t','.','.','.','.','.','.','.','t'},
            {'t','.','.','.','.','.','.','.','t'},
            {'t','t','t','t','t','t','t','t','t'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 11;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToSingleEdge() {
        char[][] forest = {
            {'t','.','t','t','t','t','t','t','t'},
            {'.','.','.','.','.','.','.','.','t'},
            {'t','.','.','.','.','.','.','.','t'},
            {'t','t','t','t','t','t','t','t','t'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testInvalid() {
        char[][] forest = {
            {'%','t','t','t','t','t','t','t','t'},
            {'t','.','.','.','.','.','.','.','t'},
            {'%','.','.','.','.','.','.','.','t'},
            {'t','t','t','t','t','t','t','t','t'}
        };

        assertThrows(InvalidForestException.class, () -> Fire.timeToBurn(forest, 0, 1));
    }
}
