package ir.melkban24.service;

import java.util.List;
import ir.melkban24.model.Agency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by mehdi on 4/13/17.
 */
public interface AgencyService {
    List<Agency> findAll();
    Page<Agency> listAllByPage(Pageable pageable);
}
