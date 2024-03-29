package com.example.sisterslabapi.controller;

import com.example.sisterslabapi.dto.request.movie.CreateMovieRequest;
import com.example.sisterslabapi.dto.request.movie.UpdateMovieRequest;
import com.example.sisterslabapi.dto.response.movie.CreateMovieResponse;
import com.example.sisterslabapi.dto.response.movie.GetMovieResponse;
import com.example.sisterslabapi.dto.response.movie.UpdateMovieResponse;
import com.example.sisterslabapi.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService service;

    @GetMapping("/All")
    public ResponseEntity<List<GetMovieResponse>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetMovieResponse> get(@PathVariable Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateMovieResponse> create(@RequestBody CreateMovieRequest request) {
        return new ResponseEntity<>(service.createMovie(request), HttpStatus.CREATED);
    }

    @GetMapping("AvgRating/{id}")
    public ResponseEntity<Double> getAvgRating(@PathVariable Long id) {
        return new ResponseEntity<>(service.getAverageRating(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UpdateMovieResponse> update(@RequestBody UpdateMovieRequest request) {
        return new ResponseEntity<>(service.updateMovie(request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("MoviesByCategoryName/{name}")
    public ResponseEntity<List<GetMovieResponse>> getCategoryById(@PathVariable String name) {
        return new ResponseEntity<>(service.getAllMovieByCategoryName(name), HttpStatus.OK);
    }

}
