package webservices1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import webservices1.entities.Field;

public interface FieldRepository extends JpaRepository<Field, Long> {

}
