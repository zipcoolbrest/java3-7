public class Test4 {

    @BeforeSuite
    public void greetingsWorld() {
        System.out.println("Test4 - Hello world! 1");
    }

    @BeforeSuite
    public void goodbyeWorld(){
        System.out.println("Test4 - Goodbye world! 2");
    }

    @Test (priority = 1)
    public void task1(){
        System.out.println("Test4 - task 1 done!" + " priority: 1");
    }

    @Test (priority = 3)
    public void task2(){
        System.out.println("Test4 - task 2 done!" + " priority: 3");
    }
}
