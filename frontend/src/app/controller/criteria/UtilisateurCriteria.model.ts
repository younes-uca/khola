import {DroitUtilisateurCriteria} from './DroitUtilisateurCriteria.model';

import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class UtilisateurCriteria  extends BaseCriteria {

    public id: number;
    public email: string;
    public emailLike: string;
    public accountNonExpired: null | boolean;
    public accountNonLocked: null | boolean;
    public username: string;
    public usernameLike: string;
    public password: string;
    public passwordLike: string;
    public lastName: string;
    public lastNameLike: string;
    public firstName: string;
    public firstNameLike: string;
    public passwordChanged: null | boolean;
     public failedAttemptCount: number;
     public failedAttemptCountMin: number;
     public failedAttemptCountMax: number;
    public dateLock: Date;
    public dateLockFrom: Date;
    public dateLockTo: Date;
      public droitUtilisateurs: Array<DroitUtilisateurCriteria>;

}
