package ma.enova.erdv.dao.facade.history;

import ma.enova.erdv.zynerator.repository.AbstractHistoryRepository;
import ma.enova.erdv.bean.history.DroitUtilisateurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DroitUtilisateurHistoryDao extends AbstractHistoryRepository<DroitUtilisateurHistory,Long> {

}
