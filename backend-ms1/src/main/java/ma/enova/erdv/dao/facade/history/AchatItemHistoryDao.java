package ma.enova.erdv.dao.facade.history;

import ma.enova.erdv.zynerator.repository.AbstractHistoryRepository;
import ma.enova.erdv.bean.history.AchatItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatItemHistoryDao extends AbstractHistoryRepository<AchatItemHistory,Long> {

}
