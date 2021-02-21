package com.ncu.main;
import java.io.*;
import java.util.*;


class Expense
{
    int c;
  String sno, date="";                        
    String amount;                  
    String purpose;   
  static int total;               
      File file=new File("C:\\Users\\ABC\\Desktop\\unguidedproject\\DailyExpenseCalculator\\expenses\\expense.txt");
      File tempFile=new File("C:\\Users\\ABC\\Desktop\\unguidedproject\\DailyExpenseCalculator\\expenses\\expense.txt");
       Scanner sc = new Scanner(System.in);
      
      
  //***********************************************************************************
    void expenseAdd()                    
    {      try{  
               FileWriter fw=new FileWriter(file, true);    
               sc.nextLine();        
          System.out.println("enter the date for which u want to enter record (dd-mm-yyyy enter)");
         date=sc.nextLine();
          
           
             
       do {

              //to input serial number
               
               for (int i = 0; i < date.length(); i++) 
                fw.write(date.charAt(i));
                fw.write(",");
              sc.nextLine();
              System.out.println("enter the serial number");
           
            sno=sc.nextLine();
            
            for (int i = 0; i < sno.length(); i++) 
            fw.write(sno.charAt(i)); 
            fw.write(",");      
        
            //to imnput purpose
            System.out.println("enter the purpose of the expense");
           
            purpose=sc.nextLine();
            for (int i = 0; i < purpose.length(); i++) 
            fw.write(purpose.charAt(i));  fw.write(",");       
        
            //to input amount
            System.out.println("enter the amount");
            amount=sc.nextLine();
            for (int i = 0; i < amount.length(); i++) 
            fw.write(amount.charAt(i));  
            fw.write("\n");
      
         
           
      
  
          
          System.out.println("success..");
           System.out.println("do u want to add more records? (1/0)");
            c=sc.nextInt(); 
          }
            while(c==1);
            fw.close();
    } 
      catch(Exception e)
        {
          System.out.println(e);
        }
      }
   //***************************************************************************
    void expenseRead()
    {
         try
         {
             FileReader fr = new FileReader(file); 
      
    int i; 
    while ((i=fr.read()) != -1) 
      System.out.print((char) i); 
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
          System.out.println("\nReached End..");
    }
    //************************************************************************
    void expenseCalculate()
    {
     String file = "C:\\Users\\ABC\\Desktop\\unguidedproject\\DailyExpenseCalculator\\expenses\\expense.txt"; 
    try  
    { FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line;
      
      while ((line= br.readLine()) != null) 
      {
        
        String arrOfStr[] = line.split(","); 
        //System.out.println(Integer.parseInt(arrOfStr[3]));
        total += Integer.parseInt(arrOfStr[3]);
        
      }
    } 
    catch (IOException e)
     {
      e.printStackTrace();
    }
    System.out.println("Total Expense till date is : ₹"+total);
    total =0;
  }

 

   //***********************************************************************
   public void expenseDelete()
   {
      boolean i,j;
       
       String removeTerm;
       String filepath = "C:\\Users\\ABC\\Desktop\\unguidedproject\\DailyExpenseCalculator\\expenses\\expense.txt";
       int positionofterm = 0;
       String tempFile = "C:\\Users\\ABC\\Desktop\\unguidedproject\\DailyExpenseCalculator\\expenses\\temp.txt";
       File oldFile = new File(filepath);
       File newFile = new File(tempFile);
      
       String currentLine;
       String data[];
       Scanner sc = new Scanner(System.in);
       System.out.println("enter the date for which the record has to be deleted");
       removeTerm = sc.nextLine();
       try{
                FileWriter fw =new FileWriter(tempFile,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
   
               FileReader fr = new FileReader(filepath);
               BufferedReader br = new BufferedReader(fr);
   
               while ((currentLine = br.readLine()) != null){
   
                 data = currentLine.split(",");
                 if(!data[positionofterm].equals(removeTerm)){
                   pw.println(currentLine);
                 }
   
               }
               
               pw.flush();
               fw.close();
               bw.close();
               pw.close();
               fr.close();
               br.close();
           
               System.gc();
             i= oldFile.delete();
             //System.out.println("old file deleted?"+i);
            j=  newFile.renameTo(oldFile);
              //System.out.println("new file renamed?"+j);                        
       }catch(Exception e){
         e.printStackTrace();
       }
 

 }    


//*************************************************************************************       
}
 

//*********************************************************************************
// class TestExpense
// {
//    public static void main(String[] args)
//    {
//        Expense ob=new Expense();
//     
//        ob.expenseDelete();
//    }
// }