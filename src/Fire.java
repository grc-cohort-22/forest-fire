import java.util.LinkedList;
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
        if (forest == null) return 0;
        if (forest[matchR][matchC] == '.') return 0;

        char[][] burningforest = new char[forest.length][forest[0].length];
        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest[0].length; j++) {
                burningforest[i][j] = forest[i][j];
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{matchR, matchC, 0});
        burningforest[matchR][matchC] = 'f';

        int output = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int time = current[2];

            if (r < burningforest.length - 1 && burningforest[r + 1][c] == 't') {
                burningforest[r + 1][c] = 'f';
                queue.add(new int[]{r + 1, c, time + 1});
                if (time + 1 > output) output = time + 1;
            }

            if (r > 0 && burningforest[r - 1][c] == 't') {
                burningforest[r - 1][c] = 'f';
                queue.add(new int[]{r - 1, c, time + 1});
                if (time + 1 > output) output = time + 1;
            }

            if (c < burningforest[0].length - 1 && burningforest[r][c + 1] == 't') {
                burningforest[r][c + 1] = 'f';
                queue.add(new int[]{r, c + 1, time + 1});
                if (time + 1 > output) output = time + 1;
            }

            if (c > 0 && burningforest[r][c - 1] == 't') {
                burningforest[r][c - 1] = 'f';
                queue.add(new int[]{r, c - 1, time + 1});
                if (time + 1 > output) output = time + 1;
            }
        }

        return output;
    }
}