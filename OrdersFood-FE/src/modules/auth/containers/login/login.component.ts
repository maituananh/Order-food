import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Api } from '@app/share/constants/api';
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

    constructor(private baseService: BaseService, private router: Router) {
        this.logApp = new LogApp();
    }
    ngOnInit() {}

    onSubmit() {
        if (localStorage.getItem('authorization')) {
            localStorage.clear();
        }

        this.logApp.username = this.formLogin.value.username;
        this.logApp.password = this.formLogin.value.password;

        this.baseService.doPostApi(Api.API_LOGIN, this.logApp).subscribe(_response => {
            const authorization = _response.headers.get('authorization');
            localStorage.setItem('authorization', authorization);

            if (authorization && _response.status === 200) {
                this.router.navigate(['/dashboard']);
            }
        });
    }
}
