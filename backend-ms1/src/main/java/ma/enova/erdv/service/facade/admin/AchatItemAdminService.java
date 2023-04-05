package ma.enova.erdv.service.facade.admin;

import java.util.List;
import ma.enova.erdv.bean.core.AchatItem;
import ma.enova.erdv.dao.criteria.core.AchatItemCriteria;
import ma.enova.erdv.dao.criteria.history.AchatItemHistoryCriteria;
import ma.enova.erdv.zynerator.service.IService;

public interface AchatItemAdminService extends  IService<AchatItem,AchatItemCriteria, AchatItemHistoryCriteria>  {

    List<AchatItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<AchatItem> findByAchatId(Long id);
    int deleteByAchatId(Long id);



}
