import {AfterViewInit, Component, Input, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Constant, ITweet, IUser} from '../../../services/model';
import {ApiService} from '../../../services/api.service';
import {ActivatedRoute, Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-user-read',
  templateUrl: './user-read.component.html',
  styleUrls: ['./user-read.component.css']
})
export class UserReadComponent implements OnInit, AfterViewInit {

  @ViewChild('modalUserRead')
  private modalTemplate: TemplateRef<any>;
  @Input() user: IUser;
  tweets: Array<ITweet>;
  private id: number;

  // tslint:disable-next-line:max-line-length
  constructor(public modal: NgbModal, private posApi: ApiService, private router: Router, private activatedRoute: ActivatedRoute, public constant: Constant) {
  }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.getPathVariables();
    this.readUser();
    this.readTweets();
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

  private readTweets(): void {
    this.posApi.readTweets(this.id).subscribe(result => {
      this.tweets = result;
    }, error => {
      console.log(error);
    });
  }

}
