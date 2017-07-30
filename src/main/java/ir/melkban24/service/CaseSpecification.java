package ir.melkban24.service;

import ir.melkban24.model.CaseSearch;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by mehdi on 7/30/17.
 */
public class CaseSpecification implements Specification<CaseSearch>{

    private SearchCriteria criteria;

    public CaseSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<CaseSearch> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if(criteria.getOperation().equalsIgnoreCase(">")){
            return criteriaBuilder.greaterThanOrEqualTo(root.get(criteria.getKey()),criteria.getValue().toString());
        }else if(criteria.getOperation().equalsIgnoreCase("<")){
            return criteriaBuilder.lessThanOrEqualTo(root.get(criteria.getKey()),criteria.getValue().toString());
        }else if(criteria.getOperation().equalsIgnoreCase(":")){
            if(root.get(criteria.getKey()).getJavaType()==String.class){
                return criteriaBuilder.like(root.get(criteria.getKey()),"%"+criteria.getValue()+"%");
            }else{
                return criteriaBuilder.equal(root.get(criteria.getKey()),criteria.getValue());
            }
        }
        return null;
    }
}
