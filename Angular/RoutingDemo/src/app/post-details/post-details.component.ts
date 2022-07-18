import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PostsService } from '../posts.service';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.css'],
})
export class PostDetailsComponent implements OnInit {
  id: any;
  postdata:any;
  constructor(private activatedroute: ActivatedRoute,private pservice:PostsService ) {
    activatedroute.paramMap.subscribe((data) => {
      this.id = data.get('id');
    });
    this.pservice.getPostById(this.id).subscribe(data=>
      {
this.postdata=data;
      })
  }

  ngOnInit(): void {}
}
