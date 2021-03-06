package ir.melkban24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ir.melkban24.model.City;
import ir.melkban24.model.Range;
import ir.melkban24.repository.RangeRepository;

@Service
public class RangeServiceImpl implements RangeService {


	@Autowired
    private RangeRepository rangeRepository;



	
	@Override
	public Page<Range> listRangeByPage(Pageable pageable) {

		return rangeRepository.findAll(pageable);
	}




	@Override
	public Range getRangeId(String RangeName, double IdArea) {
		
		return rangeRepository.findByNameRangeContaining(RangeName, IdArea);
	}
	
	@Override
	public Range getRangeId(String RangeName) {
		
		return rangeRepository.findByNameRangeContaining(RangeName);
	}



}
