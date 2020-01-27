import { Injectable } from '@angular/core';
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs";
import {Authority} from "../../models/security-models/Authority.model";
import {List} from "../../lib/list";
import * as jwt from "angular2-jwt";

@Injectable()
export class AuthService {
  private authUrl = 'http://localhost:8080/api/login';
  private headers = new Headers({'Content-Type': 'application/json'});
  private helper = new jwt.JwtHelper();
  private options = new RequestOptions({headers: this.headers});

  constructor(private http: Http) {
  }
  login(username: string, password: string): Observable<boolean> {
    return this.http.post(this.authUrl, JSON.stringify({username: username, password: password}), this.options)
      .map((response: Response) => {
        // login successful if there's a jwt token in the response
        let token = response.json() && response.json().token;
        if (token) {
          // store username and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify({ username: username, token: token }));
          // return true to indicate successful login
          return true;
        } else {
          // return false to indicate failed login
          return false;
        }
      }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }
  getToken(): string {
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    let token = currentUser && currentUser.token;
    return token ? token : "";
  }
  logout(): void {
    // clear token remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }

  isLoggedIn(): boolean {
    let token: String = this.getToken();
    return token && token.length > 0;
  }

  hasRole(role:string): boolean {
    let marker: boolean = false;
    let decodedToken  = this.helper.decodeToken(this.getToken());
    let l = decodedToken['roles']['length'];
    let i:number;
    for(i=0; i < l; i++){
      if(decodedToken['roles'][i]['authority']===role){
        marker = true;
      }
    }
    return marker;
  }
}
