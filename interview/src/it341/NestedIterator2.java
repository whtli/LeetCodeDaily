package interview.src.it341;

import java.util.*;

/**
 * @Description 341. 扁平化嵌套列表迭代器
 * 给定一个嵌套的整数列表 nestedList 。
 * 每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。
 * 实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
 * <p>
 * 实现扁平迭代器类 NestedIterator ：
 * NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
 * int next() 返回嵌套列表的下一个整数。
 * boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。
 * <p>
 * 代码将会用下述伪代码检测：
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 * append iterator.next() to the end of res
 * return res
 * <p>
 * 如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。
 * @Author liq
 * @Date 2022/03/01
 */
public class NestedIterator2 implements Iterator<Integer> {
    private Stack<NestedInteger> stack = new Stack<>();

    public void pushStack(List<NestedInteger> list) {
        for (int index = list.size() - 1; index >= 0; index--) {
            stack.add(list.get(index));
        }
    }

    public NestedIterator2(List<NestedInteger> nestedList) {
        pushStack(nestedList);
    }

    @Override
    public Integer next() {
        return hasNext() ? stack.pop().getInteger() : -1;
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        } else {
            NestedInteger item = stack.peek();
            if (item.isInteger()) {
                return true;
            } else {
                item = stack.pop();
                List<NestedInteger> list = item.getList();
                pushStack(list);
                return hasNext();
            }
        }
    }
}
