import {DroitCriteria} from './DroitCriteria.model';
import {UtilisateurCriteria} from './UtilisateurCriteria.model';

import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class DroitUtilisateurCriteria  extends BaseCriteria {

    public id: number;
  public droit: DroitCriteria ;
  public utilisateur: UtilisateurCriteria ;

}
