import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-twdbip',
  templateUrl: './twdbip.component.html',
  styleUrls: ['./twdbip.component.css'],
})
export class TwdbipComponent implements OnInit {
  @Input() size;
  constructor() {
    this.size = 0;
  }
  @Output() sizeChange = new EventEmitter();
  ngOnInit(): void {}
  increment() {
    this.size++;
    this.resizer();
  }
  decrement() {
    this.size--;
    this.resizer();
  }
  resizer() {
    this.sizeChange.emit(this.size);
  }
}
