import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AppCommonModule } from '@common/app-common.module';
import { NavigationModule } from '@modules/navigation/navigation.module';

import * as productContainers from './containers';
import * as productService from './services';

@NgModule({
    imports: [CommonModule, RouterModule, AppCommonModule, NavigationModule],
    declarations: [...productContainers.containers],
    exports: [...productContainers.containers],
    providers: [...productService.service],
})
export class ProductModule {}
