import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    static public void main(String ... args){

        Lambda lambda = (a,b,c) -> Stream.of(a,b,c).max(Integer::compareTo).orElse(0);
        Lambda lambda2 = (a,b,y) -> Stream.of(a,b,y).mapToInt(Integer::intValue).sum() / 3;

        System.out.println("max " + lambda.func1(1,2,3));
        System.out.println("average " + lambda2.func1(1,7,4));
    }

    @FunctionalInterface
    interface Lambda{
        int func1(int a,int b,int c);
    }
}
