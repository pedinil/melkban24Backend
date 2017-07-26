package ir.melkban24.service;


import ir.melkban24.model.Area;
import ir.melkban24.model.Case;
import ir.melkban24.model.CaseAdSearch;
import ir.melkban24.model.CaseSearch;
import ir.melkban24.model.City;
import ir.melkban24.model.KindCase;
import ir.melkban24.model.KindRequest;

import ir.melkban24.model.Range;
import ir.melkban24.model.State;
import ir.melkban24.repository.CaseRepository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;





/**
 * Created by pedi on 3/13/17.
 */

@Service
public class CaseServiceImpl implements CaseService {

	@Autowired
	private static final Logger logger= LoggerFactory.getLogger(CaseService.class);

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
	private StateService stateService;

     @Autowired
	 private KindCaseService kindCaseService;

     @Autowired
	 private KindRequestService kindRequestService;

     @Autowired
	 private CityService cityService;

     @Autowired
	 private AreaService areaService;

     @Autowired
	 private RangeService rangeService;

    



    
    
    @Override
    public Case findByIdCase(Double IdCase) {
        return caseRepository.findByidcase(IdCase);
    }


	@Override
	public Page<CaseSearch> listSearchCaseByString(Pageable pageable, String inputString) {
		
		//Case objecCase=SearchContent(inputString);
		
		return this.caseRepository.findByCaseSearchOrderDesc(pageable);
	}
	
	
	
	@Override
	public Page<CaseSearch> listSearchCaseByString(Pageable pageable,CaseAdSearch caseAdSearch) {
		
	  Case objecCase=SearchContent(caseAdSearch);
		
		return this.caseRepository.findByCaseSearchOrderDesc(pageable);
	}
	
	
	
    
	
	private Case SearchContent(CaseAdSearch caseAdSearch) {
		Case caseObj = new Case();
		


		String arrayString[] = caseAdSearch.getSearchPlace().split("-");
		String KindRequestName = "";
		String CaseKindName = "";
		String StateName = "";
		String CityName = "";
		String AreaName = "";
		String RangeName = "";

		KindRequest kindRequest = null;
		KindCase kindCase = null;
		State state = null;
		City city = null;
		Area area = null;
		Range range = null;
	

		if (!caseAdSearch.getKindCase().isEmpty()) {
			KindRequestName = caseAdSearch.getKindRequest();
			logger.debug("KindRequestName:"+KindRequestName);
		}

		if (!caseAdSearch.getKindCase().isEmpty()) {
			CaseKindName = caseAdSearch.getKindCase();
			logger.debug("CaseKindName:"+CaseKindName);
		}

		if (arrayString.length >= 1) {
			StateName = arrayString[0].replace("+", " ");
			logger.debug("StateName:"+StateName);
		}

		if (arrayString.length >= 2) {
			CityName = arrayString[1].replace("+", " ");
			logger.debug("CityName:"+CityName);
		}

		if (arrayString.length >= 3) {
			AreaName = arrayString[2].replace("+", " ");
			logger.debug("AreaName:"+AreaName);
		}

		if (arrayString.length >= 4) {
			RangeName = arrayString[3].replace("+", " ");
			logger.debug("RangeName:"+RangeName);
		}

		if (!KindRequestName.equals("")) {
			kindRequest = this.kindRequestService.getKindRequestId(KindRequestName);
			caseObj.setKindRequest(kindRequest);
		}

		if (!CaseKindName.equals("")) {
			kindCase = this.kindCaseService.getKindCaseId(CaseKindName);
			caseObj.setKindCase(kindCase);
		}

		if (!StateName.equals("")) {
			state = this.stateService.getStateId(StateName);
			caseObj.setState(state);
		}

		
		if (!CityName.equals("") && state != null) {
			city = this.cityService.getCityId(CityName, state.getIdState());
			caseObj.setCity(city);
		}
		
		if (!AreaName.equals("") && city != null) {
			area = this.areaService.getAreaId(AreaName, city.getIdCity());
			caseObj.setArea(area);
		}
		
		if (!RangeName.equals("") && area != null) {
			range = this.rangeService.getRangeId(RangeName, area.getIdArea());
			caseObj.setRange(range);

		}

		logger.info("  نوع معامله >" + KindRequestName + ", نوع ملک  >" + CaseKindName + ", استان >" + StateName
				+ ", شهر >" + CityName + ", منطقه >" + AreaName + ", محدوده >" + RangeName);

		return caseObj;

	}

	
	/*private Case SearchContent(String content) {
		Case caseObj = new Case();
		


		String arrayString[] = content.split("-");
		String KindRequestName = "";
		String CaseKindName = "";
		String StateName = "";
		String CityName = "";
		String AreaName = "";
		String RangeName = "";

		KindRequest kindRequest = null;
		KindCase kindCase = null;
		State state = null;
		City city = null;
		Area area = null;
		Range range = null;
		
		if (!content.contains("-"))
		{
			
			
			logger.error("wrong search path " + content);
			
			return null;
		}

		if (arrayString.length >= 1) {
			KindRequestName = arrayString[0].replace("+", " ");
			logger.debug("KindRequestName:"+KindRequestName);
		}

		if (arrayString.length >= 2) {
			CaseKindName = arrayString[1].replace("+", " ");
			logger.debug("CaseKindName:"+CaseKindName);
		}

		if (arrayString.length >= 3) {
			StateName = arrayString[2].replace("+", " ");
			logger.debug("StateName:"+StateName);
		}

		if (arrayString.length >= 4) {
			CityName = arrayString[3].replace("+", " ");
			logger.debug("CityName:"+CityName);
		}

		if (arrayString.length >= 5) {
			AreaName = arrayString[4].replace("+", " ");
			logger.debug("AreaName:"+AreaName);
		}

		if (arrayString.length >= 6) {
			RangeName = arrayString[5].replace("+", " ");
			logger.debug("RangeName:"+RangeName);
		}

		if (!KindRequestName.equals("")) {
			kindRequest = this.kindRequestService.getKindRequestId(KindRequestName);
			caseObj.setKindRequest(kindRequest);
		}

		if (!CaseKindName.equals("")) {
			kindCase = this.kindCaseService.getKindCaseId(CaseKindName);
			caseObj.setKindCase(kindCase);
		}

		if (!StateName.equals("")) {
			state = this.stateService.getStateId(StateName);
			caseObj.setState(state);
		}

		
		if (!CityName.equals("") && state != null) {
			city = this.cityService.getCityId(CityName, state.getIdState());
			caseObj.setCity(city);
		}
		
		if (!AreaName.equals("") && city != null) {
			area = this.areaService.getAreaId(AreaName, city.getIdCity());
			caseObj.setArea(area);
		}
		
		if (!RangeName.equals("") && area != null) {
			range = this.rangeService.getRangeId(RangeName, area.getIdArea());
			caseObj.setRange(range);

		}

		logger.info("  نوع معامله >" + KindRequestName + ", نوع ملک  >" + CaseKindName + ", استان >" + StateName
				+ ", شهر >" + CityName + ", منطقه >" + AreaName + ", محدوده >" + RangeName);

		return caseObj;

	}*/
	
}
