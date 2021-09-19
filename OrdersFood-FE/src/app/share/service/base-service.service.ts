import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Routes } from '../constants/routes';

@Injectable({
  providedIn: 'root'
})
export class BaseService {

  private BASE_URL: string = 'http://localhost:8080/';
  private HEADER: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json; charset=utf-8',
    'Access-Control-Allow-Origin': this.BASE_URL,
    'Access-Control-Allow-Credentials': 'true',
    'Access-Control-Allow-Methods': '*',
    'Access-Control-Allow-Headers': 'Origin, Content-Type, Accept',
  });

  constructor(private http: HttpClient) { }

  public doGetApi(url: string): Observable<Object> {
    return this.http.get(this.BASE_URL.concat(url), {
      headers: this.HEADER,
      observe: 'response' as 'body',
    }).pipe(catchError(this.handleError));
  }

  public doPostApi(url: string, data: any): Observable<any> {
    return this.http.post(this.BASE_URL.concat(url), data, {
      headers: this.HEADER,
      observe: 'response' as 'body',
    }).pipe(catchError(this.handleError));
  }

  public doPutApi(url: string, data: any): Observable<Object> {
    return this.http.put(this.BASE_URL.concat(url), data, {
      headers: this.HEADER,
    }).pipe(catchError(this.handleError));
  }

  public doDeleteApi(url: string): Observable<Object> {
    return this.http.delete(this.BASE_URL.concat(url), {
      headers: this.HEADER,
    }).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error) {
      localStorage.clear();

      if (error.status == 403) {
        window.location.href = Routes.ERROR_401;
      } else if (error.status == 0) {
        // window.location.href = Routes.ERROR_500;
      }
    }
    return throwError(error);
  }
}
