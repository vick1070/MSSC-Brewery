package com.springframework.MSSCbrewery.service;

import com.springframework.MSSCbrewery.web.model.BeerDTO;

import java.util.UUID;
import java.util.List;

public interface BeerService {

    List<BeerDTO> getBeers();

    BeerDTO getBeerById(int beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    void updateBeer(int beerId, BeerDTO beerDTO);

    void deleteByBeer(int beerId);
}
