import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class GetdataService {
  url: string;
  constructor(private http: HttpClient) {
    this.url = 'https://jsonplaceholder.typicode.com/posts';
  }
  getData() {
    return this.http.get(this.url);
  }
  deleteData(id: any) {
    return this.http.delete(this.url + '/' + id);
  }
  updateData(id: any, obj: any) {
    return this.http.put(this.url + '/' + id, obj);
  }
}
