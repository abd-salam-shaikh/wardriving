package de.tu_darmstadt.tk.wardriving.boundary;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import de.tu_darmstadt.tk.wardriving.entity.RawSignal;

public interface RawSignalRepository extends JpaRepository<RawSignal, Long> {

	List<RawSignal> findByBssid(String bssid);
	
	@Query("SELECT DISTINCT(rs.bssid) FROM RawSignal rs")
	Set<String> getKnownAccessPoints();
	
}
