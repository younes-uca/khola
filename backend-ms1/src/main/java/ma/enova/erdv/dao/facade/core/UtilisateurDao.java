package ma.enova.erdv.dao.facade.core;


import ma.enova.erdv.zynerator.repository.AbstractRepository;
import ma.enova.erdv.bean.core.Utilisateur;
import org.springframework.stereotype.Repository;
import ma.enova.erdv.bean.core.Utilisateur;
import java.util.List;


@Repository
public interface UtilisateurDao extends AbstractRepository<Utilisateur,Long>  {
    Utilisateur findByUsername(String username);
    int deleteByUsername(String username);


}
