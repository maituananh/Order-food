import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { Router } from '@angular/router';
import { BaseService } from '@app/share/service/base-service.service';
import { User } from '@app/share/models/user';
import { take } from 'rxjs/operators';
@Component({
  selector: 'sb-create-user',
  // changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss']
})
export class CreateUserComponent implements OnInit {

  private id: string;
  user = new User();

  constructor(private router: Router, private baseService: BaseService) { 
    this.id = this.router.getCurrentNavigation()?.extras?.state?.id;
  }

  ngOnInit() {
    if (this.id) {
      this.baseService.doGetApi('api/user/' + this.id).pipe(take(1)).subscribe((res: any) => {
        const data = res.body.data;
        if (res.body.code == 200) {
          this.user.name = data.name;
          this.user.username = data.username;
          this.user.email = data.email;
          this.user.phone = data.phone;
        }
      });
    }
    console.log(this.user);
    
  }
}
