package dev.nmarulo.depensaapp.commons;

public abstract class Test {

    public static void test() {
        int a = 0;
    }

    public void test0() {
        for (int i = 0; i < 10; i++) {
            System.out.println("test0" + i);
            System.out.println("test0" + i);
            System.out.println("test0" + i);
            System.out.println("test0" + i);
            
            return;
        }
    }
    
    public void test1() {
        for (int i = 0; i < 10; i++) {
            System.out.println("test0" + i);
            System.out.println("test0" + i);
            System.out.println("test0" + i);
            System.out.println("test0" + i);
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println("test0" + i);
            System.out.println("test0" + i);
            System.out.println("test0" + i);
            System.out.println("test0" + i);
            
            return;
        }
    }
    
}
