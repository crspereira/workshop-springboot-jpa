package com.claytonpereira.springproject01.config;

import com.claytonpereira.springproject01.entities.Category;
import com.claytonpereira.springproject01.entities.Order;
import com.claytonpereira.springproject01.entities.Product;
import com.claytonpereira.springproject01.entities.User;
import com.claytonpereira.springproject01.entities.enuns.OrderStatus;
import com.claytonpereira.springproject01.repositories.CategoryRepository;
import com.claytonpereira.springproject01.repositories.OrderRepository;
import com.claytonpereira.springproject01.repositories.ProductRepository;
import com.claytonpereira.springproject01.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	//Injecao de dependencia do framework com @Autowired
	//@Autowired
	// 1. declaracao da dependecia
	private final UserRepository userRepository;
	private final OrderRepository orderRepository;
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	
	//Injecao de dependencia por construtor
	// 2. injecao da dependencia
	TesteConfig(UserRepository userRepository, OrderRepository orderRepository,
				CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository =productRepository;
	}
	
	@Override //comandLineRunner method
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENY,u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENY,u1);

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}

}
