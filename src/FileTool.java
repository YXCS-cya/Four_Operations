import java.io.FileWriter;
import java.io.PrintWriter;

public class FileTool {
    public static void DataWrite(String[] temp){//输入存储字符串的数组，自动录入文件
        //注：每次运行此方法，同名文件中的内容将被更改
        String[] Operation  = new String[temp.length];
        for(int i = 0; i < Operation.length; i++){
            Operation[i] = (i+1) + "." + temp[i];
        }

        try {
            FileWriter fileWriter = new FileWriter("Exercises.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (String line : Operation) {
                printWriter.println(line);
            }

            printWriter.close();
            System.out.println("四则运算式已成功写入到文件Exercises.txt");
            Correct.Get_Grade(/*"Exercises.txt"*/);

        } catch (Exception e) {
            System.out.println("写入文件时发生错误：" + e.getMessage());
        }
    }
}
