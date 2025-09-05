package org.springframework.samples.petclinic.pet.petattribute;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Gender;
import org.springframework.samples.petclinic.pet.Pet;

@Entity
@Table(name = "attributes")
public class PetAttribute extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "pet_id", nullable = false, unique = true)
	@JsonBackReference
	private Pet pet;

	@Column(name = "temperament")
	String temperament;

	@Column(name = "weight")
	int weight;

	@Column(name = "height")
	int height;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	Gender gender;

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public String getTemperament() {
		return temperament;
	}

	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "PetAttribute{" + "pet=" + pet + ", temperament='" + temperament + '\'' + ", weight=" + weight
				+ ", height=" + height + ", gender=" + gender + '}';
	}

}
