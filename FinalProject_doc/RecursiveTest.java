public class RecursiveTest{
   public static void main(String [] args){
      System.out.println(methodA("ICS"));
   }
      public static String methodA(String s){
         return(methodA(s.length(),s));
      }
         public static String methodA(int i, String s){
            if (i==1){
               return s;
            }
            else{
               return methodA(i-1,s.substring(1)) + s.charAt(0);
            }
         }
}