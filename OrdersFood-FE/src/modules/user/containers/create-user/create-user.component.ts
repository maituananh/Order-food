import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '@app/share/models/user';
import { BaseService } from '@app/share/service/base-service.service';
@Component({
    selector: 'sb-create-user',
    // changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './create-user.component.html',
    styleUrls: ['./create-user.component.scss'],
})
export class CreateUserComponent implements OnInit {
    id: string;
    user = new User();
    title = 'Create User';

    constructor(private router: Router, private baseService: BaseService) {
        this.id = this.router.getCurrentNavigation()?.extras?.state?.id;
    }

    ngOnInit() {
        if (this.id) {
            this.title = 'Update User';

            this.baseService.doGetApi('api/user/' + this.id).subscribe((res: any) => {
                const data = res.body.data;
                if (res.body.code === 200) {
                    this.user.id = data.id;
                    this.user.name = data.name;
                    this.user.username = data.username;
                    this.user.email = data.email;
                    this.user.phone = data.phone;
                    this.user.address = data.address;
                    this.user.password = data.password;
                }
            });
        }
    }

    onSubmit() {
        if (this.id) {
            console.log('alo', this.user);
            this.baseService.doPutApi('api/user/update', this.user).subscribe((res: any) => {
                this.router.navigate(['user']);
            });
        } else {
            this.baseService.doPostApi('api/user/save', this.user).subscribe((res: any) => {
                this.router.navigate(['user']);
            });
        }
    }
}
