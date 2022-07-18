import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-evvent',
  templateUrl: './evvent.component.html',
  styleUrls: ['./evvent.component.css']
})
export class EvventComponent implements OnInit {
count;
isopen;
val;
  constructor() {
    this.count=0;
    this.isopen=true;
    this.val="Ak";
   }

  ngOnInit(): void {
  }
  increase()
  {
this.count++;
  }
  decrease()
  {
this.count--;
  }
  openclose()
  {
    this.isopen=!this.isopen;

  }
 fun1(event:any) {
  alert(event.target.value);
}
fun2(value:any) {
  alert(value);
}
}
