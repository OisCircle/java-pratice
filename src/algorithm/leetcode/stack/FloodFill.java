package algorithm.leetcode.stack;

/**
 * @author O
 * @since 2020/3/24
 */
public class FloodFill {
    public static void main(String[] args) {
        int[][] image0 = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFill(image0, 1, 1, 2);
        for (int i = 0; i < image0.length; i++) {
            for (int j = 0; j < image0[0].length; j++) {
                System.out.println(image0[i][j]);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        dfs(image, oldColor, sr, sc, newColor);
        return image;
    }

    private static void dfs(int[][] image, int oldColor, int r, int c, int newColor) {
        if (image[r][c] != newColor) {
            if (image[r][c] == oldColor) {
                image[r][c] = newColor;
                //上下左右
                if (r != 0 && image[r - 1][c] != newColor) {
                    dfs(image, oldColor, r - 1, c, newColor);
                }
                if (r != image.length - 1 && image[r + 1][c] != newColor) {
                    dfs(image, oldColor, r + 1, c, newColor);
                }
                if (c != 0 && image[r][c - 1] != newColor) {
                    dfs(image, oldColor, r, c - 1, newColor);
                }
                if (c != image[0].length - 1 && image[r][c + 1] != newColor) {
                    dfs(image, oldColor, r, c + 1, newColor);
                }
            }
        }
    }
}
