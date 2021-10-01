import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '@app/share/models/product';
import { BaseService } from '@app/share/service/base-service.service';
import { map, switchMap } from 'rxjs/operators';

@Component({
    selector: 'sb-product-detail',
    templateUrl: './product-detail.component.html',
    styleUrls: ['./product-detail.component.scss'],
})
export class ProductDetailComponent implements OnInit {
    product: Product = new Product();
    title: string = 'Product Detail';

    constructor(private activatedRoute : ActivatedRoute, private baseService : BaseService) {}

    ngOnInit(): void {
        this.activatedRoute.paramMap.pipe(
            map(param => param.get('id')),
            switchMap(id => this.baseService.doGetApi('api/product/get/' + id))
        ).subscribe(product => {this.product = product.body.data});
    }
}
