package za.ac.cput.Repository;
/*
Description:  Lecturer Repository Test class
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
class LecturerRepositoryTest {
    private static LecturerRepository repository= LecturerRepository.getRepository();
    private static Lecturer lecturer= LecturerFactory.createLecturer("hezel", "Hanjiwe","1258");
    @Test
    @Order(1)
    void create() {
        Lecturer create = repository.create(lecturer);
        assertEquals(create.getLecturerId(), lecturer.getLecturerId());
        System.out.println("Created: " + create);
    }

    @Test
    @Order(2)
    void read() {
        Lecturer read = repository.read(lecturer.getLecturerId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        Lecturer updated = new Lecturer.Builder().copy(lecturer).setSurname("Tetyana").build();
        System.out.println("Updated: " + updated);
        assertNotNull(updated);
    }

    @Test
    @Order(4)
    void delete() {
        boolean delete = repository.delete(lecturer.getLecturerId());
        assertTrue(delete);
        System.out.println("Deleted: " + delete);
    }

    @Test
    @Order(5)
    void getAll() {

        System.out.println("Display All: ");
        System.out.println(repository.getAll());
    }
}