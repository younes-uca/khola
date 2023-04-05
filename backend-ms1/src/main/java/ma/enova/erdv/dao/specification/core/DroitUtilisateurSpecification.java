package  ma.enova.erdv.dao.specification.core;

import ma.enova.erdv.zynerator.specification.AbstractSpecification;
import ma.enova.erdv.dao.criteria.core.DroitUtilisateurCriteria;
import ma.enova.erdv.bean.core.DroitUtilisateur;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DroitUtilisateurSpecification extends  AbstractSpecification<DroitUtilisateurCriteria, DroitUtilisateur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("droit","id", criteria.getDroit()==null?null:criteria.getDroit().getId());
        addPredicateFk("droit","authority", criteria.getDroit()==null?null:criteria.getDroit().getAuthority());
        addPredicateFk("utilisateur","id", criteria.getUtilisateur()==null?null:criteria.getUtilisateur().getId());
        addPredicateFk("utilisateur","username", criteria.getUtilisateur()==null?null:criteria.getUtilisateur().getUsername());
    }

    public DroitUtilisateurSpecification(DroitUtilisateurCriteria criteria) {
        super(criteria);
    }

    public DroitUtilisateurSpecification(DroitUtilisateurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
