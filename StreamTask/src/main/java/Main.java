import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    static public void main(String ...args){
        List<Integer> list1 = intStreamGeneratorRange(1,5);
        printList(list1);

        List<Integer> list2 = intStreamGeneratorGen1();
        printList(list2);

        List<Integer> list3 = intStreamGeneratorIterator();
        printList(list3);

        System.out.println("max " + list3.stream().max(Integer::compareTo).orElse(0));
        System.out.println("min " + list3.stream().min(Integer::compareTo).orElse(0));
        System.out.println("sum " + list3.stream().reduce(0,Integer::sum));
        System.out.println("sum " + list3.stream().mapToInt(i->i).average().orElse(0));

        IntSummaryStatistics statistics = list3.stream().mapToInt(i->i).summaryStatistics();
        System.out.println(statistics);

        List<Integer> list4 = list3.stream().filter(i->i>list3.stream().mapToInt(a->a).average().orElse(0)).collect(Collectors.toList());
        System.out.println("more then average");
        list4.stream().forEach(System.out::println);

    }

    static private List<Integer> intStreamGeneratorRange(int a, int b){
        return IntStream.range(a,b).mapToObj(i->new Integer(i)).collect(Collectors.toList());
    }

    static private List<Integer> intStreamGeneratorGen1(){
        int i = 0;
        return Stream.generate(()->1).limit(10).collect(Collectors.toList());
    }

    static private List<Integer> intStreamGeneratorIterator(){
        return Stream.iterate(40, (i)->++i).limit(20).collect(Collectors.toList());
    }

    static private <T> void printList(List<T> list){
        System.out.println('\n');
        list.stream().forEach(System.out::println);
        System.out.println('\n');
    }
}
