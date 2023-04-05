package ma.enova.erdv.dao.facade.history;

import ma.enova.erdv.zynerator.repository.AbstractHistoryRepository;
import ma.enova.erdv.bean.history.AchatHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatHistoryDao extends AbstractHistoryRepository<AchatHistory,Long> {

}
