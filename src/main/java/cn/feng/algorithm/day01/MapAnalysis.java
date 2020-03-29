package cn.feng.algorithm.day01;


import java.util.Arrays;

/**
 * 地图分析：
 *
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。
 * 其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？
 * 请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：
 * (x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 *
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 *
 */
public class MapAnalysis {


    public static Integer[][] strToArray(String arg) {

        String readStrSub = arg.substring(2, arg.length() - 2);

        String[] split = readStrSub.split("\\],\\[");

        Integer[][] threeArr = new Integer[3][3];

        for (int i = 0 ; i < split.length ; i++) {
            String[] nums = split[i].split(",");
            for (int j = 0; j < nums.length; j++) {
                threeArr[i][j] = Integer.valueOf(nums[j]);
            }
        }
        return threeArr;
    }


    public static Integer printDis(Integer[][] threeArr) {
        int max = 0;
        for (int i = 0; i < threeArr.length; i++) {
            for (int j = 0; j < threeArr[i].length; j++) {
                int sum = 0;
                if (j == threeArr.length - 1) {
                    System.out.println("j---->  " + threeArr[i][j] + "--"  + "[" + i +"][" + j + "]");
                    int numStart = threeArr[i][j] - threeArr[i][j - 1];
                    numStart = numStart < 0 ? -numStart : numStart;
                    int numEnd = threeArr[i][j] - threeArr[i + 1][j];
                    numEnd = numEnd < 0 ? -numEnd : numEnd;
                    sum = numStart + numEnd;
                    if (sum > max) {
                        max += 1;
                    }
                } else if(i == threeArr.length - 1) {
                    System.out.println("i---->  " + threeArr[i][j] + "--" + "[" + i +"][" + j + "]");
                    int numStart = threeArr[i][j] - threeArr[i][j + 1];
                    numStart = numStart < 0 ? -numStart : numStart;
                    int numEnd = threeArr[i][j] - threeArr[i - 1][j];
                    numEnd = numEnd < 0 ? -numEnd : numEnd;
                    sum = numStart + numEnd;
                    if (sum > max) {
                        max += 1;
                    }
                } else {
                    int numStart = (threeArr[i][j] - threeArr[i][j + 1]);
                    numStart = numStart < 0 ? -numStart : numStart;
                    int numEnd = threeArr[i][j] - threeArr[i + 1][j];
                    numEnd = numEnd < 0 ? -numEnd : numEnd;
                    sum = numStart + numEnd;
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            if (max <= 0) {
                max = -1;
            }
        }
        return max;
    }


    public static void main(String[] args) {

        String readStr = "[[1,0,0],[0,0,0],[0,0,0]]";
        Integer result = printDis(strToArray(readStr));
        System.out.println(result);

    }
}
