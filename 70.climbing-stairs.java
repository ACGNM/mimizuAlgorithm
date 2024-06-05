/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// 最后一步迈一步还是两步分为两种情况
// 最后剩两步的所有情况是包含拆成一步一步迈的，所以切入点是最后一次行动的步数
// 把中间的数据保存起来有利于执行速度加快，空间换时间
/**
class Solution {
    Map<Integer, Integer> stepMap = new HashMap<>();
    public int climbStairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        Integer previous1 = 0;
        Integer previous2 = 0;

        if(Objects.isNull(this.stepMap.get(n-1))){
            previous1 = climbStairs(n - 1);
            this.stepMap.put(n-1, previous1);
        } else {
            previous1 = this.stepMap.get(n-1);
        }

        if(Objects.isNull(this.stepMap.get(n-2))){
            previous2 = climbStairs(n - 2);
            this.stepMap.put(n-2, previous2);
        } else {
            previous2 = this.stepMap.get(n-2);
        }

        return previous1 + previous2;
    }
}
*/

// 除了递归还可以使用列表记下每种情况的步数然后计算到目标台阶数为止
// 本来可以使用数组的第i个元素存储i个台阶的方法数
// 但是每次只需要用到当前目标台阶数的前一个和前两个元素，所以只需要两个额外变量就够了
class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        int prev = 1, curr = 2;
        for (int i = 3; i<=n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}
// @lc code=end

