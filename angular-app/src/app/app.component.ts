import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import {Title} from '@angular/platform-browser';
import {filter} from 'rxjs/operators';
import {Globals} from './services/model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              public titleService: Title,
              public globals: Globals) {
  }

  ngOnInit(): void {

    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd),
    ).subscribe(() => {
      const rt = this.getChild(this.activatedRoute);
      rt.data.subscribe(data => {
        this.titleService.setTitle(data.title);
      });
    });

  }

  private getChild(activatedRoute: ActivatedRoute): ActivatedRoute {
    if (activatedRoute.firstChild) {
      return this.getChild(activatedRoute.firstChild);
    } else {
      return activatedRoute;
    }
  }

  public changeStateMenu(): void {
    if (this.globals.displayMenu === 'd-none') {
      this.globals.displayMenu = 'd-block';
      this.globals.iconMenu = 'times';
    } else {
      this.globals.displayMenu = 'd-none';
      this.globals.iconMenu = 'bars';
    }
  }

}
