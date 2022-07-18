import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Demo1';
  msg = 'Welcome to angular';
  src = '../assets/cup_light.jpg';
  state = true;
  w = 100;
  col = '2';
  wd = 2;
  color = 'blue';
  width = '200px';
  wdx = 200;
  currentState;
  constructor() {
    this.currentState = {
      fontSize: '178',
      'background-color': 'yellow',
      // backgroundColor:"green",
      width: '500px',
      height: '100px',
      border: '1px solid green',
    };
  }
}
