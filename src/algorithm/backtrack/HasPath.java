package algorithm.backtrack;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，
 * 向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进
 * 入该格子。
 *
 * @author O
 * @version 1.0
 * @date 2019/7/2
 */
public class HasPath {
    public static void main(String[] args) {
        char[] matrix = "abcesfcsadee".toCharArray();
        char[] str = "bcced".toCharArray();
        char[] str2 = "abcb".toCharArray();
        char[] str3 = "abcesfcsadee".toCharArray();
        System.out.println(hasPath(matrix, 3, 4, str));
        System.out.println(hasPath(matrix, 3, 4, str2));
        System.out.println(hasPath(matrix, 3, 4, str3));
    }

    /**
     * 回溯法
     */
    static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] map = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = matrix[i * cols + j];
            }
        }
        boolean[][] visit = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(map, visit, rows, cols, str, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean backtrack(char[][] map, boolean[][] visit, int rows, int cols, char[] str, int x, int y, int cur) {
        //找到了路径
        if (cur >= str.length) {
            return true;
        }
        if (x < 0 || y < 0 || x >= rows || y >= cols) {
            return false;
        }
        boolean hasPath = false;
        //如果路径正确且没有被访问
        if (map[x][y] == str[cur] && !visit[x][y]) {
            visit[x][y] = true;
            hasPath= backtrack(map, visit, rows, cols, str, x - 1, y, cur + 1)
                    ||
                    backtrack(map, visit, rows, cols, str, x, y - 1, cur + 1)
                    ||
                    backtrack(map, visit, rows, cols, str, x + 1, y, cur + 1)
                    ||
                    backtrack(map, visit, rows, cols, str, x, y + 1, cur + 1);
        }
        if (!hasPath) {
            //找不到路径要清空现场
            visit[x][y] = false;
        }
        return hasPath;
    }

}
