package dao;

import model.Author;

import java.util.List;
import java.util.Map;

public interface AuthorDAO {
    List<Author> getAuthors();
    Map<String, Integer> getAmountOfAuthorBooks();
    Map<String, String> getInfoAboutAuthors();
}
