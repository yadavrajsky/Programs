import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-structural-directives',
  templateUrl: './structural-directives.component.html',
  styleUrls: ['./structural-directives.component.css'],
})
export class StructuralDirectivesComponent implements OnInit {
  courses;
  val;
  clicked:string;
  primes:number[];
  evens:number[];
  odds:number[];
  constructor() {
    this.courses = ['java', 'c#', 'c', 'angular', 'cpp'];
    this.val=false;
    this.clicked="";
    this.primes=[2,3,5,7,11];
this.evens=[2,4,6,8,10];
this.odds=[3,5,7,9];
  }

  ngOnInit(): void {}
  remove(index: number) {
    this.courses.splice(index, 1);
  }
}
