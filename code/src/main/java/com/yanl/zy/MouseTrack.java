package com.yanl.zy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author YanL
 * @date 20:17 2020/11/3
 * 记录鼠标拖拽起点和中点的坐标
 */
public class MouseTrack extends JFrame {
    private static final long serialVersionUID = 7554087008285696671L;

    private static double xStart;
    private static double yStart;

    private static double xEnd;
    private static double yEnd;

    public MouseTrack(){
        // TODO Auto-generated constructor stub
        Container container = getContentPane();
        container.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("点击了鼠标");
                int i = e.getButton();
                if(i == MouseEvent.BUTTON1){
                    System.out.println("左");
                }
                if(i == MouseEvent.BUTTON2){
                    System.out.println("中");
                }
                if(i == MouseEvent.BUTTON3){
                    System.out.println("右");
                }
                int count = e.getClickCount();
                System.out.println("点击了" + count + "下");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.print("鼠标按键被按下，");
                xStart = e.getLocationOnScreen().getX();
                yStart = e.getLocationOnScreen().getY();
                System.out.println("横坐标" + xStart + "纵坐标" + yStart);
                int i = e.getButton();
                if (i == MouseEvent.BUTTON1) {
                    System.out.println("按下的是鼠标左键");
                }
                if (i == MouseEvent.BUTTON2) {
                    System.out.println("按下的是鼠标中键");
                }
                if (i == MouseEvent.BUTTON3) {
                    System.out.println("按下的是鼠标右键");
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.print("鼠标按键被释放，");
                xEnd = e.getLocationOnScreen().getX();
                yEnd = e.getLocationOnScreen().getY();
                System.out.println("后横坐标" + xEnd + "后纵坐标" + yEnd);
                int i = e.getButton();
                if (i == MouseEvent.BUTTON1) {
                    System.out.println("释放的是鼠标左键");
                }
                if (i == MouseEvent.BUTTON2) {
                    System.out.println("释放的是鼠标中键");
                }
                if (i == MouseEvent.BUTTON3) {
                    System.out.println("释放的是鼠标右键");
                }
                double k = (yEnd - yStart) / (xEnd - xStart);
                double angle = Math.atan(1 / k) * 90;
                System.out.println("斜率为" + k + "角度为" + angle + "°");
                System.out.println("=====================================");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("光标移入组件");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("光标移出组件");
            }
        });
    }

    public static void main(String[] args) {
        MouseTrack frame = new MouseTrack();
        frame.setTitle("MouseTrack");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 1000, 1000);
    }
}
