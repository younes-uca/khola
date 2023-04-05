package ma.enova.erdv.service.facade.admin;

import java.util.List;
import ma.enova.erdv.bean.core.Client;
import ma.enova.erdv.dao.criteria.core.ClientCriteria;
import ma.enova.erdv.dao.criteria.history.ClientHistoryCriteria;
import ma.enova.erdv.zynerator.service.IService;

public interface ClientAdminService extends  IService<Client,ClientCriteria, ClientHistoryCriteria>  {




}
