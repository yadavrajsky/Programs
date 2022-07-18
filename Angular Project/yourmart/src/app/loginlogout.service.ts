import { Injectable } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/compat/auth';
import { AngularFireDatabase } from '@angular/fire/compat/database';
import { Router } from '@angular/router';
import { GoogleAuthProvider } from 'firebase/auth';
@Injectable({
  providedIn: 'root',
})
export class LoginlogoutService {
  // constructor(
  //   public afAuth: AngularFireAuth // Inject Firebase auth service
  // ) {}
  // // Sign in with Google
  // GoogleAuth() {
  //   return this.AuthLogin(new GoogleAuthProvider());
  // }
  // // Auth logic to run auth providers
  // AuthLogin(provider) {
  //   return this.afAuth
  //     .signInWithPopup(provider)
  //     .then((result) => {
  //       console.log('You have been successfully logged in!');
  //     })
  //     .catch((error) => {
  //       console.log(error);
  //     });
  // }
  user: any;

  constructor(
    private afauth: AngularFireAuth,
    private db: AngularFireDatabase,
    private router:Router
  ) {
    this.afauth.authState.subscribe((x) => {
      this.user = x;
      // console.log(this.user);
    });
  }
  login() {
    this.afauth.signInWithRedirect(new GoogleAuthProvider());
  }
  logout() {
    this.afauth.signOut();
    let key: any = localStorage.getItem('cartid');
    this.db.list('/shopping-cart').remove(key);
    localStorage.removeItem('cartid');
  }

  checkout()
  {
    if(this.user!=null)
    {
      this.router.navigate(['/checkout'])
    }
    else
    {
      this.login();
    }
  }

  auth_user():boolean
  {
    if(this.user)
    {
      this.router.navigate(['/']);
      return true;
    }
   
    else
    {
      return false;

    }
  

  }
}
