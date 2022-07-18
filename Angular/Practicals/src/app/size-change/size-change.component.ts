import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-size-change',
  templateUrl: './size-change.component.html',
  styleUrls: ['./size-change.component.css']
})
export class SizeChangeComponent implements OnInit {
 @Input() fontsize:any;
 @Output() resize=new EventEmitter();
  constructor() {
    this.fontsize=0;
   }
   increment()
   {
     this.fontsize++;
     this.resizer();
   }
   decrement()
   {
     this.fontsize--;
     this.resizer();
   }
  ngOnInit(): void {
  }
  resizer()
  {
    this.resize.emit(this.fontsize);
  }


}
