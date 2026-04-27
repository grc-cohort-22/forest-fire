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
    public void testTimeToBurnPillarExample() {
        char[][] forest = {
          {'t','t','t'},
          {'t','.','t'},
          {'t','.','t'},
          {'t','.','t'},
          {'t','t','t'},
        };

        int matchR = 4;
        int matchC = 1;

        int expected = 6;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testBadInput(){
         char[][] forest = {
          {'t','t','t'},
          {'t','.','t'},
          {'t','.','t'},
          {'t','.','t'},
          {'t','t','t'},
        };

        int matchR = 1;
        int matchC = 1;


        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Fire.timeToBurn(forest, matchR, matchC);
        });

    }

    @Test
    public void testNullInput(){
         char[][] forest = null;

        int expected = -1;
        int actual = Fire.timeToBurn(forest, 0, 0);

        assertEquals(expected, actual);

    }
        
        @Test
    public void testTimeToBurnDExample() {
        char[][] forest = {
          {'t','.','.'},
          {'.','t','.'},
          {'.','.','t'},
          {'.','t','.'},
          {'t','.','.'},
        };

        int matchR = 1;
        int matchC = 1;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }
}
