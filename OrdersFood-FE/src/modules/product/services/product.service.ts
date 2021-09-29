import { Injectable } from '@angular/core';
import { BaseService } from '@app/share/service/base-service.service';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private baseService: BaseService) { }

  getAllProduct() {
    return this.baseService.doGetApi('').subscribe(res => {
      return res;
    })
  }
}
