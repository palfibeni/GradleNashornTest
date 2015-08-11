var TestClass = Java.type("nashclass.TestClass");

var myClass = new TestClass("Warcraft");

myClass.test();
printout.execute(myClass.getStr());

myClass.setStr("Starcraft");

myClass.test();
printout.execute(myClass.getStr());

TestClass.helloClass();

main.greetings("Beni");

witcher.attack(2);