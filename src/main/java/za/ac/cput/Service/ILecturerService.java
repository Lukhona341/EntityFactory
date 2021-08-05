package za.ac.cput.Service;
/*
Description: Interface Lecturer service class
Author: Lukhona Tetyana
Student number: 218119321
Date: 02 August 2021

 */



import za.ac.cput.Entity.Lecturer;
import java.util.Set;

public interface ILecturerService extends IService<Lecturer,String>{
    public Set<Lecturer> getAll();
}
