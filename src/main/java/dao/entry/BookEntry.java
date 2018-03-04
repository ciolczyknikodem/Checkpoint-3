package dao.entry;

public enum BookEntry {
    Books("Books"),
    ISBN("ISBN"),
    author("author"),
    title("title"),
    publisher("publisher"),
    publication_year("publication_year"),
    price("price"),
    type("type"),
    booksAmount("booksAmount");

    private String columnName;

    BookEntry(String name) {
        this.columnName = name;

    }

    public String getColumnName() {
        return columnName;
    }
}