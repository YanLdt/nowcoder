package com.yanl.leetcode;

/**
 * @author YanL
 * @date 21:49 2020/9/5
 * 实现前缀树
 */
public class L0208TrieTree {
    public L0208TrieTree(){}

    /**
     * 前缀树每个节点都包含一个26个元素大小的数组
     */
    private L0208TrieTree[] next = new L0208TrieTree[26];
    private boolean isEnd = false;

    /** Inserts a word into the trie. */
    public void insert(String word) {
        L0208TrieTree cur = this;
        int len = word.length();
        for(int i = 0; i < len; i ++){
            char c = word.charAt(i);
            //当前字符不存在的话
            if(cur.next[c-'a'] == null){
                cur.next[c-'a'] = new L0208TrieTree();
            }
            //把指针移到下一个节点
            cur = cur.next[c-'a'];
        }
        //遍历完word添加结束标志
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        L0208TrieTree cur = this;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            //如果当前字符不存在直接返返回false
            if(cur.next[c-'a'] == null){
                return false;
            }
            //存在的话就指向下一个节点
            cur = cur.next[c-'a'];
        }
        //最后返回最后一个字符处是否有结束标记
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        L0208TrieTree cur = this;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            char c = prefix.charAt(i);
            //不存在当前字符直接返回false
            if(cur.next[c-'a'] == null){
                return false;
            }
            //存在则指向下一个节点
            cur = cur.next[c-'a'];
        }
        //如果遍历完全部字符串则说明存在这个前缀
        return true;
    }
}
