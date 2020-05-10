import java.math.BigDecimal;
import java.util.*;

/**
 * 2 * @Author: Run Man
 * 3 * @Date: 2020/5/9 15:22
 * 4
 */
public class Test {
    public static void main(String[] args) {
//        int[] n = {5, 3, 1, 6, 7};
//        System.out.println(n[0] ^ n[1] ^ n[2]);
//        int t = n[0] ^ n[1];
//        System.out.println(n[0]);
//        System.out.println(t);
//        System.out.println(5 ^ 3 ^ 1 ^ 6 ^ 7);
//        System.out.println(5 ^ 3);
//        System.out.println(5 ^ 2);
//
//        System.out.println(5 >> 3);

        String[] test = {"A..", "AAA", "..."};
        Solution t = new Solution();
        System.out.println(t.ways(test, 3));


    }


    class Solution5 {
        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            Map<Integer, List<Integer>> cache = new HashMap<>();
            // 建立邻接表
            for (int[] edge : edges) {
                List<Integer> list = cache.computeIfAbsent(edge[0], k -> new ArrayList<>());
                list.add(edge[1]);
            }
            int res = 0;
            // root节点不管是不是苹果，步数都是0，单独提出来，不要判断
            List<Integer> children = cache.get(0);
            // 从子节点开始遍历
            for (int childIndex : children) {
                res += getAppleByNode(cache, childIndex, hasApple);
            }
            return res;

        }

        private int getAppleByNode(Map<Integer, List<Integer>> cache, int index, List<Boolean> hasApple) {
            List<Integer> children = cache.get(index);
            if (children == null) {
                // 叶子节点判断，有苹果，返回来回路径，没有则返回0
                return hasApple.get(index) ? 2 : 0;
            }
            int res = 0;
            for (int childIndex : children) {
                res += getAppleByNode(cache, childIndex, hasApple);
            }
            // 孩子有苹果,带上自己的来回路径，孩子没有苹果，判断自己是不是有苹果
            return res > 0 ? res + 2 : hasApple.get(index) ? 2 : 0;
        }


    }

    static class Solution {
        public int ways(String[] pizza, int k) {
            String row1 = pizza[0];
            int col = row1.length();
            int row = pizza.length;
            int[][] p = new int[row][col];
            for (int i = 0; i < pizza.length; i++) {
                String temp = pizza[i];
                for (int j = 0; j < temp.length(); j++) {
                    if (temp.charAt(j) == '.') {
                        p[i][j] = 0;
                    } else {
                        p[i][j] = 1;
                    }
                }
            }

            return ways1(p, row, col, k);
        }

        private int ways1(int[][] p, int row, int col, int k) {

            if (p == null) return 0;
            if (k == 1) {
                int sum = 0;
                for (int i = 0; i < p.length; i++) {
                    sum += Arrays.stream(p[i]).sum();
                }
                if (sum > 0) {
                    return 1;
                } else return 0;
            }

            if (k == 2) {
                if (p.length == 1 && p[0].length == 1) {
                    return 0;
                }
            }

            //行切
            int sum1 = 0;
            for (int i = 0; i < p.length; i++) {
                if (sumRow(p, i + 1) > 0) {

                    int[][] t = new int[row - i - 1][col];
                    for (int j = i + 1, j1 = 0; j < row; j++, j1++) {
                        t[j1] = p[j];
                    }

                    sum1 += ways1(t, row - i - 1, col, k - 1);
                }
            }

            //竖切
            int sum2 = 0;
            for (int i = 0; i < col; i++) {
                int hasApple = 0;
                for (int ii = 0; ii < i; ii++) {
                    hasApple = hasApple + sumCol(p, ii);
                }
                if (hasApple > 0) {
                    int[][] t = new int[row][col - i - 1];
                    for (int i1 = 0; i1 < p.length; i1++) {
                        for (int i2 = i + 1, i3 = 0; i2 < col; i2++, i3++) {
                            t[i1][i3] = p[i1][i2];
                        }
                    }
                    sum2 += ways1(t, row, col - i - 1, k - 1);
                }
            }
            return sum1 + sum2;
        }

        private int sumRow(int[][] p, int row) {
            int hasApple = 0;
            for (int i = 0; i < row; i++) {
                hasApple = hasApple + Arrays.stream(p[i]).sum();


            }
            return hasApple;

        }

        private int sumCol(int[][] p, int col) {
            int s = 0;
            for (int i = 0; i < p.length; i++) {
                s += p[i][col];
            }
            return s;
        }
    }

    public String reformat(String s) {
        StringBuilder ss = new StringBuilder(s);
        StringBuilder num = new StringBuilder();
        StringBuilder zimu = new StringBuilder();
        for (int i = 0; i < ss.length(); i++) {
            Boolean digit = Character.isDigit(ss.charAt(i));
            if (digit) {
                num.append(ss.charAt(i));
            } else {
                zimu.append(ss.charAt(i));
            }

        }

        if (Math.abs(num.length() - zimu.length()) > 1) {
            return "";
        } else {
            if (num.length() > zimu.length()) {
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < num.length(); i++) {
                    temp.append(num.charAt(i));
                    if (i < zimu.length()) temp.append(zimu.charAt(i));
                }
                return temp.toString();
            } else {
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < zimu.length(); i++) {
                    temp.append(zimu.charAt(i));
                    if (i < num.length()) temp.append(num.charAt(i));
                }
                return temp.toString();
            }

        }

    }


    class Solution2 {
        public double myPow(double x, int n) {
            BigDecimal xx = new BigDecimal(x);
            for (int i = 0; i < n; i++) {
                xx = xx.multiply(xx);
            }
            return xx.doubleValue();
        }
    }

    class Solution3 {
        public List<String> buildArray(int[] target, int n) {
            List<String> result = new LinkedList<String>();


            for (int i = 0, tar = 0; i < n; i++) {
                if ((i + 1) != target[tar]) {
                    result.add("Push");
                    result.add("Pop");
                } else {
                    result.add("Push");
                    tar++;
                    if (target.length <= tar) break;
                }
            }
            return result;
        }
    }

    class Solution4 {

        public int countTriplets(int[] arr) {

            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    for (int k = j; k < arr.length; k++) {
                        if (test(i, j, k, arr)) result++;
                    }
                }
            }
            return result;
        }

        public boolean test(int i, int j, int k, int[] arrs) {
            Integer a = null;
            for (int i1 = i; i1 < j; i1++) {
                if (a == null) {
                    a = arrs[i1];
                } else {
                    a = a ^ arrs[i1];
                }

            }
            Integer b = null;

            for (int i2 = j; i2 < k + 1; i2++) {
                if (b == null) {
                    b = arrs[i2];
                } else {
                    b = b ^ arrs[i2];
                }
            }
            if (a.equals(b)) return true;

            return false;

        }
    }

}
