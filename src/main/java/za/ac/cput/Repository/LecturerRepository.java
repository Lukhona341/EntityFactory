package za.ac.cput.Repository;

import za.ac.cput.Entity.Lecturer;
import java.util.HashSet;
import java.util.Set;

public class LecturerRepository implements ILecturerRepository {
 private static LecturerRepository  repository = null;
 private Set<Lecturer> lecturerDB = null;

 private LecturerRepository(){
     lecturerDB = new HashSet<Lecturer>();
 }

 public static LecturerRepository getRepository(){
     if (repository == null){
         repository = new LecturerRepository();
     }
     return repository;
 }

    @Override
    public Lecturer create(Lecturer lecturer) {
     boolean created = lecturerDB.add(lecturer);
     if(!created)
        return null;
        return lecturer;
    }

    @Override
    public Lecturer read(String lectureID) {
       for (Lecturer l : lecturerDB)
           if (l.getLecturerId().equals(lectureID)){
               return l;
           }
        return null;
    }


    @Override
    public Lecturer update(Lecturer lecturer) {
     Lecturer oldLecturer = read(lecturer.getFirstname());
     if(oldLecturer!=null){
         lecturerDB.remove(oldLecturer);
         lecturerDB.add(lecturer);
         return lecturer;
     }
        return null;
    }

    @Override
    public boolean delete(String Firstname) {
     Lecturer lecturerToDelete = read(Firstname);
     if(lecturerToDelete == null)
        return false;
     lecturerDB.remove(lecturerToDelete);
     return true;
    }

    @Override
    public Set<Lecturer> getAll() {
        return lecturerDB;
    }
}
