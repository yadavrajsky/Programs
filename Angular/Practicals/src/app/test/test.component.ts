import { Component } from '@angular/core';
import { FormControl, Validators} from '@angular/forms';

  @Component({
  selector: 'app-test',
    template: `
       <input [formControl]="control">
  
       <p>Value: {{ control.value }}</p>
       <p>Validation status: {{ control.status }}</p>
  
       <button (click)="setValue()">Set value</button>
    `,
  })
  export class TestComponent {

    control: FormControl = new FormControl('value', Validators.minLength(2));

    setValue() {
      this.control.setValue('new value');
    }

}
