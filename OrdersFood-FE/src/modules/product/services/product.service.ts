import { Injectable } from '@angular/core';
import { BaseService } from '@app/share/service/base-service.service';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private baseService: BaseService) { }

  async getAllProduct() {
    return await this.baseService.doGetApi('api/product/get').subscribe(res => {
      console.log(res);
      return res;
    });
  }
  
}
