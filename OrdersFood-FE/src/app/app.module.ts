import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BaseService } from './share/service/base-service.service';
import { Interceptor } from './Interceptor';
import { AuthGuardService } from './share/service/AuthGuardService';

@NgModule({
    declarations: [AppComponent],
    imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule, ReactiveFormsModule],
    providers: [BaseService, {provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true}, AuthGuardService],
    bootstrap: [AppComponent],
})
export class AppModule {}
