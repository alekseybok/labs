import org.example.SomeInterface;
import org.example.SomeOtherInterface;

public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;

    @AutoInjectable
    private SomeOtherInterface field2;

    public void foo(){
        field1.doSomething();
        field2.doSomeOther();
    }
}