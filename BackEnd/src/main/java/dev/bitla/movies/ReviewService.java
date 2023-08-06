package dev.bitla.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate; // template is another way to communicate with the database.
    // if you have an operation that's so complex, it cannot be within a repo., or even if it is
    // implemented within a repo., it's not feasible. A template, on the other hand, can be used
    // to form up a new dynamic query and do the job inside the database without using the repo.
    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));
//        Review review = new Review();
//        reviewRepository.insert(review);
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first(); // this ensures that we're updating only a single movie.
        // we are pushing the review to the specific movie's reviewIds where the imdbId of the movie
        // matches the imdbId of what the user inputted (see params).
        return review;
    }
}
