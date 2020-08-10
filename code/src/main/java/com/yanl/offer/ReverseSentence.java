package com.yanl.offer;

/**
 * @author YanL
 * @date 14:49 2020/8/10
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {
    public String reverseSentence(String str) {
        StringBuilder sb = new StringBuilder();
        if(str == null){
            return null;
        }
        if(str.trim().equals("")){
            return str;
        }
        String[] s = str.split(" ");
        int len = s.length;
        for(int i = len - 1; i >=0 ; i--){
            if(i == 0){
                sb.append(s[i]);
            }else {
                sb.append(s[i]).append(" ");
            }
        }
        return sb.toString();

    }


}
