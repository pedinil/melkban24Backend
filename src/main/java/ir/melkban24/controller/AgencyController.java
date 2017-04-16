package ir.melkban24.controller;

import ir.melkban24.model.Agency;
import ir.melkban24.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
    @RequestMapping(value = "/agency/create", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<String>> createAgency(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "pic1", required = true)MultipartFile pic1File,
            MultipartHttpServletRequest request, ModelAndView modelAndView) {
        List<String> requestKeys=new ArrayList<String>();
        List<String> originalFileName=new ArrayList<String>();

        request.getFileNames().forEachRemaining(requestKeys::add);
        for(String multipartFile:requestKeys) {
            originalFileName.add(request.getFile(multipartFile).getOriginalFilename());
        }
        return new ResponseEntity<List<String>>(originalFileName, HttpStatus.CREATED);
    }
}