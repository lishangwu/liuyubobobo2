/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/10 16:39
 */

package Test;

import java.io.PrintStream;

public class Test {


    public static void main(String[] args){
        
        int a = 10;
        int b = 10;
        method2(a, b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);


    }

    public static void method(int a, int b){
        System.out.println("a=100");
        System.out.println("b=200");
        System.exit(0);
    }

    public static void method2(int a, int b){
        PrintStream ps = new PrintStream(System.out){
            @Override
            public void println(String x) {
                if("a=10".equals(x)){
                    x = "a=100";
                }else if("b=10".equals(x)){
                    x = "b=200";
                }
                super.println(x);
            }
        };
        System.setOut(ps);
    }
}
