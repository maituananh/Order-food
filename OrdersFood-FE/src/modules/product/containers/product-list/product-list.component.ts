import { Component, OnInit } from '@angular/core';
import { Product } from '@app/share/models/product';
import { BaseService } from '@app/share/service/base-service.service';
import { ProductService } from '@modules/product/services';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
  title = "Product List";
  products: Array<Product> = new Array<Product>();

  constructor(private productService: ProductService, private baseService: BaseService) { }

  ngOnInit() {
    this.baseService.doGetApi('api/product/get').subscribe(res => {
      this.products = res.body.data;
    });
  }

}
