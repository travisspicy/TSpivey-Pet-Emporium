package com.catalyte.petemorapi.repositories;

import com.catalyte.petemorapi.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    @Query("{'employeeId':?0}")
    List<Employee> findByEmployeeId (String employeeId);
    @Query("{'_id':?0}")
    Optional<Employee> findById (String _id);
    @Query("{'firstName':?0}")
    List<Employee> findByFirstName (String firstName);
    @Query("{'lastName':?0}")
    List<Employee> findByLastName (String lastName);
    @Query("{'adminRole':?0}")
    List<Employee> findByRole (String adminRole);
    @Query("{'salary':?0}")
    List<Employee> findBySalary (String salary);

}
