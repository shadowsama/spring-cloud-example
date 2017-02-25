package pl.koszolko.book.gateway.service.catalog;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

@Component
public class CatalogService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "stubBook")
    public Observable<Book> getBook(long id) {
        return Observable.just(invokeBookCatalog(id));
    }

    private Book invokeBookCatalog(long id) {
        return restTemplate.getForObject("http://catalog-service/catalog/books/{id}", Book.class, id);
    }

    private Book stubBook(long id) {
        return Book.builder()
                .id(id)
                .title("Fake book title")
                .description("This is stub book")
                .build();
    }
}
