import static org.junit.Assert.assertThrows;
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
    public void testValidStartNoTree(){
        //act
                char[][] forest = {
            {'t','.','.','t','t','t','t','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        //arrange

        int matchR = 1;
        int matchC = 1;
        //assert

               assertThrows(IllegalArgumentException.class, () -> {
            Fire.timeToBurn(forest, matchR, matchC);
        });
    }

        @Test
        public void testSmallForest(){

            //act
             char[][] forest = {
            {'t','.','.','t'},
            {'.','.','t','t'},
            {'.','.','t','t'},
            {'t','t','t','t'}
        };
            //arrange
            int matchR = 1;
            int matchC = 2;
            //assert

            int expected = 4;
            int actual = Fire.timeToBurn(forest, matchR, matchC);

            assertEquals(expected, actual);

            
        }


        @Test
         public void testOneTree (){

            char[][] forest ={
                {'t'}
            };


            int matchR = 0;
            int matchC = 0;

            int expected = 0;
            int actual = Fire.timeToBurn(forest, matchR, matchC);

            assertEquals(expected, actual);
         }

         @Test
         public void testOneTreeToBurn(){
            char[][] forest = {
                {'.','.','.','t'},
                {'.','t','.','t'},
                {'.','.','.','t'},
                {'t','t','t','t'}
            };

            int matchR = 1;
            int matchC = 1;

            int expected = 0;
            int actual = Fire.timeToBurn(forest, matchR, matchC);

            assertEquals(expected, actual);
         }

         @Test
         public void testBurnEverything(){
            char[][] forest = {
                {'t','t','t','t','t','t','t','t','t'},
                {'t','t','t','t','t','t','t','t','t'},
                {'t','t','t','t','t','t','t','t','t'},
                {'t','t','t','t','t','t','t','t','t'}
            };

            int matchR = 0;
            int matchC = 0;

            int expected = 11;
            int actual = Fire.timeToBurn(forest, matchR, matchC);

            assertEquals(expected, actual);

         }

         @Test
         public void testMatchLocationOutOfBounds(){
            char[][] forest = {
                {'t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t'},
                {'t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t','t'},

            };

            int matchR = 2;
            int matchC = 12;

            
            assertThrows(IndexOutOfBoundsException.class, () -> {
                Fire.timeToBurn(forest, matchR, matchC);
             });
         }

         @Test
         public void testOnlyDiagnolTrees(){
            char[][] forest = {
                {'t','.','.','.','t'},
                {'.','t','.','t','.'},
                {'.','.','t','.','.'},
                {'.','t','.','t','.'},
                {'t','.','.','.','t'}
            };

            int matchR = 2;
            int matchC = 2;

            int expected = 0;
            int actual = Fire.timeToBurn(forest, matchR, matchC);

            assertEquals(expected, actual);

         }

}
