import java.time.LocalDate;
import java.util.Scanner;

public class User {
    private String userId;
    private String userPW;
    private LocalDate birthYear;

    private Double Balance;

    public User(String userId, String userPW, LocalDate birthYear, Double balance) {
       setUserId(userId);
       setUserPW(userPW);
        setBirthYear(birthYear);
        setBalance(balance);
    }

    public User(String userId, String userPW, Double balance) {
        setUserId(userId);
        setUserPW(userPW);
        setBalance(balance);
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPW() {
        return userPW;
    }

    public LocalDate getBirthYear() {
        return birthYear;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setUserId(String userId) {
        if(userId.isEmpty()|| userId.length()>8){
            throw new RuntimeException("invalid user id");
        }
        this.userId = userId;
    }

    public void setUserPW(String userPW) {
        for (char c : userPW.toCharArray()) {
            if(!(c<=9 || c>=0)){
                throw new RuntimeException("invalid user password");
            }
        }
        if(userPW.length()!=4){
            throw new RuntimeException("invalid user password");
        }
        
        this.userPW = userPW;
    }

    public void setBirthYear(LocalDate birthYear) {
        if(LocalDate.now().getYear()-birthYear.getYear()<18){
            throw new RuntimeException("age can not be small than 18");
        }
        this.birthYear = birthYear;
    }

    public void setBalance(Double balance) {
       if(balance<0){
           throw new RuntimeException("balance can not be negative ");
       }
        Balance = balance;
    }

    public  double withdraw(){
        System.out.println("please enter amount that you want withdraw");
        Scanner scanner = new Scanner(System.in);
        double withdraw = scanner.nextDouble();
        if(getBalance()<withdraw){
            try {
                throw new Exception("can not withdraw more than balance");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
       return getBalance()-withdraw;


    }
    public  double deposit(){
        System.out.println("please enter amount that you want deposit it");
        Scanner scanner = new Scanner(System.in);
        double deposit = scanner.nextDouble();
       return getBalance()+deposit;



    }
    public double balanceCheck(){
        return getBalance();
    }


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPW='" + userPW + '\'' +
                ", birthYear=" + birthYear +
                ", Balance=" + Balance +
                '}';
    }
}
