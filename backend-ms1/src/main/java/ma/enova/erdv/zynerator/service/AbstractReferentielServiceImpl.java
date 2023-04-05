package ma.enova.erdv.zynerator.service;

import ma.enova.erdv.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.enova.erdv.zynerator.criteria.BaseCriteria;
import ma.enova.erdv.zynerator.history.HistBusinessObject;
import ma.enova.erdv.zynerator.history.HistCriteria;
import ma.enova.erdv.zynerator.repository.AbstractHistoryRepository;
import ma.enova.erdv.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, H extends HistBusinessObject, CRITERIA extends BaseCriteria, HC extends HistCriteria, REPO extends AbstractRepository<T, Long>, HISTREPO extends AbstractHistoryRepository<H, Long>> extends AbstractServiceImpl<T, H, CRITERIA, HC, REPO, HISTREPO> {

    public AbstractReferentielServiceImpl(REPO dao, HISTREPO historyRepository) {
    super(dao, historyRepository);
    }

}