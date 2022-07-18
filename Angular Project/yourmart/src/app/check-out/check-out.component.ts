import { Component, OnInit } from '@angular/core';
import { LoginlogoutService } from '../loginlogout.service';

@Component({
  selector: 'app-check-out',
  templateUrl: './check-out.component.html',
  styleUrls: ['./check-out.component.css']
})
export class CheckOutComponent implements OnInit {

  constructor(private lls:LoginlogoutService) { 
    lls.checkout();
  }

  ngOnInit(): void {
  }

}
