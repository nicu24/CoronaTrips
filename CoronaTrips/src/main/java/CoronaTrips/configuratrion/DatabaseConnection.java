package CoronaTrips.configuratrion;

import org.springframework.context.annotation.Configuration;


@Configuration
public class DatabaseConnection  {
//    @Override
//    @Bean
//    public ConnectionFactory connectionFactory(){
//        ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
//                        .option(ConnectionFactoryOptions.HOST, "localhost")
//                        .option(ConnectionFactoryOptions.PORT, 5432)
//                        .option(ConnectionFactoryOptions.DATABASE, "DreamTrip")
//                        .option(ConnectionFactoryOptions.USER, "postgres")
//                        .option(ConnectionFactoryOptions.PASSWORD, "22ww33")
//                        .build();
//
//        return ConnectionFactories.get(options);
//    }
//
//    @Bean
//    public DatabaseClient databaseClient(@Qualifier("connectionFactory") ConnectionFactory connectionFactory){
//        return DatabaseClient.builder().connectionFactory(connectionFactory).build();
//    }
}
