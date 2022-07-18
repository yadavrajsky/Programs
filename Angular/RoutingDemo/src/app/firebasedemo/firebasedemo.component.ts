import { Component, OnInit } from '@angular/core';
import { AngularFireDatabase } from '@angular/fire/compat/database';

@Component({
  selector: 'app-firebasedemo',
  templateUrl: './firebasedemo.component.html',
  styleUrls: ['./firebasedemo.component.css'],
})
export class FirebasedemoComponent implements OnInit {
  courses$;
  constructor(private db: AngularFireDatabase) {
    // snapshotChanges
    this.courses$ = db.list('/courses').snapshotChanges();

    // value changes
    //  this.courses$= db.list("/courses").valueChanges();
  }
  insertcourse(cname: HTMLInputElement, fees: HTMLInputElement) {
    let coursename = cname.value;
    let price = Number(fees.value);
    this.db.list('/courses').push({ coursename: coursename, price: price });
  }
  updatecourse(key:any,price:HTMLInputElement) {
    let uprice=Number(price.value);
    this.db.list("/courses").update(key,{'price' :uprice});
  }
  deletecourse(key:any)
  {
    this.db.list("/courses").remove(key);

  }
  ngOnInit(): void {}
}
