package com.yanl.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author YanL
 * @date 0:19 2020/9/13
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 */
public class L0207CourseSchedule {
    /**
     * 存储有向图
     */
    List<List<Integer>> dfsEdges;
    /**
     * 访问标识 0-未搜索 1-搜索中 2-已完成搜索
     */
    int[] visited;
    /**
     * 是否存在环的标志
     */
    boolean valid = true;

    public boolean canFinishDfs(int numCourses, int[][] prerequisites) {
        dfsEdges = new ArrayList<>();
        for(int i = 0; i < numCourses; i ++){
            dfsEdges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for(int[] info : prerequisites){
            dfsEdges.get(info[1]).add(info[0]);
        }

        for(int i = 0; i < numCourses && valid; i ++){
            if(visited[i] == 0){
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int x){
        visited[x] = 1;
        for(int v : dfsEdges.get(x)){
            if(visited[v] == 0){
                dfs(v);
                if(!valid){
                    return;
                }
            }else if(visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[x] = 2;
    }


    /**
     * 广搜
     * ============================================================================
     */
    List<List<Integer>> bfsEdges;
    /**
     * 入度
     */
    int[] inDeg;
    /**
     * 索引
     */
    int bfsIndex;
    public boolean canFinishBfs(int numCourses, int[][] prerequisites){
        bfsEdges = new ArrayList<>();
        inDeg = new int[numCourses];
        for(int i = 0; i < numCourses; i ++){
            bfsEdges.add(new ArrayList<>());
        }
        for(int[] info : prerequisites){
            bfsEdges.get(info[1]).add(info[0]);
            inDeg[info[0]] ++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i ++){
            if(inDeg[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int x = queue.poll();
            bfsIndex++;
            for(int v : bfsEdges.get(x)){
                inDeg[v]--;
                if(inDeg[v] == 0){
                    queue.offer(v);
                }
            }
        }
        return bfsIndex == numCourses;
    }

}
