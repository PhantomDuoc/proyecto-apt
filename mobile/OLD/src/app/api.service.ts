import { Injectable } from '@angular/core';
import { Observable, observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators'

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

const apiURL = "http://localhost:8091/v1/departamento/gerencia/usuario/findAll";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `content was: ${error.error}`);
    }
    return throwError('Something bad happened; please try again later.');
  }

  private extractData(res: Response) {
    let content = res;
    return content || { };
  }

  getDataUser(): Observable<any> {
    return this.http.get(apiURL, httpOptions).pipe(
      map(this.extractData),
      catchError(this.handleError));
  }
}