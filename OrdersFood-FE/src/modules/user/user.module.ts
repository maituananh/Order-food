import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppCommonModule } from '@common/app-common.module';
import { NavigationModule } from '@modules/navigation/navigation.module';
import * as userContainers from './containers';
import * as userComponent from './components';
import { TablesModule } from '@modules/tables/tables.module';

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
export class UserModule { }
