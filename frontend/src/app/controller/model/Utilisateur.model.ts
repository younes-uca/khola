import {DroitUtilisateurDto} from './DroitUtilisateur.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

export class UtilisateurDto  extends BaseDto{

    public id: number;
    public email: string;
   public accountNonExpired: null | boolean;
   public accountNonLocked: null | boolean;
    public username: string;
    public password: string;
    public lastName: string;
    public firstName: string;
   public passwordChanged: null | boolean;
   public failedAttemptCount: number;
   public dateLock: Date;
    public failedAttemptCountMax: string ;
    public failedAttemptCountMin: string ;
    public dateLockMax: string ;
    public dateLockMin: string ;
     public droitUtilisateurs: Array<DroitUtilisateurDto>;

}
