import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  coursename;
  fontsizepx: any;
  coursenames: string[];
  title = 'Practicals';
  width = '400px';
  wpx = 400;
  link = 'https://google.com';
  align = 'center';
  color = 'lightgreen';
  currentStyle = {
    fontSize: '100px',
    color: 'green',
    'font-weight': 'bold',
  };
  constructor() {
    this.fontsizepx = 16;
    this.coursename = 'angular';
    this.coursenames = [];
  }
  deletecourse(i: number) {
    this.coursenames.splice(i, 1);
  }
  addItemToArray(course: string) {
    this.coursenames.push(course);
  }
}
