package ir.melkban24.repository;

import ir.melkban24.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by mehdi on 5/23/17.
 */
public interface AgentRepository extends JpaRepository<Agent,Long>{
    @Query("select a from Agent a where a.user.username = :username")
    Agent findAgentByUsername(@Param("username") String username);
}
