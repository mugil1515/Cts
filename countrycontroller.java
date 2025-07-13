package com.example.country;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CountryController {

    // Hardcoded single country
    @GetMapping("/country")
    public Country getCountry() {
        return new Country("India", "New Delhi", 1400000000);
    }

    // List of countries
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return Arrays.asList(
            new Country("India", "New Delhi", 1400000000),
            new Country("USA", "Washington D.C.", 331000000),
            new Country("Japan", "Tokyo", 126000000)
        );
    }

    // Get country by name (dummy logic)
    @GetMapping("/country/{name}")
    public Country getCountryByName(@PathVariable String name) {
        if (name.equalsIgnoreCase("india")) {
            return new Country("India", "New Delhi", 1400000000);
        } else if (name.equalsIgnoreCase("usa")) {
            return new Country("USA", "Washington D.C.", 331000000);
        } else {
            return new Country("Unknown", "Unknown", 0);
        }
    }
}
