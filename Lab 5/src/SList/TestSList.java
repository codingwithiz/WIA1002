package SList;

public class TestSList {
    public static void main(String[]args){
        SList<String> list = new SList<String>();
        list.appendEnd("Linked list");
        list.appendEnd("is");
        list.appendEnd("easy");
        list.display();
        System.out.println("Removed: " + list.removeInitial());
        if(list.contains("easy")){
            System.out.println("easy is in the list");
        }
        else{
            System.out.println("easy is not in the list");
        }
        list.display();
        list.clear();
        list.display();
    }
}
