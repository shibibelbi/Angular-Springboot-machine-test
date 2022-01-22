import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Login } from './login';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient:HttpClient, private router:Router) { }

  public loginVerify(user:Login){
    console.log(user.username);
    console.log(user.password);

    //calling web service and passing username and password

    return this.httpClient.get<Login>(environment.apiUrl + "/api/login/" +user.username + "&" + user.password);

  }

  public logOut(){
    sessionStorage.removeItem('username');
    localStorage.removeItem('username');
    localStorage.removeItem('ACCESS_ROLE');
  }

}
