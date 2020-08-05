package com.yanl.monkey;

/**
 * @author YanL
 * @date 18:41 2020/8/1
 * @Email: imyanl.dt@gmail.com
 * @Description:
 * 小猿有一台打字机，只能打出‘A’、‘B’、‘C’三种字符。某天，小猿打了一段长度为N的字符串1，
 * 然后发现可以通过打字机的快捷操作来快速改写字符串。
 * 已知一次快捷操作必须同时改写K个不同位置的字符，且被改写的字符必须改成打字机可以打出的其他字符。
 * 例如，K=2时，"AB"可以被改写为"CA"，也可以被改写为"BC"，但不可以被改写为"AA"(必须恰好改写K个字符)或"EF"。
 * 可以请问通过M次快捷操作，能有多少种将字符串1改写为目标字符串2的方案？输出方案数对1000000007取模的结果。
 *输入描述:
 * 第一行输入三个整数，N、M、K。
 * 接下来两行输入原始字符串1和目标字符串2。
 * 1 ≤ N ≤ 100
 * 1 ≤ M ≤ 100
 * 0 ≤ K ≤ N
 *
 * 输出描述:
 * 方案数对1000000007取模的结果
 *
 * 输入例子1:
 * 3 2 3
 * AAA
 * CCC
 *
 * 输出例子1:
 * 1
 *
 */
public class TypeWriter {
}