package ir.melkban24.controller;

import ir.melkban24.model.Agent;
import ir.melkban24.service.AgentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by mehdi on 5/23/17.
 */
@RestController
public class AgentController {

    public static final Logger logger= LoggerFactory.getLogger(AgentController.class);
    @Autowired
    private AgentService agentService;

    /**
     * Get Agents List by Page
     * @param pageable
     * @return
     */
    @RequestMapping(value = "/agent/list", method = RequestMethod.GET)
    public Page<Agent> getList(Pageable pageable) {
        Page<Agent> agents=this.agentService.findAllByPage(pageable);
        return agents;
    }

    /**
     * Get Agent
     * @param id
     * @return
     */
    @RequestMapping(value = "/agent/{id}", method = RequestMethod.GET)
    public ResponseEntity<Agent> getAgent(@PathVariable Long id) {
        Agent agent=this.agentService.findByAgentId(id);
        if(agent==null)
            return new ResponseEntity<Agent>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<Agent>(this.agentService.findByAgentId(id),HttpStatus.FOUND);
    }

    /**
     * Create Agent
     * @param agent
     * @param ucBuilder
     * @return
     */
    @RequestMapping(value = "/agent/create", method = RequestMethod.POST)
    public ResponseEntity<?> addAgent(@RequestBody Agent agent, UriComponentsBuilder ucBuilder)
    {
        logger.info("Creating Agent : {}",agent);

        this.agentService.save(agent);
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(ucBuilder.path("/agent/{id}").buildAndExpand(agent.getId()).toUri());
        return new ResponseEntity<String>(headers,HttpStatus.CREATED);
    }

    /**
     * Delete Agent
     * @param id
     * @return
     */
    @RequestMapping(value = "/agent/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAgent(@PathVariable Long id) {
        logger.info("Deleting agent with id: {}", id);

        Agent agent=this.agentService.findByAgentId(id);

        if(agent==null)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        this.agentService.delete(agent);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /**
     * Update Agent
     * @param id
     * @param agent
     * @return
     */
    @RequestMapping(value = "/agent/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Agent> updateAgent(@PathVariable Long id, @RequestBody Agent agent) {
        logger.info("Updating agent : {}", agent);
        Agent currentAgent=this.agentService.findByAgentId(id);
        if(currentAgent==null)
            return new ResponseEntity<Agent>(HttpStatus.NO_CONTENT);
        currentAgent.setAddress(agent.getAddress());
        currentAgent.setMobile(agent.getMobile());
        currentAgent.setPhone(agent.getPhone());
        currentAgent.setFirstname(agent.getFirstname());
        currentAgent.setLastname(agent.getLastname());
        this.agentService.update(currentAgent);
        return new ResponseEntity<Agent>(currentAgent,HttpStatus.OK);
    }
}
