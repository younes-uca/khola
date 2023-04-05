import {Component, OnInit} from '@angular/core';
import {DroitService} from 'src/app/controller/service/Droit.service';
import {DroitDto} from 'src/app/controller/model/Droit.model';
import {DroitCriteria} from 'src/app/controller/criteria/DroitCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import {Router} from '@angular/router';
import { environment } from 'src/environments/environment';
import { RoleService } from 'src/app/zynerator/security/Role.service';
import {DatePipe} from '@angular/common';



import { MessageService, ConfirmationService } from 'primeng/api';
import { AuthService } from 'src/app/zynerator/security/Auth.service';
import { ExportService } from 'src/app/zynerator/util/Export.service';

@Component({
  selector: 'app-droit-list-admin',
  templateUrl: './droit-list-admin.component.html'
})
export class DroitListAdminComponent extends AbstractListController<DroitDto, DroitCriteria, DroitService>  implements OnInit {

    fileName = 'Droit';

  
    constructor(datePipe: DatePipe, droitService: DroitService, messageService: MessageService, confirmationService: ConfirmationService
        , roleService: RoleService, router: Router , authService: AuthService , exportService: ExportService
) {
        super(datePipe, droitService, messageService, confirmationService, roleService, router, authService, exportService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadDroits(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Droit', 'list');
        isPermistted ? this.service.findAll().subscribe(droits => this.items = droits,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'authority', header: 'Authority'},
        ];
    }



	public initDuplicate(res: DroitDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Authority': e.authority ,
            }
        });

        this.criteriaData = [{
            'Authority': this.criteria.authority ? this.criteria.authority : environment.emptyForExport ,
        }];
      }
}
