import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MainTest {

    public static void main(String[] args) {
        start(Test1.class);
        System.out.println("------------------------------");
        start(Test2.class.getName());
        System.out.println("------------------------------");
        start(Test3.class);
        System.out.println("------------------------------");
        //start(Test4.class.getName());   //RuntimeException
    }

    //на старт подается имя класса
    public static void start(String className){
        try {
            Class<?> c = Class.forName(className);
            start(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //на старт подается класс
    public static void start(Class c){
        Method [] methods = c.getDeclaredMethods();
        int beforeSuite = 0;
        int afterSuite = 0;
        //создать хэшмап в который будем записывать методы и приоритеты, где Key - метод, Value - приоритет
        //для метода с аннотацией @BeforeSuite приоритет 11, с аннотоцией @AfterSuite - 0
        //если методы с аннотациями существуют в таблеце вывести на экран ошибку.

        Map<Method, Integer> prioryList = new HashMap<>();

        for(Method m: methods){

            //проверяем на наличие уникальности аннотации:
            //@BeforeSuite
            if (m.getAnnotation(BeforeSuite.class) != null){
                ++beforeSuite;
                if (beforeSuite > 1){
                    throw new RuntimeException("Можно использовать только одну аннотацю @BeforeSuite");
                }
            }

            //@AfterSuite
            if (m.getAnnotation(AfterSuite.class) != null ){
                ++afterSuite;
                if (afterSuite > 1){
                    throw new RuntimeException("Можно использовать только одну аннотацю @AfterSuite");
                }
            }

            //заполняем хэщмап
            if (m.getAnnotation(BeforeSuite.class) != null) {
                prioryList.put(m, 11);
            }else if (m.getAnnotation(AfterSuite.class) != null) {
                prioryList.put(m, 0);
            }else {
                prioryList.put(m, m.getAnnotation(Test.class).priority());
            }
        }

        //выполнение методов класса-тестировщика с учетом приоритета 11 --> 0
        for (Integer i = 11; i >= 0; i--) {
            for (Map.Entry<Method, Integer> item : prioryList.entrySet()) {
                try {
                    if (item.getValue().equals(i)) {
                        item.getKey().invoke(c.newInstance());
                    }
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
