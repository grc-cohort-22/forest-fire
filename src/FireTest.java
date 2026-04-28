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

    @Test
    public void testSingleTree() {
        char[][] forest = {
            {'t'}
        };

        assertEquals(0, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testStartEmptyLocation() {
        char[][] forest = {
            {'.', 't'},
            {'t', 't'}
        };

        assertEquals(0, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testEmptyForest() {
        char[][] forest = {
            {'.', '.'},
            {'.', '.'}
        };

        assertEquals(0, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testLineOfTrees() {
        char[][] forest = {
            {'t', 't', 't', 't'}
        };

        assertEquals(3, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testSquareForest() {
        char[][] forest = {
            {'t', 't'},
            {'t', 't'}
        };

        assertEquals(2, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testTallForest() {
        char[][] forest = {
            {'t'},
            {'t'},
            {'t'},
            {'t'}
        };

        assertEquals(3, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testDisconnectedTrees() {
        char[][] forest = {
            {'t', '.', 't'},
            {'.', '.', '.'},
            {'t', '.', 't'}
        };

        assertEquals(0, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testComplexShape() {
        char[][] forest = {
            {'t', 't', '.', 't'},
            {'.', 't', '.', 't'},
            {'t', 't', 't', 't'}
        };

        assertEquals(7, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testStartInMiddle() {
        char[][] forest = {
            {'t', 't', 't'},
            {'t', 't', 't'},
            {'t', 't', 't'}
        };

        assertEquals(2, Fire.timeToBurn(forest, 1, 1));
    }

    @Test
    public void testForestWithGaps() {
        char[][] forest = {
            {'t', '.', 't', 't', '.', 't'}
        };

        assertEquals(0, Fire.timeToBurn(forest, 0, 0));
    }
}
