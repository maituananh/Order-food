import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Routes } from '@app/share/constants/routes';

@Component({
    selector: 'sb-error-401',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './error-401.component.html',
    styleUrls: ['error-401.component.scss'],
})
export class Error401Component implements OnInit {

    urlLogin: string = Routes.AUTH_LOGIN;

    constructor() {}
    ngOnInit() {}
}
