package vehicle.data;

import org.springframework.data.jpa.repository.Query;

public interface VinRepository<Vehicle, String> {

	// Custom Method 
	@Query(value="SELECT * FROM vehicles WHERE vin=?1", nativeQuery = true)
	public Vehicle findByVin(String vin);
}
