package za.ac.cput.Service;
/*
Description:  Lecturer Service Test Class
Author: Lukhona Tetyana
Student number: 218119321
Date: 02 August 2021

 */


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Lecturer;
import za.ac.cput.Factory.LecturerFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class LecturerServiceTest {
    private static LecturerService service = LecturerService.getService();
    private static Lecturer lecturer = LecturerFactory.createLecturer("Asiphiwe", "Hanjiwe", "1258");

    @Test
    @Order(1)
    void create() {
        Lecturer created = service.create(lecturer);
        assertEquals(created.getLecturerId(), lecturer.getLecturerId());
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void read() {
        Lecturer read = service.read(lecturer.getLecturerId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        Lecturer updated = new Lecturer.Builder().copy(lecturer).setSurname("Lukhona").build();
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    void delete() {
        boolean deleted = service.delete(lecturer.getLecturerId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("Show All: ");
        System.out.println(service.getAll());
    }
}