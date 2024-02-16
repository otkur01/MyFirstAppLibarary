import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        dataGenerator.creatUser();
        System.out.println("welcome to MX bank, please enter your userId and password");
        Scanner scanner = new Scanner(System.in);
        System.out.println("plea se en you user id");
        String userid = scanner.next();
        System.out.println("plea se en you user password");
        String userPassword = scanner.next();
        boolean ismenber = false;
        String[] displayInfo = {"withdraw", "deposit", "balance check", "transfer", "exit"};
        while (true) {
            int userNum = 0;
            if (dataBase.ACOUNT.containsKey(userid) && dataBase.ACOUNT.get(userid).equals(userPassword)) {
                System.out.println("there yout acount details ");
                for (User user : dataBase.USER_LIST) {
                    if (user.getUserId().equals(userid)) {
                        System.out.println(user);
                        userNum = dataBase.USER_LIST.indexOf(user);
                    }
                }
                User user = dataBase.USER_LIST.get(userNum);
                System.out.println("witch action do  you want, press the action number");
                for (int i = 0; i < displayInfo.length; i++) {
                    System.out.println(i + " ." + displayInfo[i] + ": ");
                }
                int action = scanner.nextInt();
                switch (action) {
                    case 0:
                        double newbalance = dataBase.USER_LIST.get(userNum).withdraw();
                        dataBase.USER_LIST.get(userNum).setBalance(newbalance);
                        System.out.println("your new balance is: " + user.getBalance());
                        break;
                    case 1:
                        double newDPbalance = dataBase.USER_LIST.get(userNum).deposit();
                        dataBase.USER_LIST.get(userNum).setBalance(newDPbalance);
                        System.out.println(" your new balance is: " + user.getBalance());
                        break;
                    case 2:
                        System.out.println("your new balance is: " + user.balanceCheck());
                        break;
                    case 3:
                        System.out.println("plese enter user id that you want to transfer to it:");
                        String trName = scanner.next();
                        int userNum1 = 0;
                        for (User user1 : dataBase.USER_LIST) {
                            if (user1.getUserId().equals(trName)) {
                                System.out.println(user1);
                                userNum1 = dataBase.USER_LIST.indexOf(user1);
                            }
                        }
                        dataBase.USER_LIST.get(userNum).setBalance(dataBase.USER_LIST.get(userNum).withdraw());
                        dataBase.USER_LIST.get(userNum1).setBalance(dataBase.USER_LIST.get(userNum).deposit());
                        System.out.println("your new balance is " + user.getBalance());
                        break;
                    default:
                        System.exit(0);
                }

                System.out.println();
            } else {
                System.out.println("you are not user of our bank, do you want to join us ? if you want press Y , press N for exit");
                String awnser = scanner.next();
                if (awnser.toLowerCase().equals("y")) {


                } else {
                    System.out.println("thank for your trying , goode bye");
                    System.exit(0);
                }
            }

        }
    }


}