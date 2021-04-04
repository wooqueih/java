package test;
public class Test {
    static void meth(String name) {
        System.out.println(name);
    }

    static long factorial(long n) {
        if(n > 0){
            return factorial(n-1)*n;
        } else if (n == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String[] names = {"suse","frank","Epstein","didn't","kill","himself","Geoffrey","Jacque"};
        for(int i = 1; i < names.length; i++){
            meth(names[i]);
        }
        Num argNum = new Num(Float.parseFloat(args[0]));
        System.out.println(factorial(argNum.integer));
        System.out.println("Int : " + argNum.integer + "\tFloat : " + argNum.decimal);
    }
}