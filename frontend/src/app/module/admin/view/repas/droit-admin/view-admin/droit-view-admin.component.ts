import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {DatePipe} from '@angular/common';

import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import {RoleService} from 'src/app/zynerator/security/Role.service';
import {StringUtilService} from 'src/app/zynerator/util/StringUtil.service';

import {MessageService} from 'primeng/api';
import {MenuItem} from 'primeng/api';
import { environment } from 'src/environments/environment';
import {DroitService} from 'src/app/controller/service/Droit.service';
import {DroitDto} from 'src/app/controller/model/Droit.model';
import {DroitCriteria} from 'src/app/controller/criteria/DroitCriteria.model';

@Component({
  selector: 'app-droit-view-admin',
  templateUrl: './droit-view-admin.component.html'
})
export class DroitViewAdminComponent extends AbstractViewController<DroitDto, DroitCriteria, DroitService> implements OnInit {


    constructor(private datePipe: DatePipe, private droitService: DroitService
                , private stringUtilService: StringUtilService, private roleService: RoleService,  private messageService: MessageService
                , private router: Router  

    ){
        super(datePipe, droitService, messageService, roleService, router, stringUtilService);
    }

    ngOnInit(): void {
    }




}
