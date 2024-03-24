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
        Object[] options = {"生成四则运算式", "检查答案"};
        int option = JOptionPane.showOptionDialog(null, "请选择一个选项：", "自定义选项对话框", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (option) {
            case 0:
//                System.out.println("生成四则运算式");
                Datain();
                break;
            case 1:
                System.out.println("检查答案");
                break;

            default:
                System.out.println("用户关闭了对话框");
                break;
        }
    }

    public static void PRINT1(String[] a){
        String Loading = a[0];
        if(a.length > 30)
        {
            JOptionPane.showMessageDialog(null, "生成题目数量较多，请打开Exercises.txt文件查看！", "四则运算式", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            for(int i = 1; i < a.length; i++){
                Loading = Loading +"\n" + a[i];
            }
            JOptionPane.showMessageDialog(null, Loading, "四则运算式", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    public static void Datain(){
        String input = JOptionPane.showInputDialog(null, "请输入生成题目数量" + "\n（如果生成的题目数过大，请调整算数的范围，否则难以避免出现类似题目）", "题目生成", JOptionPane.QUESTION_MESSAGE);
        int num1 = 0, num2 = 0;
        if (input == null)
            System.out.println("用户取消输入");
        else {
            String input_Bound = JOptionPane.showInputDialog(null, "请输入生成题目数值范围（如：100）" , "题目生成", JOptionPane.QUESTION_MESSAGE);
            num1 = Integer.parseInt(input);
            num2 = Integer.parseInt(input_Bound);



            String[] a = new String[num1+1];
            a = Main.CreatOperation(num1, num2);
            PRINT1(a);
            File.DataWrite(a);
        }
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