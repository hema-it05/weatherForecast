package weatherimplementation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import weatherimplementation.entity.LocationDetails;

@Repository
public interface LocationDetailsRepository extends JpaRepository<LocationDetails, String>{
	
	LocationDetails findByCityName(String cityName);

}
