package com.houserentalservice.property;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin
public class PropertyController {

    private final PropertyRepository propertyRepository;

    public PropertyController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @GetMapping
    public ResponseEntity<?> searchProperties(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String minPrice,
            @RequestParam(required = false) String maxPrice,
            @RequestParam(required = false) String bedrooms
    ) {
        try {
            BigDecimal minPriceDecimal = minPrice != null && !minPrice.isEmpty() 
                ? new BigDecimal(minPrice) : null;
            BigDecimal maxPriceDecimal = maxPrice != null && !maxPrice.isEmpty() 
                ? new BigDecimal(maxPrice) : null;
            Integer bedroomsInt = bedrooms != null && !bedrooms.isEmpty() 
                ? Integer.parseInt(bedrooms) : null;

            List<Property> properties = propertyRepository.searchProperties(
                city, minPriceDecimal, maxPriceDecimal, bedroomsInt
            );

            return ResponseEntity.ok(properties);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Failed to search properties: " + e.getMessage());
            return ResponseEntity.status(500).body(error);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPropertyById(@PathVariable Long id) {
        return propertyRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createProperty(@RequestBody Property property) {
        try {
            // Set defaults
            if (property.getAvailable() == null) {
                property.setAvailable(true);
            }
            if (property.getFurnished() == null) {
                property.setFurnished(false);
            }
            if (property.getCountry() == null || property.getCountry().isEmpty()) {
                property.setCountry("India");
            }
            
            Property savedProperty = propertyRepository.save(property);
            return ResponseEntity.status(201).body(savedProperty);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Failed to create property: " + e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }
}
