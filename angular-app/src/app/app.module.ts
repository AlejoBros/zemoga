import {NgModule} from '@angular/core';
import {BrowserModule, Title} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {UserComponent} from './modules/user/user/user.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {UserCreateComponent} from './modules/user/user-create/user-create.component';
import {Constant, Globals} from './services/model';
import {UserReadComponent} from './modules/user/user-read/user-read.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {UserUpdateComponent} from './modules/user/user-update/user-update.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    UserCreateComponent,
    UserReadComponent,
    UserUpdateComponent,
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [
    Title, Globals, Constant
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
