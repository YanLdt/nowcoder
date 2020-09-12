package com.yanl.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author YanL
 * @date 1:01 2020/9/13
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，
 * 在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，
 * 写出一个函数找到所有的最小高度树并返回他们的根节点。
 *该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）
 * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，
 * 因此不会同时出现在 edges 里。
 *
 * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 *
 * 输出: [1]
 *
 * 最小高度树的根节点一定在最中心，所以就从外围bfs一圈一圈向内缩小，直到最后的两个或者一个节点就是结果
 *
 */
public class L0310MinHeightTree {
    /**
     * 存储图
     */
    List<List<Integer>> map;
    /**
     * 入度
     */
    int[] inDeg;

    /**
     * 结果集
     */
    List<Integer> res;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        res = new ArrayList<>();
        if(n == 1){
            res.add(0);
            return res;
        }
        map = new ArrayList<>();
        inDeg = new int[n];
        for(int i = 0; i < n; i ++){
            map.add(new ArrayList<>());
        }
        //建立图关系
        for(int[] info : edges){
            map.get(info[0]).add(info[1]);
            map.get(info[1]).add(info[0]);
            inDeg[info[0]]++;
            inDeg[info[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        //因为是无向图，所以把出度为1的所有节点入队
        for(int i = 0; i < n; i ++){
            if(inDeg[i] == 1){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            //每遍历外围的一层都需要生成新的结果集
            res = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                int cur = queue.poll();
                res.add(cur);
                for(int v : map.get(cur)){
                    inDeg[v]--;
                    if(inDeg[v] == 1){
                        queue.offer(v);
                    }
                }
            }
        }
        return res;
    }
}
