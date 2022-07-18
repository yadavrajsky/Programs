import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-web-service',
  templateUrl: './web-service.component.html',
  styleUrls: ['./web-service.component.css'],
})
export class WebServiceComponent implements OnInit {
  fdata: any;
  constructor(http: HttpClient) {
    http.get('https://randomuser.me/api').subscribe((data) => {
      this.fdata = data;
    });
  }

  ngOnInit(): void {}
}
