package  ma.enova.erdv.dao.specification.history;

import ma.enova.erdv.zynerator.specification.AbstractHistorySpecification;
import ma.enova.erdv.dao.criteria.history.ProduitHistoryCriteria;
import ma.enova.erdv.bean.history.ProduitHistory;


public class ProduitHistorySpecification extends AbstractHistorySpecification<ProduitHistoryCriteria, ProduitHistory> {

    public ProduitHistorySpecification(ProduitHistoryCriteria criteria) {
        super(criteria);
    }

    public ProduitHistorySpecification(ProduitHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
