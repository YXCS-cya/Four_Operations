
import java.io.FileWriter;
import java.io.PrintWriter;
public class File {
    public static void DataWrite(String[] Operation){//输入存储字符串的数组，自动录入文件
        try {
            FileWriter fileWriter = new FileWriter("output.txt");//还有答案、成绩文档需生成
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (String line : Operation) {
                printWriter.println(line);
            }

            printWriter.close();
            System.out.println("字符串数组已成功写入到文件中。");
        } catch (Exception e) {
            System.out.println("写入文件时发生错误：" + e.getMessage());
        }
    }
}
