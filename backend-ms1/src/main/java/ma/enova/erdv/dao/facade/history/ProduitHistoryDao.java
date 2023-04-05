package ma.enova.erdv.dao.facade.history;

import ma.enova.erdv.zynerator.repository.AbstractHistoryRepository;
import ma.enova.erdv.bean.history.ProduitHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitHistoryDao extends AbstractHistoryRepository<ProduitHistory,Long> {

}
