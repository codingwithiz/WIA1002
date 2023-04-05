public class TesterTelephone {
    public static void main(String[]args){
        Telephone t1 = new Telephone("03" , "79676300");
        Telephone t2 = new Telephone("03" , "79676301");
        Telephone t3 = new Telephone("03" , "79676302");
        Telephone t4 = new Telephone("03" , "79676303");
        Telephone t5 = new Telephone("03" , "79676304");

        Telephone[] telephones = {t1 , t2 , t3 , t4 , t5};

        for(Telephone t : telephones){
            System.out.println(t.makeFullNumber());
        }

    }
}
