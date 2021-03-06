package edu.ucsb.cs56.ucsb_open_lab_scheduler.repositories;

import edu.ucsb.cs56.ucsb_open_lab_scheduler.entities.RoomAvailability;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomAvailabilityRepository extends CrudRepository<RoomAvailability, Long> {
    RoomAvailability findById(long id);
    List<RoomAvailability> findByQuarter(String quarter);
}