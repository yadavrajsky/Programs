import { Component, OnInit } from '@angular/core';
import { LoginlogoutService } from '../loginlogout.service';
import { ProductsService } from '../products.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  count: any;
  constructor(public loginlogout: LoginlogoutService,private ps:ProductsService) {
    ps
      .getAllCartProducts().subscribe((data:any) => {
        this.count = data.length;
      });
  }
  logout() {
    this.loginlogout.logout();
  }
  ngOnInit(): void {}
}
