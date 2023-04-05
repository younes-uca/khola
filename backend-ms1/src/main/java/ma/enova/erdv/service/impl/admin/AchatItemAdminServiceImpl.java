package ma.enova.erdv.service.impl.admin;

import ma.enova.erdv.bean.core.AchatItem;
import ma.enova.erdv.bean.history.AchatItemHistory;
import ma.enova.erdv.dao.criteria.core.AchatItemCriteria;
import ma.enova.erdv.dao.criteria.history.AchatItemHistoryCriteria;
import ma.enova.erdv.dao.facade.core.AchatItemDao;
import ma.enova.erdv.dao.facade.history.AchatItemHistoryDao;
import ma.enova.erdv.dao.specification.core.AchatItemSpecification;
import ma.enova.erdv.service.facade.admin.AchatItemAdminService;
import ma.enova.erdv.zynerator.service.AbstractServiceImpl;
import ma.enova.erdv.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.enova.erdv.service.facade.admin.ProduitAdminService ;
import ma.enova.erdv.service.facade.admin.AchatAdminService ;


import java.util.List;
@Service
public class AchatItemAdminServiceImpl extends AbstractServiceImpl<AchatItem,AchatItemHistory, AchatItemCriteria, AchatItemHistoryCriteria, AchatItemDao,
AchatItemHistoryDao> implements AchatItemAdminService {



    public List<AchatItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public List<AchatItem> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }

    public void configure() {
        super.configure(AchatItem.class,AchatItemHistory.class, AchatItemHistoryCriteria.class, AchatItemSpecification.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private AchatAdminService achatService ;
    public AchatItemAdminServiceImpl(AchatItemDao dao, AchatItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}