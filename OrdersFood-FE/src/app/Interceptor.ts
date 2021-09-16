import { HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class Interceptor implements HttpInterceptor{

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = localStorage.getItem('authorization');
    if (token !== null) {
      const headers = new HttpHeaders().set('authorization', token);
      const authRequest = req.clone({headers: headers});
      return next.handle(authRequest);
    } else {
      return next.handle(req);
    }
  }
}
