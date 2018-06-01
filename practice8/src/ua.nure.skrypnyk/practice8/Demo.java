package ua.nure.skrypnyk.practice8;

import java.util.List;

import ua.nure.skrypnyk.practice8.db.DBManager;
import ua.nure.skrypnyk.practice8.db.entity.Group;
import ua.nure.skrypnyk.practice8.db.entity.User;
public class Demo {
    DBManager dbManager = DBManager.getInstance();





//        private static <T> void printList(List<T> list) {
//            for (T element : list) {
//                System.out.println(element);
//            }
//        }
//
//        public static void main(String[] args) {
//            // users  ==> [ivanov]
//            // groups ==> [teamA]
//
//            DBManager dbManager = DBManager.getInstance();
//
//            // Part 1
//            dbManager.insertUser(User.createUser("petrov"));
//            dbManager.insertUser(User.createUser("obama"));
//            printList(dbManager.findAllUsers());
//            // users  ==> [ivanov, petrov, obama]
//
//            System.out.println("===========================");
//
//        }
//
//    }
}
