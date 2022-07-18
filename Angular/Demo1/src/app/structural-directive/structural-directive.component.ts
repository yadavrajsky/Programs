import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-structural-directive',
  templateUrl: './structural-directive.component.html',
  styleUrls: ['./structural-directive.component.css']
})
export class StructuralDirectiveComponent implements OnInit {
val;
  odds;
  evens;
  primes;
  pressed_button;
  courses;
  constructor() { 
    this.evens=[2,4,6,8];
    this.odds=[3,5,7,8];
    this.primes=[3,5,7,11];
    this.val=false;
    this.courses=['java','c++','python'];
    this.pressed_button="";
    
  }
remove(index:number)
{
  this.courses.splice(index,1);
}

  ngOnInit(): void {
  }

}
