import { Component, OnInit } from '@angular/core';
import { LoginlogoutService } from '../loginlogout.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(public loginlogout:LoginlogoutService) {
    
   }

  ngOnInit(): void {
  }

}
