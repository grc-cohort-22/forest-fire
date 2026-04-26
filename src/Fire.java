import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Fire {
    /**
     * Returns how long it takes for all vulnerable trees to be set on fire if a
     * match is lit at a given location.
     * 
     * The forest is represented via a rectangular 2d char array where t represents a tree
     * and . represents an empty space.
     * 
     * At time 0, the tree at location [matchR, matchC] is set on fire. At every subsequent
     * time step, any tree that is adjacent (up/down/left/right) to a burning tree is also
     * set on fire. 
     * 
     * 
     * EXAMPLE 
     * forest:
     * 
     * t..tttt.t
     * ..tt....t
     * ..ttttttt
     * tttt.....
     * 
     * matchR: 2
     * matchC: 6
     * 
     * Result: 8
     * 
     * Explanation:
     * At time 0, the tree at (2, 6) is set on fire. At time 1, its adjacent trees also catch on fire
     * At time 2, the trees adjacent to those catch as well. At time 8, the last tree to catch is at
     * (0,6). In this example, there is one tree that never burns, so it is not included in the time calculation.
     * 
     * 
     * @param forest a 2d array where t represents a tree and . represents the ground
     * @param matchR The row the match is lit at
     * @param matchC The column the match is lit at
     * @return the time at which the final tree to be incinerated starts burning
     */
    public static int timeToBurn(char[][] forest, int matchR, int matchC){
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?

        if(forest[matchR][matchC] != 't') throw new IllegalArgumentException();

        boolean[][] visited =  new boolean[forest.length][forest[0].length];

        // Implement this AND add more tests!!!
        // Queue<char[]> queue = new LinkedList<>();

        int[][] directions = {
            {1,0}, //down
            {-1,0},// up
            {0,1},//right
            {0,-1}// left
        };
        int time = 0;

        // StartLocation start = new StartLocation(matchR, matchC);
        int[] start = new int[]{matchR, matchC, time};

        

        return bfs(forest, start, directions, visited);
    }

    public static boolean isValid(int r, int c, char[][] forest, boolean[][] visited) {
        // base case: check bounds
        if (r < 0 || r >= forest.length || c < 0 || c >= forest[0].length) return false;

        // tree check
        if (forest[r][c] != 't') return false;

        // visited check
        if (visited[r][c]) return false;
        
        return true;
    }

    public static int bfs(char[][] forest, int[] start, int[][] directions, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);
        visited[start[0]][start[1]] = true;

        int maxTime = 0;

        while(!queue.isEmpty()){
            int[] current = queue.poll();

            int currentRow = current[0];
            int currentCol = current[1];
            int time = current[2];

            maxTime = Math.max(maxTime, time);

            for(int[] direction : directions){
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];
                
                if(isValid(newRow, newCol, forest, visited)) {
                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol, time + 1});
                }

            }
        }


        return maxTime;
    }

}