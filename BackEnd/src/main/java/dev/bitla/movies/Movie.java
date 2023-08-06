package dev.bitla.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data // this handles getters, setters, and toString methods for all the private vars below.
@AllArgsConstructor // An annotation for creating a constructor that takes all
// private variables below as arguments.
@NoArgsConstructor // An annotation for creating a constructor that takes no private variables
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference // This will make the database store only the IDs of the review, and the
    // review itself would be stored in a separate collection.
    // This is known as Manual Reference Relationship
    private List<Review> reviewIds; // this is an embedded relationship
    // All reviews' id related to a specific movie will be stored in here.
}
