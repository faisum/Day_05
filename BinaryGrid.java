import java.util.*;  
public class MinimumSwapsBinaryGridBFS {  
    public static int minSwaps(int[][] grid) {  
        int n = grid.length;  
        int[] trailingZeros = new int[n];  
        for (int i = 0; i < n; i++) {  
            int count = 0;  
            for (int j = n - 1; j >= 0; j--) {  
                if (grid[i][j] == 0) {  
                    count++;  
                } else {  
                    break;  
                }  
            }  
            trailingZeros[i] = count;  
        }  
        
        Queue<int[]> queue = new LinkedList<>();  
        Set<String> visited = new HashSet<>();  
        queue.add(trailingZeros.clone());  
        visited.add(Arrays.toString(trailingZeros));  
        int swaps = 0;  
        while (!queue.isEmpty()) {  
            int size = queue.size();  
            for (int k = 0; k < size; k++) {  
                int[] current = queue.poll();  
               
                boolean valid = true;  
                for (int i = 0; i < n; i++) {  
                    if (current[i] < n - 1 - i) {  
                        valid = false;  
                        break;  
                    }  
                }  
                if (valid) {  
                    return swaps;  
                }  
                 
                for (int i = 0; i < n - 1; i++) {  
                    int[] next = current.clone();  
                    int temp = next[i];  
                    next[i] = next[i + 1];  
                    next[i + 1] = temp;  
                    String key = Arrays.toString(next);  
                    if (!visited.contains(key)) {  
                        queue.add(next);  
                        visited.add(key);  
                    }  
                }  
            }  
            swaps++;  
        }  
        
        return -1;  
    }  
    public static void main(String[] args) {  
        int[][] grid = {  
            {0, 0, 1},  
            {1, 1, 0},  
            {1, 0, 0}  
        };  
        System.out.println(minSwaps(grid));
    }  
}  
