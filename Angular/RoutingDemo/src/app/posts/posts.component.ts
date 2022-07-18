import { Component, OnInit } from '@angular/core';
import { PostsService } from '../posts.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {
postsdata:any;
  constructor(postservice:PostsService) {
    postservice.getPosts().subscribe(data=>{
      this.postsdata=data;
    })
   }

  ngOnInit(): void {
  }

}
