import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService:AuthService,public router:Router){}

  canActivate(
    route:ActivatedRouteSnapshot):boolean {
      
      const expectedRole=route.data.role;  //commming from app.routing.module

      const currentRole=localStorage.getItem("ACCESS_ROLE");
      if(currentRole!==expectedRole){
        this.router.navigateByUrl('login');
        return false;
      }
    return true;
  }
  
}
