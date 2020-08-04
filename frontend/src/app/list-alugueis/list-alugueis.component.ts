import { Component, OnInit } from '@angular/core';
import { HttpUtilService } from '../shared/services/http-util.service';

@Component({
  selector: 'app-list-alugueis',
  templateUrl: './list-alugueis.component.html',
  styleUrls: ['./list-alugueis.component.css']
})
export class ListAlugueisComponent implements OnInit {

  constructor(private httpUtil: HttpUtilService) { }

  ngOnInit(): void {
    this.httpUtil.buscarDevolucoes(0, 25).subscribe( data => {
      console.log(data);
    });
  }

}
