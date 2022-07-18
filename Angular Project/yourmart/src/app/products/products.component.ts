import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductsService } from '../products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit {
  categories$: any;
  category: any;
  products: any;
  filterProducts: any = [];
  constructor(
    private productservice: ProductsService,
    private ar: ActivatedRoute
  ) {
    this.categories$ = this.productservice.getCategories();
    this.productservice.getProducts().subscribe((data) => {
      this.products = data;
      // console.log(this.products);
      ar.queryParams.subscribe((pm) => {
        this.category = pm['category'];
        this.filterProducts=this.category?this.products.filter((p:any)=>p.category==this.category):this.products;
        // this.products=this.filterProducts;
        // console.log(this.products);
        // console.log(this.filterProducts);
      });
      // console.log(this.categories$);
    });
  }

  ngOnInit(): void {}
}
