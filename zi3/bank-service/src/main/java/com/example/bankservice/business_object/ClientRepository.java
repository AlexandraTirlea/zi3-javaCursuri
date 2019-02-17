package com.example.bankservice.business_object;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ClientRepository {
	public void deleteClient(Long id) throws IOException;
	public void updateClient(Client client)throws IOException ;
	public List<Client> createClient(Client client) throws IOException;
	public Optional<Client> getClient(Long id) throws IOException;
	public List<Client>getAllClient()throws IOException ;
}
