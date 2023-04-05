package  ma.enova.erdv.dao.specification.core;

import ma.enova.erdv.zynerator.specification.AbstractSpecification;
import ma.enova.erdv.dao.criteria.core.DroitCriteria;
import ma.enova.erdv.bean.core.Droit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DroitSpecification extends  AbstractSpecification<DroitCriteria, Droit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("authority", criteria.getAuthority(),criteria.getAuthorityLike());
    }

    public DroitSpecification(DroitCriteria criteria) {
        super(criteria);
    }

    public DroitSpecification(DroitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
