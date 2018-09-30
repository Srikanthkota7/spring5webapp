package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepo;
import guru.springframework.spring5webapp.repositories.BookRepo;
import guru.springframework.spring5webapp.repositories.PublisherRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DevBootStrapApplication implements ApplicationListener<ContextRefreshedEvent> {


    private PublisherRepo publisherRepo;
    private BookRepo bookRepo;
    private AuthorRepo authorRepo;

    public DevBootStrapApplication(PublisherRepo publisherRepo, BookRepo bookRepo, AuthorRepo authorRepo) {
        this.publisherRepo = publisherRepo;
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher pub1 = new Publisher("Tenenbaum");
        Publisher pub2 = new Publisher("Tenenbaum2");

        publisherRepo.save(pub1);
        publisherRepo.save(pub2);

        Author a1 = new Author("RR","TolkinOs");
        Author a2 = new Author("RR2","Tolkins2");

        authorRepo.save(a1);
        authorRepo.save(a2);

        Book b1 = new Book("title1","isbn1",pub1);
        Book b2 = new Book("title2","isbn2",pub2);
        Book b3 = new Book("title3","isbn3",pub2);

        Set<Author> s1 = new HashSet<>();
        s1.add(a1);
        b1.setAuthors(s1);

        Set<Author> s2 = new HashSet<>();
        s2.add(a2);
        b2.setAuthors(s2);

        Set<Author> s3 = new HashSet<>();
        s3.add(a1);
        b3.setAuthors(s3);


        bookRepo.save(b1);
        bookRepo.save(b2);
        bookRepo.save(b3);

    }
}
