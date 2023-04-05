package ma.enova.erdv.service.impl.admin;

import ma.enova.erdv.bean.core.Client;
import ma.enova.erdv.bean.history.ClientHistory;
import ma.enova.erdv.dao.criteria.core.ClientCriteria;
import ma.enova.erdv.dao.criteria.history.ClientHistoryCriteria;
import ma.enova.erdv.dao.facade.core.ClientDao;
import ma.enova.erdv.dao.facade.history.ClientHistoryDao;
import ma.enova.erdv.dao.specification.core.ClientSpecification;
import ma.enova.erdv.service.facade.admin.ClientAdminService;
import ma.enova.erdv.zynerator.service.AbstractServiceImpl;
import ma.enova.erdv.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client,ClientHistory, ClientCriteria, ClientHistoryCriteria, ClientDao,
ClientHistoryDao> implements ClientAdminService {


    public Client findByReferenceEntity(Client t){
        return  dao.findByCin(t.getCin());
    }


    public void configure() {
        super.configure(Client.class,ClientHistory.class, ClientHistoryCriteria.class, ClientSpecification.class);
    }

    public ClientAdminServiceImpl(ClientDao dao, ClientHistoryDao historyDao) {
        super(dao, historyDao);
    }

}