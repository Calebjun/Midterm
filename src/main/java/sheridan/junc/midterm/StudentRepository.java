package sheridan.junc.midterm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByEmail(@Param("email") String email);
    List<Student> findByNameContainingIgnoreCase(@Param("name") String name);
    List<Student> findByGpaGreaterThan(@Param("gpa") Double gpa);
    List<Student> findByGpaLessThan(@Param("gpa") Double gpa);
    List<Student> findByGpaBetween(@Param("min") Double min, @Param("max") Double max);
}
