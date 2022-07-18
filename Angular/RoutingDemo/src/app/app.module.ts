import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PostsComponent } from './posts/posts.component';
import { CardsComponent } from './cards/cards.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PostsService } from './posts.service';
import { PostDetailsComponent } from './post-details/post-details.component';
import { FirebasedemoComponent } from './firebasedemo/firebasedemo.component';
import {AngularFireModule} from '@angular/fire/compat';
import {AngularFireStorageModule} from '@angular/fire/compat/storage';
import {AngularFireDatabaseModule} from '@angular/fire/compat/database';
import { environment} from '../../src/environments/environment';
import { PipedemoComponent } from './pipedemo/pipedemo.component'

@NgModule({
  declarations: [
    AppComponent,
    PostsComponent,
    CardsComponent,
    NavbarComponent,
    PostDetailsComponent,
    FirebasedemoComponent,
    PipedemoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireStorageModule,
    AngularFireDatabaseModule
  ],
  providers: [PostsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
