package cern.pori.spring.repository;

import cern.pori.spring.model.SpringCampusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringCampusJpaRepository extends JpaRepository<SpringCampusEntity, Long> {
    // Spring Data JPA will automatically implement basic CRUD operations
    // We can add custom query methods here if needed
}
