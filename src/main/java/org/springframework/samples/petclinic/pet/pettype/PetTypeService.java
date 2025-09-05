package org.springframework.samples.petclinic.pet.pettype;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetTypeService {

	PetTypeRepository typeRepository;

	public PetTypeService(PetTypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}

	public List<PetType> getAllPetTypes() {
		return typeRepository.findPetTypes();
	}

	public Optional<PetType> findById(int petTypeId) {
		return typeRepository.findById(petTypeId);
	}

	public PetType createPetType(PetType petTypeDto) {
		return typeRepository.save(petTypeDto);
	}

	public PetType updatePetType(PetType petTypeDto) {
		return typeRepository.save(petTypeDto);
	}

	public void deletePetType(int petTypeId) {
		typeRepository.deleteById(petTypeId);
	}

}
