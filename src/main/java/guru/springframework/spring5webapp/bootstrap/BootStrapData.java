package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author sandi = new Author("Sandi", "Kurtin");
        Book harryPotter = new Book("Harry Potter", "111111");
        sandi.getBooks().add(harryPotter);
        harryPotter.getAuthors().add(sandi);

        authorRepository.save(sandi);
        bookRepository.save(harryPotter);

        Author miha = new  Author("Miha", "Mazzini");
        Book clipper = new  Book("Clipper od a do z", "2222222" );
        miha.getBooks().add(clipper);
        clipper.getAuthors().add(miha);

        authorRepository.save(miha);
        bookRepository.save(clipper);


        System.out.println("Starting bootstrap...");
        System.out.println("Število knjig je " + bookRepository.count());
    }
}
