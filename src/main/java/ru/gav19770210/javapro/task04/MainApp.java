package ru.gav19770210.javapro.task04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/*
- Разверните локально postgresql БД, создайте таблицу users (id bigserial primary key, username varchar(255) unique);
- Создайте Maven проект и подключите к нему: драйвер postgresql, hickaricp, spring context.
- Создайте пул соединений в виде Spring бина
- Создайте класс User (Long id, String username)
- Реализуйте в виде бина класс UserDao который позволяет выполнять CRUD операции над пользователями
- Реализуйте в виде бина UserService, который позволяет: создавать, удалять, получать одного, получать всех пользователей из базы данных
- Создайте Spring Context, получите из него бин UserService и выполните все возможные операции
 */
@Configuration
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.gav19770210.javapro.task04");

        UserService userService = context.getBean(UserService.class);

        System.out.println("getAllUsers:");
        System.out.println(userService.getAllUsers());

        System.out.println("find jo");
        User user = userService.getUserDao().findByName("jo").orElse(null);
        System.out.println(user);

        if (Objects.isNull(user)) {
            System.out.println("add jo");
            user = new User();
            user.setName("jo");
            user = userService.createUser(user);
            System.out.println(user);
        } else {
            System.out.println("update jo");
            user.setName("jo2");
            user = userService.updateUser(user);
            System.out.println(user);

            System.out.println("getAllUsers:");
            System.out.println(userService.getAllUsers());

            System.out.println("delete jo");
            userService.deleteUserById(user.getId());
        }
        System.out.println("getAllUsers:");
        System.out.println(userService.getAllUsers());

        System.out.println("find bob");
        User user2 = userService.getUserDao().findByName("bob").orElse(null);
        System.out.println(user2);

        if (!Objects.isNull(user2)) {
            System.out.println("get bob");
            user2 = userService.getUserById(user2.getId());
            if (user2 != null)
                System.out.println(user2);
        }
    }
}
