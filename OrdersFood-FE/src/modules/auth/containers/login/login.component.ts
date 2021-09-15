import { HttpResponse } from '@angular/common/http';
import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { LogApp } from '@app/share/models/log-app';
import { BaseService } from '@app/share/service/base-service.service';

@Component({
    selector: 'sb-login',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './login.component.html',
    styleUrls: ['login.component.scss'],
})
export class LoginComponent implements OnInit {

    formLogin = new FormGroup({
        username: new FormControl(''),
        password: new FormControl(''),
    });

    private logApp: LogApp;

    constructor(private baseService: BaseService) {
        this.logApp = new LogApp();
    }
    ngOnInit() {}

    onSubmit() {
        this.logApp.username = this.formLogin.value['username'];
        this.logApp.password = this.formLogin.value['password'];
        
        this.baseService.doPostApi("api/public/login", this.logApp).subscribe((_response: HttpResponse<any>) => {
            console.log(_response.headers);
            const header = _response.headers.get('authorization');
            console.log(header)
            
        });
    }
}
