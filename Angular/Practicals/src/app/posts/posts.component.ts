import { Component, OnInit } from '@angular/core';
import { GetdataService } from '../getdata.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css'],
})
export class PostsComponent implements OnInit {
  posts: any;
  obj: any;
  constructor(private service: GetdataService) {
    service.getData().subscribe((data) => {
      this.posts = data;
      this.obj = JSON.stringify({
        title: 'New Title',
      });
    });
  }
  deletepost(id: any) {
    this.service.deleteData(id).subscribe((data) => {
      this.posts.splice(id - 1, 1);
    });
  }
  updatepost(id: any) {
    this.service.updateData(id, this.obj).subscribe((data) => {
      console.log(data);
      this.posts[id - 1].title = 'This is new title';
    });
  }
  ngOnInit(): void {}
}
