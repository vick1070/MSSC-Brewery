package com.springframework.MSSCbrewery.service;

import com.springframework.MSSCbrewery.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public List<BeerDTO> getBeers() {
        List result = new ArrayList<BeerDTO>();

        BeerDTO b1 = BeerDTO.builder().id(1)
                    .beerName("Galaxy Cat")
                    .beerStyle("Pale Ale")
                    .build();
        BeerDTO b2 = BeerDTO.builder().id(2)
                    .beerName("London Fog")
                    .beerStyle("Double Indian Pale Ale")
                    .build();
        BeerDTO b3 = BeerDTO.builder().id(3)
                    .beerName("Brooklyn Lager")
                    .beerStyle("Lager")
                    .build();
        BeerDTO b4 = BeerDTO.builder().id(4)
                        .beerName("Corona")
                        .beerStyle("Lager")
                        .build();

        result.add(b1);
        result.add(b2);
        result.add(b3);
        result.add(b4);
        return result;
    }

    @Override
    public BeerDTO getBeerById(int beerId) {
        if(beerId == 1) {
            return BeerDTO.builder().id(1)
                    .beerName("Galaxy Cat")
                    .beerStyle("Pale Ale")
                    .build();
        }
        else if(beerId == 2){
            return BeerDTO.builder().id(2)
                    .beerName("London Fog")
                    .beerStyle("Double Indian Pale Ale")
                    .build();
        }
        else if(beerId == 3){
            return BeerDTO.builder().id(3)
                    .beerName("Brooklyn Lager")
                    .beerStyle("Lager")
                    .build();
        }
        else if(beerId == 4){
            return BeerDTO.builder().id(4)
                    .beerName("Corona")
                    .beerStyle("Lager")
                    .build();
        }
        else{
            return BeerDTO.builder().id(2)
                    .beerName("London Fog")
                    .beerStyle("Pale Ale")
                    .build();
        }
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
        return BeerDTO.builder()
                /* TODO CHANGE UUID*/
                .id(10)
                .build();
    }

    @Override
    public void updateBeer(int beerId, BeerDTO beerDTO) {
        //TODO imlplementation ...
    }

    @Override
    public void deleteByBeer(int beerId) {
        log.debug("deleting beer");
    }
}
