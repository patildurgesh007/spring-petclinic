package org.springframework.samples.petclinic.pet.petattribute;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/pets/{petId}/attributes")
public class PetAttributeController {

	PetAttributeService petAttributeService;

	public PetAttributeController(PetAttributeService petAttributeService) {
		this.petAttributeService = petAttributeService;
	}

	@GetMapping
	public ResponseEntity<PetAttribute> getPetAttributes(@PathVariable int petId) {
		PetAttribute attributes = petAttributeService.getAttributesByPetId(petId);
		if (attributes == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(attributes);
		}
	}

	@PutMapping
	public ResponseEntity<PetAttribute> updatePetAttributes(@PathVariable int petId,
			@RequestBody PetAttribute requestAttribute) {
		PetAttribute existingAttributes = petAttributeService.getAttributesByPetId(petId);
		if (existingAttributes == null) {
			petAttributeService.save(requestAttribute);
			return ResponseEntity.ok(requestAttribute);
		}
		else {
			petAttributeService.mapAttributes(existingAttributes, requestAttribute);
			petAttributeService.save(existingAttributes);
			return ResponseEntity.ok(existingAttributes);
		}
	}

	@DeleteMapping
	public ResponseEntity<Map<String, String>> deletePetAttributes(@PathVariable int petId) {
		petAttributeService.deletePetAttribute(petId);
		return ResponseEntity.ok(Map.of("message", "Record deleted successfully"));
	}

}
