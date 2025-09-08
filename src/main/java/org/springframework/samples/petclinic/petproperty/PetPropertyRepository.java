package org.springframework.samples.petclinic.petproperty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetPropertyRepository extends JpaRepository<PetProperty, Long> {
	Optional<PetProperty> findByPropertyKey(String propertyKey);
}
