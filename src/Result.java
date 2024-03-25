
/*
计算结果

未实现
* **/
public class Result {

    public static boolean DataIn(int a, int b, int c, String m, String n){
        int result1 = 0;
        int m1 = 0, n1 = 0;

        if(m == "*" || m == "/")
            m1++;
        if(n == "*" || n == "/")
            n1++;

        if(n1 > m1)
        {
            result1 = result(a,result(b,c,n),m);
        }
        else{
            result1 = result(result(a,b,m),c,n);
        }

        if(result1 - 1 < 0)
            return false;
        else
            return true;
    }

//    public static String Print(double a){
//
//    }
    public static int result(int a, int b, String S){
        switch(S){
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        return -1;
    }
}
