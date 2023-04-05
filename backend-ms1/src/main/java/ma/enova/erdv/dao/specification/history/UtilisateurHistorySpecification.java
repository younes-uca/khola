package  ma.enova.erdv.dao.specification.history;

import ma.enova.erdv.zynerator.specification.AbstractHistorySpecification;
import ma.enova.erdv.dao.criteria.history.UtilisateurHistoryCriteria;
import ma.enova.erdv.bean.history.UtilisateurHistory;


public class UtilisateurHistorySpecification extends AbstractHistorySpecification<UtilisateurHistoryCriteria, UtilisateurHistory> {

    public UtilisateurHistorySpecification(UtilisateurHistoryCriteria criteria) {
        super(criteria);
    }

    public UtilisateurHistorySpecification(UtilisateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
