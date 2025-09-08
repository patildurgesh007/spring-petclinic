package org.springframework.samples.petclinic.petproperty;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PetPropertyService {

	private final PetPropertyRepository repository;
	private final Map<String, String> cache = new ConcurrentHashMap<>();

	public PetPropertyService(PetPropertyRepository repository) {
		this.repository = repository;
		loadCache();
	}

	@PostConstruct
	public void loadCache() {
		repository.findAll().forEach(p -> cache.put(p.getPropertyKey(), p.getPropertyValue()));
	}

	public String getProperty(String key) {
		return cache.get(key);
	}

	// Optional: refresh cache on demand
	public void refreshCache() {
		cache.clear();
		loadCache();
	}
}
