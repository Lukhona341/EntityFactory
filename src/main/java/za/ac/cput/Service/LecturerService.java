package za.ac.cput.Service;
/*
Description:  Lecturer service class
Author: Lukhona Tetyana
Student number: 218119321
Date: 02 August 2021

 */

import za.ac.cput.Entity.Lecturer;
import za.ac.cput.Repository.LecturerRepository;

import java.util.Set;

public class LecturerService implements ILecturerService {
    private static LecturerService service = null;
    private LecturerRepository repository = null;

    private LecturerService() {
        this.repository = LecturerRepository.getRepository();
    }

    public static LecturerService getService() {
        if (service == null) {
            service = new LecturerService();
        }
        return service;
    }


    @Override
    public Lecturer create(Lecturer lecturer) {
        return this.repository.create(lecturer);
    }


    @Override
    public Lecturer read(String lecturerId) { return this.repository.read(lecturerId);
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        return this.repository.update(lecturer);
    }

    @Override
    public boolean delete(String lecturerCode) {
        return this.repository.delete(lecturerCode);
    }

    @Override
    public Set<Lecturer> getAll() {
        return this.repository.getAll();
    }
}