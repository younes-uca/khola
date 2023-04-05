package ma.enova.erdv.service.impl.admin;

import ma.enova.erdv.bean.core.Produit;
import ma.enova.erdv.bean.history.ProduitHistory;
import ma.enova.erdv.dao.criteria.core.ProduitCriteria;
import ma.enova.erdv.dao.criteria.history.ProduitHistoryCriteria;
import ma.enova.erdv.dao.facade.core.ProduitDao;
import ma.enova.erdv.dao.facade.history.ProduitHistoryDao;
import ma.enova.erdv.dao.specification.core.ProduitSpecification;
import ma.enova.erdv.service.facade.admin.ProduitAdminService;
import ma.enova.erdv.zynerator.service.AbstractServiceImpl;
import ma.enova.erdv.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class ProduitAdminServiceImpl extends AbstractServiceImpl<Produit,ProduitHistory, ProduitCriteria, ProduitHistoryCriteria, ProduitDao,
ProduitHistoryDao> implements ProduitAdminService {


    public Produit findByReferenceEntity(Produit t){
        return  dao.findByReference(t.getReference());
    }


    public void configure() {
        super.configure(Produit.class,ProduitHistory.class, ProduitHistoryCriteria.class, ProduitSpecification.class);
    }

    public ProduitAdminServiceImpl(ProduitDao dao, ProduitHistoryDao historyDao) {
        super(dao, historyDao);
    }

}