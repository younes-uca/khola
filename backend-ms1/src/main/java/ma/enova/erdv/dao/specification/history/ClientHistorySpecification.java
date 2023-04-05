package  ma.enova.erdv.dao.specification.history;

import ma.enova.erdv.zynerator.specification.AbstractHistorySpecification;
import ma.enova.erdv.dao.criteria.history.ClientHistoryCriteria;
import ma.enova.erdv.bean.history.ClientHistory;


public class ClientHistorySpecification extends AbstractHistorySpecification<ClientHistoryCriteria, ClientHistory> {

    public ClientHistorySpecification(ClientHistoryCriteria criteria) {
        super(criteria);
    }

    public ClientHistorySpecification(ClientHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
