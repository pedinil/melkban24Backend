package ir.melkban24.service;

import java.util.List;

import ir.melkban24.model.KindCase;




public interface KindCaseService {
	
	public List<KindCase> listKindCase();
	
	public KindCase getKindCaseId(String CaseKindName);
	
	

}
