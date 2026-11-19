public class Assignment01Q05 {
public static int findShortestPath(int[][] m, int i, int j) {
    int n = m.length;
    int[] pathLengths = new int[n];
    for (int k = 0; k < n; k++) {
        pathLengths[k] = -1;
    }
    pathLengths[i] = 0;

    int count = 0;
    boolean updated = true;

    while (pathLengths[j] == -1 && updated) {
        updated = false;
        for (int row = 0; row < n; row++) {
            if (pathLengths[row] == count) {
                for (int col = 0; col < n; col++) {
                    if (m[row][col] == 1 && pathLengths[col] == -1) {
                        pathLengths[col] = count + 1;
                        updated = true;
                    }
                }
            }
        }
        count++;
    }

    return pathLengths[j];
}


    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}