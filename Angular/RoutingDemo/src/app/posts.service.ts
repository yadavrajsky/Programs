import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PostsService {
  url = 'https://jsonplaceholder.typicode.com/posts';
  constructor(private http: HttpClient) {}
  getPosts() {
    return this.http.get(this.url);
  }
  getPostById(id: any) {
    return this.http.get(this.url + '/' + id);
  }
}
