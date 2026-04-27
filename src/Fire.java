import java.util.ArrayList;
import java.util.HashSet;
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
    public static int timeToBurn(char[][] forest, int matchR, int matchC) throws IllegalArgumentException{
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?
        if(forest == null){
            return -1;
        }

        if(forest[matchR][matchC] != 't'){
            throw new IllegalArgumentException("Starting match needs to be on a tree.");
        }

        int time = -1;

        // Implement this AND add more tests!!!
        HashSet<Location> seen = new HashSet<>();
        Queue<Location> queue = new LinkedList<>();

        queue.add(new Location(matchR, matchC));
        
        while(!queue.isEmpty()){
                int size = queue.size();
                time++;
                
                for (int i = 0; i < size; i++) { 
                Location current = queue.poll();
                if(seen.contains(current)){
                    continue;
                }

                seen.add(current);


                int currentR = current.row();
                int currentC = current.col();

                for(Location move : possibleMoves(forest, currentR, currentC)){
                    if (!seen.contains(move)) {
                        queue.add(new Location(move.row(), move.col()));
                    }
                }
            }
        }

        return time;
    }

    public static List<Location> possibleMoves(char[][] forest, int matchR, int matchC) {
        List<Location> list = new ArrayList<>();

        int[][] moves = new int[][]{
            {0, -1}, // LEFT
            {0, 1} , // RIGHT
            {1, 0}, // DOWN
            {-1, 0} // UP
        };

        for (int[] move : moves) {
            int newR = matchR + move[0];
            int newC = matchC + move[1];
            if (newC >= 0 && newC < forest[0].length 
                && newR >= 0 && newR < forest.length 
                && forest[newR][newC] == 't') {
                list.add(new Location(newR, newC));
            } 
        }

        return list;
    }


    


}