public class Test1 {

    // @AfterSuite / @BeforeSuite / без аннотации

    @BeforeSuite
    public void greetingsWorld() {
        System.out.println("Test1 - Hello world!");
    }

    @AfterSuite
    public void goodbyeWorld(){
        System.out.println("Test1 - Goodbye world!");
    }

    //@Test
    public void task1(){
        System.out.println("Test1 - task 1 done!" + " priority: def");
    }

    @Test (priority = 3)
    public void task2(){
        System.out.println("Test1 - task 2 done!" + " priority: 3");
    }

    @Test (priority = 9)
    public void task3(){
        System.out.println("Test1 - task 3 done!" + " priority: 9");
    }

    @Test
    public void task4(){
        System.out.println("Test1 - task 4 done!" + " priority: def");
    }
}
