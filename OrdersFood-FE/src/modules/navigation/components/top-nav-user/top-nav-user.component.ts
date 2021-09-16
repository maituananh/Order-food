import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Routes } from '@app/share/constants/routes';
import { UserService } from '@modules/auth/services';

@Component({
    selector: 'sb-top-nav-user',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './top-nav-user.component.html',
    styleUrls: ['top-nav-user.component.scss'],
})
export class TopNavUserComponent implements OnInit {

    urlLogin: string = Routes.AUTH_LOGIN;

    constructor(public userService: UserService) {}

    ngOnInit() {}

    onLogout() {
        localStorage.clear();
    }
}
