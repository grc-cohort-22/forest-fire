import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
    public static int timeToBurn(char[][] forest, int matchR, int matchC) {
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?
        // List<Location> neighbors = neighbors(forest, new Location(matchR, matchC));
        // for(Location x : neighbors) {
        //     System.out.println(x);
        // }
        if (forest[matchR][matchC] != 't') {
            return -1;
        }

        Set<Location> visited = new HashSet<>();
        Queue<BurningTree> queue = new LinkedList<>();

        Location startLoc = new Location(matchR, matchC);
        queue.add(new BurningTree(startLoc, 0));
        visited.add(startLoc);

        int maxTime = 0;

        while (!queue.isEmpty()) {
            BurningTree current = queue.poll();
            maxTime = Math.max(maxTime, current.time());

            for (Location neighbor : neighbors(forest, current.location())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new BurningTree(neighbor, current.time() + 1));
                }
            }
        }

        return maxTime;
    }

    public static void main(String[] args) {
        char[][] forest = {
            {'t', 't', 't'},
            {'t', 't', 't'},
            {'t', 't', 't'}
        };
        int matchR = 0;
        int matchC = 0;

        System.out.println(forest[matchR][matchC]);

        int result = timeToBurn(forest, matchR, matchC);
        System.out.println("Time to burn: " + result);
    }

    public static List<Location> neighbors(char[][] forest, Location currentLoc) {
        List<Location> result = new ArrayList<>();

        int[][] moves = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] move : moves) {
            int newR = currentLoc.row() + move[0];
            int newC = currentLoc.col() + move[1];

            if (
                newR >= 0 && newR < forest.length &&
                newC >= 0 && newC < forest[0].length &&
                forest[newR][newC] != '.'
            ) {
                result.add(new Location(newR, newC));
            }
        }

        return result;
    }
}