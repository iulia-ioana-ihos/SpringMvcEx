package com.evozon.repository;

import com.evozon.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserStoreUtil {

    public static List<User> readAll() {
        List<User> users = new ArrayList<>();
        try (Scanner reader = new Scanner(new File("users.txt"))){
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] userData = line.split(" ");
                if(userData.length < 5)
                    continue;
                User user = new User();
                user.setFirstName(userData[0]);
                user.setLastName(userData[1]);
                user.setAge(Integer.parseInt(userData[2]));
                user.setUsername(userData[3]);
                user.setPassword(userData[4]);
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void writeUser(User user) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt",true));)
        {
            String line = user.getFirstName() + " "
                    + user.getLastName() + " "
                    + user.getAge() + " "
                    + user.getUsername() + " "
                    + user.getPassword();
            bw.write(line);
            bw.newLine();
        }
        catch (IOException ex) {
            System.out.println("error");
            ex.printStackTrace();
        }
    }
}
