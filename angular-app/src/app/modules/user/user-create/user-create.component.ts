import {AfterViewInit, Component, Input, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Constant, IUser} from '../../../services/model';
import {ApiService} from '../../../services/api.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.css']
})
export class UserCreateComponent implements OnInit, AfterViewInit {

  @ViewChild('modalUserCreate')
  private modalTemplate: TemplateRef<any>;
  @Input() user: IUser;

  constructor(public modal: NgbModal, private posApi: ApiService, private router: Router, public constant: Constant) {
    this.user = Constant.EMPTY_USER;
  }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    this.modal.open(this.modalTemplate, {
      centered: true,
      backdrop: 'static'
    }).result.then(() => {
      this.user = Constant.EMPTY_USER;
      this.router.navigateByUrl('/user').then();
    }, () => {
      this.user = Constant.EMPTY_USER;
      this.router.navigateByUrl('/user').then();
    });
  }

  public create(): void {
    this.posApi.createUser(this.user).subscribe(result => {
      this.modal.dismissAll();
      console.log(result);
    }, error => {
      console.log(error);
    });
  }

}
