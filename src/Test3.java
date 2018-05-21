public class Test3 {

    //отсутствуют @AfterSuite  @BeforeSuite

    @Test
    public void task1(){
        System.out.println("Test3 - task 1 done!" + " priority: def");
    }

    @Test (priority = Priority.L4)
    public void task2(){
        System.out.println("Test3 - task 2 done!" + " priority: 4");
    }

    @Test (priority = Priority.L6)
    public void task3(){
        System.out.println("Test3 - task 3 done!" + " priority: 6");
    }

    @Test (priority = Priority.L6)
    public void task4(){
        System.out.println("Test3 - task 4 done!" + " priority: 6");
    }
}
