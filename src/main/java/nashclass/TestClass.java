package nashclass;

public class TestClass {
    
    private String str;
    private static final String str2 = "Lord of Terror";

    
    public TestClass(String str){
        this.str = str;
    }
    
    public void test(){
        System.out.println(this.str);
    }
    
    public String getStr(){
        return this.str;
    }
    public void setStr(String str){
        this.str = str;
    }
    
    public static void helloClass(){
        System.out.println(str2);
    }
}
