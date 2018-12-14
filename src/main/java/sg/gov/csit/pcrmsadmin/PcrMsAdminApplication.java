package sg.gov.csit.pcrmsadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PcrMsAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcrMsAdminApplication.class, args);
	}

}
