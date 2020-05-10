package com.springframework.MSSCbrewery.web.controller;

import com.springframework.MSSCbrewery.web.model.BeerDTO;
import com.springframework.MSSCbrewery.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;
import java.util.List;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/"}) // get beers
    public ResponseEntity<List<BeerDTO>> getBeers(){
        return new ResponseEntity<List<BeerDTO>>(beerService.getBeers(), HttpStatus.OK);
    }

    @GetMapping({"/{beerId}"})  //Get beer
    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") int beerId){
        // more control to return ResponseEntity
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping                //Post a new beer
    public ResponseEntity handlePost(@Valid @RequestBody BeerDTO beerDTO){
        BeerDTO saveDTO = beerService.saveNewBeer(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        //location of the resource todo HOSTNAME URL
        headers.add("Location", "/api/v1/beer/" + saveDTO.getId());
        //client knows the resource created
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})  //Update beer
    public ResponseEntity handleUpdate(@PathVariable("beerId") int beerId, @Valid @RequestBody BeerDTO beerDTO){
        beerService.updateBeer(beerId, beerDTO);
        // returning response
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})   //Delete beer
    @ResponseStatus(HttpStatus.NO_CONTENT)   //response body using this annotation
    public void deleteBeer(@PathVariable("beerId") int beerId){
        beerService.deleteByBeer(beerId);
    }
}
