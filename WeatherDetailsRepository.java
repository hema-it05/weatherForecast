package weatherimplementation.repository;

import java.util.Date;
import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import weatherimplementation.entity.WeatherDetails;

public interface WeatherDetailsRepository extends JpaRepository<WeatherDetails, String>{
	
	List<WeatherDetails> findByDateOfWeatherBetween(Date from,Date to);
	
	List<WeatherDetails> findByDateOfWeatherIn(List<Date> dates);

}
