package pl.koszolko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.koszolko.book.review.BookReviewApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BookReviewApplication.class)
@WebAppConfiguration
public class BookReviewApplicationTests {

	@Test
	public void contextLoads() {
	}

}
