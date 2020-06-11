package algorithm.leetcode.stack;

import java.util.*;

/**
 * @author O
 * @since 2020/3/25
 */
public class CanVisitAllRooms {
    public static void main(String[] args) {
        List<Integer> room0 = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        List<Integer> room2 = new ArrayList<>();
        List<Integer> room3 = new ArrayList<>();
        List<List<Integer>> rooms0 = new ArrayList<>();
        rooms0.add(room0);
        rooms0.add(room1);
        rooms0.add(room2);
        rooms0.add(room3);
        room0.add(1);
        room1.add(2);
        room2.add(3);
        System.out.println(canVisitAllRooms(rooms0));

        room0 = new ArrayList<>();
        room1 = new ArrayList<>();
        room2 = new ArrayList<>();
        room3 = new ArrayList<>();
        rooms0 = new ArrayList<>();
        rooms0.add(room0);
        rooms0.add(room1);
        rooms0.add(room2);
        rooms0.add(room3);
        room0.add(1);
        room0.add(3);
        room1.add(3);
        room1.add(0);
        room1.add(1);
        room2.add(2);
        room3.add(0);
        System.out.println(canVisitAllRooms(rooms0));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>(rooms.size());
        int count = rooms.size() - 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < rooms.get(0).size(); i++) {
            stack.push(rooms.get(0).get(i));
        }
        visited.add(0);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (visited.contains(cur)) {
                continue;
            }
            count--;
            visited.add(cur);
            for (int i = 0; i < rooms.get(cur).size(); i++) {
                stack.push(rooms.get(cur).get(i));
            }
        }
        return count == 0;
    }
}
