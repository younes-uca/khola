import {Component, OnInit, Input} from '@angular/core';

import {RoleService} from 'src/app/zynerator/security/Role.service';
import { ConfirmationService, MessageService } from 'primeng/api';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { environment } from 'src/environments/environment';
import { DatePipe } from '@angular/common';

import { StringUtilService } from 'src/app/zynerator/util/StringUtil.service';
import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {DroitService} from 'src/app/controller/service/Droit.service';
import {DroitDto} from 'src/app/controller/model/Droit.model';
import {DroitCriteria} from 'src/app/controller/criteria/DroitCriteria.model';
@Component({
  selector: 'app-droit-create-admin',
  templateUrl: './droit-create-admin.component.html'
})
export class DroitCreateAdminComponent extends AbstractCreateController<DroitDto, DroitCriteria, DroitService>  implements OnInit {



   private _validDroitAuthority = true;

    constructor(private datePipe: DatePipe, private droitService: DroitService
     , private stringUtilService: StringUtilService, private roleService: RoleService,  private messageService: MessageService
    , private confirmationService: ConfirmationService, private router: Router  

    ) {
        super(datePipe, droitService, messageService, confirmationService, roleService, router, stringUtilService);
    }

    ngOnInit(): void {
}




    public setValidation(value: boolean){
        this.validDroitAuthority = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateDroitAuthority();
    }

    public validateDroitAuthority(){
        if (this.stringUtilService.isEmpty(this.item.authority)) {
        this.errorMessages.push('Authority non valide');
        this.validDroitAuthority = false;
        } else {
            this.validDroitAuthority = true;
        }
    }






    get validDroitAuthority(): boolean {
        return this._validDroitAuthority;
    }

    set validDroitAuthority(value: boolean) {
         this._validDroitAuthority = value;
    }



}
