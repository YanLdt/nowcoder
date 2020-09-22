package com.yanl.leetcode;

import com.yanl.leetcodeutil.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YanL
 * @date 14:37 2020/9/22
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，
 * 采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 */
public class L0297SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.

    /**|
     * 将二叉树序列化为一个字符串[1,2,3,....,n]
     * 使用层序遍历
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode cur = queue.poll();
                if(cur == null){
                    sb.append("null,");
                }else {
                    sb.append(cur.val).append(",");
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
        }
        //sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    /**
     * 从层序遍历恢复一颗二叉树
     *
     */
    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length() -1).split(",");
        //根节点
        TreeNode root = trans2Node(nodes[0]);
        TreeNode p = root;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flagL = true;
        //遍历节点数组
        for(int i = 1; i < nodes.length; i ++){
            //对于每个节点都遍历左右两个子节点
            TreeNode cur = trans2Node(nodes[i]);
            if(flagL){
                p.left = cur;
            }else {
                p.right = cur;
            }
            //当前节点不为空时加入队列
            if(cur != null){
                queue.offer(cur);
            }
            //左子节点之后是右子节点
            flagL = !flagL;
            //当遍历完当前节点的两个子节点后，更新父节点为队首元素
            if(flagL){
                p = queue.poll();
            }
        }
        return root;
    }

    public TreeNode trans2Node(String val){
        if("null".equals(val)){
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
