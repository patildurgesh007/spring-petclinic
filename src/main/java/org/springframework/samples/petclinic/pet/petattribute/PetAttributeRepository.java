package org.springframework.samples.petclinic.pet.petattribute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetAttributeRepository extends JpaRepository<PetAttribute, Integer> {

	PetAttribute getByPetId(int petId);

}
