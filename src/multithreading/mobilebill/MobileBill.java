package multithreading.mobilebill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MobileBill {

    List<HashMap<String,Integer>> mobileBills= new ArrayList<>();
    HashMap<Integer,Integer> totalBillList=new HashMap<>();
    int currentBillNumber;

    public void addBill(){
        HashMap bill=new HashMap();
        Scanner input=new Scanner(System.in);
        Scanner inputName=new Scanner(System.in);
        Scanner inputPrice=new Scanner(System.in);
        System.out.println("Enter Number Of Product: ");
        int numberOfProduct=input.nextInt();
        for(int i=1;i<=numberOfProduct;i++){
            System.out.println("Enter "+i+"th Product Name: ");
            String productName=inputName.nextLine();
            System.out.println("Enter "+i+"th Product Price: ");
            Integer productPrice=inputPrice.nextInt();
            bill.put(productName,productPrice);
        }
        mobileBills.add(bill);
    }

    public static void main(String[] args) {

        MobileBill obj=new MobileBill();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Number of Bill: ");
        int numberOfBill=input.nextInt();
        for(int i=0;i<numberOfBill;i++){
            obj.addBill();
        }

        ExecutorService pool= Executors.newFixedThreadPool(2);
        for(int i=0;i<numberOfBill;i++){
            obj.currentBillNumber=i;
            Runnable task=new CalculateBill(obj);
            pool.execute(task);
        }
    }
}
