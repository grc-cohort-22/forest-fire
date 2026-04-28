import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public static int timeToBurn(char[][] forest, int matchR, int matchC) {
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?

        char[][] forestClone = new char[forest.length][];
        for (int i = 0; i < forest.length; i++) { forestClone[i] = forest[i].clone(); }
        return timeToBurn(forestClone, matchR, matchC, 0);
    }
    
    public static int timeToBurn(char[][]forest, int startRow, int startColumn, int depth){
        if(forest[startRow][startColumn] == '.') return 0;

        Queue<int[]> treeQueue = new LinkedList<>();
        treeQueue.add(new int[]{startRow, startColumn, 0});
        
        while(!treeQueue.isEmpty()){
            int[] location = treeQueue.poll();
            if(forest[location[0]][location[1]] == '.') continue;
            forest[location[0]][location[1]] = '.'; 
            depth = Math.max(depth, location[2]); // check depth burned compared to current total burned
            for(int[] move: possibleMoves(forest, location[0], location[1])){
                treeQueue.add(new int[]{move[0], move[1], depth + 1});
            }
        }

        return depth;
    }
    public static List<int[]> possibleMoves(char[][] forest, int startRow, int startColumn){
        List<int[]> possibleMoves = new ArrayList<>();
        int[][] moves = new int[][]{
            {-1, 0}, //up
            {1, 0}, //down
            {0, -1}, //left
            {0, 1}, //right
        };

        for(int[] move : moves){
            int newRow = startRow + move[0];
            int newColumn = startColumn + move[1];

            if(newRow >= 0 && newRow < forest.length &&
               newColumn >= 0 && newColumn < forest[0].length &&
               forest[newRow][newColumn] != '.'){
                    possibleMoves.add(new int[]{newRow, newColumn});
               }
        }
        return possibleMoves;
    }
}