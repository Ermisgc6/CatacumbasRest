package pe.idat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CatacumbasRestApplication //implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(CatacumbasRestApplication.class, args);
	}
	
	
	/*@Override
	public void run(String... args) throws Exception {
		
		BCryptPasswordEncoder bCript = new BCryptPasswordEncoder();
		
		System.out.println("n1234: " + bCript.encode("n1234"));
		System.out.println("h1234: " + bCript.encode("h1234"));
		System.out.println("l1234: " + bCript.encode("l1234"));

		
		
	}*/
	
	

}
