import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.util.Random;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // 测试方法
       Menu.Show();

        //CreatOperation(100,100);
        //for(int i = 0; i < 5; i++)
        //System.out.println(i + ':' + Operation.get() );
    }

    public static void CreatOperation(int NUM, int BOUND){//以字符串数组形式创建

        ArrayList<String> Operation = new ArrayList<>();//四则运算式的数组Operation
        String tempOP ;

        for(int i = 0; i < NUM; i++){
            Random random = new Random();
            String[] tl = new String[2];
            double[] temp = new double[3];
            int numIN = random.nextInt(3) + 1;//随机出当前运算式有几个算数(1~3

            if(numIN == 1){
                if(i%2 == 0)
                    numIN++;
                else
                    numIN = numIN+2;
            }
            if(numIN == 2) {
                tl[0] = ToolChose.choseTool();
                tl[1] = "\0";
            } else if (numIN == 3) {
                tl[0] = ToolChose.choseTool();
                tl[1] = ToolChose.choseTool();
            }
            String[] OPNum = new String[4];//存储算数的数组(字符型
                OPNum[0] = "\0";
                OPNum[1] = "\0";
                OPNum[2] = "\0";
                OPNum[3] = "\0";
            for (int j = 0; j < numIN; j++){

                temp[j] = random.nextDouble(BOUND);

                 temp[j] = Math.round(temp[j] * 100.0) / 100.0;

                int ifInt = random.nextInt(100) + 1;//控制出现分数的概率
                if(ifInt > 5)
                    temp[j] = (int)temp[j];

                if(temp[1] == temp[0])
                {
                    temp[1] = random.nextDouble(BOUND);

                    temp[1] = Math.round(temp[j] * 100.0) / 100.0;
                }
                if(tl[0] == "-" && temp[0] < temp[1])
                {
                    double new1 = temp[0];
                    temp[0] = temp[1];
                    temp[1] = new1;
                }
                if(tl[1] == "-" && temp[1] < temp[2])
                {
                    double new1 = temp[1];
                    temp[1] = temp[2];
                    temp[2] = new1;
                }
                    OPNum[j] = NumberConverter.convertNumber(temp[j]);
            }

            if(tl[0] == "/" && OPNum[1] == "0")
            {
                i--;
            } else if (tl[1] == "/" && OPNum[2] == "0") {
                i--;
            }
//            else if(-1.0 == Result.DataIn(temp[0], temp[1], temp[2], tl[0], tl[1])){
//                i--;
//            }
            else{
                tempOP = OPNum[0] + tl[0] + OPNum[1];
                if(OPNum[2] != "\0")
                    tempOP = OPNum[0] + tl[0] + OPNum[1] + tl[1] + OPNum[2];
                Operation.add(tempOP);

                //double result_temp = Result.DataIn(temp[0], temp[1], temp[2], tl[0], tl[1]);


                //System.out.print(NumberConverter.convertNumber(result_temp) + "  ");
                System.out.println( Operation.get(i) );
            }
        }

    }
}






//double num1 = 9.5;
//        double num2 = 4.2;
//        double num3 = 7;


//        System.out.println(NumberConverter.convertNumber(num1)); // 输出5'3/4
//        System.out.println(NumberConverter.convertNumber(num2)); // 输出4'1/5
//        System.out.println(NumberConverter.convertNumber(num3)); // 输出7



//public class Main {
//    public static void main(String[] argc){
//        String input = JOptionPane.showInputDialog(null, "请输入生成题目数量","输入",JOptionPane.QUESTION_MESSAGE);
//        if(input == null)
//            System.out.println("用户取消输入");
//        else
//            System.out.println("生成题目数为："+input);
//    }
//}
/*
import javax.swing.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleMenuExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Menu Example");

        createMenu(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private static void createMenu(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Open File Clicked");
            }
        });

        fileMenu.add(openItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
    }
}*/