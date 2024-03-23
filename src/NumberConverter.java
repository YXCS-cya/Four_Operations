/*
输入浮点型，转真分数
* */

import java.text.DecimalFormat;

public class NumberConverter {

    public static double convertNumberToDouble(double number) {//以整型/浮点型返回真分数
        DecimalFormat df = new DecimalFormat("#.##"); // 格式化规则，保留两位小数
        String formattedNumber = df.format(number); // 格式化操作
        double result = Double.parseDouble(formattedNumber); // 将格式化后的字符串转换为double类型

        number = result;

        if (number % 1 == 0) {
            // 如果是整数，直接返回整型
            return (int) number;
        } else {
            // 如果是小数，转换成浮点型
            // 先将小数部分转换成真分数
            int numerator = (int) Math.floor(number);
            int denominator = 1;
            double decimalPart = number - numerator;
            while (Math.abs(decimalPart - Math.round(decimalPart)) > 0.0001) {
                denominator *= 10;
                decimalPart *= 10;
            }
            int fractionPart = (int) Math.round(decimalPart);

            return numerator + (double) fractionPart / denominator;
        }
    }

    public static String convertNumber(double number)//将小数转换成真分数，以字符串形式返回
    {
        DecimalFormat df = new DecimalFormat("#.##"); // 格式化规则，保留两位小数
        String formattedNumber = df.format(number); // 格式化操作
        double result = Double.parseDouble(formattedNumber); // 将格式化后的字符串转换为double类型

        number = result;




        if (number % 1 == 0) {
            // 如果是整数，直接返回整型
            return String.valueOf((int) number);
        } else {
            // 如果是小数，转换成真分数形式
            // 分子
            int numerator = (int) Math.floor(number);
            // 分母
            int denominator = 1;
            double decimalPart = number - numerator;
            while (Math.abs(decimalPart - Math.round(decimalPart)) > 0.0001) {
                denominator *= 10;
                decimalPart *= 10;
            }
            int fractionPart = (int) Math.round(decimalPart);

            // 化简真分数
            int gcd = gcd(fractionPart, denominator);
            fractionPart /= gcd;
            denominator /= gcd;

            if(numerator == 0)
                return fractionPart + "/" + denominator;

            return numerator + "'" + fractionPart + "/" + denominator;
        }
    }

    // 求最大公约数
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}

