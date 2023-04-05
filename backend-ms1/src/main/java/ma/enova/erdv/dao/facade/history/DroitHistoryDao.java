package ma.enova.erdv.dao.facade.history;

import ma.enova.erdv.zynerator.repository.AbstractHistoryRepository;
import ma.enova.erdv.bean.history.DroitHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DroitHistoryDao extends AbstractHistoryRepository<DroitHistory,Long> {

}
