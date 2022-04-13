package tecent50.src.ts344;


/**
 * @Description 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * @Author liq
 * @Date 2022/04/13
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        char[] in = {'h', 'e', 'l', 'l', 'o'};
        print(in);
        System.out.println();
        solution1.reverseString(in);
        print(in);
        System.out.println();
        solution2.reverseString(in);
        print(in);
    }
    public static void print(char[] in){
        System.out.print("[");
        for (int i = 0; i < in.length - 1; i++) {
            System.out.print("\"" + in[i] + "\",");
        }
        System.out.print("\"" + in[in.length - 1] + "\"]");
    }
}
