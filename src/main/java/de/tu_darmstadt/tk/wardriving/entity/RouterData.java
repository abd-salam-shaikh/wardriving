/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tu_darmstadt.tk.wardriving.entity;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author abd_salam_shaikh
 */
@Entity
public class RouterData {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    /** The point in time when the signal was received */
	//@Temporal(TemporalType.TIMESTAMP)
	private Instant timestamp;
	
	/** The location where the signal was received */
	@NotNull
	private Location location;
        
        /** The mac address of the wireless access point */
	@NotNull
	private String bssid;

    public RouterData() {
    }

    public RouterData(Long id, Instant timestamp, Location location, String bssid) {
        this.id = id;
        this.timestamp = timestamp;
        this.location = location;
        this.bssid = bssid;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the timestamp
     */
    public Instant getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return the bssid
     */
    public String getBssid() {
        return bssid;
    }

    /**
     * @param bssid the bssid to set
     */
    public void setBssid(String bssid) {
        this.bssid = bssid;
    }
        
        
}
