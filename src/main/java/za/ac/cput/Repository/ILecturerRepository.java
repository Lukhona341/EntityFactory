package za.ac.cput.Repository;
import za.ac.cput.Entity.Lecturer;

import java.util.Set;

public interface ILecturerRepository extends IRepository<Lecturer,String>{
    public Set<Lecturer> getAll();
}
