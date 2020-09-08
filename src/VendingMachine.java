import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class MyProduct {
    String productName;
    int value;
    int index;
    MyProduct(){}
    MyProduct(String name, int val, int i) {
        productName = name;
        value = val;
        index = i;
    }

    @Override
    public String toString() {
        return "Enter " + index + " for : " + productName;
    }
}

public class VendingMachine {

    static MyProduct coke = new MyProduct("coke", 25, 1);
    static MyProduct pepsi = new MyProduct("pepsi", 35, 2);
    static MyProduct soda = new MyProduct("soda", 45, 3);

    static int initialAmount;
    static boolean cont = true;
    private static String password = "admin@1234";

    public static void setPassword(String password) {
        VendingMachine.password = password;
    }

    public static void reset() {
        initialAmount = 0;
        coke = null;
        pepsi = null;
        soda = null;
        cont = false;
        System.out.println("Reset Done.");
    }


    public static void calcOptions(ArrayList<MyProduct> options, int amount) {
        if(amount >= 25)
            options.add(coke);
        if(amount >= 35)
            options.add(pepsi);
        if(amount >= 45)
            options.add(soda);
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        while(cont) {
            System.out.println("Enter Initial Amount: ");
            initialAmount = sc.nextInt();

            //coke-25 pepsi-35 soda-45

            ArrayList<MyProduct> options = new ArrayList<>();
            calcOptions(options, initialAmount);

            System.out.println("Here Are Your Choices: ");


            Iterator iterator = options.iterator();
            if(!iterator.hasNext()) {
                System.out.println("No product in price range!");
            } else {

                System.out.println("Enter 0 for Restarting");
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }

                int choice = sc.nextInt();

                if(choice == 0) {
                    System.out.println("Exiting Program");
                } else if(choice == coke.index) {
                    System.out.println("Change is: " + (initialAmount - coke.value));
                } else if(choice == pepsi.index) {
                    System.out.println("Change is: " + (initialAmount - pepsi.value));
                } else if(choice == soda.index) {
                    System.out.println("Change is: " + (initialAmount - soda.value));
                } else {
                    System.out.println("Wrong Input!");
                }

//                switch (choice) {
//                    case 0:
//                        System.out.println("Exiting Program");
//                        break;
//                    case 1:
//                        System.out.println("Change is: " + (initialAmount - coke.value));
//                        break;
//                    case 2:
//                        System.out.println("Change is: " + (initialAmount - pepsi.value));
//                        break;
//                    case 3:
//                        System.out.println("Change is: " + (initialAmount - soda.value));
//                        break;
//                    default:
//                        System.out.println("Wrong Input!");
//                }

            }

            System.out.println("Would you like to go into admin mode and RESET: reply 1 for 'Yes' or 0 for 'N'.");

            if(sc.hasNext() && sc.nextInt() == 1) {
                System.out.println("Enter password:");
                sc.nextLine(); // buffer issue due to '\n'
                String pass = sc.nextLine();
                if(password.equals(pass)) {
                    reset();
                } else {
                    System.out.println("Wrong password");
                }
            }

        }


    }
}
