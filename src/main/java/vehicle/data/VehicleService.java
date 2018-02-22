package vehicle.data;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	 
	
 
	public Vehicle save(Vehicle vehicle) {
		if (vehicle.getId() != null && vehicleRepository.exists(vehicle.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
 
		return vehicleRepository.save(vehicle);
	}
 
	public Vehicle update(Vehicle vehicle) {
		if (vehicle.getId() != null && !vehicleRepository.exists((long) vehicle.getId())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}
 
		return vehicleRepository.save(vehicle);
	}
 
	public List<Vehicle> findAllVehicles() {
		return vehicleRepository.findAll();
	}
 
	public Vehicle findOne(Long id) {
		return vehicleRepository.findOne(id);
	}
	
	public Vehicle findByVin(String vin) {
		return vehicleRepository.findByVin(vin);
	}
	
	public void delete(Long id) {
		vehicleRepository.delete(id);
	}
}
