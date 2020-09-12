package com.yanl.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author YanL
 * @date 23:02 2020/9/12
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 *
 * 拓扑排序---图中不能出现环，如果出现环则会出现冲突，不能完成所有课程
 * 1-dfs深搜实现
 * 2-bfs广搜实现
 */
public class L0210CourseSchedule2 {
    /**
     * 存储有向图
     */
    List<List<Integer>> edges;
    /**
     * 标记每个节点的状态 0-未搜索 1-搜索中还未加入栈 2-搜索已完成，已加入结果集
     */
    int[] visited;
    /**
     * 结果集 n-1为栈底 0为栈顶
     */
    int[] res;
    /**
     * 判断图中是否有环
     */
    boolean valid = true;

    /**
     * 栈的下标
     */
    int index;

    public int[] findOrderDfs(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for(int i = 0; i < numCourses; i ++){
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        res = new int[numCourses];
        index = numCourses-1;
        for(int[] i : prerequisites){
            edges.get(i[1]).add(i[0]);
        }
        //每次选择一个未搜索的节点进行深搜
        for(int i = 0; i < numCourses && valid; i ++){
            if(visited[i] == 0){
                dfs(i);
            }
        }
        if(!valid){
            return new int[0];
        }else {
            return res;
        }
    }

    /**
     * 图的深搜
     * @param x
     */
    public void dfs(int x){
        //将当前节点置为搜索中,然后搜索其相邻节点
        visited[x] = 1;
        for(int i : edges.get(x)){
            //搜索其相邻节点
            if(visited[i] == 0){
                dfs(i);
                if(!valid){
                    return;
                }
            }else if(visited[i] == 1){
                //如果其周围节点还处在搜索中状态没有加入结果集说明存在环
                valid = false;
                return;
            }
        }
        //置为搜索完成，并加入结果集
        visited[x] = 2;
        res[index--] = x;
    }


    /**
     * 广搜
     * ======================================================================================
     * 存储有向图
     */
    List<List<Integer>> bfsEdges;
    /**
     * 每个节点的入度
     */
    int[] inDeg;
    /**
     * 结果集
     */
    int[] bfsRes;
    /**
     * 下标
     */
    int bfsIndex;
    public int[] findOrderBfs(int numCourses, int[][] prerequisites){
        bfsEdges = new ArrayList<>();
        for(int i = 0; i < numCourses; i ++){
            bfsEdges.add(new ArrayList<>());
        }
        inDeg = new int[numCourses];
        bfsRes = new int[numCourses];
        bfsIndex = 0;
        for(int[] i : prerequisites){
            bfsEdges.get(i[1]).add(i[0]);
            inDeg[i[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        //如果入度为0则表示没有任何依赖，直接入队
        for(int i = 0; i < numCourses; i ++){
            if(inDeg[i] == 0){
                queue.offer(i);
            }
        }
        //当队列非空的时候，每次取出一个元素放入结果集，相当于当前元素相邻的各个元素的入度-1，
        // 如果相邻元素入度为0则入队
        while (!queue.isEmpty()){
            int x = queue.poll();
            bfsRes[bfsIndex++] = x;
            for(int v : bfsEdges.get(x)){
                inDeg[v]--;
                if(inDeg[v] == 0){
                    queue.offer(v);
                }
            }
        }
        //最终索引不是元素个数说明出现了环 则返回空
        if(bfsIndex != numCourses){
            return new int[0];
        }else {
            return bfsRes;
        }
    }
}
