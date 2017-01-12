package de.tu_darmstadt.tk.wardriving.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a raw signal as received from the wardriving android app.
 */
@Entity
public class RawSignal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/** The point in time when the signal was received */
	//@Temporal(TemporalType.TIMESTAMP)
	private Instant timestamp;
	
	/** The location where the signal was received */
	@NotNull
	private Location location;
	
	/** The accuracy of the provided location in meters */
	@JsonProperty("location_accuracy")
	private float locationAccuracy;
	
	/** The mac address of the wireless access point */
	@NotNull
	private String bssid;
	
	/** Received signal strength indicator */
	private int rssi;
	
	public RawSignal() {
	}
	
	public RawSignal(Instant timestamp, Location location, float locationAccuracy, String bssid, int rssi) {
		this.timestamp = timestamp;
		this.location = location;
		this.locationAccuracy = locationAccuracy;
		this.bssid = bssid;
		this.rssi = rssi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public float getLocationAccuracy() {
		return locationAccuracy;
	}

	public void setLocationAccuracy(float locationAccuracy) {
		this.locationAccuracy = locationAccuracy;
	}

	public String getBssid() {
		return bssid;
	}

	public void setBssid(String bssid) {
		this.bssid = bssid;
	}

	public int getRssi() {
		return rssi;
	}

	public void setRssi(int rssi) {
		this.rssi = rssi;
	}
	
}
