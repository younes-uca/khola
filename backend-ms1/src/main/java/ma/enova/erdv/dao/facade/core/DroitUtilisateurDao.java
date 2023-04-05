package ma.enova.erdv.dao.facade.core;


import ma.enova.erdv.zynerator.repository.AbstractRepository;
import ma.enova.erdv.bean.core.DroitUtilisateur;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DroitUtilisateurDao extends AbstractRepository<DroitUtilisateur,Long>  {

    List<DroitUtilisateur> findByDroitId(Long id);
    int deleteByDroitId(Long id);
    List<DroitUtilisateur> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);

}
