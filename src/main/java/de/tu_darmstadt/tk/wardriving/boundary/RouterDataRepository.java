/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tu_darmstadt.tk.wardriving.boundary;

import de.tu_darmstadt.tk.wardriving.entity.RouterData;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author abd_salam_shaikh
 */

public interface RouterDataRepository extends JpaRepository<RouterData, Long> {

	List<RouterData> findByBssid(String bssid);
	
	@Query("SELECT * FROM RouterData rd")
	Set<String> getRouterData();
	
}