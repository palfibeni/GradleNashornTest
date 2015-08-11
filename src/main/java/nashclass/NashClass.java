package nashclass;

import java.io.FileReader;
import java.io.IOException;
import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashClass {

    public static void main(String[] args) throws IOException, ScriptException {
        
        ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName("nashorn");
   
        Bindings bindings = engine.createBindings();
        bindings.put("printout", new PrintCommand());
        bindings.put("main", new NashClass());
        bindings.put("witcher", new TestInterface() {

            @Override
            public void attack(int targetstr) {
                if((targetstr < 3)){
                    System.out.println("Geralt annahilates his enemy!");
                }else{
                    System.out.println("Geralt's enemy was stronger, but strength doesn't matter when you are flat on your back...");}
            }

            @Override
            public void defend(int direction, int enemydir) {
                if((direction == enemydir)){
                    System.out.println("Geralt parries his enemies attack, the defense was so immense, your enemy drops his weapon, and run away...");
                }else{
                    System.out.println("Best defense is attack, you should have done that, now you are dead...");}
            }
        });
        
        engine.setBindings(bindings, ScriptContext.GLOBAL_SCOPE);
        
        dumpBindings(engine.getBindings(ScriptContext.GLOBAL_SCOPE));
        //dumpBindings(engine.getBindings(ScriptContext.ENGINE_SCOPE));
        
        engine.eval(new FileReader("myscript.js")/*, bindings*/ );
    }
    
    public void greetings(){       
        System.out.println("hello");
    }

    public void greetings(String name){       
        System.out.println("hello " + name);
    }

    public static interface Command {

        public void execute(Object data);
    }

    public static class PrintCommand implements Command{  

        @Override
        public void execute(Object data){
            System.out.println(data.toString());
        }
    }
    
    public static void dumpBindings(Bindings bindings) {
        if (bindings == null){
            System.out.println("  No bindings");
        }
        else{
            for (String key : bindings.keySet()){
                System.out.println("  " + key + ": " + bindings.get(key));
            }
        }
        System.out.println();
    }
}