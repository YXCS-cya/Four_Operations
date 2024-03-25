//package org.example;
//import com.sun.xml.internal.txw2.output.DataWriter;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Correct {
    public static void Get_Grade(/*String args*/) {
        String filePath = "F:/学习/编程/软件工程/四则运算生成器-java/Four_Operations/Exercises.txt";//args; //"F:/学习/编程/软件工程/四则运算生成器-java/Four_Operations/output.txt"; // 替换为实际的文件路径
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] lines = new String[10000];
            int index = 0;
            String[] out = new String[10000];
            while ((line = reader.readLine()) != null) {
                Fraction result;
                result = evaluateExpression(line);
                lines[index] = line;
                if (result.numerator == 0) {
                    out[index]=(index+1)+"."+result.wholePart;
                    //System.out.println(out[index]);//输出
                } else if (result.wholePart == 0) {
                    out[index]=(index+1)+"."+result.numerator + "/" + result.denominator;
                    //System.out.println(out[index]); // 输出
                } else {
                    out[index]=(index+1)+"."+result.wholePart + "'" + result.numerator + "/" + result.denominator;
                    //System.out.println(out[index]); // 输出
                }
                index++;
            }
            File1.DataWriter(out);
            //CompareFiles.compareFiles("output.txt", "daan.txt");//1：临时文件  2.待比较答案
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class File1 {
        public static void DataWriter(String[] Operation){//输入存储字符串的数组，自动录入文件
            try {
                FileWriter fileWriter = new FileWriter("Answers.txt");//还有答案、成绩文档需生成
                PrintWriter printWriter = new PrintWriter(fileWriter);

                for (String line : Operation) {
                    if (line == null) {
                        break;
                    }
                    printWriter.println(line);
                }

                printWriter.close();
                System.out.println("答案已成功写入到文件Answers.txt");
            } catch (Exception e) {
                System.out.println("写入文件时发生错误：" + e.getMessage());
            }
        }
    }
    public static Fraction evaluateExpression(String expression) {
        // 根据加号和减号将表达式分割成操作数数组
        String[] tokens = expression.split("(?=[-+*/'.])|(?<=[-+*/'.])");
        // 初始化结果为第一个操作数
        Fraction[] fr = new Fraction[1000];
        for (int i = 0; i < 1000; i++) {
            fr[i] = new Fraction(0, 0, 1);
        }
        char[] op = new char[1000];
        int a = 0, b = 0;
        // 从第一个操作数开始遍历，根据运算符进行加减操作
        for (int i = 2; i < tokens.length; i+=2) {
            if (i + 1 == tokens.length) {
                fr[a].wholePart = Integer.parseInt(tokens[i]);
                a++;
                break;
            }
            char operator = tokens[i+1].charAt(0);
            switch (operator) {
                case '+':
                case '-':
                case '*':
                case '/':
                    fr[a].wholePart = Integer.parseInt(tokens[i]);
                    a++;
                    op[b] = operator;
                    b++;
                    break;
                case '\'':
                    fr[a].wholePart = Integer.parseInt(tokens[i]);
                    fr[a].numerator = Integer.parseInt(tokens[i + 2]);
                    fr[a].denominator = Integer.parseInt(tokens[i + 4]);
                    a++;
                    if(i+5 == tokens.length) break;
                    op[b] = tokens[i + 5].charAt(0);
                    b++;
                    i += 4;
                    break;
            }
        }



        Fraction result;
        Fraction[] temp = new Fraction[10];
        for (int i = 0; i < 10; i++) {
            temp[i] = new Fraction(0, 0, 1);
        }
        int ta = 0, tb = 0;
        char[] op2 = new char[10];
        for (int i = 0; i < b; i++) {
            if (op[i] == '+'||op[i] == '-') {
                op2[tb] = op[i];
                tb++;
            }
        }
        for (int i = 0; i <= b; i++) {
            if (op[i] == '+'||op[i] == '-') {
                temp[ta] = fr[i];
                ta++;
            } else if (op[i] == '*') {
                temp[ta] = temp[ta].multiplyMixedNumber(fr[i], fr[i + 1]);
                fr[i + 1] = temp[ta];
                /*ta++;
                i++;*/
            } else if (op[i] == '/') {
                temp[ta] = temp[ta].divideMixedNumber(fr[i], fr[i + 1]);
                fr[i + 1] = temp[ta];
                /*ta++;
                i++;*/
            } else if (i == b) {
                temp[ta] = fr[i];
                ta++;
            }
        }
        result = temp[0];
        for (int i = 0; i < tb; i++) {
            if (op2[i] == '+') {
                result = result.addMixedNumber(result, temp[i + 1]);
            } else if (op2[i] == '-') {
                result = result.subtractMixedNumber(result, temp[i + 1]);
            }
        }
        return result; // 返回最终计算结果
    }
    public static class Fraction {
        private long wholePart;   //整数
        private long numerator;   // 分子
        private long denominator; // 分母
        // 构造函数
        public Fraction(long wholePart, long numerator, long denominator) {
            this.wholePart = wholePart;
            this.numerator = numerator;
            this.denominator = denominator;
        }

        // 假分数转为带分数
        private Fraction simplify(Fraction a) {
            a.wholePart = a.numerator / a.denominator;
            if (a.numerator == 0) {
                a.denominator = 1;
            } else if (a.numerator % a.denominator != 0) {
                long gcd = greatestCommonDivisor(a.numerator, a.denominator);
                a.numerator /= gcd;
                a.denominator /= gcd;
                a.numerator -= a.wholePart * a.denominator;
            } else if (numerator % denominator == 0) {
                a.numerator = 0;
                a.denominator = 1;
            }
            return new Fraction(a.wholePart, a.numerator, a.denominator);
        }

        // 求两个数的最大公约数
        private long greatestCommonDivisor(long a, long b) {
            return (b == 0) ? a : greatestCommonDivisor(b, a % b);
        }
        // 将带分数转换为假分数
        private Fraction toImproperFraction(Fraction a) {
            long newNumerator = a.wholePart * a.denominator + ((a.numerator < 0) ? -a.numerator : a.numerator);
            a.wholePart = 0;
            return new Fraction(a.wholePart, newNumerator, a.denominator);
        }
        // 假分数加法
        public Fraction addMixedNumber(Fraction a,Fraction b) {
            a = toImproperFraction(a);
            b = toImproperFraction(b);
            long newNumerator = a.numerator * b.denominator + a.denominator * b.numerator;
            long newDenominator = a.denominator * b.denominator;
            Fraction c=new Fraction(0, newNumerator, newDenominator);
            c = simplify(c);
            return c;
        }

        // 假分数减法
        public Fraction subtractMixedNumber(Fraction a,Fraction b) {
            a = toImproperFraction(a);
            b = toImproperFraction(b);
            long newNumerator = a.numerator * b.denominator - a.denominator * b.numerator;
            long newDenominator = a.denominator * b.denominator;
            Fraction c=new Fraction(0, newNumerator, newDenominator);
            c = simplify(c);
            return c;
        }

        // 假分数乘法
        public Fraction multiplyMixedNumber(Fraction a,Fraction b) {
            a = toImproperFraction(a);
            b = toImproperFraction(b);
            long newNumerator = a.numerator * b.numerator;
            long newDenominator = a.denominator * b.denominator;
            Fraction c=new Fraction(0, newNumerator, newDenominator);
            c = simplify(c);
            return c;
        }

        // 假分数除法
        public Fraction divideMixedNumber(Fraction a,Fraction b) {
            a = toImproperFraction(a);
            b = toImproperFraction(b);
            long newNumerator = a.numerator * b.denominator;
            long newDenominator = a.denominator * b.numerator;
            Fraction c=new Fraction(0, newNumerator, newDenominator);
            c = simplify(c);
            return c;
        }
    }
    public static class CompareFiles {
        public static void compareFiles(String file1Path, String file2Path) {
            List<Integer> correctLines = new ArrayList<>();
            List<Integer> wrongLines = new ArrayList<>();

            try {
                BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
                BufferedReader reader2 = new BufferedReader(new FileReader(file2Path));

                int lineNum = 1;
                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                while (line1 != null && line2 != null) {
                    if (!line1.equals(line2)) {
                        wrongLines.add(lineNum);
                    } else {
                        correctLines.add(lineNum);
                    }
                    line1 = reader1.readLine();
                    line2 = reader2.readLine();
                    lineNum++;
                }

                if (line1 != null || line2 != null) {
                    System.out.println("Files have different number of lines");
                } else {
                    System.out.println("Files are identical");
                }

                reader1.close();
                reader2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            writeResultToFile(correctLines, wrongLines);
        }

        private static void writeResultToFile(List<Integer> correctLines, List<Integer> wrongLines) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Grade.txt"));
                writer.write("Correct: " + correctLines.size() + " (" + correctLines.toString().replaceAll("[\\[\\]]", "") + ")\n");
                writer.write("Wrong: " + wrongLines.size() + " (" + wrongLines.toString().replaceAll("[\\[\\]]", "") + ")\n");
                writer.close();
                System.out.println("Results written to Grade.txt");
                try{
                    File txtFile = new File("Grade.txt");
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

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
