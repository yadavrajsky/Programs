import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginlogoutService } from '../loginlogout.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(public loginlogout:LoginlogoutService,  private router:Router) { }

  ngOnInit(): void {
  }
  login() {
    this.loginlogout.login();
    this.router.navigate(['/']);


  }


}
