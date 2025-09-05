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

	public void mapAttributes(PetAttribute oldAttributes, PetAttribute newAttributes) {
		oldAttributes.setWeight(newAttributes.getWeight());
		oldAttributes.setTemperament(newAttributes.getTemperament());
		oldAttributes.setGender(newAttributes.getGender());
		oldAttributes.setHeight(newAttributes.getHeight());
	}

	public void save(PetAttribute petAttribute) {
		this.petAttributeRepository.save(petAttribute);
	}

	public PetAttribute getAttributesByPetId(int petId) {
		return petAttributeRepository.getByPetId(petId);
	}

	public void deletePetAttribute(int petId) {
		PetAttribute petAttributeToDelete = petAttributeRepository.getByPetId(petId);
		petAttributeRepository.delete(petAttributeToDelete);
	}

	public List<PetAttribute> getAll(int petId) {
		return petAttributeRepository.findAll();
	}

}
