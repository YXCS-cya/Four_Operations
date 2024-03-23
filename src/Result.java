
/*
计算结果

未实现
* **/
public class Result {

    public static Double DataIn(double a, double b, double c, String m, String n){
        double temp = 0.00;
        int m1 = 0, n1 = 0;
        if(m == "*" || m == "/")
            m1++;
        if(n == "*" || n == "/")
            n1++;
        if(n1 > m1)
        {
            temp = result(b, c, n);
            if(temp > a && m =="-")
                return -1.0;
            else{
                return  result(a, temp, m);
            }
        }

        return -1.0;
    }

//    public static String Print(double a){
//
//    }
    public static Double result(double a, double b, String S){
        switch(S){
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        return null;
    }
}
