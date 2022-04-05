import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {UserComponent} from './modules/user/user/user.component';
import {UserUpdateComponent} from './modules/user/user-update/user-update.component';
import {UserReadComponent} from './modules/user/user-read/user-read.component';
import {UserCreateComponent} from './modules/user/user-create/user-create.component';

const routes: Routes = [
  {
    path: 'user', component: UserComponent, data: {title: 'Users'}, children: [
      {path: 'create', component: UserCreateComponent},
      {path: 'update/:id', component: UserUpdateComponent},
      {path: 'read/:id', component: UserReadComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
