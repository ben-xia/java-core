package com.ben.java.gof.behavioral_model.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author ben-xia
 * @date 2021/04/23
 * @Description TODO
 **/
public class ReverseArrayCollection<T> implements Iterable<T> {
    private T[] array;

    public ReverseArrayCollection(T... objs) {
        this.array = Arrays.copyOfRange(objs, 0, objs.length);
    }

    public Iterator<T> iterator() {
        return new ReverseIterator();
    }

    /**
     * 使用内部类的好处是内部类隐含地持有一个它所在对象的this引用，
     * 可以通过ReverseArrayCollection.this引用到它所在的集合
     */
    class ReverseIterator implements Iterator<T> {
        // 索引位置:
        int index;

        public ReverseIterator() {
            // 创建Iterator时,索引在数组末尾:
            this.index = ReverseArrayCollection.this.array.length;
        }

        public boolean hasNext() {
            // 如果索引大于0,那么可以移动到下一个元素(倒序往前移动):
            return index > 0;
        }

        public T next() {
            // 将索引移动到下一个元素并返回(倒序往前移动):
            index--;
            return array[index];
        }
    }

    public static void main(String[] args) {
        ReverseArrayCollection reverseArrayCollection = new ReverseArrayCollection(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (Iterator iterator = reverseArrayCollection.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + "\t");
        }
    }
}
