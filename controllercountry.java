package com.example.country;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/country")
public class CountryController {

    private static final Map<String, Country> countryMap = new HashMap<>();

    static {
        countryMap.put("IN", new Country("IN", "India", "New Delhi", 1400000000));
        countryMap.put("US", new Country("US", "United States", "Washington D.C.", 331000000));
        countryMap.put("JP", new Country("JP", "Japan", "Tokyo", 126000000));
    }

    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        Country country = countryMap.get(code.toUpperCase());
        if (country != null) {
            return country;
        } else {
            // Return default object or throw exception
            return new Country(code.toUpperCase(), "Unknown", "Unknown", 0);
        }
    }
}
