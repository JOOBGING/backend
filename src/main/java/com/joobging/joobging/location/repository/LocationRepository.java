package com.joobging.joobging.location.repository;

import com.joobging.joobging.location.domain.Location;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
    @Override
    List<Location> findAll();
}
