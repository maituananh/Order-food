import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '@app/share/models/user';
import { BaseService } from '@app/share/service/base-service.service';

@Component({
    selector: 'sb-user-list',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './user-list.component.html',
    styleUrls: ['./user-list.component.scss'],
})
export class UserListComponent implements OnInit {
    dataModel: Array<User> = new Array<User>();

    constructor(private baseService: BaseService, private router: Router) {}

    ngOnInit(): void {
        // get data user
        this.baseService.doGetApi('api/user/').subscribe((res: any) => {
            // this.dataModel = res.body.data;
            res.body.data.forEach((element: User) => {
                this.dataModel.push(element);
            });
            // console.log(this.dataModel);
        });
    }

    onAction(event: any) {
        if (event.action === 'edit') {
            this.router.navigate(['user/create'], { state: { id: event.id, name: event.action } });
        } else if (event.action === 'delete') {
            this.baseService.doDeleteApi('api/user/delete/' + event.id).subscribe((res: any) => {
                if (res.code === 200) {
                    console.log('ok');
                }
            });
        }
    }
}
