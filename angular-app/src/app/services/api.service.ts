import {Injectable} from '@angular/core';
import {catchError, tap} from 'rxjs/internal/operators';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {map} from 'rxjs/operators';
import {IUser} from './model';

const endpoint = 'http://localhost:20212/zemoga/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) {
  }

  // tslint:disable-next-line:typedef
  private extractData(res: Response) {
    return res || {};
  }

  createUser(user: IUser): Observable<any> {
    return this.http.post<any>(endpoint + 'user', JSON.stringify(user), httpOptions).pipe(
      tap(() => {
        alert('Create user OK');
      }),
      catchError(this.handleError<any>('Create user'))
    );
  }

  readUser(id: number): Observable<any> {
    // tslint:disable-next-line:max-line-length
    return this.http.get<any>(endpoint + 'user/' + id, httpOptions).pipe(map(this.extractData), catchError(this.handleError<any>('readUser')));
  }

  readUsers(): Observable<any> {
    // tslint:disable-next-line:max-line-length
    return this.http.get<any>(endpoint + 'user/all', httpOptions).pipe(map(this.extractData), catchError(this.handleError<any>('readUsers')));
  }

  updateUser(user: IUser): Observable<any> {
    return this.http.put<any>(endpoint + 'user/' + user.id, JSON.stringify(user), httpOptions).pipe(
      tap(() => {
        alert('Update user OK');
      }),
      catchError(this.handleError<any>('Updated user'))
    );
  }

  readTweets(id: number): Observable<any> {
    // tslint:disable-next-line:max-line-length
    return this.http.get<any>(endpoint + 'user/' + id + '/tweets', httpOptions).pipe(map(this.extractData), catchError(this.handleError<any>('readTweets')));
  }

  // tslint:disable-next-line:typedef
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      alert(`${operation} failed: ${error.error.message}`);

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
