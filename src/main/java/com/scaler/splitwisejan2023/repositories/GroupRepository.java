package com.scaler.splitwisejan2023.repositories;

import com.scaler.splitwisejan2023.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Optional<Group> findById(Long id);

    // Optional<Group>



//    List<Group> findAllByParticipantsContaining(List<User> users);
    // select * from groups
    // where participants in ()

}
