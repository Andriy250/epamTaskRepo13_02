import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4Main {
    static public void main(String... args){
        Scanner sc = new Scanner(System.in);
        String line = "l";
        List<String> list = new ArrayList<>();
        while (!line.equals("")) {
            line = sc.nextLine();
            list.add(line);
        }
        /*Stream<String> stream = list.stream().flatMap(e->Stream.of(e.split(" ")));
        long count = stream.distinct().count();*/
        System.out.println(list.stream().flatMap(e->Stream.of(e.split(" "))).distinct().count());

        list.stream().flatMap(e->Stream.of(e.split(" "))).distinct().sorted().forEach(System.out::println);

        Map<String, Long> map = list.stream().flatMap(e->Stream.of(e.split(" "))).distinct().collect(Collectors.toMap(i->i, i-> list.stream().
                flatMap(e->Stream.of(e.split(" "))).filter(a->a.equals(i)).count()));
        System.out.println(map);
    }
}
