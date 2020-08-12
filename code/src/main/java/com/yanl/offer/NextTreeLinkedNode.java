package com.yanl.offer;

/**
 * @author YanL
 * @date 10:19 2020/8/12
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 中序遍历应该找左子树
 */
public class NextTreeLinkedNode {

    public TreeLinkNode getNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }
        //如果当前节点有右子树
        if(pNode.right != null){
            pNode = pNode.right;
            //如果右子树有左子树则一直遍历到最左边的节点
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }else {
            //当前节点没有右子树则向上遍历，直到找到一个是其父节点--左子节点的节点
            while (pNode.next != null){
                //当前节点没有右子树
                //1如果是父节点的左子树，返回父节点
                if(pNode.next.left == pNode){
                    return pNode.next;
                } else{
                    //2当前节点是父节点的右子树，此时说明左边这棵树已经遍历
                    pNode = pNode.next;
                }
            }

        }
        return null;

    }
}
