public class CommandObj1 implements Command {

    public final String name = "Object";
    public String str;

    public void execute(){
        System.out.println(name);
        System.out.println(str);
    }
}
