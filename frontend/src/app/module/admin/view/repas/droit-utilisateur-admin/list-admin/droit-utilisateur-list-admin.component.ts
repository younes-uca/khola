import {Component, OnInit} from '@angular/core';
import {DroitUtilisateurService} from 'src/app/controller/service/DroitUtilisateur.service';
import {DroitUtilisateurDto} from 'src/app/controller/model/DroitUtilisateur.model';
import {DroitUtilisateurCriteria} from 'src/app/controller/criteria/DroitUtilisateurCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import {Router} from '@angular/router';
import { environment } from 'src/environments/environment';
import { RoleService } from 'src/app/zynerator/security/Role.service';
import {DatePipe} from '@angular/common';


import { DroitService } from 'src/app/controller/service/Droit.service';
import { UtilisateurService } from 'src/app/controller/service/Utilisateur.service';

import {DroitDto} from 'src/app/controller/model/Droit.model';
import {UtilisateurDto} from 'src/app/controller/model/Utilisateur.model';
import { MessageService, ConfirmationService } from 'primeng/api';
import { AuthService } from 'src/app/zynerator/security/Auth.service';
import { ExportService } from 'src/app/zynerator/util/Export.service';

@Component({
  selector: 'app-droit-utilisateur-list-admin',
  templateUrl: './droit-utilisateur-list-admin.component.html'
})
export class DroitUtilisateurListAdminComponent extends AbstractListController<DroitUtilisateurDto, DroitUtilisateurCriteria, DroitUtilisateurService>  implements OnInit {

    fileName = 'DroitUtilisateur';

    droits :Array<DroitDto>;
    utilisateurs :Array<UtilisateurDto>;
  
    constructor(datePipe: DatePipe, droitUtilisateurService: DroitUtilisateurService, messageService: MessageService, confirmationService: ConfirmationService
        , roleService: RoleService, router: Router , authService: AuthService , exportService: ExportService
, private droitService: DroitService, private utilisateurService: UtilisateurService) {
        super(datePipe, droitUtilisateurService, messageService, confirmationService, roleService, router, authService, exportService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadDroit();
      this.loadUtilisateur();
    }

    public async loadDroitUtilisateurs(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('DroitUtilisateur', 'list');
        isPermistted ? this.service.findAll().subscribe(droitUtilisateurs => this.items = droitUtilisateurs,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'droit?.authority', header: 'Droit'},
            {field: 'utilisateur?.username', header: 'Utilisateur'},
        ];
    }


    public async loadDroit(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('DroitUtilisateur', 'list');
        isPermistted ? this.droitService.findAll().subscribe(droits => this.droits = droits,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadUtilisateur(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('DroitUtilisateur', 'list');
        isPermistted ? this.utilisateurService.findAll().subscribe(utilisateurs => this.utilisateurs = utilisateurs,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: DroitUtilisateurDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Droit': e.droit?.authority ,
                'Utilisateur': e.utilisateur?.username ,
            }
        });

        this.criteriaData = [{
        //'Droit': this.criteria.droit?.authority ? this.criteria.droit?.authority : environment.emptyForExport ,
        //'Utilisateur': this.criteria.utilisateur?.username ? this.criteria.utilisateur?.username : environment.emptyForExport ,
        }];
      }
}
