package  ma.enova.erdv.dao.specification.history;

import ma.enova.erdv.zynerator.specification.AbstractHistorySpecification;
import ma.enova.erdv.dao.criteria.history.DroitUtilisateurHistoryCriteria;
import ma.enova.erdv.bean.history.DroitUtilisateurHistory;


public class DroitUtilisateurHistorySpecification extends AbstractHistorySpecification<DroitUtilisateurHistoryCriteria, DroitUtilisateurHistory> {

    public DroitUtilisateurHistorySpecification(DroitUtilisateurHistoryCriteria criteria) {
        super(criteria);
    }

    public DroitUtilisateurHistorySpecification(DroitUtilisateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
