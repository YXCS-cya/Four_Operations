/*
菜单

尚未实现
* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    public static void Show() {
        String input = JOptionPane.showInputDialog(null, "请输入生成题目数量", "输入", JOptionPane.QUESTION_MESSAGE);
        int num1 = 0;
        if (input == null)
            System.out.println("用户取消输入");
        else {
            num1 = Integer.parseInt(input);
            Main.CreatOperation(num1, 100);
        }

        //System.out.println("生成题目数为：" + input);
    }
}

/*JFrame frame = new JFrame("Menu Window Example");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("Open New Window");

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame("New Window");
                JLabel label = new JLabel("This is a new window!");
                newFrame.add(label);
                newFrame.setSize(200, 100);
                newFrame.setLocationRelativeTo(null); // 居中显示
                newFrame.setVisible(true);
            }
        });

        menu.add(menuItem);
        menuBar.add(menu);

        frame.setJMenuBar(menuBar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }*/