package ma.enova.erdv.service.impl.admin;

import ma.enova.erdv.bean.core.Utilisateur;
import ma.enova.erdv.bean.history.UtilisateurHistory;
import ma.enova.erdv.dao.criteria.core.UtilisateurCriteria;
import ma.enova.erdv.dao.criteria.history.UtilisateurHistoryCriteria;
import ma.enova.erdv.dao.facade.core.UtilisateurDao;
import ma.enova.erdv.dao.facade.history.UtilisateurHistoryDao;
import ma.enova.erdv.dao.specification.core.UtilisateurSpecification;
import ma.enova.erdv.service.facade.admin.UtilisateurAdminService;
import ma.enova.erdv.zynerator.service.AbstractServiceImpl;
import ma.enova.erdv.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.enova.erdv.bean.core.DroitUtilisateur;

import ma.enova.erdv.service.facade.admin.DroitUtilisateurAdminService ;


import java.util.List;
@Service
public class UtilisateurAdminServiceImpl extends AbstractServiceImpl<Utilisateur,UtilisateurHistory, UtilisateurCriteria, UtilisateurHistoryCriteria, UtilisateurDao,
UtilisateurHistoryDao> implements UtilisateurAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Utilisateur create(Utilisateur t) {
        super.create(t);
        if (t.getDroitUtilisateurs() != null) {
                t.getDroitUtilisateurs().forEach(element-> {
                    element.setUtilisateur(t);
                    droitUtilisateurService.create(element);
            });
        }
        return t;
    }

    public Utilisateur findWithAssociatedLists(Long id){
        Utilisateur result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setDroitUtilisateurs(droitUtilisateurService.findByUtilisateurId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        droitUtilisateurService.deleteByUtilisateurId(id);
    }


    public void updateWithAssociatedLists(Utilisateur utilisateur){
    if(utilisateur !=null && utilisateur.getId() != null){
            List<List<DroitUtilisateur>> resultDroitUtilisateurs= droitUtilisateurService.getToBeSavedAndToBeDeleted(droitUtilisateurService.findByUtilisateurId(utilisateur.getId()),utilisateur.getDroitUtilisateurs());
            droitUtilisateurService.delete(resultDroitUtilisateurs.get(1));
            ListUtil.emptyIfNull(resultDroitUtilisateurs.get(0)).forEach(e -> e.setUtilisateur(utilisateur));
            droitUtilisateurService.update(resultDroitUtilisateurs.get(0),true);
    }
    }

    public Utilisateur findByReferenceEntity(Utilisateur t){
        return  dao.findByUsername(t.getUsername());
    }


    public void configure() {
        super.configure(Utilisateur.class,UtilisateurHistory.class, UtilisateurHistoryCriteria.class, UtilisateurSpecification.class);
    }

    @Autowired
    private DroitUtilisateurAdminService droitUtilisateurService ;
    public UtilisateurAdminServiceImpl(UtilisateurDao dao, UtilisateurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}