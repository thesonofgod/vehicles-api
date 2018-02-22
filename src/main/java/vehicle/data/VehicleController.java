package vehicle.data;

import java.net.URI;
import java.net.URISyntaxException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// This Means That this class is a controller
@RestController
@RequestMapping(path="/api")
public class VehicleController {

	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	private VehicleService vehicleService;
		
	// Get Data from Database
		// Get All Vehicles
			@GetMapping(path="/vehicle")
			public @ResponseBody Iterable<Vehicle> getAllVehicles() {
					//This Returns a JSON or XML with the vehicles
				return vehicleService.findAllVehicles();
			}
		// Get Vehicles by Vin number
			@RequestMapping(value = "/vehicle/{vin}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
			public Vehicle getVehicle(@PathVariable String vin) {
				return vehicleService.findByVin(vin);
			}
			
			// Post Data to Database
			@RequestMapping(value = "/vehicle", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) throws URISyntaxException {
				try {
					Vehicle result = vehicleService.save(vehicle);
					return ResponseEntity.created(new URI("/vehicle/add" + result.getId())).body(result);
					} catch (EntityExistsException e) {
					return new ResponseEntity<Vehicle>(HttpStatus.CONFLICT);
					}
			}
		
				// Delete Data From Database
			@RequestMapping(value = "/vehicle/{id}", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
				vehicleService.delete(id);
				return ResponseEntity.ok().build();
			}
				// Update data on Database
		@RequestMapping(value = "/vehicle", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle) throws URISyntaxException {
		 	if (vehicle.getId() == null) {
		 		return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);			
		 	}
		 		try {
		 			Vehicle result = vehicleService.update(vehicle);
		 			return ResponseEntity.created(new URI("/api/vehicle/" + result.getId())).body(result); 			
		 			}	catch (EntityNotFoundException e) {
		 					return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
		 				}
		}
}
			
			
			

