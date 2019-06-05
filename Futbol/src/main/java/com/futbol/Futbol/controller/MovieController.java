package com.futbol.Futbol.controller;

import com.futbol.Futbol.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @GetMapping("")
    public Movie getMovie() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.themoviedb.org/3/movie/329996?api_key=8d7db92be0746d3da167842d227f2f64&language=en-US", Movie.class);
    }
}
