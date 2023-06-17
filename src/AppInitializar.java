import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class AppInitializar {
    //===============Database area===============
    static String[][] users = new String[3][2];
    static String[][] customer = new String[500][4];

    static String[][] item = new String[500][5];

    static String[][] orders = new String[500][5];

    //===============Database area===============

    public static void main(String[] args) {
        // ==============testing===========================testing===============testing===============

        item [0][0] = "001";
        item [0][1] = "book 1";
        item [0][2] = "001 book";
        item [0][3] = "15";
        item [0][4] = "250";


        customer[0][0]="C01";
        customer[0][1]="Tharaka";
        customer[0][2]="Matale";
        customer[0][3]="25000";

        customer[1][0]="C02";
        customer[1][1]="Nadeel";
        customer[1][2]="Kandy";
        customer[1][3]="35000";

        customer[2][0]="C03";
        customer[2][1]="Hashan";
        customer[2][2]="Colombo";
        customer[2][3]="45000";

        // ===============testing==========================testing=================testing=============



        Scanner input = new Scanner(System.in);
        boolean exitStatement = false; // ekadigata run karanna...

        //program initialization prose's
        String[] initializePageQuestion=
                {
                        "01) Do you want to Login?",
                        " ",
                        "02) Are you new to here?",
                        " ",
                        "03) Do you want to exit the page?",
                        " "
                };


        while (!exitStatement){  //true wenakamma run karanna...

            for (String question: initializePageQuestion) {
                System.out.println(question);
            }

            int userInput = input.nextInt();
            switch (userInput){

                case 1: // me kes eka eka nm
                    //just foe our testing process
                    users[0][0] = "tharaka@gmail.com";
                    users[0][1] = "1234";
                    //just foe our testing process

                    if (login()){ //login wena method eka call wenna
                    printUi("Dashboard");
                    openDashboard();
                }
                printUi("Application");
                break;


                case 2:
                    if (register()){
                        openDashboard();
                    }break;


                case 3:
                    System.out.println("Good Bye..!");
                    break;
                default:
                    System.out.println("Idiot..! Wrong input..!\uD83D\uDE14"+'\n');
                    return;//exit
            }

        }




        //program initialization prose's
    }


    //Login process
    public static boolean login () {
        printUi("Login");
    Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the email");
        String email = input.nextLine();
        System.out.println("Please Enter the password");
        String password = input.nextLine();
        //============================================

        for (int i = 0; i < users.length; i++) {
            if (users[i][0]!=null  && users[i][0].equals(email)){  // ehema eliment ekak thiyanwada eka thiyanwa nm meka check karanna
                if (users[i][1].equals(password)){
                    System.out.println("Welcom again!");
                    return true;
                }else {
                    System.out.println("Wrong Pasword!");
                    return false;
                } // password eka hari nm welcom kiyala print karanna ehema nathinam wrong password kiyala print karnna
            }

        }
        System.out.println("404 Not Found"+'\n'); // for loop ela false nm 404 print karanna


        return false;
    }
    //Login process

    //Register process
    public static boolean register() {
        //[free?] , [1?, 2?, 3?]==> empty => insert value
        Scanner input = new Scanner(System.in);

        //[][][****]
        if (users[users.length-1][0] !=null){ //? [1][2][3] => 3 [0][1][2] =>   // check kara arrey eka emtiy da kiyala
            System.out.println("User database is full!");
            return false;
        }

        System.out.println("Insert Your Email!");
        String email = input.nextLine();
        System.out.println("Insert Your Password!");
        String password = input.nextLine();

        for (int x=0; x<users.length-1; x++){   // input raganna aragena for loop eke ithuru issoroma hambena shoot ekat daganna
            if (users[x][0]==null){
                users[x][0]=email;
                users[x][1]=password;
                return true;
            }else {
                if (users[x][0].equalsIgnoreCase(email)){
                    System.out.println("Email is already exists!");
                    return false;
                }
            }  // ehema kenek innawa nm Email is already exists print karanna
        }
        return false;
    }
    //Register process


    //Dashboard process
    public static void openDashboard(){
        Scanner input = new Scanner(System.in);
        String dashboardQuestion[]={
                "01) Customer Management",
                "02) Item Management",
                "03) Order Management",
                "04) Logout"
        };
        while (true){
        for (String question:dashboardQuestion){
            System.out.println(question);

        }
        int userInput= input.nextInt();

        switch (userInput){
            case 1:
                customerManagment();
                break;
            case 2:
                itemManagement();
                break;
            case 3:
                pleceNewOrder();
                break;
            case 4:break;
            default:return;
        }

        }

    }

    //Customer Management>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Customer Management
    public static void customerManagment(){
        // == // save, update, delete,list
        Scanner input = new Scanner(System.in);
        String customerQuestion[]={
                "01) Save Customer",
                "02) Find Customer",
                "03) Update Customer",
                "04) Delete Customer",
                "05) Find All Customer",
                "06) Back to Home"
        };
        while (true){
            for (String question: customerQuestion){
                System.out.println(question);
            }
            int userInput= input.nextInt();
            switch (userInput){
                case 1:
                    saveCustomer();
                    break;
                case 2:
                    findCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    printAllCustomers();
                    break;
                case 6:
                    openDashboard();
                    break;
                default:break;
            }
        }

    }
    //save Customer
    public static void saveCustomer(){
        //customer save [ array length?, array length =10 20]
        Scanner input = new Scanner(System.in);
        while (true){
            String nic,name,address;
            double salary;
            System.out.println("Inset Customer NIC");
            nic = input.nextLine();
            System.out.println("Inset Customer Name");
            name = input.nextLine();
            System.out.println("Inset Customer Address");
            address = input.nextLine();
            System.out.println("Inset Customer Salary");
            salary = input.nextDouble();
            //========================================================

            customerForLoop:
            for (int i = 0; i < customer.length; i++) {
                if (customer[i][0] != null){
                    if (customer[i][0].equals(nic)){
                        System.out.println("Customer Already Exists!");
                        break customerForLoop;
                    }
                }else {
                    customer[i][0]=nic;
                    customer[i][1]=name;
                    customer[i][2]=address;
                    customer[i][3]=String.valueOf(salary); // dubbel ekak string ellata convert kar aganna
                    //=============================================
                    System.out.println("Customer save!\n");
                    System.out.println("01) Do you want to add an another customer");
                    System.out.println("02) Back to Main Menu");
                    int option = input.nextInt();
                    switch (option){
                        case 1:
                            break customerForLoop; // me For loop eka methanin iwarai
                        case 2:
                           return;
                        default:
                            return;
                    }

                }
            }


        }

    }
    //save Customer

    //findCustomer
    public static void findCustomer(){
        Scanner input = new Scanner(System.in);
        System.out.println("Inset NIC");
        String nic= input.nextLine();

        for (int i = 0; i < customer.length ; i++) {
            if (customer[i][0]!=null){
                if (customer[i][0].equals(nic)){
                    System.out.println("=======================Customer=====================");
                    System.out.println("NIC : "+customer[i][0]);
                    System.out.println("Name : "+customer[i][1]);
                    System.out.println("Address : "+customer[i][2]);
                    System.out.println("Salary : "+customer[i][3]);
                    System.out.println("=======================Customer=====================");
                    return;
                }
            }

        }
        System.out.println("Customer Not Found");
    }

    //findCustomer

    //Update Customer
    public static void updateCustomer(){
        Scanner input = new Scanner(System.in);
        System.out.println("Inset NIC to Find the customer");
        String nic= input.nextLine();

        for (int i = 0; i < customer.length ; i++) {
            if (customer[i][0]!=null){
                if (customer[i][0].equals(nic)){

                    //========Update
                    String newName,newAddress;
                    double newSalary;

                    System.out.println("Inset Customer Name");
                    newName = input.nextLine();
                    System.out.println("Inset Customer Address");
                    newAddress = input.nextLine();
                    System.out.println("Inset Customer Salary");
                    newSalary = input.nextDouble();
                    //========Update
                    customer[i][1]=newName;
                    customer[i][2]=newAddress;
                    customer[i][3]=String.valueOf(newSalary);
                    System.out.println("Customer Update!");
                    return;
                }
            }

        }
        System.out.println(" Customer Not Found!");

    }
    //Update Customer

    //Delete Customer
    public static void deleteCustomer(){
        Scanner input = new Scanner(System.in);
        System.out.println("Inset NIC to Find the customer");
        String nic= input.nextLine();
        for (int i = 0; i < customer.length ; i++) {
            if (customer[i][0]!=null) {
                if (customer[i][0].equals(nic)) {
                    customer[i][0]=null;
                    customer[i][1]=null;
                    customer[i][2]=null;
                    customer[i][3]=null;
                    System.out.println("Delete Customer!");
                    return;

                }

                }
            }
            System.out.println(" Customer Not Found!");


    }

    //Delete Customer

    //Find All Customer
    public static void printAllCustomers(){
        for (int i = 0; i < customer.length; i++) {
            if (customer[i][0] != null){
                System.out.println("Nic: "+customer[i][0]+"\tName: "+customer[i][1]+"\tAddress: "+customer[i][2]+"\t\tSalary: "+customer[i][3]);
            }else {
                return;
            }


        }

    }
    //Find All Customer

    //Customer Management>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Customer Management

    //Item Management>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Item Management
    public static void itemManagement(){
        // == // save, update, delete,list
        Scanner input = new Scanner(System.in);
        String itemQuestion[]={
                "01) Save Item",
                "02) Find Item",
                "03) Update Item",
                "04) Delete Item",
                "05) Find All Item",
                "06) Back to Home"
        };
        while (true){
            for (String question: itemQuestion){
                System.out.println(question);
            }
            int userInput= input.nextInt();
            switch (userInput){
                case 1:
                    saveItem();
                    break;
                case 2:
                    findItem();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    printAllItem();
                    break;
                case 6:
                    openDashboard();
                    break;
                default:break;
            }
        }

    }

    //save Item
    public static void saveItem(){

        Scanner input = new Scanner(System.in);
        while (true){
            String code,name,description;
            int qtyOnHand;
            double unitPrice;
            System.out.println("Inset Item Code");
            code = input.nextLine();
            System.out.println("Inset Item name");
            name = input.nextLine();
            System.out.println("Inset Item description");
            description = input.nextLine();
            System.out.println("Inset Item qtyOnHand");
            qtyOnHand = input.nextInt();
            System.out.println("Inset Item unitPrice");
            unitPrice = input.nextDouble();
            //========================================================

            itemForLoop:
            for (int i = 0; i < item.length; i++) {
                if (item[i][0] != null){
                    if (item[i][0].equals(code)){
                        System.out.println("Item Already Exists!");
                        break itemForLoop;                    }
                }else {
                    item[i][0]=code;
                    item[i][1]=name;
                    item[i][2]=description;
                    item[i][3]=String.valueOf(qtyOnHand);
                    item[i][4]=String.valueOf(unitPrice);
                    //=============================================
                    System.out.println("Item save!\n");
                    System.out.println("01) Do you want to add an another Item");
                    System.out.println("02) Back to Main Menu");
                    int option = input.nextInt();
                    switch (option){
                        case 1:
                            break itemForLoop;
                        case 2:
                            return;
                        default:
                            return;
                    }

                }
            }


        }

    }
    //save Item

    //find Item
    public static void findItem(){
        Scanner input = new Scanner(System.in);
        System.out.println("Inset Code");
        String code= input.nextLine();

        for (int i = 0; i < item.length ; i++) {
            if (item[i][0] != null){
                if (item[i][0].equals(code)){
                    System.out.println("=======================Item=====================");
                    System.out.println("Code : "+item[i][0]);
                    System.out.println("Name : "+item[i][1]);
                    System.out.println("Description : "+item[i][2]);
                    System.out.println("QtyOnHand : "+item[i][3]);
                    System.out.println("UnitPrice : "+item[i][4]);
                    System.out.println("=======================Item=====================");
                    return;
                }
            }

        }
        System.out.println("Item Not Found");
    }

    //find Item

    //Update Item
    public static void updateItem(){
        Scanner input = new Scanner(System.in);
        System.out.println("Inset code to Find the customer");
        String code= input.nextLine();

        for (int i = 0; i < item.length ; i++) {
            if (item[i][0]!=null){
                if (item[i][0].equals(code)){

                    //========Update
                    String newName,newDescription;
                    int newQtyOnHand;
                    double newUnitPrice;

                    System.out.println("Inset Item Name");
                    newName = input.nextLine();
                    System.out.println("Inset Item Address");
                    newDescription = input.nextLine();
                    System.out.println("Inset Item Salary");
                    newQtyOnHand= input.nextInt();
                    System.out.println("Inset Item Salary");
                    newUnitPrice= input.nextDouble();
                    //========Update
                    item[i][1]=newName;
                    item[i][2]=newDescription;
                    item[i][3]=String.valueOf(newQtyOnHand);
                    item[i][4]=String.valueOf(newUnitPrice);
                    System.out.println("Item Update!");
                    return;
                }
            }

        }
        System.out.println(" Item Not Found!");

    }
    //Update Item

    //Delete Item
    public static void deleteItem(){
        Scanner input = new Scanner(System.in);
        System.out.println("Inset CODE to Find the item");
        String nic= input.nextLine();
        for (int i = 0; i < item.length; i++) {
            if (item[i][0]!=null) {
                if (item[i][0].equals(nic)) {
                    item[i][0]=null;
                    item[i][1]=null;
                    item[i][2]=null;
                    item[i][3]=null;
                    item[i][4]=null;
                    System.out.println("Delete Item!");
                    return;

                }

            }
        }
        System.out.println(" Item Not Found!");


    }

    //Delete Item

    //Find All Item
    public static void printAllItem(){
        for (int i = 0; i < item.length; i++) {
            if (item[i][0] != null){
                System.out.println("Code: "+item[i][0]+"\tName: "+item[i][1]+"\tDescription: "+item[i][2]+"\tQtyOnHand: "+item[i][3]+"\tUnitPrice : "+item[i][4]);
            }else {
                return;
            }


        }

    }
    //Find All Item


    //Item Management>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Item Management

    //Order Management>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Order Management

    public static void pleceNewOrder(){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert Customer Nic");
        String nic = input.nextLine();


        String name,address;
        double salary;

        //================================ Customer find ===================================
        for (int i = 0; i < customer.length ; i++) {
            if (customer[i][0]!=null){
                if (customer[i][0].equals(nic)){
                    System.out.println("=======================Customer=====================");
                 name = customer[i][1];
                 address =  customer[i][2];
                 salary = Double.parseDouble(customer[i][3]); // [String <<= Double]
                    System.out.println("=======================Customer=====================");

                }
            }

        }
        //================================ Customer find ===================================

        //================================ Item find ===================================
        System.out.println("Insert Item Code");
        String code = input.nextLine();

        String description;
        int qtyOnHand;
        double unitPrice=0;

        for (int i = 0; i < item.length ; i++) {
            if (item[i][0]!=null){
                if (item[i][0].equals(code)){
                    System.out.println("=======================Item=====================1");
                    description = item[i][2];
                    qtyOnHand = Integer.parseInt(item[i][3]); // [String <<= Integer]
                    unitPrice = Double.parseDouble (item[i][4]); // [String <<= Double]
                    System.out.println("=======================Item=====================2");

                }
            }
            //Orders =================================
            System.out.println("Insert Order code");
            String orderId = input.nextLine();

            for (int j = 0; j < orders.length; j++) {
                if (orders[i][0]!=null){
                    if (orders[i][0].equals(orderId)){
                        System.out.println("Order Id exists");
                        return;
                    }else {
                        Date date = new Date();
                        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                        String selectedDate = f.format(date);
                        orders[i][0]=orderId;
                        orders[i][1]=nic;
                        orders[i][2]=code;
                        orders[i][3]=selectedDate;
                        orders[i][4]=String.valueOf(unitPrice);

                    }
                }
                
            }
            System.out.println("Order Completed!");
            return;


            //Orders =================================
        }

        //================================ Item find ===================================


    }
    
    

    //Order Management>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Order Management

    //Dashboard process

    public static void printUi(String position) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss") ;

        String simpleDate = dateFormat.format(date);
        String simpleTime = timeFormat.format(date);

        System.out.println("==============="+simpleDate+"==============="+simpleTime+"=======>"+position);
        //System.out.println("================================@System====================================");
    }
}
