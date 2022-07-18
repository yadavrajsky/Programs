import { Injectable } from '@angular/core';
import { AngularFireDatabase } from '@angular/fire/compat/database';

@Injectable({
  providedIn: 'root',
})
export class ShoppingCartService {
  constructor(private db: AngularFireDatabase) {}
  create() {
    return this.db.list('/shopping-cart').push(Math.random() * 100);
    //push() return promise
  }
  addtocart(product: any, quantity: any) {
    let cartid: any = localStorage.getItem('cartid');
    let item: any;
    let key: any;
    this.db
      .list('/shopping-cart/' + cartid + '/items')
      .snapshotChanges()
      .subscribe((data) => {
        for (let i = 0; i < data.length; i++) {
          item = data[i].payload.toJSON();
          if (item.products.title == product.title) {
            key = data[i].key;
            this.db.list('/shopping-cart/' + cartid + '/items').update(key, {
              products: product,
              quantity: Number(quantity),
            });
            break;
          }
        }
        if (!key) {
          this.db.list('/shopping-cart/' + cartid + '/items').push({
            products: product,
            quantity: Number(quantity),
          });
        }
      });
  }
}
