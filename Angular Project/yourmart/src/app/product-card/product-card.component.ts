import { state } from '@angular/animations';
import { Component, Input, OnInit } from '@angular/core';
import { ProductsService } from '../products.service';
import { ShoppingCartService } from '../shopping-cart.service';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css'],
})
export class ProductCardComponent implements OnInit {
  constructor(private scs: ShoppingCartService) {
    this.button_state = true;
  }
  no_of_products: number = 1;
  button_state: boolean;
  @Input() Product: any;
  cartid: any;
  addToCart(product: any, quantity: any) {
    this.cartid = localStorage.getItem('cartid');
    if (this.cartid == null) {
      this.scs.create().then((result: any) => {
        localStorage.setItem('cartid', result.key);
        this.cartid = result.key;
      });
    }
    this.scs.addtocart(product, quantity);
    // console.log(this.Product);
  }

  incrementQuantity() {
    this.no_of_products++;
    if (this.no_of_products > 1) {
      this.button_state = false;
    }
  }
  decrementQuantity() {
    if (this.no_of_products == 1) {
      this.button_state = true;
    } else {
      this.no_of_products--;
    }
  }
  ngOnInit(): void {}
}
