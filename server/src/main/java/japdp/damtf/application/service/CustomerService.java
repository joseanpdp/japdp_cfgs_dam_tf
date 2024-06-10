package japdp.damtf.application.service;

import java.util.List;

import japdp.damtf.application.dto.request.CustomerRequest;
import japdp.damtf.application.dto.response.CustomerResponse;

/**
 * La interfaz CustomerService declara métodos para realizar operaciones relacionadas
 * con los clientes, como obtener todos los clientes, obtener un cliente por su identificador
 * o por su nombre y apellido, crear, actualizar y eliminar un cliente.
 */
public interface CustomerService {

	public List<CustomerResponse> getAll();

	public CustomerResponse getById(long id);

	public CustomerResponse getByNameAndSurname(String name, String surname);

	public CustomerResponse create(CustomerRequest customerRequest);

	public CustomerResponse update(long id, CustomerRequest customerRequest);

	public void delete(long id);

}
