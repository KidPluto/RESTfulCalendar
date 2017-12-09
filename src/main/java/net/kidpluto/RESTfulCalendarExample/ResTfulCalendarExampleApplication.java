package net.kidpluto.RESTfulCalendarExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResTfulCalendarExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResTfulCalendarExampleApplication.class, args);

		GetCalendar getCal = new GetCalendar();
		getCal.getCalendar("Hello");
	}
}
