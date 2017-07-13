package ir.melkban24.service;

import java.util.List;

import ir.melkban24.model.KindRequest;




public interface KindRequestService {
	
	public List<KindRequest> listKindRequest();
	
	public KindRequest getKindRequestId(String KindRequestName);

}
