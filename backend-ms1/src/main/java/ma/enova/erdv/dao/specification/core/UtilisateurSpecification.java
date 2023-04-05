package  ma.enova.erdv.dao.specification.core;

import ma.enova.erdv.zynerator.specification.AbstractSpecification;
import ma.enova.erdv.dao.criteria.core.UtilisateurCriteria;
import ma.enova.erdv.bean.core.Utilisateur;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurSpecification extends  AbstractSpecification<UtilisateurCriteria, Utilisateur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicateBool("accountNonExpired", criteria.getAccountNonExpired());
        addPredicateBool("accountNonLocked", criteria.getAccountNonLocked());
        addPredicate("username", criteria.getUsername(),criteria.getUsernameLike());
        addPredicate("password", criteria.getPassword(),criteria.getPasswordLike());
        addPredicate("lastName", criteria.getLastName(),criteria.getLastNameLike());
        addPredicate("firstName", criteria.getFirstName(),criteria.getFirstNameLike());
        addPredicateBool("passwordChanged", criteria.getPasswordChanged());
        addPredicateInt("failedAttemptCount", criteria.getFailedAttemptCount(), criteria.getFailedAttemptCountMin(), criteria.getFailedAttemptCountMax());
        addPredicate("dateLock", criteria.getDateLock(), criteria.getDateLockFrom(), criteria.getDateLockTo());
    }

    public UtilisateurSpecification(UtilisateurCriteria criteria) {
        super(criteria);
    }

    public UtilisateurSpecification(UtilisateurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
