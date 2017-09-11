package ir.melkban24.service;


import ir.melkban24.model.Area;
import ir.melkban24.model.Case;
import ir.melkban24.model.CaseAdSearch;
import ir.melkban24.model.CaseSearch;
import ir.melkban24.model.City;
import ir.melkban24.model.KindCase;
import ir.melkban24.model.KindRequest;
import java.util.List;

import ir.melkban24.model.Range;
import ir.melkban24.model.State;
import ir.melkban24.repository.CaseRepository;


import ir.melkban24.repository.CaseSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specifications;
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
    private CaseSearchRepository caseSearchRepository;

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
	public Page<CaseSearch> listRandomSpecialOffer(Pageable pageable) {
		return caseSearchRepository.findRandamCaseSearch(pageable);
	}
	
	
	
	@Override
	public Page<CaseSearch> listSearchCaseByString(Pageable pageable,CaseAdSearch caseAdSearch) {
		
		
		
		
		Case objecCase=SearchContent(caseAdSearch);
		
		CaseSpecification csKindCase=null;
		CaseSpecification csKindRequest=null;
		CaseSpecification csState=null;
		CaseSpecification csCity=null;
		CaseSpecification csArea=null;
		CaseSpecification csNama=null;
		CaseSpecification csRange=null;
		CaseSpecification csCabinet=null;
		CaseSpecification csNegahban=null;
		CaseSpecification csDoor=null;
		CaseSpecification csParking=null;
		CaseSpecification csElevator=null;
		CaseSpecification csIphone=null;
		CaseSpecification csPasio=null;
		CaseSpecification csStorage=null;
		CaseSpecification csPool=null;
		CaseSpecification csWithPicture=null;
		CaseSpecification csFromAge=null;
		CaseSpecification csTillAge=null;
		CaseSpecification csFromPrice1=null;
		CaseSpecification csTillPrice1=null;
		CaseSpecification csFromPrice2=null;
		CaseSpecification csTillPrice2=null;
		CaseSpecification csFromMetraj=null;
		CaseSpecification csTillMetraj=null;
		CaseSpecification csFromCountbed=null;
		CaseSpecification csTillCountbed=null;

		//objecCase
		if (objecCase.getKindRequest()!=null)
			csKindRequest=new CaseSpecification(new SearchCriteria("kindRequest",":",objecCase.getKindRequest()));
		

		if (objecCase.getKindCase()!=null)
			csKindCase=new CaseSpecification(new SearchCriteria("kindCase",":",objecCase.getKindCase()));
		
		
		if (objecCase.getState()!=null)
			csState=new CaseSpecification(new SearchCriteria("state",":",objecCase.getState()));
		
		if (objecCase.getCity()!=null)
			csCity=new CaseSpecification(new SearchCriteria("city",":",objecCase.getCity()));
		
		if (objecCase.getArea()!=null)
			csArea=new CaseSpecification(new SearchCriteria("area",":",objecCase.getArea()));
		
		if (objecCase.getRange()!=null)
			csRange=new CaseSpecification(new SearchCriteria("range",":",objecCase.getRange()));
		
		
		
		//caseAdsearch
		if (objecCase.getNama()!=null)
			csNama=new CaseSpecification(new SearchCriteria("nama",":",objecCase.getNama()));
		
		
		
		if (caseAdSearch != null) {
			if (caseAdSearch.isNegahban() == true) {
				csNegahban=new CaseSpecification(new SearchCriteria("Negahban",":",caseAdSearch.isNegahban()));
			}

			
			if (caseAdSearch.isDoor() == true) {
				csDoor=new CaseSpecification(new SearchCriteria("Door",":",caseAdSearch.isDoor()));
			}
			
			if (caseAdSearch.isParking() == true) {
				csParking=new CaseSpecification(new SearchCriteria("Parking",":",caseAdSearch.isDoor()));
			}

			if (caseAdSearch.isElevator() == true) {
				csElevator=new CaseSpecification(new SearchCriteria("Elevator",":",caseAdSearch.isElevator()));
				
			}
			
			
			if (caseAdSearch.isIphone() == true) {
				csIphone=new CaseSpecification(new SearchCriteria("Iphone",":",caseAdSearch.isIphone()));
			}

		
			
			if (caseAdSearch.isPasio() == true) {
				csPasio=new CaseSpecification(new SearchCriteria("Pasio",":",caseAdSearch.isPasio()));
			}
			
			if (caseAdSearch.isStorage() == true) {
				csStorage=new CaseSpecification(new SearchCriteria("Storage",":",caseAdSearch.isStorage()));
			}

			if (caseAdSearch.isPool() == true) {
				csPool=new CaseSpecification(new SearchCriteria("Pool",":",caseAdSearch.isPool()));
			}

			if (caseAdSearch.isWithPicture() == true) {
		
				csWithPicture=new CaseSpecification(new SearchCriteria("pic","","http"));
			}

			if (caseAdSearch.getCabinet() != null) {
				if (objecCase.getCabinet().getfID()!=87 )
				{
					csCabinet=new CaseSpecification(new SearchCriteria("cabinet",":",caseAdSearch.getCabinet()));
				}
			}

			if (caseAdSearch.getNama() != null) {
				if (caseAdSearch.getNama().getfID()!=87 )
				{

				csNama=new CaseSpecification(new SearchCriteria("nama",":",caseAdSearch.getNama()));
				}
			}

			
			/*if (objecCase.getRoof() != null) {
				if (objecCase.getRoof().getfID()!=87 )
				{
				strQuery.append("and  KindRoof=:KindRoof ");
				}
			}*/

			if (caseAdSearch.getFromAge() != null && caseAdSearch.getTillAge() != null) {
				if ((!caseAdSearch.getFromAge().isEmpty()) && (!caseAdSearch.getTillAge().isEmpty())) {
					//strQuery.append("and (Age>= :FromAge and Age<= :TillAge) ");
					csFromAge=new CaseSpecification(new SearchCriteria("Age",">",caseAdSearch.getFromAge()));
					csTillAge=new CaseSpecification(new SearchCriteria("Age","<",caseAdSearch.getTillAge()));

				}
			}

			if (caseAdSearch.getTillPrice1() != null && caseAdSearch.getTillPrice1() != null) {
				if ((!caseAdSearch.getFromPrice1().isEmpty()) && (!caseAdSearch.getTillPrice1().isEmpty())) {
					//strQuery.append("and (Price1 >= :FromPrice1 and Price1<= :TillPrice1) ");
					csFromPrice1=new CaseSpecification(new SearchCriteria("Price1",">",caseAdSearch.getFromPrice1()));
					csTillPrice1=new CaseSpecification(new SearchCriteria("Price1","<",caseAdSearch.getTillPrice1()));

				}
			}

			if (caseAdSearch.getFromPrice2() != null && caseAdSearch.getTillPrice1() != null) {
				if ((!caseAdSearch.getFromPrice2().isEmpty()) && (!caseAdSearch.getTillPrice2().isEmpty())) {
					//strQuery.append("and (Price2 >= :FromPrice2 and Price2<= :TillPrice2) ");
					csFromPrice2=new CaseSpecification(new SearchCriteria("Price2",">",caseAdSearch.getFromPrice2()));
					csTillPrice2=new CaseSpecification(new SearchCriteria("Price2","<",caseAdSearch.getTillPrice2()));
				}
			}

			if (caseAdSearch.getFromMetraj() != null && caseAdSearch.getTillMetraj() != null) {
				if ((!caseAdSearch.getFromMetraj().isEmpty()) && (!caseAdSearch.getTillMetraj().isEmpty())) {
					//strQuery.append("and (Metraj >= :FromMetraj and Metraj<= :TillMetraj) ");
					csFromMetraj=new CaseSpecification(new SearchCriteria("Metraj",">",caseAdSearch.getFromMetraj()));
					csTillMetraj=new CaseSpecification(new SearchCriteria("Metraj","<",caseAdSearch.getTillMetraj()));
				}
			}

			if (caseAdSearch.getFromCountbed() != null && caseAdSearch.getTillCountbed() != null) {
				if ((!caseAdSearch.getFromCountbed().isEmpty()) && (!caseAdSearch.getTillCountbed().isEmpty())) {
					//strQuery.append("and (Countbed >= :FromCountbed and Countbed<= :TillCountbed) ");
					csFromCountbed=new CaseSpecification(new SearchCriteria("Countbed",">",caseAdSearch.getFromCountbed()));
					csTillCountbed=new CaseSpecification(new SearchCriteria("Countbed","<",caseAdSearch.getTillCountbed()));
				}
				
				
			}
		}
			

		CaseSpecification sort =new CaseSpecification(new SearchCriteria("id","::",""));
		
		
		
		return this.caseSearchRepository.findAll(Specifications.where(csKindCase)
																.and(csKindRequest)
																.and(csState)
																.and(csCity)
																.and(csArea)
																.and(csRange)
																.and(csNama)
																.and(csCabinet)
																.and(csNegahban)
																.and(csDoor)
																.and(csParking)
																.and(csElevator)
																.and(csIphone)
																.and(csPasio)
																.and(csStorage)
																.and(csPool)
																.and(csWithPicture)
																.and(csFromAge)
																.and(csTillAge)
																.and(csFromPrice1)
																.and(csTillPrice1)
																.and(csFromPrice2)
																.and(csTillPrice2)
																.and(csFromMetraj)
																.and(csTillMetraj)
																.and(csFromCountbed)
																.and(csTillCountbed)
																.and(sort)																
																,pageable);
		
	
		
		
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
		int arrayint= arrayString.length ;

		if (!caseAdSearch.getKindCase().isEmpty()) {
			KindRequestName = caseAdSearch.getKindRequest();
			logger.debug("KindRequestName:"+KindRequestName);
		}

		if (!caseAdSearch.getKindCase().isEmpty()) {
			CaseKindName = caseAdSearch.getKindCase();
			logger.debug("CaseKindName:"+CaseKindName);
		}

		if (arrayint >= 1) {
			StateName = arrayString[arrayint-1].replace("استان ", "");
			logger.debug("StateName:"+StateName);
		}

		if (arrayint >= 2) {
			CityName = arrayString[arrayint-2].replace("+", " ");
			logger.debug("CityName:"+CityName);
		}

		if (arrayint >= 3) {
			AreaName = arrayString[arrayint-3].replace("+", " ");
			logger.debug("AreaName:"+AreaName);
		}

		if (arrayint >= 4) {
			RangeName = arrayString[arrayint-4].replace("+", " ");
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
			
			
		}else
		{
			
			range = this.rangeService.getRangeId(AreaName);
			caseObj.setRange(range);
		}

		logger.info("  نوع معامله >" + KindRequestName + ", نوع ملک  >" + CaseKindName + ", استان >" + StateName
				+ ", شهر >" + CityName + ", منطقه >" + AreaName + ", محدوده >" + RangeName);

		return caseObj;

	}









	

	
	
}
