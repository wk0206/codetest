package test;

public class constructor {
    public static void main(String... args) {  
        Bar bar = new Bar();  
    }  
}
class Foo {  
    int i;  
      
    Foo() {  
        i = 1;  
        int x = getValue();  
        System.out.println(x);  
    }  
      
    protected int getValue() {  
        return i;  
    }  
}  
  
class Bar extends Foo {  
    int j;  
      
    Bar() {  
        j = 2;  
    }  
      
    @Override  
    protected int getValue() {  
        return j;  
    }  
}  
  