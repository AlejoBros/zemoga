import {
  AfterViewInit,
  Component,
  Input, OnInit,
  TemplateRef,
  ViewChild, ViewEncapsulation
} from '@angular/core';
import {Constant, IUser} from '../../../services/model';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ActivatedRoute, Router} from '@angular/router';
import {ApiService} from '../../../services/api.service';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class UserUpdateComponent implements OnInit, AfterViewInit {

  @ViewChild('modalUserUpdate')
  private modalTemplate: TemplateRef<any>;
  @Input() user: IUser;
  private id: number;

  // tslint:disable-next-line:max-line-length
  constructor(public modal: NgbModal, private posApi: ApiService, private router: Router, private activatedRoute: ActivatedRoute, public constant: Constant) {
  }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.getPathVariables();
    this.readUser();
  }

  ngAfterViewInit(): void {
    this.modal.open(this.modalTemplate, {
      centered: true,
      backdrop: 'static'
    }).result.then(() => {
      this.router.navigateByUrl('/user').then();
    }, () => {
      this.router.navigateByUrl('/user').then();
    });
  }

  private getPathVariables(): void {
    this.activatedRoute.paramMap.subscribe(pathVariables => {
      this.id = Number(pathVariables.get('id'));
    });
  }

  private readUser(): void {
    this.posApi.readUser(this.id).subscribe(result => {
      this.user = result;
    }, error => {
      console.log(error);
    });
  }

  public update(): void {
    this.posApi.updateUser(this.user).subscribe(result => {
      this.modal.dismissAll();
    }, error => {
      console.log(error);
    });
  }

}
