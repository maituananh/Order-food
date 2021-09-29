import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService } from '@app/share/service/AuthGuardService';
import { SBRouteData } from '@modules/navigation/models';
import * as productContainers from './containers';
import { ProductModule } from './product.module';

export const ROUTES: Routes = [
    {
        path: 'product',
        pathMatch: 'full',
        redirectTo: '',
    },
    {
        path: 'create',
        canActivate: [],
        component: productContainers.CreateProductComponent,
        data: {
            title: 'Pages Login - SB Admin Angular',
        } as SBRouteData,
    },
    {
        path: '',
        canActivate: [],
        component: productContainers.ProductListComponent,
        data: {
            title: 'Pages Login - SB Admin Angular',
        } as SBRouteData,
    },
];

@NgModule({
    imports: [ProductModule, RouterModule.forChild(ROUTES)],
    exports: [RouterModule],
})
export class ProductRoutingModule {}
