package org.springframework.samples.petclinic.pet.pettype;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/pettypes")
public class PetTypeController {

	PetTypeService petTypeService;

	public PetTypeController(PetTypeService petTypeService) {
		this.petTypeService = petTypeService;
	}

	@GetMapping
	public ResponseEntity<Object> getAllPetTypes() {
		List<PetType> petTypeList = petTypeService.getAllPetTypes();
		if (petTypeList == null || petTypeList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(petTypeList);
		}
	}

	@GetMapping("/{petTypeId}")
	public EntityModel<PetType> getPetType(@PathVariable int petTypeId) {
		Optional<PetType> petType = petTypeService.findById(petTypeId);
		if(petType.isEmpty()) {
			throw new ResourceNotFoundException("Resource unavailable");
		}
		return EntityModel.of(petType.get(),
			linkTo(methodOn(PetTypeController.class).getAllPetTypes()).withRel("all-pets"),
			linkTo(methodOn(PetTypeController.class).deletePetType(petTypeId)).withRel("delete")
		);
	}

	@PostMapping()
	public ResponseEntity<PetType> createPetType(@RequestBody PetType petTypeDto) {
		PetType petType = petTypeService.createPetType(petTypeDto);
		return ResponseEntity.status(201).body(petType);
	}

	@DeleteMapping("/{petTypeId}")
	public ResponseEntity<Map<String, String>> deletePetType(@PathVariable int petTypeId) {
		petTypeService.deletePetType(petTypeId);
		return ResponseEntity.ok(Map.of("message", "Record deleted successfully"));
	}

	@PutMapping("/{petTypeId}")
	public ResponseEntity<PetType> updatePetType(@RequestBody PetType petTypeDto) {
		PetType petType = petTypeService.updatePetType(petTypeDto);
		return ResponseEntity.status(201).body(petType);
	}
}
