package fi.heiniola.bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.heiniola.bookstore.domain.Book;
import fi.heiniola.bookstore.domain.BookRepository;
import fi.heiniola.bookstore.domain.Category;
import fi.heiniola.bookstore.domain.CategoryRepository;
import fi.heiniola.bookstore.domain.User;
import fi.heiniola.bookstore.domain.UserRepository;



@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository Repository, CategoryRepository cRepository, UserRepository urepository) {
		return (args) -> {
			System.out.println("save a couple");
			
			cRepository.save(new Category("detective"));
			cRepository.save(new Category("document"));
			
			Repository.save(new Book("93939", "Tekijä", "Teos", 2000, 87.5, cRepository.findByName("detective").get(0)));
			Repository.save(new Book("93939", "Tekijä", "Teos", 2000, 87.8, cRepository.findByName("detective").get(0)));
			Repository.save(new Book("93939", "Tekijä", "Teos", 2000, 87.9, cRepository.findByName("detective").get(0)));
			Repository.save(new Book("93939", "Tekijä", "Teos", 2000, 87.0, cRepository.findByName("detective").get(0)));
			Repository.save(new Book("93939", "Tekijä", "Teos", 2000, 87.9, cRepository.findByName("detective").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			System.out.println("fetch all categories"); 
			for (Category category : cRepository.findAll()) {
				System.out.println(category.getName());
			}
	};
	
}
}

