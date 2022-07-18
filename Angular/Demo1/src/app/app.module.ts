import { DemoComponent } from './demo.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { FormControl, FormsModule, NgModel } from '@angular/forms';
import { SignInComponent } from './sign-in/sign-in.component';
import { BindingComponent } from './binding/binding.component';
import { EvventComponent } from './evvent/evvent.component';
import { LoginComponent } from './login/login.component';
import { StructuralDirectiveComponent } from './structural-directive/structural-directive.component';

@NgModule({
  declarations: [
    AppComponent,DemoComponent, RegisterComponent, SignInComponent, BindingComponent, EvventComponent, LoginComponent, StructuralDirectiveComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
