package com.example.bankservice.business_object;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import net.bytebuddy.asm.Advice.Local;

@Component
public class FileClientRepository implements ClientRepository{

	//public List<Client> listaClienti=new ArrayList<>();
	private static final String databaseFile="test_copy.csv";
	Path path= Paths.get(databaseFile); 
	
	public List<Client>getAllClient() throws IOException{
		
			return Files.lines(Paths.get(databaseFile))
			.map(line->{
				return getClient(line);
			}).collect(Collectors.toList());
		
		
	}
	
	
	
	private Client getClient(String line) {
		String[] fields =line.split(",");
		Client client=new Client();
		client.setId(Long.parseLong(fields[0]));
		client.setName(fields[1]);
		client.setEmail(fields[2]);
		client.setPhoneNumber(fields[3]);
		String[] dateFields=fields[4].split("-");
		LocalDate dateOfBirth =LocalDate.of(
				Integer.parseInt(dateFields[2]), 
				Integer.parseInt(dateFields[1]), 
				Integer.parseInt(dateFields[0]));
		client.setDateOfBirth(dateOfBirth);
		
		client.setActive(Boolean.parseBoolean(fields[5]));
		
		return client;
	}
	
	
	public Optional<Client> getClient(Long id) throws IOException {
		return getAllClient().stream()
				.filter(s->s.getId() == id)
				.findFirst();
	

	}
	
	//metodacare primeste o colectie de clienti si suprascrie in fisierul csv
	public void writeClientsFile(Collection<Client> clients) throws IOException
	{
		String clientsString=
		clients
		.stream()
		.map(client -> {
			return getClientRow(client);
		}).collect(Collectors.joining("\n"));
		Files.deleteIfExists(Paths.get(databaseFile));
		Files.write(Paths.get(databaseFile), 
				clientsString.getBytes(), 
				StandardOpenOption.CREATE_NEW);
		//Files.write(Paths.get(first, more), bytes, options)
	}
	
	
private String getClientRow(Client client) {
	DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-YYYY");
	return client.getId()+","+client.getName()+","
						+client.getEmail()+","+client.getPhoneNumber()+","+
						formatter.format(client.getDateOfBirth())+","+client.getActive();
}

//metoda create primeste un ob de tip Client (ma folosesc de apelul getClients()
public List<Client> createClient(Client client) throws IOException{
	List<Client> allClients= new ArrayList<>(getAllClient());
	client.setId(allClients.size()+1L);
	allClients.add(client);
	writeClientsFile(allClients);
	
	return getAllClient()
			.stream()
			.collect(Collectors.toList());
		 
}

public void deleteClient(Long id) throws IOException {
	List<Client> clients=getAllClient().stream().filter(s->s.getId() !=id).collect(Collectors.toList());
	writeClientsFile(clients);
	
}


public void updateClient(Client client) throws IOException {
	List<Client> clienti= getAllClient();
	
	Optional<Client>clientOptional=clienti
			.stream()
			.filter(s->s.getId()==client.getId())
			.findFirst();
	
	if(clientOptional.isPresent()) {
		Client oldClient=clientOptional.get();
		oldClient.setName(client.getName());
		oldClient.setEmail(client.getEmail());
		oldClient.setPhoneNumber(client.getPhoneNumber());
		oldClient.setDateOfBirth(client.getDateOfBirth());
		oldClient.setActive(client.getActive());
		
		writeClientsFile(clienti);
	}
	else
		System.out.println("Nu exista clientul cu acest id!!");
}





}
