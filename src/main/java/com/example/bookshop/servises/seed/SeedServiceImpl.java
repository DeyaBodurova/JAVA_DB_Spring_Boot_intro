package com.example.bookshop.servises.seed;

import com.example.bookshop.servises.book.BookService;
import com.example.bookshop.servises.category.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class SeedServiceImpl implements SeedService {
    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;

    public SeedServiceImpl(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (!this.authorService.isDataSeeded()) {
            this.authorService
                    .seedAuthors(Files.readAllLines(Path.of(RESOURCE_URL + AUTHOR_FILE_NAME))
                            .stream()
                            .filter(s -> !s.isBlank())
                            .map(firstAndLastName -> Author.builder()
                                    .firstName(firstAndLastName.split(" ")[0])
                                    .lastName(firstAndLastName.split(" ")[1])
                                    .build())
                            .collect(Collectors.toList()));
        }
    }

    @Override
    public void seedBooks() throws IOException {
        final List<Book> books = Files.readAllLines(Path.of(RESOURCE_URL + BOOK_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(row -> {
                    String[] data = row.split("\\s+");
                    String title = Arrays.stream(data)
                            .skip(5)
                            .collect(Collectors.joining(" "));

                    return Book.builder()
                            .title(title)
                            .editionType(EditionType.values()[Integer.parseInt(data[0])])
                            .price(new BigDecimal(data[3]))
                            .releaseDate(LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy")))
                            .ageRestriction(AgeRestriction.values()[Integer.parseInt(data[4])])
                            .author(this.authorService.getRandomAuthor())
                            .categories(this.categoryService.getRandomCategories())
                            .copies(Integer.parseInt(data[2]))
                            .build();

                })
                .collect(Collectors.toList());

        this.bookService.seedBooks(books);
    }

    @Override
    public void seedCategory() throws IOException {
        if (!this.categoryService.isDataSeeded()) {
            this.categoryService.seedCategories(Files.readAllLines(Path.of(RESOURCE_URL + CATEGORY_FILE_NAME))
                    .stream()
                    .filter(s -> !s.isBlank())
                    .map(name -> Category.builder()
                            .name(name)
                            .build())
                    .collect(Collectors.toList()));
        }
    }
}