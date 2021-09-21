import { UserService } from './../../services/user.service';
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
import { SBSortableHeaderDirective, SortEvent } from '@modules/tables/directives';
import { Country } from '@modules/tables/models';
// import { Action } from '@modules/tables/models/action.model';
import { CountryService } from '@modules/tables/services';
import { Observable } from 'rxjs';
import { Action } from 'rxjs/internal/scheduler/Action';
import { User } from '@app/share/models/user';


@Component({
    selector: 'sb-ng-bootstrap-table',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './ng-bootstrap-table.component.html',
    styleUrls: ['ng-bootstrap-table.component.scss'],
})
export class NgBootstrapTableComponent implements OnInit {
    @Input() pageSize = 10;
    @Input() dataTable: Array<User>;
    @Output() outID = new EventEmitter<any>();

    countries$!: Observable<User[]>;
    total$!: Observable<number>;
    sortedColumn!: string;
    sortedDirection!: string;

    @ViewChildren(SBSortableHeaderDirective) headers!: QueryList<SBSortableHeaderDirective>;

    constructor(
        public countryService: UserService,
        private changeDetectorRef: ChangeDetectorRef
    ) {
        this.countryService.dataTable = this.dataTable;
    }

    ngOnInit() {
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
            id: id,
            action: action,
        };
        this.outID.emit(ob);
    }
}
