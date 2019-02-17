package com.example.bankservice.business_object;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class ClientService {
   private FileClientRepository repository;
   
  
   public ClientService(FileClientRepository repository) {
	super();
	this.repository = repository;
}

public void deleteClient(Long id) throws IOException {
	   repository.getClient(id).ifPresent(client->{
		   if(!client.getActive()) {
			   try {
				repository.deleteClient(id);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		   }
	   });
	  
   }

public Client getClient(Long id) throws ClientNotFoundException, IOException {
	return repository.getClient(id)
	    .orElseThrow(() -> new ClientNotFoundException(id));
}
}
