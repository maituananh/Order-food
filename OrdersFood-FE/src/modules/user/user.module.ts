import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AppCommonModule } from '@common/app-common.module';
import { NavigationModule } from '@modules/navigation/navigation.module';
import { TablesModule } from '@modules/tables/tables.module';

import * as userComponent from './components';
import * as userContainers from './containers';

@NgModule({
    imports: [
        CommonModule,
        RouterModule,
        ReactiveFormsModule,
        FormsModule,
        AppCommonModule,
        NavigationModule,
        TablesModule,
        // UserRoutingModule,
    ],
    providers: [],
    exports: [...userContainers.containers, ...userComponent.components],
    declarations: [...userContainers.containers, ...userComponent.components],
})
export class UserModule {}
