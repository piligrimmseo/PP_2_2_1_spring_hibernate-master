package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user = new User("Сидоров", "Петр", "petrovivan@gmail.com");
        Car car = new Car("BMW", 538);
        user.setCar(car);
        car.setUser(user);
        userService.add(user);

        User userTwo = new User("Петров", "Сидр", "petrovsidr@gmail.com");
        Car carTwo = new Car("Audi", 6);
        userTwo.setCar(carTwo);
        carTwo.setUser(userTwo);
        userService.add(userTwo);

        User userThree = new User("Кириллов", "Сергей", "kirillov@gmail.com");
        Car carThree = new Car("Mersedes", 200);
        userThree.setCar(carThree);
        carThree.setUser(userThree);
        userService.add(userThree);

        User userFour = new User("Глебов", "Иван", "glebovgleb@gmail.com");
        Car carFour = new Car("Vaz", 2105);
        userFour.setCar(carFour);
        carFour.setUser(userFour);
        userService.add(userFour);

        List<User> users = userService.listUsers();
        for (User person : users) {
            System.out.println("Id = " + person.getId());
            System.out.println("First Name = " + person.getFirstName());
            System.out.println("Last Name = " + person.getLastName());
            System.out.println("Email = " + person.getEmail());
            System.out.println();
        }

        System.out.println(userService.readUserByCar("BMW", 538));

        context.close();
    }
}
