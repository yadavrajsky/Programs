import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css'],
})
export class EventComponent implements OnInit {
  isopen;
  constructor() {
    this.isopen = true;
  }

  ngOnInit(): void {}
  openclose()
  {
    this.isopen=!this.isopen;
  }
//   eventhandler($event:any)
//   {
// alert($event.target.value);
//   }
  eventhandler(value:any)
  {
alert(value);
  }
}
