package ir.melkban24.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ir.melkban24.model.Range;
import ir.melkban24.model.State;




public interface StateService {
	
	public Page<State> listStateByPage(Pageable pageable);
	
/*	public List<Range> listRangeByArea(double IdArea);
	
	public Range getRangeId(String RangeName,double IdArea);
	*/


}
