/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tu_darmstadt.tk.wardriving.boundary;

import de.tu_darmstadt.tk.wardriving.entity.RawSignal;
import de.tu_darmstadt.tk.wardriving.entity.RouterData;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abd_salam_shaikh
 */
@RestController
@RequestMapping("/router-data")
public class RouterDataController {

    private RouterDataRepository routerDataRepository;

    public RouterDataController() {
    }

    @Autowired
    public RouterDataController(RouterDataRepository routerDataRepository) {
        this.routerDataRepository = routerDataRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Set<String> getRouterData() {
        return routerDataRepository.getRouterData();
    }

    @RequestMapping(method = RequestMethod.POST)
    public int persistRouterData(@RequestBody @Valid ArrayList<RouterData> routerData) {
        List<RouterData> savedItems = routerDataRepository.save(routerData);
        return savedItems.size();
    }

}
