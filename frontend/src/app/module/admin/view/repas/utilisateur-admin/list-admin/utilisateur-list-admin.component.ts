import {Component, OnInit} from '@angular/core';
import {UtilisateurService} from 'src/app/controller/service/Utilisateur.service';
import {UtilisateurDto} from 'src/app/controller/model/Utilisateur.model';
import {UtilisateurCriteria} from 'src/app/controller/criteria/UtilisateurCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import {Router} from '@angular/router';
import { environment } from 'src/environments/environment';
import { RoleService } from 'src/app/zynerator/security/Role.service';
import {DatePipe} from '@angular/common';



import {DroitUtilisateurDto} from 'src/app/controller/model/DroitUtilisateur.model';
import { MessageService, ConfirmationService } from 'primeng/api';
import { AuthService } from 'src/app/zynerator/security/Auth.service';
import { ExportService } from 'src/app/zynerator/util/Export.service';

@Component({
  selector: 'app-utilisateur-list-admin',
  templateUrl: './utilisateur-list-admin.component.html'
})
export class UtilisateurListAdminComponent extends AbstractListController<UtilisateurDto, UtilisateurCriteria, UtilisateurService>  implements OnInit {

    fileName = 'Utilisateur';

     yesOrNoAccountNonExpired :any[] =[];
     yesOrNoAccountNonLocked :any[] =[];
     yesOrNoPasswordChanged :any[] =[];
  
    constructor(datePipe: DatePipe, utilisateurService: UtilisateurService, messageService: MessageService, confirmationService: ConfirmationService
        , roleService: RoleService, router: Router , authService: AuthService , exportService: ExportService
) {
        super(datePipe, utilisateurService, messageService, confirmationService, roleService, router, authService, exportService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    this.yesOrNoAccountNonExpired =  [{label: 'AccountNonExpired', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
    this.yesOrNoAccountNonLocked =  [{label: 'AccountNonLocked', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
    this.yesOrNoPasswordChanged =  [{label: 'PasswordChanged', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
    }

    public async loadUtilisateurs(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Utilisateur', 'list');
        isPermistted ? this.service.findAll().subscribe(utilisateurs => this.items = utilisateurs,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'email', header: 'Email'},
            {field: 'accountNonExpired', header: 'Account non expired'},
            {field: 'accountNonLocked', header: 'Account non locked'},
            {field: 'username', header: 'Username'},
            {field: 'password', header: 'Password'},
            {field: 'lastName', header: 'Last name'},
            {field: 'firstName', header: 'First name'},
            {field: 'passwordChanged', header: 'Password changed'},
            {field: 'failedAttemptCount', header: 'Failed attempt count'},
            {field: 'dateLock', header: 'Date lock'},
        ];
    }



	public initDuplicate(res: UtilisateurDto) {
        if (res.droitUtilisateurs != null) {
             res.droitUtilisateurs.forEach(d => { d.utilisateur = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Email': e.email ,
                'Account non expired': e.accountNonExpired? 'Vrai' : 'Faux' ,
                'Account non locked': e.accountNonLocked? 'Vrai' : 'Faux' ,
                 'Username': e.username ,
                 'Password': e.password ,
                 'Last name': e.lastName ,
                 'First name': e.firstName ,
                'Password changed': e.passwordChanged? 'Vrai' : 'Faux' ,
                 'Failed attempt count': e.failedAttemptCount ,
                'Date lock': this.datePipe.transform(e.dateLock , 'dd/MM/yyyy hh:mm'),
            }
        });

        this.criteriaData = [{
            'Email': this.criteria.email ? this.criteria.email : environment.emptyForExport ,
            'Account non expired': this.criteria.accountNonExpired ? (this.criteria.accountNonExpired ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Account non locked': this.criteria.accountNonLocked ? (this.criteria.accountNonLocked ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Username': this.criteria.username ? this.criteria.username : environment.emptyForExport ,
            'Password': this.criteria.password ? this.criteria.password : environment.emptyForExport ,
            'Last name': this.criteria.lastName ? this.criteria.lastName : environment.emptyForExport ,
            'First name': this.criteria.firstName ? this.criteria.firstName : environment.emptyForExport ,
            'Password changed': this.criteria.passwordChanged ? (this.criteria.passwordChanged ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Failed attempt count Min': this.criteria.failedAttemptCountMin ? this.criteria.failedAttemptCountMin : environment.emptyForExport ,
            'Failed attempt count Max': this.criteria.failedAttemptCountMax ? this.criteria.failedAttemptCountMax : environment.emptyForExport ,
            'Date lock Min': this.criteria.dateLockFrom ? this.datePipe.transform(this.criteria.dateLockFrom , this.dateFormat) : environment.emptyForExport ,
            'Date lock Max': this.criteria.dateLockTo ? this.datePipe.transform(this.criteria.dateLockTo , this.dateFormat) : environment.emptyForExport ,
        }];
      }
}
