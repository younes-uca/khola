package  ma.enova.erdv.dao.specification.history;

import ma.enova.erdv.zynerator.specification.AbstractHistorySpecification;
import ma.enova.erdv.dao.criteria.history.AchatItemHistoryCriteria;
import ma.enova.erdv.bean.history.AchatItemHistory;


public class AchatItemHistorySpecification extends AbstractHistorySpecification<AchatItemHistoryCriteria, AchatItemHistory> {

    public AchatItemHistorySpecification(AchatItemHistoryCriteria criteria) {
        super(criteria);
    }

    public AchatItemHistorySpecification(AchatItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
