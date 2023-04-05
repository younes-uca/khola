package ma.enova.erdv.service.impl.admin;

import ma.enova.erdv.bean.core.Droit;
import ma.enova.erdv.bean.history.DroitHistory;
import ma.enova.erdv.dao.criteria.core.DroitCriteria;
import ma.enova.erdv.dao.criteria.history.DroitHistoryCriteria;
import ma.enova.erdv.dao.facade.core.DroitDao;
import ma.enova.erdv.dao.facade.history.DroitHistoryDao;
import ma.enova.erdv.dao.specification.core.DroitSpecification;
import ma.enova.erdv.service.facade.admin.DroitAdminService;
import ma.enova.erdv.zynerator.service.AbstractServiceImpl;
import ma.enova.erdv.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class DroitAdminServiceImpl extends AbstractServiceImpl<Droit,DroitHistory, DroitCriteria, DroitHistoryCriteria, DroitDao,
DroitHistoryDao> implements DroitAdminService {


    public Droit findByReferenceEntity(Droit t){
        return  dao.findByAuthority(t.getAuthority());
    }


    public void configure() {
        super.configure(Droit.class,DroitHistory.class, DroitHistoryCriteria.class, DroitSpecification.class);
    }

    public DroitAdminServiceImpl(DroitDao dao, DroitHistoryDao historyDao) {
        super(dao, historyDao);
    }

}