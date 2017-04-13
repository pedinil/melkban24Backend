package ir.melkban24.controller;

import ir.melkban24.model.Agency;
import ir.melkban24.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mehdi on 4/13/17.
 */
@RestController
public class AgencyController {
    @Autowired
    private AgencyService agencyService;
    @RequestMapping(value = "/agency/list",method = RequestMethod.GET)
    public List<Agency> agencyList() {
        return agencyService.findAll();
    }
}
