import { Component, OnInit } from '@angular/core';
import { AngularFireDatabase } from '@angular/fire/compat/database';
import { ProductsService } from '../products.service';
import { ShoppingCartService } from '../shopping-cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  products: any = [];
  totalAmount: any;
  buttonStyle = {
    'btn btn-sm border border-dark text-center rounded-circle btn-outline-primary .quantity-atc':
      true,
  };
  constructor(private scs: ShoppingCartService, private ps: ProductsService) {
    ps.getAllCartProducts().subscribe((data: any) => {
      this.products = data;
      this.totalAmount = 0;
      for (let p of this.products) {
        p = p.payload.toJSON();
        this.totalAmount = this.totalAmount + p.products.price * p.quantity;
      }
    });
  }
  removeFromCart(product: any) {
    this.ps.removeProduct(product.title);
  }
  increaseQuantity(product_key: any, product: any, quantity: any) {
    quantity = Number(quantity);
    quantity++;
    this.ps.updateProduct(product_key, product, quantity);
  }

  decreaseQuantity(product_key: any, product: any, quantity: any) {
    quantity = Number(quantity);
    quantity--;
    this.ps.updateProduct(product_key, product, quantity);
  }
  ngOnInit(): void {}
}
