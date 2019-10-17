package com.example.abcdef;


import com.example.abcdef.repository.UsuarioRepository;
import io.r2dbc.mssql.MssqlConnectionConfiguration;
import io.r2dbc.mssql.MssqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;
import org.springframework.stereotype.Component;

@SpringBootApplication

public class AbcdefApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcdefApplication.class, args);
	}



}

@Component
class DataLoader {
	private final UsuarioRepository repo;

	DataLoader(UsuarioRepository repo) {
		this.repo = repo;
	}
}


	@Configuration
	class DatabaseConfig {
	@Bean
	public MssqlConnectionFactory connectionFactory() {
		return new MssqlConnectionFactory(MssqlConnectionConfiguration.builder()
			.host("prueb1sql.database.windows.net")
			.database("prueba1")
			.username("prueba1user@prueb1sql")
			.password("Suzuka123%")
			.build());
	}

		@Bean
		DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
			return DatabaseClient.builder()
				.connectionFactory(connectionFactory)
				.build();
		}

		@Bean
		R2dbcRepositoryFactory repositoryFactory(DatabaseClient client) {
			RelationalMappingContext context = new RelationalMappingContext();
			context.afterPropertiesSet();

			return new R2dbcRepositoryFactory(client, context);
		}

		@Bean
		UsuarioRepository usuarioRepository(R2dbcRepositoryFactory factory) {
			return factory.getRepository(UsuarioRepository.class);
		}
}

