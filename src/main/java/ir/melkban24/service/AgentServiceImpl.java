package ir.melkban24.service;

import ir.melkban24.model.Agent;
import ir.melkban24.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by mehdi on 5/23/17.
 */
@Service
public class AgentServiceImpl implements AgentService{

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    @Override
    public Page<Agent> findAllByPage(Pageable pageable) {
        return this.agentRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public void save(Agent agent) {
        agent.getUser().setPassword(bCryptPasswordEncoder.encode(agent.getUser().getPassword()));
        this.agentRepository.save(agent);
    }

    @Override
    public Agent findByAgentId(Long id) {
        return this.agentRepository.findOne(id);
    }

    @Override
    public void delete(Agent agent) {
        this.agentRepository.delete(agent);
    }

    @Override
    public void update(Agent agent) {
        this.agentRepository.save(agent);
    }

    @Override
    public Agent findByAgentUsername(String username) {
        return this.agentRepository.findAgentByUsername(username);
    }
}
