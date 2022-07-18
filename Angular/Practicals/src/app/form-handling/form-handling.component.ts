import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form-handling',
  templateUrl: './form-handling.component.html',
  styleUrls: ['./form-handling.component.css']
})
export class FormHandlingComponent implements OnInit {
  constructor() { }
errr={'required':true};

  ngOnInit(): void {
  }
  display(log:any)
  {
    console.log(log);
    console.log(this.errr['required'])
  }
  show(form:any)
  {

    console.log(form.form.value['t1']);
  }
  
}
