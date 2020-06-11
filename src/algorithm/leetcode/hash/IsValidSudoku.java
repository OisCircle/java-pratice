package algorithm.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author O
 * @since 2020/3/14
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }
        int len = board[0].length;
        List<Map<Character, Integer>> rows = new ArrayList<>(len);
        List<Map<Character, Integer>> cols = new ArrayList<>(len);
        //子数独
        List<Map<Character, Integer>> subSudokus = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            rows.add(new HashMap<>());
            cols.add(new HashMap<>());
            subSudokus.add(new HashMap<>());
        }
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                //记录目前的数字在第几个子数独里面
                int subSudoku = (row / 3) * 3 + col / 3;
                final char c = board[row][col];
                if (c != '.') {
                    Map<Character, Integer> rowMap = rows.get(row);
                    Map<Character, Integer> colMap = cols.get(col);
                    Map<Character, Integer> subSudokuMap = subSudokus.get(subSudoku);
                    if (rowMap == null || rowMap.containsKey(c)) {
                        return false;
                    } else {
                        rowMap.put(c, rowMap.getOrDefault(c, 0) + 1);
                    }
                    if (colMap == null || colMap.containsKey(c)) {
                        return false;
                    } else {
                        colMap.put(c, colMap.getOrDefault(c, 0) + 1);
                    }
                    if (subSudokuMap == null || subSudokuMap.containsKey(c)) {
                        return false;
                    } else {
                        subSudokuMap.put(c, subSudokuMap.getOrDefault(c, 0) + 1);
                    }
                }
            }
        }
        return true;
    }
}
