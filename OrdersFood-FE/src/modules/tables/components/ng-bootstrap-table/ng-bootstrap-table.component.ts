import {
    ChangeDetectionStrategy,
    ChangeDetectorRef,
    Component,
    EventEmitter,
    Input,
    OnInit,
    Output,
    QueryList,
    ViewChildren,
} from '@angular/core';
import { User } from '@app/share/models/user';
import { SBSortableHeaderDirective, SortEvent } from '@modules/tables/directives';
import { Country } from '@modules/tables/models';
// import { Action } from '@modules/tables/models/action.model';
import { CountryService } from '@modules/tables/services';
import { Observable } from 'rxjs';
import { Action } from 'rxjs/internal/scheduler/Action';

import { UserService } from './../../services/user.service';

@Component({
    selector: 'sb-ng-bootstrap-table',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './ng-bootstrap-table.component.html',
    styleUrls: ['ng-bootstrap-table.component.scss'],
})
export class NgBootstrapTableComponent implements OnInit {
    @Input() pageSize = 2;
    @Input() dataTable: Array<User> = new Array<User>();
    @Output() outID = new EventEmitter<any>();

    countries$!: Observable<User[]>;
    total$!: Observable<number>;
    sortedColumn!: string;
    sortedDirection!: string;

    @ViewChildren(SBSortableHeaderDirective) headers!: QueryList<SBSortableHeaderDirective>;

    constructor(public countryService: UserService, private changeDetectorRef: ChangeDetectorRef) {}

    ngOnInit() {
        console.log(this.dataTable);
        this.countryService.dataTable = this.dataTable;

        this.countryService.pageSize = this.pageSize;
        this.countries$ = this.countryService.countries$;
        this.total$ = this.countryService.total$;
    }

    onSort({ column, direction }: SortEvent) {
        this.sortedColumn = column;
        this.sortedDirection = direction;
        this.countryService.sortColumn = column;
        this.countryService.sortDirection = direction;
        this.changeDetectorRef.detectChanges();
    }

    outActionID(id: number, action: string): void {
        const ob = {
            id,
            action,
        };
        this.outID.emit(ob);
    }
}
