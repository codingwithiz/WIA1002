package Lab_2;

public class L2Q1 {
    public static void main(String[]args){
        MyGeneric<String> strObj = new MyGeneric<>();
        MyGeneric<Integer> intObj = new MyGeneric<>();
        strObj.setE("Nothing");
        intObj.setE(100);

        System.out.println(strObj.getE());
        System.out.println(intObj.getE());
    }

}

class MyGeneric<E>{
    private E e;

    public MyGeneric(){

    }

    public E getE(){
        return e;
    }

    public void setE(E e){
        this.e = e;
    }

    public MyGeneric(E e){
        this.e = e;
    }

}