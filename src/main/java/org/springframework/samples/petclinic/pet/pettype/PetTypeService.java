package org.springframework.samples.petclinic.pet.pettype;

import org.springframework.samples.petclinic.exception.RecordAlreadyExistsException;
import org.springframework.samples.petclinic.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetTypeService {

	PetTypeRepository typeRepository;

	public PetTypeService(PetTypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}

	/**
	 * Get all Pet Types
	 * @return
	 */
	public List<PetType> getAllPetTypes() {
		return typeRepository.findPetTypes();
	}

	/**
	 * Return Optional PetType by it Pet Type ID
	 * @param petTypeId
	 * @return
	 */
	public Optional<PetType> findById(int petTypeId) {
		return typeRepository.findById(petTypeId);
	}

	/**
	 * Create new Pet Type
	 * Throw RecordAlreadyExistsException in case Pet type with same name exist
	 * @param petTypeDto
	 * @return
	 */
	public PetType createPetType(PetType petTypeDto) {
		Optional<PetType> existingPetType =  typeRepository.findByName(petTypeDto.getName());
		if(existingPetType.isPresent()){
			throw new RecordAlreadyExistsException("Pet Type" + petTypeDto.getName() + " already exists into the Table");
		}
		return typeRepository.save(petTypeDto);
	}

	/**
	 * Update Pet Type
	 * @param petTypeDto
	 * @return
	 */
	public PetType updatePetType(PetType petTypeDto) {
		return typeRepository.save(petTypeDto);
	}

	/**
	 * This method deletes PetType by its ID
	 * Exception is handled globally
	 * @param petTypeId
	 */
	public void deletePetType(int petTypeId) {
		Optional<PetType> petTypeToDelete = typeRepository.findById(petTypeId);
		if(petTypeToDelete.isEmpty()){
			throw new ResourceNotFoundException("PetType with id " + petTypeId + " not found");
		}
		typeRepository.delete(petTypeToDelete.get());
	}

}
