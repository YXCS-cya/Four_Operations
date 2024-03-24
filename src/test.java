import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.*;
import java.io.File;
import java.util.Random;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class test{
    public static void main(String[] argc){

        Object[] options = {"生成四则运算式", "检查答案"};
        int option = JOptionPane.showOptionDialog(null, "请选择一个选项：", "自定义选项对话框", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (option) {
            case 0:
                System.out.println("生成四则运算式");
                break;
            case 1:
                System.out.println("检查答案");
                break;

            default:
                System.out.println("用户关闭了对话框");
                break;
        }




//        Color selectedColor = JColorChooser.showDialog(null, "选择颜色", Color.RED);
//        System.out.println("选择的颜色是：" + selectedColor);
        //JOptionPane.showMessageDialog(null, "这是一个简单的信息框", "信息", JOptionPane.INFORMATION_MESSAGE);

        //文件选择框
//        JFileChooser fileChooser = new JFileChooser();
//        int returnValue = fileChooser.showOpenDialog(null);
//        if (returnValue == JFileChooser.APPROVE_OPTION) {
//            File selectedFile = fileChooser.getSelectedFile();
//            System.out.println("选择的文件是：" + selectedFile.getName());
//        }
    }
}
















//public class test {
//
//    public static void main(String[] args){
//        double num1 = 9.56548446;
//        double num2 = 4.2;
//        double num3 = 7;
//
//
//        System.out.println(NumberConverter.convertNumber(num1)); // 输出5'3/4
//        System.out.println(NumberConverter.convertNumber(num2)); // 输出4'1/5
//        System.out.println(NumberConverter.convertNumber(num3)); // 输出7
//    }
//     //测试方法
//
//    public class NumberConverter {
//
//        public static double convertNumberToDouble(double number) {//以整型/浮点型返回真分数
//
//            DecimalFormat df = new DecimalFormat("#.##"); // 格式化规则，保留两位小数
//            String formattedNumber = df.format(number); // 格式化操作
//            double result = Double.parseDouble(formattedNumber); // 将格式化后的字符串转换为double类型
//
//            number = result;
//
//            if (number % 1 == 0) {
//                // 如果是整数，直接返回整型
//                return (int) number;
//            } else {
//                // 如果是小数，转换成浮点型
//                // 先将小数部分转换成真分数
//                int numerator = (int) Math.floor(number);
//                int denominator = 1;
//                double decimalPart = number - numerator;
//                while (Math.abs(decimalPart - Math.round(decimalPart)) > 0.0001) {
//                    denominator *= 10;
//                    decimalPart *= 10;
//                }
//                int fractionPart = (int) Math.round(decimalPart);
//
//                return numerator + (double) fractionPart / denominator;
//            }
//        }
//
//        public static String convertNumber(double number)//将小数转换成真分数，以字符串形式返回
//        {
//
//            DecimalFormat df = new DecimalFormat("#.##"); // 格式化规则，保留两位小数
//            String formattedNumber = df.format(number); // 格式化操作
//            double result = Double.parseDouble(formattedNumber); // 将格式化后的字符串转换为double类型
//
//            number = result;
//
//            if (number % 1 == 0) {
//                // 如果是整数，直接返回整型
//                return String.valueOf((int) number);
//            } else {
//                // 如果是小数，转换成真分数形式
//                // 分子
//                int numerator = (int) Math.floor(number);
//                // 分母
//                int denominator = 1;
//                double decimalPart = number - numerator;
//                while (Math.abs(decimalPart - Math.round(decimalPart)) > 0.0001) {
//                    denominator *= 10;
//                    decimalPart *= 10;
//                }
//                int fractionPart = (int) Math.round(decimalPart);
//
//                // 化简真分数
//                int gcd = gcd(fractionPart, denominator);
//                fractionPart /= gcd;
//                denominator /= gcd;
//
//                return numerator + "'" + fractionPart + "/" + denominator;
//            }
//        }
//
//        // 求最大公约数
//        private static int gcd(int a, int b) {
//            return b == 0 ? a : gcd(b, a % b);
//        }
//
//    }
//}
