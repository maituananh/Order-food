import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BaseService {

  private BASE_URL: string = 'http://localhost:8080/';
  private HEADER: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json; charset=utf-8', 
    'Access-Control-Allow-Origin':  this.BASE_URL,
    'Access-Control-Allow-Credentials': 'true',
    'Access-Control-Allow-Methods' : '*',
    'Access-Control-Allow-Headers' : 'Origin, Content-Type, Accept',
  });

  constructor(private http: HttpClient) {}

  public doGetApi(url: string): Observable<Object> {
    this.HEADER.set('token', '');

    return this.http.get(this.BASE_URL.concat(url), {
      headers: this.HEADER,
    }).pipe(catchError(this.handleError));
  }

  public doPostApi(url: string, data: any): Observable<any> {
    this.HEADER.set('token', '');

    return this.http.post(this.BASE_URL.concat(url), data, {
      headers: this.HEADER,
      observe: 'response' as 'body',
      responseType: 'json'
    }).pipe(catchError(this.handleError));
  }

  public doPutApi(url: string, data: any): Observable<Object> {
    this.HEADER.set('token', '');

    return this.http.put(this.BASE_URL.concat(url), data, {
      headers: this.HEADER,
    }).pipe(catchError(this.handleError));
  }

  public doDeleteApi(url: string): Observable<Object> {
    this.HEADER.set('token', '');

    return this.http.delete(this.BASE_URL.concat(url), {
      headers: this.HEADER,
    }).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    return throwError(error);
}
}
