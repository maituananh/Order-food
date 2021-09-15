import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ServiceComponent {

  private BASE_URL: string = 'localhost:8080/';
  private HEADER: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json; charset=utf-8'});

  constructor(private http: HttpClient) {}

  public doGetApi(url: string): Observable<Object> {
    this.HEADER.set('token', '');

    return this.http.get(this.BASE_URL.concat(url), {
      headers: this.HEADER,
    }).pipe(catchError(this.handleError));
  }

  public doPostApi(url: string, data: any): Observable<Object> {
    this.HEADER.set('token', '');

    return this.http.post(this.BASE_URL.concat(url), data, {
      headers: this.HEADER,
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
