package  ma.enova.erdv.dao.specification.history;

import ma.enova.erdv.zynerator.specification.AbstractHistorySpecification;
import ma.enova.erdv.dao.criteria.history.DroitHistoryCriteria;
import ma.enova.erdv.bean.history.DroitHistory;


public class DroitHistorySpecification extends AbstractHistorySpecification<DroitHistoryCriteria, DroitHistory> {

    public DroitHistorySpecification(DroitHistoryCriteria criteria) {
        super(criteria);
    }

    public DroitHistorySpecification(DroitHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
