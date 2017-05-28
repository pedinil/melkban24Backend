package ir.melkban24.service;

import ir.melkban24.model.Agent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by mehdi on 5/23/17.
 */
public interface AgentService {
    Agent findByAgentId(Long id);
    List<Agent> findAll();
    Page<Agent> findAllByPage(Pageable pageable);
    void save(Agent agent);
    void delete(Agent agent);
    void update(Agent agent);
    Agent findByAgentUsername(String username);
}
