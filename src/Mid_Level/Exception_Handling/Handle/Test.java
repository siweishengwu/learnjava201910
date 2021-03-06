package Mid_Level.Exception_Handling.Handle;

public class Test {

    public static int method(){
        try{
            return return1();
        }catch (Exception e){
            return return2();
        }finally {
            return return3();
        }
    }

    private static int return3() {
        System.out.println("return 3");
        return 3;
    }

    private static int return2() {
        System.out.println("return 2");
        return 2;
    }

    private static int return1() {
        System.out.println("return 1");
        return 1;
    }

    public static void main(String[] args) {
        int result = method();
        System.out.println("result:"+result);
    }
}
