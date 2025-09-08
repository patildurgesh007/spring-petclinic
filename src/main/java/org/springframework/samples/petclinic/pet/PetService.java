package org.springframework.samples.petclinic.pet;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.pet.petattribute.PetAttribute;
import org.springframework.samples.petclinic.pet.petattribute.PetAttributeService;
import org.springframework.samples.petclinic.pet.pettype.PetType;
import org.springframework.samples.petclinic.pet.pettype.PetTypeRepository;
import org.springframework.samples.petclinic.petproperty.PetPropertyService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
public class PetService {

	private final OwnerRepository ownerRepository;

	private final PetTypeRepository typeRepository;

	private final PetAttributeService petAttributeService;

	private final PetPropertyService propertyService;

	public PetService(OwnerRepository ownerRepository, PetTypeRepository typeRepository,
					  PetAttributeService petAttributeService, PetPropertyService propertyService) {
		this.ownerRepository = ownerRepository;
		this.typeRepository = typeRepository;
		this.petAttributeService = petAttributeService;
		this.propertyService = propertyService;
	}

	/**
	 * Updates the pet details if it exists or adds a new pet to the owner.
	 * @param owner The owner of the pet
	 * @param pet The pet with updated details
	 */
	public void updatePetDetails(Owner owner, Pet pet) {
		Pet existingPet = owner.getPet(pet.getId());
		System.out.println(pet.getAttribute().toString());
		if (existingPet != null) {
			PetAttribute petAttribute = existingPet.getAttribute();
			// Update existing pet's properties
			existingPet.setName(pet.getName());
			existingPet.setBirthDate(pet.getBirthDate());
			existingPet.setType(pet.getType());
			petAttributeService.mapAttributes(petAttribute, pet.getAttribute());
			petAttributeService.save(petAttribute);
		}
		else {
			petAttributeService.save(pet.getAttribute());
			owner.addPet(pet);
		}
		this.ownerRepository.save(owner);
	}

	public Collection<PetType> findPetTypes() {
		return typeRepository.findPetTypes();
	}

	public Optional<Owner> findById(int ownerId) {
		return ownerRepository.findById(ownerId);
	}

	public void save(Owner owner) {
		ownerRepository.save(owner);
	}

	public void savePetAttributes(Pet pet) {
		PetAttribute attribute = pet.getAttribute();
		attribute.setPet(pet);
		petAttributeService.save(attribute);
	}

	public void validateBirthDate(Pet pet, BindingResult result) {
		LocalDate currentDate = LocalDate.now();
		if (pet.getBirthDate() != null && pet.getBirthDate().isAfter(currentDate)) {
			result.rejectValue("birthDate", "typeMismatch.birthDate");
		}
	}

	public void validateAttributes(Pet pet, BindingResult result) {
		int maxWeight = Integer.parseInt(
			propertyService.getProperty("pet.attribute.weight")
		);
		if(pet.getAttribute().getWeight() > maxWeight || pet.getAttribute().getWeight() <=0){
			result.rejectValue("birthDate", "weight.rangeExceed");
		}
		int maxHeight = Integer.parseInt(
			propertyService.getProperty("pet.attribute.height")
		);
		if(pet.getAttribute().getHeight() > maxHeight || pet.getAttribute().getHeight() <=0){
			result.rejectValue("birthDate", "height.rangeExceed");
		}
	}

}
