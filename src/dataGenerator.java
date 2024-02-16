import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class dataGenerator {
    public static void creatUser(){
        User user = new User("Hekim", "3050", LocalDate.of(1986,8,3), 10000.0);
        User user1 = new User("alim", "3050", LocalDate.of(1986,8,3), 10000.0);
        User user2 = new User("alim", "0001", LocalDate.of(1986,8,3), 10000.0);
        dataBase.USER_LIST.add(user1);
        dataBase.USER_LIST.add(user);
        dataBase.USER_LIST.add(user2);
        for (User eachUser : dataBase.USER_LIST) {
            dataBase.ACOUNT.put(eachUser.getUserId(),eachUser.getUserPW());
        }


    }

}
