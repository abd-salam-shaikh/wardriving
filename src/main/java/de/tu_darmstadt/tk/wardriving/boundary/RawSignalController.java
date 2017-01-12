package de.tu_darmstadt.tk.wardriving.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tu_darmstadt.tk.wardriving.entity.RawSignal;

@RestController
@RequestMapping("/raw-signal")
public class RawSignalController {

	private RawSignalRepository repository;
	
	@Autowired
	public RawSignalController(RawSignalRepository repository) {
		this.repository = repository;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<String> getKnownAccessPoints() {
		return repository.getKnownAccessPoints();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public int persistRawSignalData(@RequestBody @Valid ArrayList<RawSignal> rawSignalData) {
		List<RawSignal> savedItems = repository.save(rawSignalData);
		return savedItems.size();
	}

}
