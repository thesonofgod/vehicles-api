package vehicle.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called vehicleRepository
//CRUD refers Create, Read, Update, Delete

public interface VehicleRepository extends JpaRepository<Vehicle, Long>, VinRepository<Vehicle, String> {

}
