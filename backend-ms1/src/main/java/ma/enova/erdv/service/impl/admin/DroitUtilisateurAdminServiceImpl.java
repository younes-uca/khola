package ma.enova.erdv.service.impl.admin;

import ma.enova.erdv.bean.core.DroitUtilisateur;
import ma.enova.erdv.bean.history.DroitUtilisateurHistory;
import ma.enova.erdv.dao.criteria.core.DroitUtilisateurCriteria;
import ma.enova.erdv.dao.criteria.history.DroitUtilisateurHistoryCriteria;
import ma.enova.erdv.dao.facade.core.DroitUtilisateurDao;
import ma.enova.erdv.dao.facade.history.DroitUtilisateurHistoryDao;
import ma.enova.erdv.dao.specification.core.DroitUtilisateurSpecification;
import ma.enova.erdv.service.facade.admin.DroitUtilisateurAdminService;
import ma.enova.erdv.zynerator.service.AbstractServiceImpl;
import ma.enova.erdv.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.enova.erdv.service.facade.admin.UtilisateurAdminService ;
import ma.enova.erdv.service.facade.admin.DroitAdminService ;


import java.util.List;
@Service
public class DroitUtilisateurAdminServiceImpl extends AbstractServiceImpl<DroitUtilisateur,DroitUtilisateurHistory, DroitUtilisateurCriteria, DroitUtilisateurHistoryCriteria, DroitUtilisateurDao,
DroitUtilisateurHistoryDao> implements DroitUtilisateurAdminService {



    public List<DroitUtilisateur> findByDroitId(Long id){
        return dao.findByDroitId(id);
    }
    public int deleteByDroitId(Long id){
        return dao.deleteByDroitId(id);
    }
    public List<DroitUtilisateur> findByUtilisateurId(Long id){
        return dao.findByUtilisateurId(id);
    }
    public int deleteByUtilisateurId(Long id){
        return dao.deleteByUtilisateurId(id);
    }

    public void configure() {
        super.configure(DroitUtilisateur.class,DroitUtilisateurHistory.class, DroitUtilisateurHistoryCriteria.class, DroitUtilisateurSpecification.class);
    }

    @Autowired
    private UtilisateurAdminService utilisateurService ;
    @Autowired
    private DroitAdminService droitService ;
    public DroitUtilisateurAdminServiceImpl(DroitUtilisateurDao dao, DroitUtilisateurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}