import {Component, OnInit, Input} from '@angular/core';

import {RoleService} from 'src/app/zynerator/security/Role.service';
import { ConfirmationService, MessageService } from 'primeng/api';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { environment } from 'src/environments/environment';
import { DatePipe } from '@angular/common';

import { StringUtilService } from 'src/app/zynerator/util/StringUtil.service';
import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ProduitService} from 'src/app/controller/service/Produit.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitCriteria} from 'src/app/controller/criteria/ProduitCriteria.model';
@Component({
  selector: 'app-produit-create-admin',
  templateUrl: './produit-create-admin.component.html'
})
export class ProduitCreateAdminComponent extends AbstractCreateController<ProduitDto, ProduitCriteria, ProduitService>  implements OnInit {



   private _validProduitReference = true;

    constructor(private datePipe: DatePipe, private produitService: ProduitService
     , private stringUtilService: StringUtilService, private roleService: RoleService,  private messageService: MessageService
    , private confirmationService: ConfirmationService, private router: Router  

    ) {
        super(datePipe, produitService, messageService, confirmationService, roleService, router, stringUtilService);
    }

    ngOnInit(): void {
}




    public setValidation(value: boolean){
        this.validProduitReference = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateProduitReference();
    }

    public validateProduitReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validProduitReference = false;
        } else {
            this.validProduitReference = true;
        }
    }






    get validProduitReference(): boolean {
        return this._validProduitReference;
    }

    set validProduitReference(value: boolean) {
         this._validProduitReference = value;
    }



}
