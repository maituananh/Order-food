import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'sb-create-user',
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.scss']
})
export class CreateUserComponent implements OnInit {

  private id: string;

  constructor(private router: Router) { 
    this.id = this.router.getCurrentNavigation()?.extras?.state?.id;
  }

  ngOnInit(): void {
    if (this.id) {
      // request
    }
  }

}
