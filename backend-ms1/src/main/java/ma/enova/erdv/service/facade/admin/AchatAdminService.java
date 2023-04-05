package ma.enova.erdv.service.facade.admin;

import java.util.List;
import ma.enova.erdv.bean.core.Achat;
import ma.enova.erdv.dao.criteria.core.AchatCriteria;
import ma.enova.erdv.dao.criteria.history.AchatHistoryCriteria;
import ma.enova.erdv.zynerator.service.IService;

public interface AchatAdminService extends  IService<Achat,AchatCriteria, AchatHistoryCriteria>  {

    List<Achat> findByClientId(Long id);
    int deleteByClientId(Long id);



}
