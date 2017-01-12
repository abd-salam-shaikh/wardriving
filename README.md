# Wardriving server

You need maven to build the wardriving server. While in development you can run the server
by invoking

    mvn spring-boot:run

You can access the server under <code>http://localhost:8080/</code>.

## Import data

To import data to the server database from the Android wardring app you can POST data to
<code>/raw-signal</code> with a body payload in the following JSON format.

```json
[
	{
		"timestamp": 1447080936,
		"location": {
			"lat": 49.871873,
			"long": 8.625702
		},
		"location_accuracy": 1.0,
		"bssid": "00-60-2F-00-11-22",
		"rssi": 20
	},
	{
		"timestamp": 1447080939,
		"location": {
			"lat": 49.871877,
			"long": 8.625700
		},
		"location_accuracy": 6.0,
		"bssid": "00-60-2F-33-44-55",
		"rssi": 10
	}
]
```

