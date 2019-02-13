import java.lang.reflect.Field;
import java.util.Scanner;

public class Customer {

    static public void main(String ... args) throws Exception{
        Command lambda_function = ()-> System.out.println("lambda function");

        Command anonymous_class = new Command() {
            public String name = "anonymous class";
            public String str;

            @Override
            public void execute() {
                System.out.println(str);
                System.out.println("anonymous class");
            }

            public String getStr() {
                return str;
            }
        };
        Class clazz = anonymous_class.getClass();
        Object name = clazz.getField("name").get(anonymous_class);

        Command method_ref = CommandObj2::execute;

        CommandObj1 comObj = new CommandObj1();

        Scanner sc = new Scanner(System.in);
        String line = "l";
        while (!line.equals("q")) {
            line = sc.nextLine();
            if (line.equals("lambda")) lambda_function.execute();
            else if (line.equals(name.toString())) anonymous_class.execute();
            else if (line.equals(comObj.name)) comObj.execute();
            else if (line.equals(CommandObj2.name)) method_ref.execute();
        }
    }
}
