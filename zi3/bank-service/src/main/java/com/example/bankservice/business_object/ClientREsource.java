package com.example.bankservice.business_object;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController    //e doar o componenta si ea
@RequestMapping("clients")  //tot ce e jos se aplica automat
public class ClientREsource {
    private ClientService clientService;
    private ClientRepository clientRepository;

	public ClientREsource(ClientService clientService,ClientRepository clientRepository) {
		this.clientService = clientService;
		this.clientRepository = clientRepository;
		
	}
    
	 @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public  ResponseEntity<Client>getClient(@PathVariable("id")Long id) throws ClientNotFoundException, IOException {
    	return ResponseEntity.ok(clientService.getClient(id));
    }
    
	 
	 @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	 public ResponseEntity<Void> deleteClient(@PathVariable("id")Long id) throws IOException{
		 clientRepository.deleteClient(id);
		 return new ResponseEntity<Void>(HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/{id}",method=RequestMethod.POST)
	 public ResponseEntity<Void> createClient(Client client) throws IOException{
		 clientRepository.createClient(client);
			 return new ResponseEntity<Void>(HttpStatus.OK);
		 
	 }
	 
	 @RequestMapping(value="/",method=RequestMethod.GET)
	    public  ResponseEntity<List<Client>>getClient() throws ClientNotFoundException, IOException {
	    	return ResponseEntity.ok(clientRepository.getAllClient());
	    }
   
	 
}
