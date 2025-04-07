package LeetCode.number.a001_100;

//补充内容暂待后续去了解~
import java.util.Arrays;
import java.util.Scanner;

public class twoSum {   //方法
    public static int[] twoSum(int nums[], int target) {
        for(int i = 0; i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    //普通调用
    /*public static void main(String[] args) {
        twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        if (result != null) {
            System.out.println(result[0] + " " + result[1]);
        } else {
            System.out.println("None");
        }
    }*/

    //调用
    public static void main(String[] args){
        //键入数组
        System.out.print("Please input nums and slipt with ,");
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("\\s");
        int[] sums = new int[str.length];
        for(int i = 0;i < sums.length;i++){
            sums[i] = Integer.parseInt(str[i]);
        }
        System.out.print("Please input target:");
        int target = sc.nextInt();
        //调用方法
        int[] result = twoSum(sums,target);
        System.out.print(Arrays.toString(result));
    }

    //补充：暴力解法 - 优化版：List
    /*public static List<int[]> bruteForceTwoSum(int[] nums, int target) {
        List<int[]> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) { // j从i+1开始，避免重复
                if (nums[i] + nums[j] == target) {
                    results.add(new int[]{i, j});
                }
            }
        }
        return results;
    }*/


    //部分新知识 - 哈希表
/*    import java.util.HashMap;
import java.util.Arrays;

    public class Solution {
        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i}; // 返回已存储的索引和当前索引[[3, 11, 18]]
                }
                map.put(nums[i], i); // 将当前元素存入哈希表
            }
            throw new IllegalArgumentException("No two sum solution"); // 无解时抛出异常
        }

        public static void main(String[] args) {
            int[] nums = {2, 7, 11, 15};
            int target = 9;
            int[] result = twoSum(nums, target);
            System.out.println("结果下标：" + Arrays.toString(result)); // 输出：[0, 1]
        }
    }*/

/*    import java.util.HashMap;
import java.util.Arrays;
import java.util.Scanner;

    public class Solution {
        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("无解");
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // 手动输入数组
            System.out.print("请输入数组元素（用空格分隔，例如：2 7 11 15）: ");
            String[] input = scanner.nextLine().split("\\s+");
            int[] sums = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                sums[i] = Integer.parseInt(input[i]);
            }

            // 手动输入目标值
            System.out.print("请输入目标值（例如：9）: ");
            int target = scanner.nextInt();

            // 计算并输出结果
            int[] result = twoSum(sums, target);
            System.out.println("结果下标：" + Arrays.toString(result));
        }
    }*/


    //部分新知识 - 暴力解法
/*
    public class Solution {
        public static int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j}; // 返回两个索引[[1, 5, 13]]
                    }
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }

        public static void main(String[] args) {
            int[] nums = {2, 7, 11, 15};
            int target = 9;
            int[] result = twoSum(nums, target);
            System.out.println("结果下标：" + Arrays.toString(result)); // 输出：[0, 1]
        }
    }
*/


    //补充：哈希表 - 优化版
    /*public class MultiTwoSum {
        public static List<int[]> twoSum(int[] nums, int target) {
            Map<Integer, List<Integer>> valueIndices = new HashMap<>();
            List<int[]> results = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                // 检查补数是否存在且已被记录
                if (valueIndices.containsKey(complement)) {
                    for (int j : valueIndices.get(complement)) {
                        results.add(new int[]{j, i}); // 保证j < i，避免重复
                    }
                }
                // 将当前元素加入哈希表（处理值重复情况）
                valueIndices.putIfAbsent(nums[i], new ArrayList<>());
                valueIndices.get(nums[i]).add(i);
            }
            return results;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // 输入数组
            System.out.print("输入数组元素（空格分隔，如：2 7 3 3 6）: ");
            String[] inputs = scanner.nextLine().split("\\s+");
            int[] nums = new int[inputs.length];
            for (int i = 0; i < inputs.length; i++) {
                nums[i] = Integer.parseInt(inputs[i]);
            }

            // 输入目标值
            System.out.print("输入目标值（如：9）: ");
            int target = scanner.nextInt();

            // 计算并输出结果
            List<int[]> results = twoSum(nums, target);
            if (results.isEmpty()) {
                System.out.println("无解");
            } else {
                System.out.println("所有解的下标：");
                for (int[] pair : results) {
                    System.out.println(Arrays.toString(pair));
                }
            }
        }
    }*/
}