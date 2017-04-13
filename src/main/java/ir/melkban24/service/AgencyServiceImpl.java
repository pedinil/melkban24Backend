package ir.melkban24.service;

import ir.melkban24.model.Agency;
import ir.melkban24.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mehdi on 4/13/17.
 */
@Service
public class AgencyServiceImpl implements AgencyService{

    @Autowired
    private AgencyRepository agencyRepository;

    @Override
    public List<Agency> findAll() {
        return agencyRepository.findAll();
    }
}
