public class Telephone {
   public String areaCode;
   public String number;
   static int numberOfTelephones = 0;

   public Telephone(String areaCode , String number){
       this.areaCode = areaCode;
       this.number = number;
       numberOfTelephones++;
   }

   public String getAreaCode(){
       return areaCode;
   }

   public String getNumber(){
       return number;
   }

   public void setNumber(String number){
       this.number = number;
   }

   public void setAreaCode(String areaCode){
       this.areaCode = areaCode;
   }

   public String makeFullNumber(){
         return areaCode + "-" + number;
   }
}