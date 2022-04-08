package tecent50.src.ts292;

/**
 * @Description 292. Nim 游戏
 * 两个人一起玩 Nim 游戏：
 * 桌子上有一堆石头。你们轮流进行自己的回合， 你作为先手。
 * 每一回合，轮到的人拿掉 1 - 3 块石头。拿掉最后一块石头的人就是获胜者。
 * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。
 * 如果可以赢，返回 true；否则，返回 false。
 * @Author liq
 * @Date 2022/04/08
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 5;
        boolean res = solution.canWinNim(num);
        System.out.println(res);
    }
}
