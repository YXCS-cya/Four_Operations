/*
菜单

尚未实现
* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Menu {
    public static void Show() {
        Object[] options = {"生成四则运算式", "检查答案"};
        int option = JOptionPane.showOptionDialog(null, "请选择一个选项：", "四则运算生成-检验器", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (option) {
            case 0:
//                System.out.println("生成四则运算式");
                Datain();
                break;
            case 1:
                DataCheck();
                break;

            default:
                System.out.println("用户关闭了对话框");
                break;
        }
    }

    public static void DataCheck() {
        String temp = "\t", daan = "\t";
        JOptionPane.showMessageDialog(null, "请选择需要校对的题目！（txt文档）\n格式：1.a+b'c/d*e", "四则运算式", JOptionPane.INFORMATION_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        File selectedFile = null;
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
//            System.out.println("选择的文件是：" + selectedFile.getName());
             temp = selectedFile.getName();
        }
        JOptionPane.showMessageDialog(null, "请选择您的答案文件！（txt文档）\n格式：1.b'c/d", "四则运算式", JOptionPane.INFORMATION_MESSAGE);
        JFileChooser fileChooser2 = new JFileChooser();
        int returnValue2 = fileChooser.showOpenDialog(null);
        File selectedFile2 = null;
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile2 = fileChooser.getSelectedFile();
//            System.out.println("选择的文件是：" + selectedFile.getName());
            daan = selectedFile2.getName();
        }

        test.main1(temp,daan);
        //Correct.CompareFiles.compareFiles(temp, daan);

        Show();

    }

    public static void PRINT1(String[] a){
        String Loading = 1 + "." + a[0];
        if(a.length > 30)
        {
            JOptionPane.showMessageDialog(null, "生成题目数量较多，请在Exercises.txt文件查看！", "四则运算式", JOptionPane.INFORMATION_MESSAGE);
            try{
                java.io.File txtFile = new java.io.File("Exercises.txt");
                {
                    if(txtFile.exists()){
                        Desktop.getDesktop().open(txtFile);

                    }else{
                        System.out.println("File not found!");
                    }
                }
            }

            catch(IOException e)

            {
                System.out.println("打开文件出现错误："+e.getMessage());
            }
        }
        else{
            for(int i = 1; i < a.length; i++){
                Loading =  Loading +"\n" + (i+1) + ".\t" +a[i];
            }
            JOptionPane.showMessageDialog(null, Loading, "四则运算式", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void Datain() {
        String input = JOptionPane.showInputDialog(null, "请输入生成题目数量" + "\n（如果生成的题目数过大，请调整算数的范围，否则难以避免出现类似题目）", "题目生成", JOptionPane.QUESTION_MESSAGE);
        int num1 = 0, num2 = 0;
        if (input == null)
            System.out.println("用户取消输入");
        else if (input.equals("0") || input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "您输入的范围有误！\n可输入最小值为1", "四则运算式", JOptionPane.INFORMATION_MESSAGE);
            Datain();
        } else {
            String input_Bound = JOptionPane.showInputDialog(null, "请输入生成题目数值范围（如：100）", "题目生成", JOptionPane.QUESTION_MESSAGE);

            if (input_Bound.equals("0") || input_Bound.isEmpty()) {
                JOptionPane.showMessageDialog(null, "您输入的范围有误！\n可输入最小值为1", "四则运算式", JOptionPane.INFORMATION_MESSAGE);
                Datain();}
                num1 = Integer.parseInt(input);
                num2 = Integer.parseInt(input_Bound);


                String[] a = new String[num1 + 1];
                a = Main.CreatOperation(num1, num2);
                PRINT1(a);
                FileTool.DataWrite(a);
                Show();
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