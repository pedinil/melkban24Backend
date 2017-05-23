package ir.melkban24.controller;

import ir.melkban24.model.Agency;
import ir.melkban24.model.Agent;
import ir.melkban24.model.Role;
import ir.melkban24.service.AgencyService;
import ir.melkban24.service.AgentService;
import ir.melkban24.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehdi on 4/13/17.
 */
@RestController
public class AgencyController {
    private static final Logger logger= LoggerFactory.getLogger(AgencyController.class);
    @Autowired
    private AgencyService agencyService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AgentService agentService;

    @RequestMapping(value = "/agency/list",method = RequestMethod.GET)
    public Page<Agency> list(Pageable pageable) {
        Page<Agency> agencies=agencyService.listAllByPage(pageable);
        return agencies;
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
        storageService.store(pic1File);
        return new ResponseEntity<List<String>>(originalFileName, HttpStatus.CREATED);
    }
}
