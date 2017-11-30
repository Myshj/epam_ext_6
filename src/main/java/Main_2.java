import java.lang.reflect.Field;

public class Main_2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //value
        String string = new String( "MISHEL");
        System.out.println(string.intern());

        Class<? extends String> stringClass = string.getClass();

        Field value = stringClass.getDeclaredField("value");

        value.setAccessible(true);
        value.set(string, "MAUS".getBytes());
        value.setAccessible(false);
        System.out.println(string);

        System.out.println("MISHEL");

        System.out.println(string.intern());
    }
}
