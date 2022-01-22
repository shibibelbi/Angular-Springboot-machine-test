import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../shared/auth.service';
import { Login } from '../shared/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  //declare variable for formGroup
  loginForm: FormGroup;

  //declare variable for submit
  isSubmitted: boolean = false;

  //create a variablr for error
  error: any = '';

  //create a variablr for user
  loginUser: Login;
  uName: String = '';

  //DI
  constructor(private formBuilder: FormBuilder, private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    //create a reactive form
    //username and password
    this.loginForm = this.formBuilder.group(
      {
        username: ['', [Validators.required]],
        password: ['', [Validators.required]]
      }
    );
  }

  //get control for validation
  get formControls() {
    return this.loginForm.controls;
  }

  //login verify method
  loginCredentials() {
    this.isSubmitted = true;

    //form is valid 
    if (this.loginForm.valid) {
      //calling method from webservice
      this.authService.loginVerify(this.loginForm.value)
        .subscribe(
          data => {
            console.log(data);
            this.uName = data.username;
            localStorage.setItem("username", data.username);
            sessionStorage.setItem("username", data.username);
            localStorage.setItem("ACCESS_ROLE", data.userType.toString());
            //form-level role based authentication 
            if (data.userType === "admin") {
              this.router.navigateByUrl('/admin')
            }
            else if (data.userType === "sc") {
              this.router.navigateByUrl('/salescoordinator')
            }
            else {
              this.error = "Sorry .... This role is not allowed";
            }
          },
          error => {
            console.log(error);
            this.error = "invalid Username or Password";
          }
        );
    }
    //form is in-valid
    return this.router;
  }


}
