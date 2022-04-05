import {AfterViewInit, Component, TemplateRef, ViewChild} from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Router} from '@angular/router';
import {Constant} from '../../services/model';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements AfterViewInit {

  @ViewChild('modalMessage')
  private modalTemplate: TemplateRef<any>;

  constructor(public modal: NgbModal, private router: Router, public constant: Constant) { }

  ngAfterViewInit(): void {
    this.modal.open(this.modalTemplate, {
      centered: true,
      backdrop: 'static'
    }).result.then(() => {}, () => {});
  }

}
