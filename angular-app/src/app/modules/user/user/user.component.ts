import {Component, OnInit} from '@angular/core';
import {ApiService} from '../../../services/api.service';
import {IUser} from '../../../services/model';

@Component({
  selector: 'app-user-list',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: Array<IUser>;
  selectUser: IUser;

  constructor(public posApi: ApiService) {
  }

  ngOnInit(): void {
    this.readUsers();
  }

  public setSelectUser(user: IUser): void {
    this.selectUser = user;
  }

  public readUsers(): void {
    this.posApi.readUsers().subscribe(result => {
      this.users = result;
    }, error => {
      console.log(error);
    });
  }

}
