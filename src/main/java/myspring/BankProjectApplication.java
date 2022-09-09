package myspring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.sun.media.sound.ModelMappedInstrument;
@EntityScan
@SpringBootApplication
public class BankProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankProjectApplication.class, args);
	}
	
	
	@Bean//יצור מופע ממה שהפונקציה מחזירה בהתאם לצורך ויזריק את המופע במקומות המתאימים//IoC Container//זה אומר ש//bean //כאשר פונקציה מוגדרת כ
	public ModelMapper getMapper()
	{
		return new ModelMapper();
	}

}
