package  ma.enova.erdv.dao.specification.history;

import ma.enova.erdv.zynerator.specification.AbstractHistorySpecification;
import ma.enova.erdv.dao.criteria.history.AchatHistoryCriteria;
import ma.enova.erdv.bean.history.AchatHistory;


public class AchatHistorySpecification extends AbstractHistorySpecification<AchatHistoryCriteria, AchatHistory> {

    public AchatHistorySpecification(AchatHistoryCriteria criteria) {
        super(criteria);
    }

    public AchatHistorySpecification(AchatHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
