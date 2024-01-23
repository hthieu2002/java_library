package Util;

import Model.ReaderDAO;
import Model.BookDAO;
import Model.AuthorDAO;
import Controller.ReaderGui;
import Controller.BookGui;
import Controller.AuthorGui;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Model {
    
public static List<String> RamDom() {
        List<String> date = new ArrayList<>();
        
        Random r = new Random();
    int randint = Math.abs(r.nextInt()) % 10000;
   if(randint < 100){
        date.add("00"+randint);
   }else if(randint < 1000){
          date.add("0"+randint);
     }else{
          date.add(""+randint);  
     }      
   return date;
 }
public static List<String> RamD0m() {
        List<String> date = new ArrayList<>();
        
        Random r = new Random();
    int randint = Math.abs(r.nextInt()) % 10000;
   if(randint < 100){
        date.add(""+randint);
   }else if(randint < 1000){
          date.add(""+randint);
     }else{
          date.add(""+randint);  
     }      
   return date;
 }
 public static List<String> RamD0m1() {
        List<String> date = new ArrayList<>();
        
        Random r = new Random();
    int randint = Math.abs(r.nextInt()) % 10000;
   if(randint < 100){
        date.add("SV00"+randint);
   }else if(randint < 1000){
          date.add("SV0"+randint);
     }else{
          date.add("SV"+randint);  
     }      
   return date;
 }
    private static List<AuthorGui> dg = new ArrayList<>();

    public static List<String> getIdAuthor() {
        List<String> data = new ArrayList<>();
        AuthorDAO dao = new AuthorDAO();
        for (AuthorGui authorGui : dao.ShowAuthor()) {
            authorGui.getIDAuthor();
           
            dg.add(authorGui);
            data.add(authorGui.getIDAuthor());   
            
        }
        return data;
}
//    
//
//        public static List<String> Nam() {
//        List<String> date = new ArrayList<>();
//        int i;
//      for(i = 2019; i < 2030; i++){
//          date.add(""+i);
//      }     
//   return date;
//}   
public static List<String> RamDomBorrowed() {
        List<String> date = new ArrayList<>();
        
        Random r = new Random();
    int randint = Math.abs(r.nextInt()) % 10000;
   if(randint < 100){
        date.add("BL00"+randint);
   }else if(randint < 1000){
          date.add("BL0"+randint);
     }else{
          date.add("BL"+randint);  
     }      
   return date;
 }
    public static List<String> RamDomGiveBookBack() {
        List<String> date = new ArrayList<>();
        
        Random r = new Random();
    int randint = Math.abs(r.nextInt()) % 10000;
   if(randint < 100){
        date.add("PP00"+randint);
   }else if(randint < 1000){
          date.add("PP0"+randint);
     }else{
          date.add("PP"+randint);  
     }      
   return date;
 }
    
public static List<String> RamDomRequest () {
        List<String> date = new ArrayList<>();
    Random r = new Random();
    int randint = Math.abs(r.nextInt()) % 100000;
    if(randint < 10000){
        date.add("5"+randint);  
    }else if(randint < 100){
        date.add("721"+randint);
    }else if(randint < 1000){
          date.add("93"+randint);
    }else{
          date.add(""+randint);  
     }      
   return date;
 }
    
    private static List<String> data1 = new ArrayList<>();
    
    public static List<String> DataBook(){
        data1.add("ID book");
        data1.add("Name book");
        data1.add("Name author");
        data1.add("Category");
        data1.add("Number");
        data1.add("Note");
        
        return data1;
    }
    

}


