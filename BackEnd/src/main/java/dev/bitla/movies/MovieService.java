package dev.bitla.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired // This will let the framework know that
    // we want the framework to instantiate this class.
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        return movieRepository.findAll(); // findAll is described in the MongoRepository interface.
    }

//    public Optional<Movie> getMovie(ObjectId id) {
//        // We have to let Java know that it may return null if it doesn't find the movie.
//        // This is why we use the Optional package which will return null if a movie doesnt exist.
//        return movieRepository.findById(id);
//    }

    public Optional<Movie> getMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
