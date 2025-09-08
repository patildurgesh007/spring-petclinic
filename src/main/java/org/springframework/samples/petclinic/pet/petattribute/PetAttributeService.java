package org.springframework.samples.petclinic.pet.petattribute;

import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetAttributeService {

	private final PetAttributeRepository petAttributeRepository;

	public PetAttributeService(PetAttributeRepository petAttributeRepository) {
		this.petAttributeRepository = petAttributeRepository;
	}

	/**
	 * Map assign updated attributes to existing pet.
	 * @param oldAttributes
	 * @param newAttributes
	 */
	public void mapAttributes(PetAttribute oldAttributes, PetAttribute newAttributes) {
		oldAttributes.setWeight(newAttributes.getWeight());
		oldAttributes.setTemperament(newAttributes.getTemperament());
		oldAttributes.setGender(newAttributes.getGender());
		oldAttributes.setHeight(newAttributes.getHeight());
	}

	/**
	 * Save Pet Attributes
	 * @param petAttribute
	 */
	public void save(PetAttribute petAttribute) {
		this.petAttributeRepository.save(petAttribute);
	}

	/**
	 * Pull Pet Attributes By Pet ID
	 * @param petId
	 * @return
	 */
	public PetAttribute getAttributesByPetId(int petId) {
		return petAttributeRepository.getByPetId(petId);
	}

	/**
	 * Remove pet attributes only if Orphan.
	 * Will throw DataIntegrityViolation exception if case attribute is linked to any Pet
	 * @param petId
	 */
	public void deletePetAttribute(int petId) {
		PetAttribute petAttributeToDelete = petAttributeRepository.getByPetId(petId);
		petAttributeRepository.delete(petAttributeToDelete);
	}
}
