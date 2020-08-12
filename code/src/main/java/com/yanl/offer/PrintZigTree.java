package com.yanl.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YanL
 * @date 11:01 2020/8/12
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintZigTree {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        boolean flag = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            //将该层打印完
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur == null){
                    continue;
                }
                if(!flag){
                    tmp.add(cur.val);
                }else {
                    //插入在最前面
                    tmp.add(0, cur.val);
                }
                //并录入当前层的子节点
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            if(tmp.size() > 0){
                res.add(tmp);
            }
            flag = !flag;
        }
        return res;
    }
}
