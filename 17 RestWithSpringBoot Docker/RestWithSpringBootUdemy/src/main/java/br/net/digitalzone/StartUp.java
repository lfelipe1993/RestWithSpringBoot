package br.net.digitalzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import br.net.digitalzone.config.FileStorageConfig;

@EnableConfigurationProperties({
	FileStorageConfig.class
	})
@SpringBootApplication
@EnableAutoConfiguration // application content do spring seja automaticamente carregado
@ComponentScan //usada para dizer ao springboot que ele deve scanear os arquivo de configuracao (como webconfig)
public class StartUp {

	public static void main(String[] args) {
		SpringApplication.run(StartUp.class, args);
		
		/*BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
		String result = bCryptPasswordEncoder.encode("admin123");
		
		System.out.println("My Hash" + result);*/
	}

}
