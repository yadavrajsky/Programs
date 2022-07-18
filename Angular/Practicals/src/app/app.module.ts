import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EventComponent } from './event/event.component';
import { TwoWayDataBindingComponent } from './two-way-data-binding/two-way-data-binding.component';
import { StructuralDirectivesComponent } from './structural-directives/structural-directives.component';
import { InputComponent } from './input/input.component';
import { OutputComponent } from './output/output.component';
import { SizeChangeComponent } from './size-change/size-change.component';
import { TwdbipComponent } from './twdbip/twdbip.component';
import { HighlightDirective } from './highlight.directive';
import { CapitalDirective } from './capital.directive';
import { FormHandlingComponent } from './form-handling/form-handling.component';
import { ReactiveFormsComponent } from './reactive-forms/reactive-forms.component';
import { TestComponent } from './test/test.component';
import { HttpClientModule } from '@angular/common/http';
import { WebServiceComponent } from './web-service/web-service.component';
import { PostsComponent } from './posts/posts.component'
import { GetdataService } from './getdata.service';

@NgModule({
  declarations: [
    AppComponent,
    EventComponent,
    TwoWayDataBindingComponent,
    StructuralDirectivesComponent,
    InputComponent,
    OutputComponent,
    SizeChangeComponent,
    TwdbipComponent,
    HighlightDirective,
    CapitalDirective,
    FormHandlingComponent,
    ReactiveFormsComponent,
    TestComponent,
    WebServiceComponent,
    PostsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [GetdataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
