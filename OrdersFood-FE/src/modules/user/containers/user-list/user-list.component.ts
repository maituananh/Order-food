import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { User } from '@app/share/models/user';
import { BaseService } from '@app/share/service/base-service.service';

@Component({
  selector: 'sb-user-list',
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  dataModel: Array<User> = new Array<User>();

  constructor(private baseService: BaseService) { }

  ngOnInit(): void {
    // get data user
    this.baseService.doGetApi('api/user/').subscribe((res: any) => {
      this.dataModel = res.body.data
      console.log(res.body.data);
    });
  }

}
