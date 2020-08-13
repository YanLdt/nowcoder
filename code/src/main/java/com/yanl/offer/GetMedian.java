package com.yanl.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author YanL
 * @date 15:14 2020/8/13
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 可以排序
 * 也可以使用优先队列---
 * 优先队列默认是小顶堆
 * 可以自己实现大顶堆
 * 两个堆
 * 大顶堆存放小于中位数的
 * 小顶堆存放大于中位数的
 * 如果当前已经插入了偶数个  下一个需要插入到小顶堆
 * 先把数组插入大顶堆然后求出一个最大数插入小顶堆
 * 如果已经插入了奇数个数字，下一个应该插入到大顶堆
 * 先将数字插入小顶堆，然后找出最小的插入到大顶堆
 *
 */
public class GetMedian {
    ArrayList<Integer> arr = new ArrayList<>();

    public void insert(Integer num) {
        arr.add(num);
    }

    public Double getMedian() {
        Collections.sort(arr);
        int len = arr.size();
        if((len % 2) == 0){
            return (double)(arr.get(len / 2 - 1) + arr.get(len / 2)) / 2;
        }else {
            return (double) arr.get(len / 2);
        }
    }
}
