import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-output',
  templateUrl: './output.component.html',
  styleUrls: ['./output.component.css']
})
export class OutputComponent implements OnInit {
@Output() newcourseadded=new EventEmitter();
@Input() coursecount;
  constructor() { 
    this.coursecount=0;
  }
  addcourse(course:string)
  {
this.newcourseadded.emit(course);
  }
  ngOnInit(): void {
  }


}
