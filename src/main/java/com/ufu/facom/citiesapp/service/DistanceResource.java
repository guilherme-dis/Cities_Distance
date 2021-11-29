package com.ufu.facom.citiesapp.service;

import com.ufu.facom.citiesapp.cities.entities.City;
import com.ufu.facom.citiesapp.cities.repositories.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
public class DistanceResource {

    private final DistanceService service;
    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    public DistanceResource(DistanceService service) {

        this.service = service;
    }

    @GetMapping("/by-points")
    public Double byPoints(@RequestParam(name = "from") final Long city1,
                           @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return service.distanceByPointsInMiles(city1, city2);
    }

    @GetMapping("/by-cube")
    public Double byCube(@RequestParam(name = "from") final String city1,
                         @RequestParam(name = "to") final String city2) {
        log.info("byCube");
        Long c1=service.findByName(city1);
        Long c2=service.findByName(city2);
        return service.distanceByCubeInMeters(c1, c2);
    }

    @GetMapping(value = "/search-name")
    public Long foundIdByName(@RequestParam(defaultValue = "") String name) {
        log.info("Search by name");
        return service.findByName(name);
    }


}