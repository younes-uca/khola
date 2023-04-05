package ma.enova.erdv.service.facade.admin;

import java.util.List;
import ma.enova.erdv.bean.core.DroitUtilisateur;
import ma.enova.erdv.dao.criteria.core.DroitUtilisateurCriteria;
import ma.enova.erdv.dao.criteria.history.DroitUtilisateurHistoryCriteria;
import ma.enova.erdv.zynerator.service.IService;

public interface DroitUtilisateurAdminService extends  IService<DroitUtilisateur,DroitUtilisateurCriteria, DroitUtilisateurHistoryCriteria>  {

    List<DroitUtilisateur> findByDroitId(Long id);
    int deleteByDroitId(Long id);
    List<DroitUtilisateur> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);



}
