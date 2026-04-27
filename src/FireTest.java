import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testSingleTreeBurnsImmediately() {
        char[][] forest = {
            {'t'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testLineOfTreesBurnsToFarthestTree() {
        char[][] forest = {
            {'t', 't', 't', 't'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 3;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testFireDoesNotSpreadAcrossEmptyGround() {
        char[][] forest = {
            {'t', '.', 't'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testMatchInCenterSpreadsAllDirections() {
        char[][] forest = {
            {'t', 't', 't'},
            {'t', 't', 't'},
            {'t', 't', 't'}
        };
        assertEquals(2, Fire.timeToBurn(forest, 1, 1));
    }

    @Test
    public void testGridOfTreesBurns() {
        char[][] forest = {
            {'t', 't', 't', 't'},
            {'t', 't', 't', 't'},
            {'t', 't', 't', 't'},
            {'t', 't', 't', 't'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 6;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testFireDoesNotSpreadAcrossEmptyRow() {
        char[][] forest = {
            {'t', 't', 't', 't'},
            {'.', '.', '.', '.'},
            {'t', 't', 't', 't'},
            {'t', 't', 't', 't'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 3;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTwoGroupsOfIsolatedTrees() {
        char[][] forest = {
            {'t', 't', '.', 't', 't'},
            {'t', 't', '.', 't', 't'},
            {'t', 't', '.', 't', 't'}
        };
        assertEquals(3, Fire.timeToBurn(forest, 0, 0));
    }
}
