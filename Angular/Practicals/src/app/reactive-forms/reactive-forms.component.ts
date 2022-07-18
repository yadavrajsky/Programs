import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SpaceValidator } from '../space.validation';

@Component({
  selector: 'app-reactive-forms',
  templateUrl: './reactive-forms.component.html',
  styleUrls: ['./reactive-forms.component.css'],
})
export class ReactiveFormsComponent implements OnInit {
  // Assigning FormControl object to control elements 
  // public fc: FormControl = new FormControl();


  // Assining FormControl using FormGroup
  public fg:FormGroup=new FormGroup({
    "fname":new FormControl('',[Validators.required,Validators.minLength(5),SpaceValidator.isSpace]),
    "lname":new FormControl('',Validators.minLength(5))
  })
  log(f:any)
  {
    console.log(f);
  }

  constructor() {}
  get uname()
  {
    return this.fg.get('fname');
  }

  ngOnInit(): void {}
}
