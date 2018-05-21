public class Test2 {

    //отсутствует @AfterSuite

    @BeforeSuite
    public void greetingsWorld() {
        System.out.println("Test2 - Hello world!");
    }

    @Test
    public void task1(){
        System.out.println("Test2 - task 1 done!" + " priority:  def");
    }

    @Test (priority = Priority.L3)
    public void task2(){
        System.out.println("Test2 - task 2 done!" + " priority: 3");
    }

    @Test (priority = Priority.L7)
    public void task3(){
        System.out.println("Test2 - task 3 done!" + " priority: 7");
    }

    @Test
    public void task4(){
        System.out.println("Test2 - task 4 done!" + " priority:  def");
    }
}
