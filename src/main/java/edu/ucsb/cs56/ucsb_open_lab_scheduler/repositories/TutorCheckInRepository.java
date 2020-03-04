package edu.ucsb.cs56.ucsb_open_lab_scheduler.repositories;

import java.util.List;

import edu.ucsb.cs56.ucsb_open_lab_scheduler.entities.TutorCheckIn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorCheckInRepository extends CrudRepository<TutorCheckIn, Long> {
    public List<TutorCheckIn> findById(String Id);
}