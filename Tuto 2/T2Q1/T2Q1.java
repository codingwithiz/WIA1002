package T2Q1;

public class T2Q1 {
    public static void main(String[]args){
        Container.main(args);
    }
}

class Container <T> {
    private T t;
    public Container(){

    }

    public void add(T t){
        this.t = t;
    }

    public T retrieve(){
        return t;
    }

    public static void main(String[]args){
        Container <Integer> c1 = new Container<>();
        Container<String> c2 = new Container<String>();
        c1.add(10);
        c2.add("Hello");
        System.out.println(c1.retrieve());
        System.out.println(c2.retrieve());
    }
}