import { Injectable } from '@angular/core';
import { AngularFireDatabase } from '@angular/fire/compat/database';

@Injectable({
  providedIn: 'root',
})
export class ProductsService {
  cartid: any;
  constructor(private db: AngularFireDatabase) {
    this.cartid = localStorage.getItem('cartid');
  }
  getProducts() {
    return this.db.list('/products').valueChanges();
  }
  getCategories() {
    return this.db.list('/category').valueChanges();
  }
  getAllCartProducts() {
    return this.db.list('/shopping-cart/' + this.cartid + '/items').snapshotChanges();
  }
  removeProduct(product_key: any) {
    this.db
      .list('/shopping-cart/' + this.cartid + '/items')
      .remove(product_key);
  }
  updateProduct(key: any, product: any, quantity: any) {
    console.log(key,product,quantity);
   console.log(this.db.list('/shopping-cart/' + this.cartid + '/items').update(key, {
      products: product,
      quantity: Number(quantity)
    }));
  }
}
