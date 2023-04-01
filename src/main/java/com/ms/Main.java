package com.ms;

import com.ms.entity.Employee;
import com.ms.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        Employee employee = createEmployee();
        User user = createUser();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(employee);
//        entityManager.persist(user);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }


    private static Employee createEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Mojo");
        employee.setLastName("Senyonjo");
        return employee;
    }

    private static User createUser() {
        return new User("Mo", "mo@gmail.com", "password", "0791234567", "1 Parkway Drive", " London", "A7 7NY");
    }
}
