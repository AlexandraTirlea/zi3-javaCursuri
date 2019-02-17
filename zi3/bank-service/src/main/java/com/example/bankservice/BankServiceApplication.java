package com.example.bankservice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bankservice.business_object.Client;
import com.example.bankservice.business_object.FileClientRepository;
import com.example.bankservice.business_object.ClientService;

@SpringBootApplication
public class BankServiceApplication {//implements ApplicationRunner {

	
	@Autowired
	private ClientService clientService;
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(BankServiceApplication.class, args);
		
		
		//testing();
	
	}

	private static void testing() throws IOException {
		FileClientRepository clientRep=new FileClientRepository();
		System.out.println(clientRep.getAllClient());
		
		System.out.println(clientRep.getClient(1L));
		
		Client client=new Client(1L,"Calin","calin@gmail.com","0833333",LocalDate.parse("1990-05-06"),true);
		Client client2=new Client(null,"Ionel","ionel@gmail.com","0833333",LocalDate.parse("1990-05-06"),true);
		//clientRep.
		
		clientRep.writeClientsFile(Collections.singletonList(client));
		
		System.out.println(clientRep.getAllClient());
		System.out.println("\n--------------------------------");
		System.out.println(clientRep.createClient(client2));
		
		//clientRep.deleteClient(1L);
		Client client55=new Client(1L,"Lulu","lulu@gmail.com","911",LocalDate.parse("1990-09-06"),false);
		clientRep.updateClient(client55);
		System.out.println(clientRep.getAllClient());
		
		//-------------------pana aici a fost Repository
		
		
		//SErvice
		ClientService clientService=new ClientService(clientRep);
		clientService.deleteClient(1L);
	}

	/*@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(clientService.getClient(2L));
		
	}
*/
}

