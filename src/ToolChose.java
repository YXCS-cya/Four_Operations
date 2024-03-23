/*
选择符号
* */

import java.util.Random;

public class ToolChose{
    public static String choseTool(){
        Random random = new Random();
        int Tool = random.nextInt(4) + 1;
        switch(Tool)
        {
            case 1: return "+";
            case 2: return "-";
            case 3: return "*";
            case 4: return "/";
        }
        return "+";
    }
}
