import { Component, OnInit } from '@angular/core';
import { HttpUtilService } from '../shared/services/http-util.service';

import * as moment from 'moment';

@Component({
  selector: 'app-list-devolucoes',
  templateUrl: './list-devolucoes.component.html',
  styleUrls: ['./list-devolucoes.component.css']
})
export class ListDevolucoesComponent implements OnInit {

  constructor(private httpUtil: HttpUtilService) { }

  ngOnInit(): void {
    this.httpUtil.buscarDevolucoes(0, 25).subscribe( data => {
      console.log(data);
    });
  }

}
